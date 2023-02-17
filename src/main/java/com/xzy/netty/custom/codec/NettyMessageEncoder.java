package com.xzy.netty.custom.codec;

import com.alibaba.fastjson.JSON;
import com.xzy.netty.custom.struct.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * User: RuzzZZ
 * Date: 2023/2/15
 * Time: 17:06
 */
@Slf4j
public class NettyMessageEncoder extends MessageToByteEncoder<NettyMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, ByteBuf out) throws Exception {
        log.info("start encode msg,msg:{}", msg);
        String result = JSON.toJSONString(msg);
        out.writeBytes(result.getBytes());
    }
}
