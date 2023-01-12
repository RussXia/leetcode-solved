package com.xzy.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * User: RuzzZZ
 * Date: 2021/5/31
 * Time: 20:41
 */
@Slf4j
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg;
        for (int i = 0; i < 100; i++) {
            msg = Unpooled.copiedBuffer("QUERY TIME ORDER\r\n".getBytes());
            ctx.writeAndFlush(msg);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String result = (String) msg;
        System.out.println("The time client receive time : " + result);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
