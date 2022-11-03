package com.xzy.netty.aio;

import com.alibaba.fastjson.util.IOUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

/**
 * User: RuzzZZ
 * Date: 2022/9/28
 * Time: 17:02
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
    }

    static class AsyncTimeServerHandler implements Runnable {

        private int port;

        CountDownLatch count;

        AsynchronousServerSocketChannel asynchronousServerSocketChannel;

        public AsyncTimeServerHandler(int port) {
            this.port = port;
            try {
                asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
                asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
                System.out.println("The time server is start in port " + port);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        @Override
        public void run() {
                count = new CountDownLatch(1);
                doAccept();
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doAccept() {
            asynchronousServerSocketChannel.accept(this, new CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler>() {
                @Override
                public void completed(AsynchronousSocketChannel channel, AsyncTimeServerHandler attachment) {
                    attachment.asynchronousServerSocketChannel.accept(attachment, this);
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    channel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {

                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            String req = StandardCharsets.UTF_8.decode(readBuffer).toString();
                            System.out.println("The time server receive order : " + req);
                            String currentTime = "QUERY TIME ORDER\r\n".equalsIgnoreCase(req)
                                    ? LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
                                    : "BAD ORDER";
                            ByteBuffer writeBuffer = StandardCharsets.UTF_8.encode(currentTime);
                            channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                                @Override
                                public void completed(Integer result, ByteBuffer writeBuffer) {
                                    if (writeBuffer.hasRemaining()) {
                                        channel.write(writeBuffer, writeBuffer, this);
                                    }
                                }

                                @Override
                                public void failed(Throwable exc, ByteBuffer writeBuffer) {
                                    IOUtils.close(channel);
                                }
                            });
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            IOUtils.close(channel);
                        }
                    });

                }

                @Override
                public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
                    exc.printStackTrace();
                    attachment.count.countDown();
                }
            });
        }
    }
}
