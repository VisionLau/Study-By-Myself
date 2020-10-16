package innerclass;

public class SimpleInnerClass implements  Hobby{
    @Override
    public void show() {
        System.out.println("外部类的爱好是encoding");
    }

    class Demo02 implements Hobby{
        @Override
        public void show() {
            System.out.println("常规内部类没有爱好");
        }
    }
    public static void main(String[] args){
        SimpleInnerClass demo01 = new SimpleInnerClass();
        demo01.show();
        demo01.new Demo02().show();
    }
}

interface Hobby{
    void show();
}
