package Funtion;

import Resource.Resource;

import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Check {
    public static void C()
    {
        ResourceBundle r= ResourceBundle.getBundle("Pro");
        String s=r.getString("Pro");
        System.out.println("id 类别 账户 日期     说明\t");
        AddAccount.ReadContent(s);
        System.out.print("1、搜索id，2、搜索类别 3、搜索账户 4、搜索日期 5、搜索说明");
        System.out.println();
        System.out.print("请输入您要的功能:");
        Scanner sm=new Scanner(System.in);
        int kk=sm.nextInt();
        System.out.println();
        System.out.print("输入您要查询的信息:");
        String kk1=sm.next();
        System.out.println("id 类别 账户 日期     说明\t");
        switch (kk)
        {
            case 1:
                System.out.println(Collectionstore.l.get(kk-1));
                break;
            case 2:
                getinfomation(l.类别,kk1);
                break;
            case 3:
                getinfomation(l.账户,kk1);
                break;
            case 4:
                getinfomation(l.日期,kk1);
                break;
            case 5:
                getinfomation(l.说明,kk1);
                break;
                default:
                    System.out.println("输入错误!");
        }
    }
    public static void getinfomation(l lm,String kk)//获取信息
    {
        Iterator<Resource> it=Collectionstore.l.iterator();
        while(it.hasNext())
        {
            Resource r=it.next();
            if(l.类别==lm)
            {
               if(kk.equals(r.getCategory()))
               {
                   System.out.println(r.toString());
               }
            }else if(l.账户==lm)
            {
                if(kk.equals(r.getAccount()))
                {
                    System.out.println(r.toString());
                }
            }
            else if(l.日期==lm)
            {
                if(kk.equals(r.getDate()))
                {
                    System.out.println(r.toString());
                }
            }
            else if(l.说明==lm)
            {
                if(kk.equals(r.getDescription()))
                {
                    System.out.println(r.toString());
                }
            }
        }


        }
}
enum l
{  类别,账户,金额,日期,说明}