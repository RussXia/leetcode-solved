package com.xzy.netty.nio;


import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * User: RuzzZZ
 * Date: 2022/9/21
 * Time: 17:39
 */
public class Client {


    public static void main(String[] args) {

        int n = 10000;
        SocketTest[] st = new SocketTest[n];
        for (int i = 0; i < n; i++)
            st[i] = new SocketTest("hi");

        for (int i = 0; i < n; i++)
            new Thread(st[i]).start();
    }

    static class SocketTest implements Runnable {

        private String message = "";
        private Selector selector;
        private int i;


        public SocketTest(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            SocketChannel channel;
            try {
                selector = Selector.open();
                channel = SocketChannel.open();
                channel.configureBlocking(false);

                channel.register(selector, SelectionKey.OP_CONNECT);
                channel.connect(new InetSocketAddress("127.0.0.1", 8080));


                while (!Thread.currentThread().isInterrupted()) {

                    selector.select();

                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove();

                        if (!key.isValid()) continue;

                        if (key.isConnectable()) {
                            connect(key);
                            System.out.println("I am connected to the server");
                        }
                        if (key.isWritable()) {
                            write(key);
                        }
                        if (key.isReadable()) {
                            read(key);
                        }
                    }
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } finally {
                close();
            }
        }

        private void close() {
            try {
                selector.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        private void read(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer readBuffer = ByteBuffer.allocate(1000);
            readBuffer.clear();
            int length;
            try {
                length = channel.read(readBuffer);

            } catch (IOException e) {
                System.out.println("Reading problem, closing connection");
                key.cancel();
                channel.close();
                return;
            }
            if (length == -1) {
                System.out.println("Nothing was read from server");
                channel.close();
                key.cancel();
                return;
            }
            readBuffer.flip();
            byte[] buff = new byte[1024];
            readBuffer.get(buff, 0, length);
            //length=buff.length;

            String fromserver = new String(buff, 0, length, "UTF-8");
            length = fromserver.length();
            System.out.println("Server said: " + fromserver);

            key.interestOps(SelectionKey.OP_WRITE);
        }

        private void write(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            i++;
            message = "location now " + i;
            try {
                Thread.sleep(5000);

            } catch (InterruptedException ie) {
                System.out.println("" + ie);
            }
            channel.write(StandardCharsets.UTF_8.encode("QUERY TIME ORDER\r\n"));

            // lets get ready to read.
            key.interestOps(SelectionKey.OP_READ);
        }

        private void connect(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            try {
                if (!channel.finishConnect())
                    System.out.println("* Here *");
            } catch (ConnectException e) {
                System.out.println("BP 1");
                e.printStackTrace();

                //channel.close();
                //key.cancel();
                //return;
            }
        /*if (channel.isConnectionPending()){
            while(!channel.ffinishConnect()){
                System.out.println("not connected");
            }
        }*/

            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_WRITE);
        }
    }
}
