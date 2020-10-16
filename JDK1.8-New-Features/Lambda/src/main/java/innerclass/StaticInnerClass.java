package innerclass;

public class StaticInnerClass implements  Hobby2{
    @Override
    public void show() {
        System.out.println("外部类的爱好是encoding");
    }

    static  class Demo02 implements Hobby2{
        @Override
        public void show() {
            System.out.println("静态内部类没有爱好");
        }
    }
    public static void main(String[] args){
        new StaticInnerClass().show();
        new Demo02().show();
    }
}

interface Hobby2{
    void show();
}
