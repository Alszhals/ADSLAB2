import java.util.LinkedList;

public class MyLinkedList <T> implements MyList<T>{
    private class Node{
        T element;
        Node next;
        Node prev;
        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(T element) {
        Node node = new Node(element);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;

    }

    @Override
    public void add(T element, int index) {
        if (index >= 0 && index <= size) {
            Node node = new Node(element);
            if (index == 0) {
                node.next = head;
                head.prev = node;
                head = node;
            } else if (index == size) {
                tail.next = node;
                node.prev = tail;
                tail = node;
            } else {
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                node.next = current;
                node.prev = current.prev;
                current.prev.next = node;
                current.prev = node;
            }
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean remove(T item) {
        Node current = head;
        while (true) {
            if (current == null) break;
            if (current.element.equals(item)) {
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current.next == null) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        boolean b = index >= size;
        if (index < 0|| b) {
            throw new IndexOutOfBoundsException();
        }

        Node current;
        if (index == 0) {
            current = head;
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            if (index < size / 2) {
                current = head;
                int count = 0;
                while (count < index) {
                    current = current.next;
                    count++;
                }
            } else {
                current = tail;
                int count = size - 1;
                while (count > index) {
                    current = current.prev;
                    count--;
                }
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return (T) current.element;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
