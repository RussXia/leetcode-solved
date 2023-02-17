package com.xzy.netty.custom.struct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: RuzzZZ
 * Date: 2023/2/15
 * Time: 16:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NettyMessage {

    private Header header;

    private Object body;
}
