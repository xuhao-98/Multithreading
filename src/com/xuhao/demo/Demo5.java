package com.xuhao.demo;

/**
 * 描述：
 *
 * @author XuHao
 * @date 2020/9/18  15:03
 **/
public class Demo5 implements Runnable{
    //胜利者
    private static String winner;
    @Override
    public void run() {
        //判断比赛是否结束
        for (int i = 0; i < 100; i++) {
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子")&& i%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--->跑了"+i+"步");
        }
    }
    //判断是否完成比赛
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if (winner!=null){
            return true;
        }if (steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is "+winner+"!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        new Thread(demo5,"兔子").start();
        new Thread(demo5,"乌龟").start();
    }
}
