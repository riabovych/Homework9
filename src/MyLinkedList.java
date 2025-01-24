public class MyLinkedList {
    Node head;
    Node tail;
    private int count;

    class Node {
        Object value;
        Node next;
        Node prev;

        Node(Object value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public void add(Object value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        count++;
    }

    public void remove(int index){
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException("Index out of bounds " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // переход к нужному узлу
        }
        if(current.prev!= null){
            current.prev.next = current.next; // связал прошлый со след. узлом
        } else {
            head = current.next; // если head = null то мы переходим к след элементу и делаем его head (не null)
        }

        if (current.next!=null){
            current.next.prev = current.prev; // связал след. узел с прошлым
        } else {
            tail = current.prev; //
        }
        count--;
    }

    public Object get(int index){  // 1 3 4 5
        // 0 1 2 3
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException("Index out of bounds " + index);
        }
        Node current = head;
        for (int i = 0; i < index ; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }


    public String toString() {
        String printing = "[";
        Node current = head;

        while (current != null) {
            printing += current.value;
            if (current.next != null) {
                printing += ", ";
            }
            current = current.next;
        }
        printing += "]";
        return printing;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add("dog");
        list.add(2);
        list.add(4);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(2));

    }
}