package com.xzy.netty.custom.handler;

import com.xzy.netty.custom.constant.NettyConstant;
import com.xzy.netty.custom.struct.Header;
import com.xzy.netty.custom.struct.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * User: RuzzZZ
 * Date: 2023/2/15
 * Time: 17:47
 */
@Slf4j
public class LoginAuthReqHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("send login request");
        ctx.writeAndFlush(buildLoginReq());
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getBody() != null && message.getHeader().getType() == NettyConstant.MessageType.LOGIN_RESP) {
            int loginResult = (int) message.getBody();
            // send login request success,but get failed response
            if (loginResult !=  0) {
                log.info("login failed, result code : {}", loginResult);
                ctx.close();
                return;
            }
            // login success
            log.info("login success,message:{}", message);
            super.channelRead(ctx, msg);
            return;
        }
        // non login response msg, direct pass
        super.channelRead(ctx, msg);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("some error occurred!", cause);
        super.exceptionCaught(ctx, cause);
    }

    private NettyMessage buildLoginReq() {
        Header header = Header.builder()
                .type(NettyConstant.MessageType.LOGIN_REQ)
                .sessionId(System.currentTimeMillis())
                .build();
        return NettyMessage.builder().header(header).build();
    }
}
