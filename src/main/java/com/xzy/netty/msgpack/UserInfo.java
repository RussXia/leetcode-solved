package com.xzy.netty.msgpack;

import lombok.Data;
import org.msgpack.annotation.Message;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * User: RuzzZZ
 * Date: 2023/2/3
 * Time: 11:02
 */
@Data
@Message
public class UserInfo {


    private int age;
    private String name;

    public UserInfo() {
        this.age = ThreadLocalRandom.current().nextInt(100);
        this.name = UUID.randomUUID().toString();
    }
}
