package mfcodbc.menu.operationmenu;

import mfcodbc.operations.UserOperation;
import java.util.Scanner;

/**
 * Demo AdminMenu
 *
 * @author Accer
 * @date 2022/07/04
 */

public class AdminMenu {
    /**
     * 管理员菜单
     *
     * @params null
     * @return null
     */
    public static void adminMenu()
    {
        final int end = 9;
        int c = 0;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("adminMenu");
            System.out.println("1.查看全部用户信息");
            System.out.println("2.添加学生信息");
            System.out.println("3.添加教师信息");
            System.out.println("4.添加课程信息");
            System.out.println("5.删除信息");
            System.out.println("6.修改信息");
            System.out.println("7.给学生安排课程");
            System.out.println("8.给课程安排教师");
            System.out.println("9.结束使用");
            c = s.nextInt();
            final int low = 1, high = 9;
            while(c < low || c > high) {
                System.out.println("输入错误，请重新输入");
                c = s.nextInt();
            }
            switch (c) {
                case 1:
                    showAllInfo();
                    break;
                case 2:
                    addStudentInfo();
                    break;
                case 3:
                    addTeacherInfo();
                    break;
                case 4:
                    addCourseInfo();
                    break;
                case 5:
                    deleteInfo();
                    break;
                case 6:
                    modifyInfo();
                    break;
                case 7:
                    assignGradesToStudents();
                    break;
                case 8:
                    assignTeacherToCourses();
                    break;
                default:
                    System.out.println("Thanks");
                    break;
            }
        } while (c != end);
    }
    /**
     * 显示所有用户信息
     *
     * @params null
     * @return null
     */
    public static void showAllInfo()
    {
        UserOperation.queryAll();
    }
    /**
     * 添加学生信息
     *
     * @params null
     * @return null
     */
    public static void addStudentInfo()
    {
        UserOperation.addStudent();
    }
    /**
     * 添加教师信息
     *
     * @params null
     * @return null
     */
    public static void addTeacherInfo()
    {
        UserOperation.addTeacher();
    }
    /**
     * 添加课程信息
     *
     * @params null
     * @return null
     */
    public static void addCourseInfo()
    {
        UserOperation.addCourse();
    }
    /**
     * 删除用户信息
     *
     * @params null
     * @return null
     */
    public static void deleteInfo()
    {
        UserOperation.delete();
    }
    /**
     * 修改用户信息
     *
     * @params null
     * @return null
     */
    public static void modifyInfo()
    {
        UserOperation.modify();
    }
    /**
     * 给学生安排课程
     *
     * @params null
     * @return null
     */
    public static void assignGradesToStudents()
    {
        UserOperation.arrangeStudent();
    }
    /**
     * 给课程安排授课老师
     *
     * @params null
     * @return null
     */
    public static void assignTeacherToCourses()
    {
        UserOperation.arrangeCourse();
    }
}