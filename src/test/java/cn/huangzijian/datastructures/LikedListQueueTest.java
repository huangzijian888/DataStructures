package cn.huangzijian.datastructures;

import org.junit.jupiter.api.Test;

/**
 * @author: huangzijian888
 * @date: 2019/10/20 21:20
 */
class LikedListQueueTest<LinkedListQueue> {
    @Test
    public void test() {

        LikedListQueue<Integer> queue = new LikedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);

            }
        }
    }

}