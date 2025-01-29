import java.util.EmptyStackException;

public class MyStack {

    private Object[] myArray;
    private int size;

    public MyStack() {
        this.myArray = new Object[0];
        size = 0;
    }

    public void printArray(){
        for (int i = 0; i < size; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }

    public void clear(){
        this.myArray = new Object[0];
        size = 0;
    }

    public int size(){
        System.out.println("The size of Stack is " + size);
        return size;
    }

    public void push(Object value) {
        Object[] increasedArray = new Object[myArray.length + 1];
        for (int i = 0; i < myArray.length; i++) {
            increasedArray[i] = myArray[i];
        }
        increasedArray[increasedArray.length - 1] = value;
        this.myArray = increasedArray;
        size++;
    }

    public void remove(int index){
        if (index < 0 || index >= myArray.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Object[] removedArray = new Object[myArray.length - 1];
        for (int i = 0; i < myArray.length - 1; i++) {
            if(i < index){
                removedArray[i] = myArray[i];
            }
            else {
                removedArray[i] = myArray[i+1];
            }
        }
        this.myArray = removedArray;
        size--;
    }

    public Object peek(){
        if(size == 0){
            throw new EmptyStackException();
        }
        System.out.println("The peaked element is " + myArray[size-1]);
        return myArray[size-1];
    }

    public Object poll() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object first = myArray[size-1];
        Object[] removedArray = new Object[myArray.length - 1];
        for (int i = 0; i < size - 1; i++) { // anton 3 5 Stas
           removedArray[i] = myArray[i];
        }
        this.myArray = removedArray;
        size--;

        System.out.println("The first to remove element is " + first);
        return first;
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("Anton");
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.remove(1);
        stack.printArray();
        stack.size();
        stack.peek();
        stack.push("Stas");
        stack.peek();
        stack.poll();
        stack.printArray();
    }
}
