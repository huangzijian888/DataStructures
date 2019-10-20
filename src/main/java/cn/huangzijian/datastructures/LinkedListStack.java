package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/20 19:53
 */
public class LinkedListStack<T> implements Stack<T> {

    private LinkedList<T> list;

    public LinkedListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public Integer getSize() {
        return this.list.getSize();
    }

    @Override
    public Boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(T element) {
        this.list.addFirst(element);
    }

    @Override
    public T pop() {
        return this.list.removeFirst();
    }

    @Override
    public T peek() {
        return this.list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: top");
        stringBuilder.append(this.list);
        return stringBuilder.toString();
    }

}
