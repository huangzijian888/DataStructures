package cn.huangzijian.datastructures;

import org.junit.jupiter.api.Test;

/**
 * @author: huangzijian888
 * @date: 2019/10/20 19:57
 */
class LinkedListStackTest {

    @Test
    public void test() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

}