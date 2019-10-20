package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 18:32
 */
public class ArrayStack<T> implements Stack<T> {
    Array<T> array;

    public ArrayStack(Integer capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<>();
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
    public void push(T element) {
        this.array.addLast(element);
    }

    @Override
    public T pop() {
        return this.array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("【");
        for (int i = 0; i < this.array.getSize(); i++) {
            res.append(this.array.get(i));
            if (i != this.array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("】top");
        return res.toString();
    }
}
