public class ArrayDemo4 {
    public static void main(String[] args){
        int array[]={10,50,40,60,80};
        for (int i = 0; i < array.length/2; i++) {
            int num=array[i];
            array[i]=array[array.length-1];
            array[array.length-1]=num;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
    }
}
