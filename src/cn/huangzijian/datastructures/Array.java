package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/14 00:25
 */
public class Array<T> {
    private T[] data;
    private int size;

    /**
     * 传入 capacity 构造 Array
     *
     * @param
     */
    public Array(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 默认构造 capacity = 10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     *
     * @return size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 在指定位置插入一个新元素 element
     *
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("AddLast failed. Required index >= 0 and <= size");
        }
        if (this.size == this.data.length) {
            this.resize(2 * this.data.length);
        }
        for (int i = this.size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = element;
        this.size++;
    }

    /**
     * 在所有元素的后面添加一个新元素
     *
     * @param element
     */
    public void addLast(T element) {
        this.add(size, element);
    }

    /**
     * 在所有元素前添加一个新元素
     *
     * @param element
     */
    public void addFirst(T element) {
        this.add(0, element);
    }

    /**
     * 获取 index 索引位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Required index >= 0 and < size");
        }
        return this.data[index];
    }

    /**
     * 修改 index 索引位置的元素为 element
     *
     * @param index
     * @param element
     */
    public void set(int index, T element) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Set failed. Required index >= 0 and < size");
        }
        this.data[index] = element;
    }

    /**
     * 查找数组中是否包含元素 element
     *
     * @param element
     * @return
     */
    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素 element 在数组中的索引
     * 若数组中不存在 element 则返回 -1
     *
     * @param element
     * @return
     */
    public int find(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除 index 位置的元素，并返回被删除的元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Remove failed. Required index >= 0 and < size");
        }
        T ret = this.data[index];
        for (int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.size--;
        this.data[size] = null;
        if (size == this.data.length / 4 && this.data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组中第一个元素，并返回被删除的元素
     *
     * @return
     */
    public T removeFirst() {
        return this.remove(0);
    }

    /**
     * 删除数组中最后一个元素，并返回该元素
     *
     * @return
     */
    public T removeLast() {
        return this.remove(this.size - 1);
    }

    /**
     * 从数组中删除元素 element
     *
     * @param element
     */
    public void removeElement(T element) {
        int index = this.find(element);
        if (index != -1) {
            this.remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d ,capacity = %d\n", this.size, this.data.length));
        res.append("[");
        for (int i = 0; i < this.size; i++) {
            res.append(this.data[i]);
            if (i != this.size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * new 一个容量为 newCapacity 的新数组
     * 将 this.data 的元素复制到新数组
     * 将 this.data 的指向为新数组
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
}
