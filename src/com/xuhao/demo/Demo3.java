package com.xuhao.demo;

/**
 * 描述：
 *
 * @author XuHao
 * @date 2020/9/17  15:46
 **/
//实现runnable接口,重写run方法,执行线程丢入实现类
public class Demo3 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("妹妹在干嘛"+i);
        }
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        Thread thread = new Thread(demo3);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在想哥哥"+i);
        }
    }
}
