package mfcodbc.operations;

import mfcodbc.cls.Course;
import mfcodbc.cls.Student;
import mfcodbc.cls.Teacher;
import mfcodbc.connect.CrudUtils;
import java.util.List;
import java.util.Scanner;

/**
 * Demo TeacherOperation
 *
 * @author Accer
 * @date 2022/07/05
 */

public class TeacherOperation {
    /**
     * 根据工号查询信息
     *
     * @params String id
     * @return null
     */
    public static void query(String id)
    {
        Teacher teacher = CrudUtils.querySingleT("select * from teachers where teacher_id = ?", id);
        System.out.println(teacher.toString());
    }
    /**
     * 显示教授课程信息
     *
     * @params String id
     * @return list of String
     */
    public static List<String> queryCourseInfo(String id)
    {
        List<String> list = CrudUtils.queryAllCourse("select course_id from teach where teacher_id = ?", id);
        if(list != null){
            System.out.println("您教授以下课程：");
            for (String courseId : list){
                Course course = CrudUtils.querySingleC("select * from courses where course_id = ?", courseId);
                System.out.println(course.getId() + " " + course.getName() + " " + course.getCredit());
            }
        } else {
            System.out.println("您暂未教授课程!!!");
        }
        return list;
    }
    /**
     * 批改或修改学生成绩
     *
     * @params String id
     * @return null
     */
    public static void modifyStudentScore(String id)
    {
        Scanner s = new Scanner(System.in);
        List<String> list = queryCourseInfo(id);
        if(list == null){ return ; }
        String courseId = "";
        System.out.println("请选择要更改成绩的课程：");
        courseId = s.next();
        Boolean flag = false;
        for(String c : list){
            if(c.equals(courseId)){
                flag = true;
                break;
            }
        }
        if(flag == true){
            int c = 0;
            System.out.println("1.批改全部成绩");
            System.out.println("2.更改学生成绩");
            c = s.nextInt();
            final int low = 1, high = 2;
            final int c1 = 1;
            while(c < low || c > high){
                System.out.println("输入错误，请重新输入");
                c = s.nextInt();
            }
            int score = 0;
            if(c == c1){
                List<String> student = CrudUtils.queryAllStudent("select student_id from study where course_id = ?", courseId);
                for(String element : student){
                    Student stu = CrudUtils.querySingleS("select * from students where student_id = ?", element);
                    System.out.println(element + " " + stu.getName() + "的成绩为：");
                    score = s.nextInt();
                    int res = CrudUtils.update("update study set course_score = ? where student_id = ? and course_id = ?", score, element, courseId);
                    System.out.println(res > 0 ? "Succeeded" : "Failed");
                }
            } else {
                String studentId = "";
                System.out.println("请输入要修改的学生学号:");
                studentId = s.next();
                Student stu = CrudUtils.querySingleS("select * from students where student_id = ?", studentId);
                System.out.println(studentId + " " + stu.getName() + "的成绩为：");
                score = s.nextInt();
                int res = CrudUtils.update("update study set course_score = ? where student_id = ? and course_id = ?", score, studentId, courseId);
                System.out.println(res > 0 ? "Succeeded" : "Failed");
            }
        } else {
            System.out.println("请输入正确的信息");
        }
    }
}
