package com.xzy.netty.protobuf;

import com.xzy.netty.protobuf.proto.SubscribeReqProto;
import com.xzy.netty.protobuf.proto.SubscribeRespProto;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import lombok.extern.slf4j.Slf4j;

/**
 * User: RuzzZZ
 * Date: 2023/2/6
 * Time: 15:23
 */
@Slf4j
public class SubReqProtoServer {

    private int port;

    public SubReqProtoServer(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new ProtobufVarint32FrameDecoder())
                                    .addLast(new ProtobufDecoder(SubscribeReqProto.SubscribeReq.getDefaultInstance()))
                                    .addLast(new ProtobufVarint32LengthFieldPrepender())
                                    .addLast(new ProtobufEncoder())
                                    .addLast(new ChannelInboundHandlerAdapter() {
                                        @Override
                                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                            SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
                                            log.info("receive subscribe req :{}", req);
                                            SubscribeRespProto.SubscribeResp resp = SubscribeRespProto.SubscribeResp.newBuilder()
                                                    .setSubReqId(req.getSubReqId())
                                                    .setRespCode(0)
                                                    .setDesc("receive time:" + System.currentTimeMillis())
                                                    .build();
                                            ctx.writeAndFlush(resp);
                                        }
                                    });
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = bootstrap.bind(port).sync();

            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }


    public static void main(String[] args) throws Exception {
        int port = 9527;
        new SubReqProtoServer(port).run();
    }
}
