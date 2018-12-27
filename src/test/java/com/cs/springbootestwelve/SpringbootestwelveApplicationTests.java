package com.cs.springbootestwelve;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootestwelveApplicationTests {


//    @Test
//    public void TestOne(String strUrl,String strUrl2){
////        String strUrl="http://search.dangdang.com/?key=%BB%FA%D0%B5%B1%ED&act=input";
//        try {
//            URL url=new URL(strUrl);
//            //创建url建立网页的链接
//            File file=new File(strUrl2);
//            //获取要存储本地的路径
//            URLConnection conn=url.openConnection();
//            //通过链接取得网页返回的数据
//            InputStream is=conn.getInputStream();
//            System.out.println(conn.getContentEncoding());
//            //一般按行读取网页读取，并进行内容分析
//            //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
//            //进行转化时，需要处理编码格式问题
//            BufferedReader br=new BufferedReader(new InputStreamReader(is,"gbk"));
//            String line=null;
//            while ((line=br.readLine())!=null){
//                TestFour(new File(strUrl),strUrl2);
//            }
//            br.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void TestTwo() {
        File file1= new File("C:\\Users\\lenovo\\Desktop\\杂\\a.txt");
        File file2=new File("C:\\Users\\lenovo\\Desktop\\杂\\as");
        try {
            System.out.println(file1.createNewFile());//创建文件用方法createNewFile
            System.out.println(file2.mkdir());//创建文件夹用方法用mkdir
            if(file1.createNewFile()&&file2.mkdir()){
                System.out.println(file1.delete()+"\n"+file2.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Test
    public void TestThree(){
        File file=new File("C:\\");
        File [] strArray=file.listFiles();
        for (File f:strArray){
            if(f.getName().endsWith(".DBF")){//getName()获取文件全名，endsWith()判断后缀名
                System.out.println(f.getName());
            }
        }
//        String[] strArray=file.list();
//        for (String s:strArray){
//            System.out.println(s);
//
//        }

    }


    public void TestIo(File file,String str){
        BufferedWriter fileWriter= null;
        try {
//            fileWriter = new FileWriter(file,true);//不支持设置格式
            fileWriter=new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"gbk")));
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    @Test
//    public  void TestFour(File file,String str){
////        File file=new File("C:\\Users\\lenovo\\Desktop\\杂\\a.txt");
//        try {
//            if (!file.exists()){
//                if (file.createNewFile()){
//                    TestIo(file,str);
//                    System.out.println("通过第一种方式创建");
//                }else {
//                    System.out.println("文件创建失败");
//                }
//            } else{
//                TestIo(file,str);
//                System.out.println("通过第二种方式创建");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void contextLoads() {
        String strUrl="http://search.dangdang.com/?key=%BB%FA%D0%B5%B1%ED&act=input";
        String strUrl2="C:\\Users\\lenovo\\Desktop\\杂\\a.html";
        try {
            URL url=new URL(strUrl);
            //创建url建立网页的链接
            File file=new File(strUrl2);
            //获取要存储本地的路径
            URLConnection conn=url.openConnection();
            //通过链接取得网页返回的数据
            InputStream is=conn.getInputStream();
            System.out.println(conn.getContentEncoding());
            //一般按行读取网页读取，并进行内容分析
            //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
            //进行转化时，需要处理编码格式问题
            BufferedReader br=new BufferedReader(new InputStreamReader(is,"gbk"));
            String line=null;
            while ((line=br.readLine())!=null){
                try {
                    if (!file.exists()){
                        if (file.createNewFile()){
                            TestIo(file,line);
                            System.out.println("通过第一种方式创建，已经写入内容");
                        }else {
                            System.out.println("文件创建失败");
                        }
                    } else{
                        TestIo(file,line);
                        System.out.println("通过第二种方式创建，已经写入内容");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

