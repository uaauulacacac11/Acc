package Funtion;

import Resource.Resource;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddAccount{

    //在集合中内存保存着属性，同时整体数据也保存在文件中
    public static void Add() {
        ResourceBundle r = ResourceBundle.getBundle("Pro");
        String s = r.getString("Pro");//得到相对的路径
        String s1 = r.getString("idcount");//有多少次id了
        int k = Integer.parseInt(s1);

        Resource oo = new Resource();

        WriteIDContent(s, r);//写入txt文件中
        /*写入类别* */
        System.out.print("1、请输入类别:");
        Scanner sm = new Scanner(System.in);
        String k1 = sm.next();
        oo.setCategory(k1);//先给它一个对象记得
        WriteContent(s, r, k1);//写入txt文件中
        /*写入账户
         * */
        System.out.print("2、请输入账户:");
        String k2 = sm.next();
        oo.setAccount(k2);
        WriteContent(s, r, k2);


        System.out.print("3、请输入金额[请输入数字]:");
        String k3 = sm.next();
        oo.setNumberl(Double.valueOf(k3));
        WriteContent(s, r, k3);

        System.out.print("4、请输入日期[格式yyyy-MM-dd]:");
        String k4 = sm.next();
        if (k4.length() == 0)//判断是否为0
        {
            try {
                throw new InputException("输入错误");
            } catch (InputException e) {
                e.getMessage();
                return;
            }
        }
        int count = 0;
        for (int i = 0; i < k4.length(); i++) {
            if (k4.charAt(i) == '-') {
                count++;
            }
        }
        if (count == 2) {
            oo.setDate(k4);
            WriteContent(s, r, k4);
        } else {
            System.out.println("输入错误");
            return;
        }

        System.out.print("5、请输入说明(不输入输入0):");
        String k5 = sm.next();
        if ("0".equals(k5)) {
            k5 = "无";
        }
        oo.setDescription(k5);
        WriteContent(s, r, k5);
        WriteContent(s, r, "\n");
        System.out.println();
        System.out.println("id 类别 账户 金额 时间      说明\t");
        ReadContent(s);
        Collectionstore.l.add(oo);
    }
    /* //修改properties文件
      public static void setProperties(String path,String key,String value) throws Exception{
          FileReader f=new FileReader(Thread.currentThread().getContextClassLoader().getResource(path).getPath());
          Properties p=new Properties();
          p.load(f);
          p.setProperty(key,value);//set修改到内存里
          //然后需要
          FileWriter fos=new FileWriter(Thread.currentThread().getContextClassLoader().getResource(path).getPath(),false);
          p.store(fos,null);
          //fos.flush();
          //fos.close();
      }*/
    //setProperties("Pro.properties","idcount",String.valueOf(k));
    public static void setProperties(String path,String key,String value) {
        Properties p=new Properties();
        try {
            InputStream inputStream =Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
            p.load(inputStream);
            p.setProperty(key,value);
            FileOutputStream oFile=new FileOutputStream(Thread.currentThread().getContextClassLoader().getResource(path).getPath(),false);
            p.store(oFile,null);
            oFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //fos.flush();
        //fos.close();
    }

    //增加IDr.txt,在里面加1的配置文件
    public static void WriteIDContent(String path,ResourceBundle r)
    {
        int k=Collectionstore.l.size();
        System.out.println("Write->"+k);
        FileWriter pp=null;
        try {
            pp=new FileWriter(Thread.currentThread().getContextClassLoader().getResource(path).getPath(),true);
            String l=(++k)+"  ";
            pp.write(l);
            pp.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (pp!=null)
            {
                try {
                    pp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("k->"+k);
        setProperties("Pro.properties","idcount",String.valueOf(k));
    }
    //String属性写入txt
    public static void WriteContent(String path,ResourceBundle r,String value)
    {

        FileWriter pp=null;
        try {
            pp=new FileWriter(Thread.currentThread().getContextClassLoader().getResource(path).getPath(),true);
            String l="";
            if(value=="\n")
            {
                l=value;
            }
           else
            {
                l=value+"  ";
            }
            pp.write(l);
            pp.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (pp!=null)
            {
                try {
                    pp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //有异常没写
    //读出txt全部内容,重写下
    //返回一个内容即可
    public static void ReadContent(String path)
    {
        FileReader k=null;
        //System.out.println();
        try {
            k=new FileReader(Thread.currentThread().getContextClassLoader().getResource(path).getPath());
            //C:\Users\86137\IdeaProjects\Acc\src\Resource\aIDr.txt
            char[] chars=new char[4];
            int c=0;

            while((c=k.read(chars))!=-1)
            {
                String s=new String(chars,0,c);
                System.out.print(s);
            }
            System.out.print(" ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(k!=null)
            {
                try {
                    k.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
