package cn.huangzijian.datastructures;

/**
 * @author: huangzijian888
 * @date: 2019/10/20 20:25
 */
public class LikedListQueue<T> implements Queue<T> {
    private Node head;
    private Node tail;
    private Integer size;

    public LikedListQueue() {
        this.size = 0;
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public Boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enqueue(T e) {
        if (this.tail == null) {
            this.tail = new Node(e);
            this.head = this.tail;
        } else {
            this.tail.next = new Node(e);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot deque from an empty queue.");
        }
        Node retNode = this.head;
        this.head = this.head.next;
        retNode.next = null;
        if (this.head == null) {
            this.tail = null;
        }
        this.size--;
        return retNode.element;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return this.head.element;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: front ");
        Node current = this.head;
        while (current != null) {
            stringBuilder.append(current + "->");
            current = current.next;
        }
        stringBuilder.append("NULL tail");
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
