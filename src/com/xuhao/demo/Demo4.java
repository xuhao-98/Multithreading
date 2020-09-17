package com.xuhao.demo;

/**
 * 描述：
 *
 * @author XuHao
 * @date 2020/9/17  16:35
 **/
public class Demo4 implements Runnable {
    private int ticksNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticksNum < 1) {
            break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticksNum--+"票");
        }
    }

    public static void main(String[] args) {
        Demo4 ticket = new Demo4();
        new Thread(ticket,"小许").start();
        new Thread(ticket,"小胡").start();
        new Thread(ticket,"小李").start();
    }
}
