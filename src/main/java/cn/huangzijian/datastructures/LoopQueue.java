package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/20 12:56
 */
public class LoopQueue<T> implements Queue<T> {
    private final Integer THRESHOLD = 4;
    private T[] data;
    private Integer front;
    private Integer tail;
    private Integer size;

    public LoopQueue(Integer capacity) {
        this.data = (T[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public Integer getCapacity() {
        return this.data.length - 1;
    }

    @Override
    public Boolean isEmpty() {

        return this.front.equals(this.tail);
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public void enqueue(T element) {
        if ((this.tail + 1) % this.data.length == this.front) {
            this.resize(getCapacity() * 2);
        }
        this.data[this.tail] = element;
        this.tail = (this.tail + 1) % this.data.length;
        this.size++;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from a empty queue.");
        }
        T ret = this.data[front];
        this.data[front] = null;
        this.front = (this.front + 1) % this.data.length;
        this.size--;
        if (this.size == this.getCapacity() / THRESHOLD && this.getCapacity() / 2 != 0) {
            this.resize(this.getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public T getFront() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return this.data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d ,capacity = %d\n", this.size, this.getCapacity()));
        res.append("front [");
        for (int i = this.front; i != tail; i = (i + 1) % this.data.length) {
            res.append(this.data[i]);
            if ((i + 1) % this.data.length != this.tail) {
                res.append(",  ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    private void resize(Integer newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (Integer i = 0; i < this.size; i++) {
            newData[i] = this.data[(i + this.front) % this.data.length];
        }
        this.data = newData;
        this.front = 0;
        this.tail = this.size;
    }

}
