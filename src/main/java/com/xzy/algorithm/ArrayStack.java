package com.xzy.algorithm;

/**
 * @author xiazhengyue
 * @since 2020-08-19
 */
public class ArrayStack<E> {

    /**
     * 存放的元素
     */
    private Object[] array;

    /**
     * 栈的大小
     */
    private int size;

    /**
     * 栈中的当前元素个数
     */
    private int count;

    public ArrayStack(int size) {
        this.size = size;
        array = new Object[size];
        count = 0;
    }

    public boolean push(E e) {
        if (count == size) {
            return false;
        }
        array[count] = e;
        count++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (count == 0) {
            return null;
        }
        Object e = array[count-1];
        count--;
        return (E) e;
    }


    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(16);
        System.out.println(stack.push("Hello 1"));
        System.out.println(stack.push("Hello 2"));
        System.out.println(stack.push("Hello 3"));
        System.out.println(stack.push("Hello 4"));

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
