package mfcodbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Demo JdbcUtils
 *
 * @author Accer
 * @date 2022/07/01
 */
public class JdbcUtils {
    /**
     * 连接数据库
     *
     * @params null
     * @return Connection
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //获得连接（亦可在这里修改你的数据库信息）
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mfc?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
    }
    /**
     * 关闭连接
     *
     * @params null
     * @return null
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {//通用
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

