import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bool=true;
        while (bool) {
            System.out.println("请输入用户名：");

            Scanner sc = new Scanner(System.in);
            String username = sc.next();//阻塞方法
            System.out.println("你输入的用户名：" + username);

            System.out.println("请输入密码：");
            String password = sc.next();

            System.out.println("你输入的密码是：" + password);

            //File file=new File("D:\\IdeaU\\IntelliJ IDEA 2019.2.4\\CmdShop\\src\\users.xlsx");

            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();//创建对象
            User users[] = readExcel.readExcel(in);
            System.out.println("从excel中读到的用户名: " + users[0].getUsername());
            System.out.println("从excel中读到的密码: " + users[0].getPassword());
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登录成功！");
                    bool=false;
                    break;
                } else {
                    System.out.println("登录失败！");
                }
            }
        }
    }
}