package lambda;

public class LambdaTest implements hobby5{
    @Override
    public void show(String name) {
        System.out.println("外部类的爱好是"+name);
    }

    public static void main(String[] args) {
        new LambdaTest().show("encoding");
       /* hobby5 hobby5=(String name)->{
            System.out.println("Lambda表达式"+name);
        };*/
        /*hobby5 hobby5=(name)->{
            System.out.println("Lambda表达式"+name);
        };*/
       /* hobby5 hobby5=name -> {
            System.out.println("Lambda表达式"+name);
        };*/
        hobby5 hobby5=name ->  System.out.println("Lambda表达式"+name);
        hobby5.show("没有爱好");
    }
}
@FunctionalInterface
interface hobby5{
    void show(String name);
}