public class MyHashMap {

    Node head;
    private int count;

    static class Node {
        Object value;
        Object key;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

    public void put(Object key, Object value) {
        if (head == null) {
            head = new Node(key, value);
            count++;
            System.out.println("Added, count: " + count);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(key, value);
        count++;
        System.out.println("Added, count: " + count);
    }


    public void remove(Object key) {
        if (head == null) return;
        if (head.key == key) {
            head = head.next;
            count--;
            System.out.println("Removed, count: " + count);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                count--;
                System.out.println("Removed, count: " + count);
                return;
            }
            current = current.next;
        }
    }


    public String print() {
        String printing = "[";
        Node current = head;
        while (current != null) {
            printing += current.key;
            printing += " - ";
            printing += current.value;
            if (current.next != null) {
                printing += ", ";
            }
            current = current.next;
        }
        printing += "]";
        System.out.println(printing);
        return printing;
    }
    public Object get(int index){
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException("Index out of bounds " + index);
        }
        if(head == null){
            throw new IllegalStateException("List is empty");
        }

        Node current = head;
        for (int i = 0; i < index ; i++) {
            current = current.next;
        }
        System.out.println("you got: " + current.value);
        return current.value;
    }

    public int size(){
        System.out.println("size of array is: " + count);
        return count;
    }

    public void clear(){
        head = null;
        count = 0;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("stas@gmail.com", "2256878");
        hashMap.put("dima@gmail.com", "213213333");
        hashMap.put("lera@gmail.com", "14214");
        hashMap.print();
        hashMap.remove("dima@gmail.com");
        hashMap.print();
        hashMap.put("denys@gmail.com", "92352");
        hashMap.put("anton@gmail.com", "56437873");
        hashMap.print();
        hashMap.get(2);
        hashMap.print();
        hashMap.size();
        hashMap.clear();
        hashMap.print();
    }
}
