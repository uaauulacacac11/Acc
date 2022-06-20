package Funtion;

import Resource.Resource;

import java.io.*;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Edit {
    public static void Editm()
    {
        ResourceBundle r=ResourceBundle.getBundle("Pro");
        String s=r.getString("Pro");//得到相对的路径
        System.out.println("id 类别 账户 金额 时间      说明\t");
        AddAccount.ReadContent(s);

        Scanner ss=new Scanner(System.in);
        System.out.println();
        System.out.print("输入您要修改的数据的id:");
        int i=ss.nextInt();
        Iterator<Resource> it=Collectionstore.l.iterator();
        Resource sm=null;
        while(it.hasNext())
        {
            sm=it.next();
            //System.out.println(sm.getID());
            if(i==sm.getID())//找id
            {
                break;
            }
        }
        if(it.hasNext()==false)
        {
            boolean m=true;
           A: while(m)
            {
                System.out.print("输入您想要修改的数据[1、类别，2、账号，3、金额，4、日期，5、说明]:");
                int i2=ss.nextInt();
                String s1="";
                switch (i2)
                {
                    case 1:
                        System.out.print("请输入修改的类别:");
                        s1=ss.next();
                        sm.setCategory(s1);
                        Collectionstore.l.get(i-1).setCategory(s1);
                        System.out.println("修改成功！");
                        break;
                    case 2:
                        System.out.print("请输入修改的账号:");
                        s1=ss.next();
                        sm.setAccount(s1);
                        Collectionstore.l.get(i-1).setAccount(s1);
                        System.out.println("修改成功！");
                        break;
                    case 3:
                        System.out.print("请输入修改的金额:");
                        s1=ss.next();
                        sm.setNumberl(Double.valueOf(s1));
                        Collectionstore.l.get(i-1).setNumberl(Double.valueOf(s1));
                        System.out.println("修改成功！");
                        break;
                    case 4:
                        System.out.print("请输入修改的日期:");
                        s1=ss.next();
                        sm.setDate(s1);
                        Collectionstore.l.get(i-1).setDate(s1);
                        System.out.println("修改成功！");
                        break;
                    case 5:
                        System.out.print("请输入修改的说明:");
                        s1=ss.next();
                        sm.setDescription(s1);
                        Collectionstore.l.get(i-1).setDescription(s1);
                        System.out.print("修改成功！");
                        break;
                    default:
                        System.out.print("输入错误");
                }
                //AddAccount.WriteContent(s,r,s1);//修改txt文件
                OverWrite(s);
                System.out.println();
                System.out.println("id 类别 账户 金额 时间      说明\t");
                AddAccount.ReadContent(s);
                System.out.println("是否继续修改这条数据[输入是/否]");
                String s2=ss.next();
                if("否".equals(s2))
                {
                    break A;
                }
                System.out.println();
                System.out.println("id 类别 账户 金额 时间      说明\t");
                AddAccount.ReadContent(s);
            }
        }
        else
        {
            System.out.println("没有找到该id！");
        }
    }

    public static void OverWrite(String path)
    {
        String pathh=Thread.currentThread().getContextClassLoader().getResource(path).getPath();
        FileWriter pw=null;
        try {
            pw=new FileWriter(pathh,false);
            for(int i=0;i<Collectionstore.l.size();i++)
            {
                pw.write(Collectionstore.l.get(i).toString());
            }
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pw!=null)
            {
                try {
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
    public static void OverWrite(String path,int line,String pre)//覆盖
    {
        String pathh=Thread.currentThread().getContextClassLoader().getResource(path).getPath();
        FileWriter pw=null;
        try {
            pw=new FileWriter(pathh,false);
            String m=getOneLine(path,line-1);//前i行照旧
            pw.write(m);
            pw.write(pre);
            m=getOneLine(path,line,1);
            pw.write(m);
            //pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pw!=null)
            {
                try {
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String getOneLine(String path,int line,int...mm)
    {
        String pat=Thread.currentThread().getContextClassLoader().getResource(path).getPath();
        FileReader m=null;
        StringBuilder m2=new StringBuilder(20);
        try {
            m=new FileReader(pat);
            char[] m1=new char[1];
            int c=0;

            if(mm.length==0)
            {
                for(int i=0;i<line;i++)
                {
                    while((c=m.read(m1))!=-1)
                    {
                        m2.append(m1);
                        if(m1[0]=='\n')
                        {
                            break;
                        }
                    }
                }
            }else
            {
                A:for (int i = 0; i <line ; i++) {
                    while((c=m.read(m1))!=-1)//先判断是否读
                    {
                        if(m1[0]=='\n')
                        {
                            break A;
                        }
                    }
                }
               while((c=m.read(m1))!=-1)
               {
                   m2.append(m1);
               }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(m!=null)
            {
                try {
                    m.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(m2.toString());
        return m2.toString();
    }*/
}
