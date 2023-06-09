public class MyArrayList <T> implements MyList <T> {
    private T[] arr;
    private int size;
    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }


    public void  add(T element){
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

    @Override
    public void add(T item, int index) {

    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    public T getElement(int index) {
        checkIndex(index);
        return arr[index];
    }

    public int getSize() {
        return size;
    }
    @Override
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public T get(int index){
        checkIndex(index);
        return(T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i>=0; i--){
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < size; i++) {
                if (((Comparable) arr[i-1]).compareTo(arr[i]) > 0) {
                    Object temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = (T) temp;
                    swap = true;
                }
            }

        }
    }
  public void  subString(int fromIndex,int toIndex){
            if(fromIndex>0||toIndex>size)
                for (int i = fromIndex; i < toIndex; i++) {
                    if (((Comparable) arr[i-1]).compareTo(arr[i]) > 0) {
                        Object temp = arr[i-1];
                        arr[i-1] = arr[i];arr[i] = (T) temp;

                    }
                }
        }

    public void delete(int index){
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
    }
    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }


}
