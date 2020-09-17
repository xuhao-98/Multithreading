package com.xuhao.demo;

/**
 * 描述：
 *
 * @author XuHao
 * @date 2020/9/17  13:34
 **/
//继承Thread类,重写run()方法,调用start
public class Demo extends Thread{
    @Override
    public void run() {
        //run方法线程
        for (int i = 0; i < 200; i++) {
            System.out.println("哥哥在干嘛"+i);
        }
    }

    public static void main(String[] args) {
        //new一个新的线程对象 调用start方法
        Demo demo = new Demo();
        demo.start();
        //主方法线程
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在想妹妹"+i);
        }

    }
}
