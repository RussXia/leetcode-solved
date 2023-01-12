package com.xzy.netty.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: RuzzZZ
 * Date: 2023/1/9
 * Time: 17:28
 */
public class TimeProtocol2Handler extends ChannelInboundHandlerAdapter {

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("The time server receive order : " + body + ",\tthe counter is " + counter.incrementAndGet());
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
                System.currentTimeMillis() + "\r\n"
                : "BAD ORDER\r\n";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
