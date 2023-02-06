package com.xzy.netty.protobuf;

import com.google.common.collect.Lists;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xzy.netty.protobuf.proto.SubscribeReqProto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * User: RuzzZZ
 * Date: 2023/2/6
 * Time: 14:54
 */
@Slf4j
public class TestSubscribeReqProto {

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq(int subSeqId, String userName
            , String productName, List<String> address) {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        return builder.setSubReqId(subSeqId)
                .setUserName(userName)
                .setProductName(productName)
                .addAllAddress(address)
                .build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq subscribeReq =
                createSubscribeReq(1, "aaa", "qqq", Lists.newArrayList("abc","bcd"));
        log.info("before encode : {}", subscribeReq);
        byte[] encode = encode(subscribeReq);
        log.info("after encode : {}", new String(encode));
        SubscribeReqProto.SubscribeReq subscribeReq1 = decode(encode);
        log.info("after decode : {}",subscribeReq1);
        log.info("assert equals : {}",subscribeReq.equals(subscribeReq1));
    }
}
