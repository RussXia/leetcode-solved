package com.xzy.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * User: RuzzZZ
 * Date: 2021/5/31
 * Time: 17:21
 */
@Slf4j
public class EchoProtocolHandler extends ChannelInboundHandlerAdapter {

    //@Override
    //public void channelActive(ChannelHandlerContext ctx) throws Exception {
    //    ctx.writeAndFlush("hello,channel_active!\r\n");
    //}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //ChannelId channelId = ctx.channel().id();
        //log.info("channelId.asLongText:{},channelId.asShortText:{}", channelId.asLongText(), channelId.asShortText());

        String req = (String) msg;
        log.info("receive request,req:{}", req);
        if (Objects.equals("exit", req)) {
            ctx.close();
        }
        ctx.writeAndFlush("hello," + req + "\r\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
