package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/20 17:01
 */
public class LinkedList<T> {
    private Node dummyHead;
    private Integer size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 在链表index(0-based)位置添加一个新元素 element
     *
     * @param index
     * @param element
     */
    public void add(Integer index, T element) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(element, prev.next);
        this.size++;

    }

    /**
     * 在链表头添加元素 element
     *
     * @param element
     */
    public void addFirst(T element) {
        this.add(0, element);
    }

    /**
     * 在链表末尾添加元素 element
     *
     * @param element
     */
    public void addLast(T element) {
        this.add(this.size, element);
    }

    /**
     * 获取链表第 index(0-based) 位置的元素
     *
     * @param index
     * @return
     */
    public T get(Integer index) {

        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node current = this.dummyHead.next;
        for (Integer i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public T getFirst() {
        return this.get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public T getLast() {
        return this.get(this.size - 1);
    }

    /**
     * 修改链表第 index(0-based) 个位置的元素为 element
     *
     * @param index
     * @param element
     */
    public void set(Integer index, T element) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node current = this.dummyHead.next;
        for (Integer i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = element;
    }

    /**
     * 查找链表中是否有元素 element
     *
     * @param element
     * @return
     */
    public Boolean contains(T element) {
        Node current = this.dummyHead.next;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从链表中删除 index(0-based) 位置的元素并返回该元素
     *
     * @param index
     * @return
     */
    public T remove(Integer index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.element;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return this.remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public T removeLast() {
        return this.remove(this.size - 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = this.dummyHead.next;
        while (current != null) {
            stringBuilder.append(current + "->");
            current = current.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    private class Node {
        public Node next;
        private T element;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(T element) {
            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return this.element.toString();
        }
    }
}
