package testdemo;


public class TestDemo {
    public static void main(String[] args) {
        // ||: 短路 或运算符； a()||b():a()为false,才会执行 b()
        System.out.println(a()||b());
    }
    public  static   boolean a(){
        System.out.println("a");
        return  false;
    }
    public  static   boolean b(){
        System.out.println("b");
        return  true;
    }

}
