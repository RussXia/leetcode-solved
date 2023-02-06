package com.xzy.netty.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * User: RuzzZZ
 * Date: 2023/2/1
 * Time: 15:51
 */
@Slf4j
public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        byte[] raw = new byte[msg.readableBytes()];
        msg.readBytes(raw);
        MessagePack msgPack = new MessagePack();
        out.add(msgPack.read(raw, UserInfo.class));
    }
}
