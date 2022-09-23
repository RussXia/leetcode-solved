package com.xzy.netty.nio;


import com.alibaba.fastjson.util.IOUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * User: RuzzZZ
 * Date: 2022/9/21
 * Time: 10:47
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer server = new MultiplexerTimeServer(port);
        new Thread(server, "NIO-MultiplexerTimeServer").start();

    }

    static class MultiplexerTimeServer implements Runnable {

        private Selector selector;

        private ServerSocketChannel servChannel;

        private volatile boolean stop;

        public MultiplexerTimeServer(int port) {
            this.start(port);
        }

        public void start(int port) {
            try {
                selector = Selector.open();
                servChannel = ServerSocketChannel.open();
                servChannel.configureBlocking(false);
                servChannel.socket().bind(new InetSocketAddress(port), 1024);
                servChannel.register(selector, SelectionKey.OP_ACCEPT);
                this.stop = false;
                System.out.println("The time server is start in port : " + port);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        public void stop() {
            this.stop = true;
        }

        @Override
        public void run() {
            while (!stop) {
                try {
                    selector.select(1000);
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    for (SelectionKey selectionKey : selectionKeys) {
                        try {
                            handleInput(selectionKey);
                        } catch (Exception e) {
                            selectionKey.cancel();
                            IOUtils.close(selectionKey.channel());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            IOUtils.close(selector);
        }

        private void handleInput(SelectionKey key) throws Exception {
            if (!key.isValid()) {
                return;
            }
            System.out.println("key is acceptable ? " + key.isAcceptable() + "\t key is readable?" + key.isReadable());
            // handle new request message
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
                System.out.println("The time server receive new request!");
            }
            //
            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int read = sc.read(readBuffer);
                if (read > 0) {
                    readBuffer.flip();
                    String body = StandardCharsets.UTF_8.decode(readBuffer).toString();
                    System.out.println("The time server receive order : " + body);
                    String currentTime = "QUERY TIME ORDER\r\n".equalsIgnoreCase(body)
                            ? LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
                            : "BAD ORDER";
                    sc.write(StandardCharsets.UTF_8.encode(currentTime));
                } else if (read < 0) {
                    key.cancel();
                    sc.close();
                }
            }
        }
    }
}
