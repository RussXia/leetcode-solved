package com.xzy.netty.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * User: RuzzZZ
 * Date: 2021/5/31
 * Time: 17:21
 */
@Slf4j
public class EchoProtocolHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ChannelId channelId = ctx.channel().id();
        System.out.println(channelId.asLongText());
        System.out.println(channelId.asShortText());

        ByteBuf in = (ByteBuf) msg;
        log.info(in.toString(CharsetUtil.UTF_8));
//        in.clear();
//        in.writeBytes("Hello".getBytes());
        ctx.writeAndFlush(in);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
