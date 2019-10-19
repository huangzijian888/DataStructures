package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 18:24
 */
public interface Stack<T> {
    /**
     * 获取栈的大小
     *
     * @return
     */
    Integer getSize();

    /**
     * 判断栈是否为空
     *
     * @return
     */
    Boolean isEmpty();

    /**
     * 入栈
     *
     * @param element
     */
    void push(T element);

    /**
     * 出栈
     *
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    T peek();
}
