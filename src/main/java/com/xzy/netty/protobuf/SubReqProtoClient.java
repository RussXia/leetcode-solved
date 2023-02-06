package com.xzy.netty.protobuf;

import com.google.common.collect.Lists;
import com.xzy.netty.protobuf.proto.SubscribeReqProto;
import com.xzy.netty.protobuf.proto.SubscribeRespProto;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import lombok.extern.slf4j.Slf4j;

/**
 * User: RuzzZZ
 * Date: 2023/2/6
 * Time: 15:41
 */
@Slf4j
public class SubReqProtoClient {

    public static void main(String[] args) throws InterruptedException {
        String host = "127.0.0.1";
        int port = 9527;
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new ProtobufVarint32FrameDecoder())
                                    .addLast(new ProtobufVarint32LengthFieldPrepender())
                                    .addLast(new ProtobufEncoder())
                                    .addLast(new ProtobufDecoder(SubscribeRespProto.SubscribeResp.getDefaultInstance()))
                                    .addLast(new ChannelInboundHandlerAdapter() {
                                        @Override
                                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                            for (int i = 0; i < 10; i++) {
                                                SubscribeReqProto.SubscribeReq req = SubscribeReqProto.SubscribeReq.newBuilder()
                                                        .setSubReqId(i)
                                                        .setUserName("userName-" + i)
                                                        .setProductName("productName-" + i)
                                                        .addAllAddress(Lists.newArrayList("address1-" + i, "address2-" + i))
                                                        .build();
                                                ctx.writeAndFlush(req);
                                            }
                                        }

                                        @Override
                                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                            SubscribeRespProto.SubscribeResp resp = (SubscribeRespProto.SubscribeResp) msg;
                                            log.info("receive subscribe resp : {}", resp);
                                        }
                                    });

                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect(host, port);
            channelFuture.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
        }

    }
}
