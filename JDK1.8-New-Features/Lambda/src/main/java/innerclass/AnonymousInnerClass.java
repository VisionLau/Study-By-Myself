package innerclass;

public class AnonymousInnerClass implements  Hobby3{
    @Override
    public void show() {
        System.out.println("外部类的爱好是encoding");
    }

    public static void main(String[] args){
        new AnonymousInnerClass().show();
        Hobby3 hobby = new Hobby3() {
            @Override
            public void show() {
                System.out.println("匿名内部类没有爱好");
            }
        };
        hobby.show();
    }
}

interface Hobby3{
    void show();
}
