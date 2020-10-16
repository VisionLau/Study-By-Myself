package innerclass;

public class LocalInnerClass implements  Hobby1{
    @Override
    public void show() {
        System.out.println("外部类的爱好是encoding");
    }
    public static void main(String[] args){
        class Demo02 implements Hobby1{
            @Override
            public void show() {
                System.out.println("局部内部类没有爱好");
            }
        }
        new LocalInnerClass().show();
        new Demo02().show();
    }
}

interface Hobby1{
    void show();
}
