package Resource;

import Funtion.InputException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Resource {
    private int ID;//id
    private String Category;//类别
    private String Account;//账户
    private double numberl;//金额
    private Date date;//日期（常量，在输出时赋值）
    private String Description;//说明
    public static Resource instance;//new的对象
    public Resource() {
    }

    public static Resource getInstance() {
        return instance;
    }

    public static void setInstance(Resource instance) {
        Resource.instance = instance;
    }

    public Resource(int ID, String category, String account, double numberl, Date date, String description) {
        this.ID = ID;
        Category = category;
        Account = account;
        this.numberl = numberl;
        this.date = date;
        Description = description;
    }
    public static Resource newIntances()//懒汉模式
    {
        if(instance==null)
        {
            return new Resource();
        }
        return instance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {

        Category = category;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public double getNumberl() {
        return numberl;
    }

    public void setNumberl(double numberl) {
        this.numberl = numberl;
    }

    public String getDate() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.date);
    }

    public void setDate(String date) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=null;
        try {
                date1=sdf.parse(date);
            } catch (ParseException e) {
                e.getMessage();
                return;
            }
            this.date = date1;
    }

    @Override
    public String toString() {
        return  ID +"  " +Category +"  "+ Account +"  " + numberl  +"  " + this.getDate() +"  "+ Description +"\n";
    }

    public String getDescription() {

        return Description;
    }

    public void setDescription(String description) {
        if(description=="0")
        {
            description=new String("无");
        }
        Description = description;
    }
}
