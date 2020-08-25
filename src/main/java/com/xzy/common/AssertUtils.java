package com.xzy.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author xiazhengyue
 * @since 2020-08-21
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AssertUtils {

    public static void isTrue(boolean expression) {
        if(!expression) {
            throw new IllegalStateException();
        }
    }
}
