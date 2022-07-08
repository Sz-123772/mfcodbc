package mfcodbc.operations;

import javafx.util.Pair;
import mfcodbc.cls.Course;
import mfcodbc.cls.Student;
import mfcodbc.connect.CrudUtils;
import java.util.List;

/**
 * Demo StudentOperation
 *
 * @author Accer
 * @date 2022/07/05
 */
public class StudentOperation {
    /**
     * 根据学号查询信息
     *
     * @params null
     * @return null
     */
    public static void query(String id)
    {
        Student student = CrudUtils.querySingleS("select * from students where student_id = ?", id);
        System.out.println(student.toString());
    }
    /**
     * 根据学号查询成绩信息
     *
     * @params null
     * @return null
     */
    public static void queryScoreInfo(String id)
    {
        List<Pair<String, Integer>> list = CrudUtils.queryAllScore("select course_id, course_score from study where student_id = ?", id);
        double sumScore = 0;
        if(list != null)
        {
            for(Pair<String, Integer> c : list)
            {
                String courseId = c.getKey();
                Course course = CrudUtils.querySingleC("select * from courses where course_id = ?", courseId);
                System.out.println(course.getName() + " " + courseId + " " + c.getValue());
                if(c.getValue() >= 60) {
                    sumScore += course.getCredit();
                }
            }
            System.out.println("Total Score: " + sumScore);
        } else {
            System.out.println("you HavenT Taken Any Tests Yet");
        }
    }
    /**
     * 根据学号查询课程信息
     *
     * @params null
     * @return null
     */
    public static void queryCourseInfo(String id)
    {
        List<String> courses = CrudUtils.queryAllCourse("select * from study where student_id = ?", id);
        for (String element : courses) {
            Course course = CrudUtils.querySingleC("select * from courses where course_id = ?", element);
            System.out.println(course.toString());
        }
    }
}
