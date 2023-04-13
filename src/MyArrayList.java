/*public class MyArrayList<T> {
    private T[] arr;
    private int size;
    public MyArrayList(){
        arr= int[5];
        size=0;
    }
    public void add(int value){
        if(size==arr.length){
        arr[size++]=value;
     }
    }
    public void increaseSize(){
        int[]newArr=new int[arr.length*2];
        for(int i=0; i<arr.length;i++){
            newArr[i]=arr[i];
        }
        arr=newArr;}
    public int getElement(int index){
        checkIndex(index);
        return arr[index];
    }
     public int getSize(){
        return  size;
     }
     public void clear(){
        this.arr=new int[5];
        this.size=0;
     }
     public void delete(int index){
         for(int i=index+1;i<size;i++){
             arr[i-1]=arr[i];
         }
         size--;
     }
     public void checkIndex( int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
     }



}*/
