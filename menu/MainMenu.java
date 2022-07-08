package mfcodbc.menu;

import javafx.util.Pair;
import mfcodbc.menu.loginmenu.Login;
import mfcodbc.menu.operationmenu.*;

/**
 * Demo MainMenu
 *
 * @author Accer
 * @date 2022/07/02
 */

public class MainMenu {
    /**
     * 主菜单
     *
     * @params null
     * @return null
     */
    public static void mainMenu() {
        /// 登录
        Pair<Integer, String> res;
        final String empty = "";
        do {
            res = Login.loginMenu();
            if (res.getValue().equals(empty)) {
                System.out.println("Login failed, please try again.");
            } else {
                System.out.println("Login succeeded");
            }
        } while (res.getValue().equals(empty));

        /// 菜单
        final int studentNumber = 1, teacherNumber = 2;
        if(res.getKey() == studentNumber)
        {
            menuForStudent(res.getValue());
        } else if(res.getKey() == teacherNumber){
            menuForTeacher(res.getValue());
        } else {
            menuForAdmin();
        }
    }
    /**
     * 管理员界面
     *
     * @params null
     * @return null
     */
    public static void menuForAdmin()
    {
        AdminMenu.adminMenu();
    }
    /**
     * 学生界面
     *
     * @params String id
     * @return null
     */
    public static void menuForStudent(String id)
    {
        StudentMenu.studentMenu(id);
    }
    /**
     * 教师界面
     *
     * @params String id
     * @return null
     */
    public static void menuForTeacher(String id)
    {
        TeacherMenu.teacherMenu(id);
    }
}
