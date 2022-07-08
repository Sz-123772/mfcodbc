package mfcodbc.menu.loginmenu;

import mfcodbc.cls.User;
import mfcodbc.operations.UserOperation;
import java.util.Scanner;

/**
 * Demo LoginMenu
 *
 * @author Accer
 * @date 2022/07/02
 */

public class LoginMenu {
    /**
     * 登录菜单
     *
     * @params null
     * @return String
     */
    public static String loginMenu(String remark)
    {
        Scanner s = new Scanner(System.in);
        String id, password;
        System.out.println("账号：");
        id = s.next();
        System.out.println("密码：");
        password = s.next();
        User user = UserOperation.querySingle(id, remark);
        if(user != null)
        {
            Boolean res = user.getPassword().equals(password);
            if(res == false)
            {
                System.out.println("密码错误");
                return "";
            }
            return id;
        }
        else
        {
            return "";
        }
    }
}
