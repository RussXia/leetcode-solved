package com.xzy.netty.msgpack;

import org.apache.commons.compress.utils.Lists;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * User: RuzzZZ
 * Date: 2023/2/1
 * Time: 14:47
 */
public class MessagePackDemo {

    public static void main(String[] args) throws IOException {
        List<String> src = Lists.newArrayList();
        src.add("message");
        src.add("pack");
        src.add("hello");
        src.add("world");
        MessagePack msgPack = new MessagePack();
        byte[] write = msgPack.write(src);
        System.out.println(new String(write));
        Collection<String> read = msgPack.read(write, Templates.tCollection(Templates.TString));
        System.out.println(read);
    }
}
