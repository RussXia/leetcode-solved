package com.xzy.demo;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * User: RuzzZZ
 * Date: 2023/4/25
 * Time: 16:06
 */
public class VarHandleDemo {
    private volatile int count;

    private static final VarHandle COUNT_HANDLE;

    static {
        try {
            COUNT_HANDLE = MethodHandles.lookup().findVarHandle(
                    VarHandleDemo.class, "count", int.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public void increment() {
        int oldValue, newValue;
        do {
            oldValue = count;
            newValue = oldValue + 1;
        } while (!COUNT_HANDLE.compareAndSet(this, oldValue, newValue));
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        VarHandleDemo demo = new VarHandleDemo();
        System.out.println(demo.getCount());
        demo.increment();
        System.out.println(demo.getCount());
    }
}
