package com.xzy.netty.custom.codec;

import com.alibaba.fastjson.JSON;
import com.xzy.netty.custom.struct.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * User: RuzzZZ
 * Date: 2023/2/15
 * Time: 16:58
 */
@Slf4j
public class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {

    public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        if (frame == null) {
            return null;
        }
        byte[] raw = new byte[frame.readableBytes()];
        frame.readBytes(raw);
        return JSON.parseObject(new String(raw), NettyMessage.class);
    }
}
