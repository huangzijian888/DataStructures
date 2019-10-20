package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/20 04:27
 */
public class ArrayQueue<T> implements Queue<T> {

    private Array<T> array;

    public ArrayQueue() {
        this.array = new Array<>();
    }

    public ArrayQueue(Integer capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public Integer getSize() {
        return this.array.getSize();
    }

    @Override
    public Boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        this.array.addLast(e);
    }

    @Override
    public T dequeue() {
        return this.array.removeFirst();
    }

    @Override
    public T getFront() {
        return this.array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front【");
        for (int i = 0; i < this.array.getSize(); i++) {
            res.append(this.array.get(i));
            if (i != this.array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("】tail");
        return res.toString();
    }
}
