package com.xzy.netty.custom.handler;

import com.xzy.netty.custom.constant.NettyConstant;
import com.xzy.netty.custom.struct.Header;
import com.xzy.netty.custom.struct.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * User: RuzzZZ
 * Date: 2023/2/16
 * Time: 14:13
 */
@Slf4j
public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType() == NettyConstant.MessageType.HEARTBEAT_REQ) {
            log.info("receive heart beat request, message : {}.", message);
            NettyMessage response = buildHeartBeatResponse();
            ctx.writeAndFlush(response);
            return;
        }
        super.channelRead(ctx, msg);
    }


    private NettyMessage buildHeartBeatResponse() {
        Header header = Header.builder()
                .type(NettyConstant.MessageType.HEARTBEAT_RESP)
                .build();
        return NettyMessage.builder()
                .header(header)
                .build();
    }
}
