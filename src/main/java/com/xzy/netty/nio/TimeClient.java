package com.xzy.netty.nio;

import com.alibaba.fastjson.util.IOUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Set;

/**
 * User: RuzzZZ
 * Date: 2022/9/21
 * Time: 14:51
 */
public class TimeClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;
        new Thread(new TimeClientHandle(host, port)).start();
    }

    static class TimeClientHandle implements Runnable {
        private String host;
        private int port;
        private Selector selector;
        private SocketChannel socketChannel;
        private volatile boolean stop;

        public TimeClientHandle(String host, int port) {
            try {
                this.host = Optional.ofNullable(host).orElse("127.0.0.1");
                this.port = port;
                this.selector = Selector.open();
                this.socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
                stop = false;
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        @Override
        public void run() {
            try {
                doConnect();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            while (!stop) {
                try {
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    for (SelectionKey selectionKey : selectionKeys) {
                        try {
                            handInput(selectionKey);
                        } catch (Exception e) {
                            e.printStackTrace();
                            selectionKey.cancel();
                            IOUtils.close(selectionKey.channel());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
            IOUtils.close(selector);
        }

        private void handInput(SelectionKey selectionKey) throws Exception {
            if (!selectionKey.isValid()) {
                return;
            }
            SocketChannel sc = (SocketChannel) selectionKey.channel();
            if (selectionKey.isConnectable()) {
                if (sc.finishConnect()) {
                    sc.register(selector, SelectionKey.OP_READ);
                    doWrite(sc);
                } else {
                    System.exit(1);
                }
            }
            if (selectionKey.isReadable()) {
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    String body = StandardCharsets.UTF_8.decode(readBuffer).toString();
                    System.out.println("Now is : " + body);
                    //this.stop = true;
                    doWrite(sc);
                } else if (readBytes < 0) {
                    selectionKey.cancel();
                    IOUtils.close(selectionKey.channel());
                }
            }

        }

        private void doConnect() throws IOException {
            if (socketChannel.connect(new InetSocketAddress(host, port))) {
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel);
            } else {
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        }

        private void doWrite(SocketChannel sc) throws IOException {
            ByteBuffer writeBuffer = StandardCharsets.UTF_8.encode("QUERY TIME ORDER\r\n");
            sc.write(writeBuffer);
            if (!writeBuffer.hasRemaining()) {
                System.out.println("Send order to server succeed.");
            }

        }
    }
}
