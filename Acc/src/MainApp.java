import Funtion.*;
import Resource.Resource;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
* 打开Pro.properties获取该文件路径，1、读取它的内容 2、往里面写
*
* */
public class MainApp extends AddAccount{
    public static void main(String[] args) {
        /*
        ResourceBundle r=ResourceBundle.getBundle("Pro");
        String s=r.getString("Pro");

        //必须一写一读，不然会出错的。
        WriteIDContent(s,r);
        WriteContent(s,r,"吃饭支出");
        WriteContent(s,r,"交通银行");
        WriteContent(s,r,Double.toString(10.0));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        WriteContent(s,r,sdf.format(new Date()));
        WriteContent(s,r,"家庭聚餐");
        WriteContent(s,r,"\n");
        System.out.print("\t");
        ReadContent(s);
        System.out.print("\t");*/
        //menu();


        /*
        System.out.println("测试");
        ResourceBundle r=ResourceBundle.getBundle("Pro");
        String s=r.getString("Pro");
        ArrayList<Resource> l=getOneLine(s);
        Resource m=l.get(0);
        System.out.println(m.getID());
        System.out.println(m.getCategory());
        System.out.println(m.getNumberl());
        System.out.println(m.getDate());
        System.out.println(m.getDescription());
        */
        //getAllValue();
        getAllValue();
        menu();
    }

    public static void menu()
    {
        while(true)
        {
            System.out.println("----------记账软件----------");
            System.out.println("1、添加账务 2、编辑账务 3、删除账务 4、查询账务 5、退出系统");
            Scanner s=new Scanner(System.in);
            System.out.print("请输入要操作的功能[1-5]:");
            int k=s.nextInt();
            switch (k)
            {
                case 1:
                    AddAccount.Add();
                    break;
                case 2:
                    Edit.Editm();
                    break;
                case 3:
                    Delete.del();
                    break;
                case 4:
                    Check.C();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误");
            }
            System.out.println();
        }
    }

    public static void getAllValue()
    {
        ResourceBundle r=ResourceBundle.getBundle("Pro");
        String s=r.getString("Pro");
        //获取到了地址，然后就是把一行一行的内容提取出来
        String s1=r.getString("idcount");//有多少次id了
        int k=Integer.parseInt(s1);
        //System.out.println(k);
        for(int i=0;i<k;i++)
        {
            getOneLine(s,i);
            //System.out.println("");
        }
    }
    //这个要修改
    public static void getOneLine(String path,int line)//恢复数据,枚举，行数
    {

        FileReader pp=null;
        Resource r=new Resource();
        try {
            pp=new FileReader(Thread.currentThread().getContextClassLoader().getResource(path).getPath());
            int c=0;
            char[] mmm=new char[1];
            A:for (int i = 0; i <line ; i++) {
                while((c=pp.read(mmm))!=-1)//先判断是否读
                {
                    if(mmm[0]=='\n')
                    {
                        break A;
                    }
                }
            }
            //一个一个提取
            //id
            char[] chars=new char[1];

            String m="";
            while ((c=pp.read(chars))!=-1)//判断找id
            {
                if(chars[0]==' ')
                {
                    break;
                }
                m=m+Character.toString(chars[0]);
            }
           // System.out.print(m+" ");
            r.setID(Integer.parseInt(m));

            //类别
            chars=new char[1];
            String cd="";
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]!=' ')
                {
                    cd=Character.toString(chars[0]);
                    break;
                }
            }
            chars=new char[1];//重新置空
            while((c=pp.read(chars))!=-1)
            {

                if(chars[0]==' ')
                {
                    break;
                }
                cd=cd+chars[0];
            }
           // System.out.print(cd+" ");
            r.setCategory(cd);

            //账号
            chars=new char[1];
            cd="";
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]!=' ')
                {
                    cd=Character.toString(chars[0]);
                    break;
                }

            }
            chars=new char[1];
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]==' ')//"  "
                {
                    break;
                }
                cd=cd+chars[0];
            }
            //System.out.print(cd+" ");
            r.setAccount(cd);

            //金额
            chars=new char[1];
            cd="";
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]!=' ')
                {
                    cd=Character.toString(chars[0]);
                    break;
                }
            }
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]==' ')
                {
                    break;
                }
                cd=cd+Character.toString(chars[0]);
            }
            //System.out.print(cd+" ");
            r.setNumberl(Double.valueOf(cd));

            //日期
            chars=new char[1];
            cd="";
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]!=' ')
                {
                    cd=Character.toString(chars[0]);
                    break;
                }
            }
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]==' ')
                {
                    break;
                }
                cd=cd+Character.toString(chars[0]);
            }
           // System.out.print(cd+" ");
            r.setDate(cd);
            //说明
            chars=new char[1];
            cd="";
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]!=' ')
                {
                    cd=Character.toString(chars[0]);
                    break;
                }
            }
            while((c=pp.read(chars))!=-1)
            {
                if(chars[0]=='\n')
                {
                    break;
                }

                cd=cd+Character.toString(chars[0]);
            }
            //System.out.print(cd+" ");
            r.setDescription(cd);
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
        Collectionstore.l.add(r);
    }
}
