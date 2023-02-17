package com.xzy.netty.custom.handler;

import com.xzy.netty.custom.constant.NettyConstant;
import com.xzy.netty.custom.struct.Header;
import com.xzy.netty.custom.struct.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * User: RuzzZZ
 * Date: 2023/2/16
 * Time: 11:24
 */
@Slf4j
public class HeartBeatReqHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        // send heartbeat per 5 seconds since login success
        if (message.getHeader() != null && message.getHeader().getType() == NettyConstant.MessageType.LOGIN_RESP) {
            ctx.executor().scheduleAtFixedRate(() -> {
                NettyMessage heartBeat = buildHeartBeatRequest();
                ctx.writeAndFlush(heartBeat);
            }, 0, 5, TimeUnit.SECONDS);
            return;
        }
        // log heart beat resp
        if (message.getHeader() != null && message.getHeader().getType() == NettyConstant.MessageType.HEARTBEAT_RESP) {
            log.info("receive heart beat,beat message :{}", message);
            return;
        }
        // direct pass
        super.channelRead(ctx, msg);
    }

    private NettyMessage buildHeartBeatRequest() {
        Header header = Header.builder()
                .type(NettyConstant.MessageType.HEARTBEAT_REQ)
                .build();
        return NettyMessage.builder()
                .header(header)
                .build();
    }
}
