package com.vision.test;

public class StaticProxyTest {
    public static void main(String[] args){
        new weddingCompany(new who("小明")).marry();
    }
}

interface Marry {
    void marry();
}

class who implements Marry {
    private String name;
    public who(String name) {
        this.name = name;
    }
    @Override
    public void marry() {
        System.out.println(name + "结婚了");
    }
}

class weddingCompany implements Marry {
    private Marry whoIsMarry;//谁要结婚
    public weddingCompany(Marry whoIsMarry) {
        this.whoIsMarry = whoIsMarry;
    }
    @Override
    public void marry() {
        befor();
        whoIsMarry.marry();
        after();
    }
    private void befor() {
        //添加了一行注释 测试
        System.out.println("结婚前，婚庆公司开始筹备");
    }
    private void after(){
        //又添加了一行注释 测试
        System.out.println("结婚后，婚庆公司收取尾款123");
    }
}
