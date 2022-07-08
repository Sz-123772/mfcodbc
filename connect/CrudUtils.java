package mfcodbc.connect;

import javafx.util.Pair;
import mfcodbc.cls.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

/**
 * Demo CrudUtils
 *
 * @author Accer
 * @date 2022/06/23
 */

public class CrudUtils {
    /**
     * 在数据库中执行更新操作
     * @params string, Object... params
     * @return int
     */
    public static int update(String sql, Object... params) {//不确定个数 不确定类型
        //获取链接
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; ++ i) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询单个User类型的信息
     * @params string, Object... params
     * @return An User Object
     */
    public static User querySingleU(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            if (set.next()) {
                String id = set.getString("user_id");
                String password = set.getString("user_password");
                String remark = set.getString("user_remark");
                User user = new User(id, password, remark);
                return user;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询全部User类型的信息
     * @params string, Object... params
     * @return List of User objects
     */
    public static List<User> queryAllU(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            List<User> list = new ArrayList<User>();
            while (set.next())
            {
                String id = set.getString("user_id");
                String password = set.getString("user_password");
                String remark = set.getString("user_remark");
                list.add(new User(id, password, remark));
            }
            if(list.size() > 0)
            {
                return list;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询单个Student类型的信息
     * @params string, Object... params
     * @return A Student Object
     */
    public static Student querySingleS(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            if (set.next()) {
                String id = set.getString("student_id");
                String name = set.getString("student_name");
                String sex = set.getString("student_sex");
                int age = set.getInt("student_age");
                String major = set.getString("student_major");
                int cls = set.getInt("student_class");
                Student student = new Student(id, name, sex, age, major, cls);
                return student;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询单个Teacher类型的信息
     * @params string, Object... params
     * @return A Teacher Object
     */
    public static Teacher querySingleT(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            if (set.next()) {
                String id = set.getString("teacher_id");
                String name = set.getString("teacher_name");
                String sex = set.getString("teacher_sex");
                int age = set.getInt("teacher_age");
                String title = set.getString("teacher_title");
                Teacher teacher = new Teacher(id, name, sex, age, title);
                return teacher;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询单个Course类型的信息
     * @params string, Object... params
     * @return A Course Object
     */
    public static Course querySingleC(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            if (set.next()) {
                String id = set.getString("course_id");
                String name = set.getString("course_name");
                double credit = set.getDouble("course_credit");
                int term = set.getInt("course_term");
                Course course = new Course(id, name, credit, term);
                return course;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询全部Course类型的信息
     * @params string, Object... params
     * @return List of Course objects
     */
    public static List<Course> queryAllC(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            List<Course> list = new ArrayList<Course>();
            while (set.next())
            {
                String id = set.getString("course_id");
                String name = set.getString("course_name");
                double credit = set.getDouble("course_credit");
                int term = set.getInt("course_term");
                list.add(new Course(id, name, credit, term));
            }
            if(list.size() > 0)
            {
                return list;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询学生成绩信息
     * @params string, Object... params
     * @return List of Pair<String, Integer>
     */
    public static List<Pair<String, Integer>> queryAllScore(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            List<Pair<String, Integer>> list = new ArrayList<Pair<String, Integer>>();
            while (set.next())
            {
                String id = set.getString("course_id");
                int score = set.getInt("course_score");
                list.add(new Pair<String, Integer>(id, score));
            }
            if(list.size() > 0)
            {
                return list;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询教师教授课程信息
     * @params string, Object... params
     * @return List of String
     */
    public static List<String> queryAllCourse(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            List<String> list = new ArrayList<String>();
            while (set.next())
            {
                String id = set.getString("course_id");
                list.add(id);
            }
            if(list.size() > 0)
            {
                return list;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    /**
     * 在数据库中查询选修了该课程的学生信息
     * @params string, Object... params
     * @return List of String
     */
    public static List<String> queryAllStudent(String sql, Object... params)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            set = preparedStatement.executeQuery();
            List<String> list = new ArrayList<String>();
            while (set.next())
            {
                String id = set.getString("student_id");
                list.add(id);
            }
            if(list.size() > 0)
            {
                return list;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
}
