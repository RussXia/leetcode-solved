package com.xzy.netty.custom.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * User: RuzzZZ
 * Date: 2023/2/15
 * Time: 17:59
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NettyConstant {

    public static class MessageType {
        public static final byte LOGIN_REQ = 1;
        public static final byte LOGIN_RESP = 2;
        public static final byte SERVICE_REQ = 3;
        public static final byte SERVICE_RESP = 4;
        public static final byte HEARTBEAT_REQ = 5;
        public static final byte HEARTBEAT_RESP = 6;
    }


    public static class LoginRespCode {
        public static final int SUCCESS = 0;
        public static final int REPEATED = -1;
        public static final int NOT_IN_WHITE_LIST = -2;
        public static final int NON_LOGIN_REQUEST = -100;
    }

}
