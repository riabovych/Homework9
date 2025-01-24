public class MyArrayList {
    private int[] myArray;

    public MyArrayList() {
        this.myArray  = new int[0];
    }

    public int get(int index){
        if (index < 0 || index >= myArray.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        System.out.println("the number by index " + index + " is "+ myArray[index]);
        return myArray[index];
    }

    public void add(int number) {
        int [] increasedArray = new int[myArray.length+1];
        for (int i = 0; i < myArray.length ; i++) {
            increasedArray[i] = myArray[i];
        }
        increasedArray[increasedArray.length-1] = number;
        this.myArray = increasedArray;
    }

    public void remove(int index) {
        if (index < 0 || index >= myArray.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        int[] removedArray = new int[myArray.length - 1];
        for (int i = 0; i < myArray.length -1; i++) {
            if (i < index) {
                removedArray[i] = myArray[i];
            } else {
                removedArray[i] = myArray[i + 1];
            }
        }
        this.myArray = removedArray;
    }


    public void clear(){
        this.myArray = new int[0];
    }

    public void size(){
        int size = 0;
        for (int i = 0; i < myArray.length; i++) {
            if(myArray[i] != 0){
                size++;
            }
        }
        System.out.println("size is " + size);
    }



    public void printArray(){
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(2);
        list.add(4);
        list.add(5);
        list.printArray();
        list.size();
        list.get(1);
        list.printArray();
        list.clear();
        list.add(65);
        list.printArray();
    }
}
