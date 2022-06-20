package Funtion;

import Resource.Resource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Delete {
    public static void del()
    {
        ResourceBundle r=ResourceBundle.getBundle("Pro");
        String s=r.getString("Pro");
        String s1=r.getString("idcount");//有多少次id了
        int k=Integer.parseInt(s1);
        AddAccount.ReadContent(s);
        System.out.print("请输入要删除的元素的id");
        System.out.print("(元素有"+Collectionstore.l.size()+"个):");
        Scanner ss=new Scanner(System.in);
        int i=ss.nextInt();
        if(i>=Collectionstore.l.size()&&i<0)
        {
            System.out.println("输入数字过大或者过小");
            return;
        }
        int length=Collectionstore.l.size();
        Collectionstore.l.remove(i-1);
        //删除之后需要更新值
        for(int ii=i;ii<length;ii++)
        {
            Collectionstore.l.get(ii-1).setID(Collectionstore.l.get(ii-1).getID()-1);
        }
        writeP(Collectionstore.l,s);
        System.out.println("Collectionstore.l.size()->"+Collectionstore.l.size());
        AddAccount.setProperties("Pro.properties","idcount",String.valueOf(Collectionstore.l.size()));
        AddAccount.ReadContent(s);
    }
    public static void writeP(List<Resource> m,String s)
    {
        FileWriter p=null;
        try {
            p=new FileWriter(Thread.currentThread().getContextClassLoader().getResource(s).getPath());
            for(int i=0;i<m.size();i++)
            {
                p.write(linked(m.get(i)));
            }
            p.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(p!=null)
            {
                try {
                    p.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public static String linked(Resource m)
    {
        StringBuilder b=new StringBuilder(20);
        b.append(m.getID());
        b.append("  ");
        b.append(m.getCategory());
        b.append("  ");
        b.append(m.getAccount());
        b.append("  ");
        b.append(m.getNumberl());
        b.append("  ");
        b.append(m.getDate());
        b.append("  ");
        b.append(m.getDescription());
        b.append("\n");
        return b.toString();
    }
}
