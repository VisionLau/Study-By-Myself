public class ArrayDemo4 {
    public static void main(String[] args){
        int array[]={10,50,40,60,80};
        for (int i = 0; i < array.length; i++) {
            int num=array[i]; //获取角标为i的元素
            array[i]=array[array.length-1];//角标最大的值赋给角标为i的
            array[array.length-1-i]=num;//num重新赋回去
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
    }
}
