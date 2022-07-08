package mfcodbc.menu.loginmenu;

import javafx.util.Pair;
import java.util.Scanner;

/**
 * Demo Login
 *
 * @author Accer
 * @date 2022/06/23
 */

public class Login {
    /**
     * 登录菜单
     * @params null
     * @return Pair<Integer, String>  判断是否登录成功和返回登录者身份以及id
     */
    public static Pair<Integer, String> loginMenu()
    {
        Scanner s = new Scanner(System.in);
        int select = 0;
        System.out.println("Welcome");
        System.out.println("1.学生登录");
        System.out.println("2.教师登录");
        System.out.println("3.管理员登录");
        select = s.nextInt();
        final int low = 1, high = 3;
        while(select < low || select > high)
        {
            System.out.println("输入错误, 请重新输入");
            select = s.nextInt();
        }
        final int c1 = 1, c2 = 2;
        String remark = "";
        if(select == c1)
        {
            remark = "student";
        }
        else if(select == c2)
        {
            remark = "teacher";
        }
        else
        {
            remark = "root";
        }
        String res = login(remark);
        Pair<Integer, String> pair = new Pair<>(select, res);
        return pair;
    }
    /**
     * 登录
     * @params String remark
     * @return String
     */
    public static String login(String remark)
    {
        return LoginMenu.loginMenu(remark);
    }
}