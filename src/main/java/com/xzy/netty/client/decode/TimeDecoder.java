package com.xzy.netty.client.decode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * User: RuzzZZ
 * Date: 2022/7/29
 * Time: 17:23
 */
@Slf4j
public class TimeDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        log.info("decode triggered");
        out.add(in.readBytes(4));
    }
}
