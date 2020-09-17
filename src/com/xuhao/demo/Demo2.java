package com.xuhao.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 描述：
 *
 * @author XuHao
 * @date 2020/9/17  14:45
 **/
//练习thread,多线程现在图片
public class Demo2 extends Thread {
    private String url;
    private String name;

    public Demo2(String url,String name) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        downLoad dl = new downLoad();
        dl.downLoad(url, name);
        System.out.println("下载的文件名:"+name);
    }

    public static void main(String[] args) {
        Demo2 d = new Demo2("http://pic.netbian.com/uploads/allimg/200618/005100-1592412660d6f4.jpg","2.jpg");
        Demo2 d1 = new Demo2("http://pic.netbian.com/uploads/allimg/200618/005100-1592412660d6f4.jpg","3.jpg");
        Demo2 d2 = new Demo2("http://pic.netbian.com/uploads/allimg/200618/005100-1592412660d6f4.jpg","4.jpg");
        d.start();
        d1.start();
        d2.start();
    }
}

//下载器
class downLoad {
    //下载方法
    public void downLoad(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Io异常");
        }
    }
}
