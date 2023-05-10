package com.xzy.netty.custom;

import com.xzy.netty.custom.codec.NettyMessageDecoder;
import com.xzy.netty.custom.codec.NettyMessageEncoder;
import com.xzy.netty.custom.handler.HeartBeatReqHandler;
import com.xzy.netty.custom.handler.LoginAuthReqHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.ByteBufFormat;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * User: RuzzZZ
 * Date: 2023/2/16
 * Time: 14:27
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        String host = "127.0.0.1";
        int port = 9527;
        connect(host, port);
    }

    private static void connect(String host, int port) throws InterruptedException {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO, ByteBufFormat.HEX_DUMP));
                            ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 0, 4, 0, 4));
                            ch.pipeline().addLast(new LengthFieldPrepender(4));
                            ch.pipeline().addLast(new NettyMessageEncoder());
                            ch.pipeline().addLast(new ReadTimeoutHandler(5));
                            ch.pipeline().addLast(new LoginAuthReqHandler());
                            ch.pipeline().addLast(new HeartBeatReqHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().closeFuture().sync();
        } finally {
            Executors.newScheduledThreadPool(1).execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    connect(host, port);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
