package com.xzy.netty.custom.struct;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * User: RuzzZZ
 * Date: 2023/2/15
 * Time: 16:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Header {
    private int magic = 0xabef101;
    private int length;
    private long sessionId;
    private byte type;
    private byte priority;
    private Map<String, Object> attachment = Maps.newHashMap();
}
