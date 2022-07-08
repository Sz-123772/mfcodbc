package mfcodbc.menu.operationmenu;

import mfcodbc.operations.TeacherOperation;
import mfcodbc.operations.UserOperation;
import java.util.Scanner;

/**
 * Demo TeacherMenu
 *
 * @author Accer
 * @date 2022/07/05
 */

public class TeacherMenu {
    /**
     * 教师菜单
     *
     * @params String id
     * @return null
     */
    public static void teacherMenu(String id)
    {
        System.out.println("welcome!" + id);
        Scanner s = new Scanner(System.in);
        int c = 0;
        final int end = 5;
        do {
            System.out.println("studentMenu");
            System.out.println("1.查看个人信息");
            System.out.println("2.查看教授课程信息");
            System.out.println("3.批改或修改学生成绩");
            System.out.println("4.修改密码");
            System.out.println("5.结束使用");
            c = s.nextInt();
            final int low = 1, high = 5;
            while (c < low || c > high) {
                System.out.println("输入错误，请重新输入");
                c = s.nextInt();
            }
            switch (c) {
                case 1:
                    showInfo(id);
                    break;
                case 2:
                    showCourseInfo(id);
                    break;
                case 3:
                    modifyScore(id);
                    break;
                case 4:
                    modifyPassword(id);
                    break;
                case 5:
                    System.out.println("Thanks");
                    break;
                default:
                    break;
            }
        } while (c != end);
    }
    /**
     * 显示个人信息
     *
     * @params String id
     * @return null
     */
    public static void showInfo(String id)
    {
        TeacherOperation.query(id);
    }
    /**
     * 修改密码
     *
     * @params String id
     * @return null
     */
    public static void modifyPassword(String id)
    {
        UserOperation.modifyPassword(id);
    }
    /**
     * 显示教师所教授的课程信息
     *
     * @params String id
     * @return null
     */
    public static void showCourseInfo(String id)
    {
        TeacherOperation.queryCourseInfo(id);
    }
    /**
     * 批改或修改学生成绩
     *
     * @params String id
     * @return null
     */
    public static void modifyScore(String id)
    {
        TeacherOperation.modifyStudentScore(id);
    }
}
