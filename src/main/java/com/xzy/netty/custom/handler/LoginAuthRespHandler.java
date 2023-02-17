package com.xzy.netty.custom.handler;

import com.google.common.collect.Lists;
import com.xzy.netty.custom.constant.NettyConstant;
import com.xzy.netty.custom.struct.Header;
import com.xzy.netty.custom.struct.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: RuzzZZ
 * Date: 2023/2/16
 * Time: 10:49
 */
@Slf4j
public class LoginAuthRespHandler extends ChannelInboundHandlerAdapter {

    private final Map<String, Boolean> nodeCheck = new ConcurrentHashMap<>();

    private final List<String> whiteList = Lists.newArrayList("127.0.0.1", "192.168.116.87");

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("receive login request");
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() == null || message.getHeader().getType() != NettyConstant.MessageType.LOGIN_REQ) {
            // non-login req, direct pass
            super.channelRead(ctx, msg);
            return;
        }
        // check if repeat login
        String nodeIndex = ctx.channel().remoteAddress().toString();
        if (nodeCheck.containsKey(nodeIndex)) {
            NettyMessage response = buildResponse(NettyConstant.LoginRespCode.REPEATED);
            ctx.writeAndFlush(response);
            return;
        }
        // check if in white list
        InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
        if (!whiteList.contains(address.getAddress().getHostAddress())) {
            NettyMessage response = buildResponse(NettyConstant.LoginRespCode.NOT_IN_WHITE_LIST);
            ctx.writeAndFlush(response);
            return;
        }
        // login success
        NettyMessage response = buildResponse(NettyConstant.LoginRespCode.SUCCESS);
        nodeCheck.put(nodeIndex, true);
        ctx.writeAndFlush(response);
    }

    private NettyMessage buildResponse(int result) {
        Header header = Header.builder()
                .type(NettyConstant.MessageType.LOGIN_RESP)
                .build();
        return NettyMessage.builder()
                .header(header)
                .body(result)
                .build();
    }
}
