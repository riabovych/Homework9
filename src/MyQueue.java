public class MyQueue {
    private Object[] myArray;
    private int size;

    public MyQueue() {
        this.myArray = new Object[0];
        size = 0;
    }

    public void add(Object value) {
        Object[] increasedArray = new Object[myArray.length + 1];
        for (int i = 0; i < myArray.length; i++) {
            increasedArray[i] = myArray[i];
        }
        increasedArray[increasedArray.length - 1] = value;
        this.myArray = increasedArray;
        size++;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add(2);
        queue.add(4);
        queue.printArray();
        queue.peek();
        queue.poll();
        queue.add(6);
        queue.printArray();
        queue.size();
        queue.clear();
        queue.size();
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        System.out.println("The first element is " + myArray[0]);
        return myArray[0];
    }


    public Object poll() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object first = myArray[0];
        Object[] removedArray = new Object[myArray.length - 1];
        for (int i = 1; i < size; i++) {
            removedArray[i - 1] = myArray[i];
        }
        this.myArray = removedArray;
        size--;

        System.out.println("The first to remove element is " + first);
        return first;
    }


    public void clear() {
        this.myArray = new Object[0];
        size = 0;
    }

    public int size() {
        System.out.println("the size of queue is: " + size);
        return size;
    }
}
