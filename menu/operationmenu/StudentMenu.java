package mfcodbc.menu.operationmenu;

import mfcodbc.operations.StudentOperation;
import mfcodbc.operations.UserOperation;
import java.util.Scanner;

/**
 * Demo StudentMenu
 *
 * @author Accer
 * @date 2022/07/05
 */

public class StudentMenu {
    /**
     * 学生菜单
     *
     * @params String id
     * @return null
     */
    public static void studentMenu(String id)
    {
        System.out.println("welcome!" + id);
        Scanner s = new Scanner(System.in);
        int c = 0;
        final int end = 5;
        do{
            System.out.println("studentMenu");
            System.out.println("1.查看个人信息");
            System.out.println("2.查看所选课程");
            System.out.println("3.查看成绩和学分");
            System.out.println("4.修改密码");
            System.out.println("5.结束使用");
            c = s.nextInt();
            final int low = 1, high = 5;
            while(c < low || c > high) {
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
                    showScoreInfo(id);
                    break;
                case 4:
                    modifyPassword(id);
                    break;
                default:
                    System.out.println("thanks");
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
        StudentOperation.query(id);
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
     * 查看成绩和学分
     *
     * @params String id
     * @return null
     */
    public static void showScoreInfo(String id)
    {
        StudentOperation.queryScoreInfo(id);
    }
    /**
     * 查看所选课程信息
     *
     * @params String id
     * @return null
     */
    public static void showCourseInfo(String id)
    {
        StudentOperation.queryCourseInfo(id);
    }
}
