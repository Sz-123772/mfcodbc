package mfcodbc.operations;

import mfcodbc.cls.*;
import mfcodbc.connect.CrudUtils;
import sun.security.util.Password;

import java.util.List;
import java.util.Scanner;

/**
 * Demo UserOperation
 *
 * @author Accer
 * @date 2022/07/04
 */

public class UserOperation {
    /**
     * 通过user_id查询用户信息，用作登录
     *
     * @params string id, String remark
     * @return An User Object
     */
    public static User querySingle(String id, String remark)
    {
        User user = CrudUtils.querySingleU("select * from users where user_id = ?", id);
        if(user == null || user.getRemark().equals(remark) == false)
        {
            System.out.println("不存在该用户");
            return null;
        }
        return user;
    }

    /**
     * 查询所有用户信息
     *
     * @params null
     * @return null
     */
    public static void queryAll()
    {
        List<User> users = CrudUtils.queryAllU("select * from users");
        if(users.size() == 0)
        {
            System.out.println("No users found");
        }
        else
        {
            System.out.println("All users found: " + users.size());
            for(User user : users)
            {
                System.out.println(user.toString());
            }
        }
    }
    /**
     * 添加学生信息
     *
     * @params null
     * @return null
     */
    public static void addStudent()
    {
        Scanner s = new Scanner(System.in);
        String id = "", password = "", remark = "student", name = "", sex = "", major = "", cls = "";
        int age = 0;
        System.out.println("id:");
        id = s.next();
        User user = CrudUtils.querySingleU("select * from users where user_id = ?", id);
        if(user != null)
        {
            System.out.println("该用户已存在！！！");
        } else {
            password = id;
            System.out.println("name:");
            name = s.next();
            System.out.println("sex:");
            sex = s.next();
            System.out.println("age:");
            age = s.nextInt();
            System.out.println("major:");
            major = s.next();
            System.out.println("class:");
            cls = s.next();
            int res1 = CrudUtils.update("insert into users(user_id, user_password, user_remark) values(?,?,?)" , id, password, remark);
            int res2 = CrudUtils.update("insert into students(student_id, student_name, student_sex, student_age, student_major, student_class) values(?,?,?,?,?,?)" , id, name, sex, age, major, cls);
            if(res1 > 0 && res2 > 0) {
                System.out.println("Successfully updated");
            } else {
                System.out.println("Failed to update");
            }
        }
    }
    /**
     * 添加教师信息
     *
     * @params null
     * @return null
     */
    public static void addTeacher()
    {
        Scanner s = new Scanner(System.in);
        String id = "", password = "", remark = "teacher", name = "", sex = "", title = "";
        int age = 0;
        System.out.println("id:");
        id = s.next();
        User user = CrudUtils.querySingleU("select * from users where user_id = ?", id);
        if(user != null)
        {
            System.out.println("该用户已存在！！！");
        } else {
            password = id;
            System.out.println("name:");
            name = s.next();
            System.out.println("sex:");
            sex = s.next();
            System.out.println("age:");
            age = s.nextInt();
            System.out.println("title:");
            title = s.next();
            int res1 = CrudUtils.update("insert into users(user_id, user_password, user_remark) values(?,?,?)" , id, password, remark);
            int res2 = CrudUtils.update("insert into teachers(teacher_id, teacher_name, teacher_sex, teacher_age, teacher_title) values(?,?,?,?,?)" , id, name, sex, age, title);
            if(res1 > 0 && res2 > 0) {
                System.out.println("Successfully updated");
            } else {
                System.out.println("Failed to update");
            }
        }
    }
    /**
     * 添加课程信息
     *
     * @params null
     * @return null
     */
    public static void addCourse()
    {
        Scanner s = new Scanner(System.in);
        String id = "", name = "";
        double credit = 0;
        int term = 0;

        System.out.println("id:");
        id = s.next();
        System.out.println("name:");
        name = s.next();
        System.out.println("credit:");
        credit = s.nextDouble();
        System.out.println("term:");
        term = s.nextInt();
        int res = CrudUtils.update("insert into courses(course_id, course_name, course_credit, course_term) values (?,?,?,?)", id, name, credit, term);
        System.out.println(res > 0 ? "Successfully" : "Failed");
    }
    /**
     * 修改信息
     *
     * @params null
     * @return null
     */
    public static void modify()
    {
        Scanner s = new Scanner(System.in);
        String id = "", password = "", remark = "";
        System.out.println("id:");
        id = s.next();
        User user = CrudUtils.querySingleU("select * from users where user_id = ?", id);
        if(user == null)
        {
            System.out.println("用户不存在！！！");
        } else {
            System.out.println("password:");
            password = s.next();
            System.out.println("remark:");
            remark = s.next();
            int res = CrudUtils.update("update users set user_password = ?, user_remark = ? where user_id = ?", password, remark, id);
            System.out.println(res > 0 ? "修改成功" : "修改失败");
        }
    }
    /**
     * 删除信息
     *
     * @params null
     * @return null
     */
    public static void delete()
    {
        UserOperation.queryAll();
        Scanner s = new Scanner(System.in);
        String again = "y", choice = "", id = "";
        do {
            int res1 = 0, res2 = 0;
            System.out.println("Please select the user ID to delete:");
            id = s.next();
            Student student = CrudUtils.querySingleS("select * from students where student_id = ?" ,id);
            Teacher teacher = CrudUtils.querySingleT("select * from teachers where teacher_id = ?" ,id);
            if(teacher != null || student != null){
                res1 = CrudUtils.update("delete from users where user_id = ?" , id);
                if(student != null){
                    res2 = CrudUtils.update("delete from students where student_id = ?",id);
                } else {
                    res2 = CrudUtils.update("delete from teachers where teacher_id = ?",id);
                }
            }
            if(res1 > 0 && res2 > 0){
                System.out.println("Successfully deleted");
            } else {
                System.out.println("Failed to delete");
            }
            System.out.println("还要继续删除吗?(y/n)");
            choice = s.next();
        } while(choice.equals(again));
    }
    /**
     * 修改密码
     *
     * @params String id
     * @return null
     */
    public static void modifyPassword(String id)
    {
        Scanner s = new Scanner(System.in);
        String oldPassword = "", newPassword = "", password = "";
        User user = CrudUtils.querySingleU("select * from users where user_id = ?", id);
        oldPassword = user.getPassword();
        System.out.println("oldPassword:");
        password = s.next();
        if(password.equals(oldPassword))
        {
            System.out.println("newPassword:");
            newPassword = s.next();
            System.out.println("Enter Your Password Again:");
            password = s.next();
            while(!password.equals(newPassword)){
                System.out.println("inputInconsistency,pleaseEnterAgain!!!");
                password = s.next();
            }
            int res = CrudUtils.update("update users set user_password = ? where user_id = ?", newPassword, id);
            System.out.println(res > 0 ? "修改成功" : "修改失败");
        } else {
            System.out.println("wrong oldPassword");
        }
    }
    /**
     * 给学生安排课程
     *
     * @params null
     * @return null
     */
    public static void arrangeStudent()
    {
        Scanner s = new Scanner(System.in);
        String grade = "", course = "", cls = "";
        System.out.println("年级(20XX)：");
        grade = s.next();
        System.out.println("课程：");
        course = s.next();
        System.out.println("班级：");
        cls = s.next();
        List<Course> courses = CrudUtils.queryAllC("select * from courses");
        Boolean flag = false;
        for (Course c : courses) {
            if(c.getId().equals(course)){
                flag = true;
                break;
            }
        }
        int wrong = 0;
        List<String> students = CrudUtils.queryAllStudent("select student_id from students where student_id like ?\"%\" and student_class = ?", grade, cls);
        if(students != null && flag) {
            for(String student : students) {
                int res = CrudUtils.update("insert into study(student_id, course_id) values(?, ?)", student, course);
                if(res == 0){
                    System.out.println("Failed to update");
                    ++ wrong;
                }
            }
            System.out.println("success："+(students.size() - wrong)+"\nwrong："+wrong);
        } else {
            System.out.println(flag ? "不存在满足要求的学生" : "课程信息错误");
        }
    }
    /**
     * 给课程安排授课老师
     *
     * @params null
     * @return null
     */
    public static void arrangeCourse()
    {
        Scanner s = new Scanner(System.in);
        String courseId = "", teacherId = "";
        System.out.println("课程号：");
        courseId = s.next();
        System.out.println("教师工号：");
        teacherId = s.next();
        Course c = CrudUtils.querySingleC("select * from courses where course_id = ?" , courseId);
        Teacher t = CrudUtils.querySingleT("select * from teachers where teacher_id = ?" , teacherId);
        if(c != null && t != null)
        {
            int res = CrudUtils.update("insert into teach(teacher_id, course_id) values(?, ?)",teacherId, courseId);
            System.out.println(res > 0 ? "Successfully" : "Failed");
        } else {
            if(t == null) {
                System.out.println("不存在该教师");
            } else if(c == null) {
                System.out.println("不存在该课程");
            } else {
                System.out.println("输入信息错误");
            }
        }
    }
}