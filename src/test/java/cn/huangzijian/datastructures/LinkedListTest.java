package cn.huangzijian.datastructures;

import org.junit.jupiter.api.Test;


/**
 * @author: huangzijian888
 * @date: 2019/10/20 18:55
 */
class LinkedListTest {

    @Test
    public void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }

}