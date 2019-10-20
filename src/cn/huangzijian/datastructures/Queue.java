package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/20 04:24
 */
public interface Queue<T> {
    /**
     * 获取队列大小
     *
     * @return
     */
    Integer getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    Boolean isEmpty();

    /**
     * 向队列中添加元素
     *
     * @param e
     */
    void enqueue(T e);

    /**
     * 从队列中取出元素
     *
     * @return
     */
    T dequeue();

    /**
     * 获取队首元素
     *
     * @return
     */
    T getFront();
}
