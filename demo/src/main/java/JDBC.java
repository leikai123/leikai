import com.mchange.v2.sql.filter.FilterConnection;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.*;


public class JDBC {
  /*  public static void main(String[] args) throws ClassNotFoundException, SQLException {
//加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //连接数据库
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/xiuzhen?serverTimezone=UTC","root","123");
        //构建statement声明      驱动程序管理器           得到声明     统一资源定位器
        Statement statement = conn.createStatement();
        String sql = "select * from baoming where id=8";
                //执行查找数据
        boolean resultSet = statement.execute(sql);
        //从结果里摘取数据。通常通过执行查询数据库的语句生成 = 声名执行 sql语句

        System.out.println("resultSet");*/

  static Logger logger = Logger.getLogger(String.valueOf(Test.class));

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/xiuzhen?serverTimezone=UTC","root","123");
            //构建statement声明      驱动程序管理器           得到声明     统一资源定位器
            String sql = "insert into baoming (name,qq,nianling) values(?,?,?)";



            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "你是谁");
            preparedStatement.setInt(2,55555);
            preparedStatement.setInt(3,4444);

            long a = System.currentTimeMillis();
            connection.setAutoCommit(false);
            for (int i = 1; i <= 30000000; i++) {
                if (i % 100000 != 0){
                    preparedStatement.addBatch();
                } else {
                    logger.info(String.valueOf(i));
                    preparedStatement.executeBatch();
                    connection.commit();
                    preparedStatement.clearBatch();
                }
            }
            long b = System.currentTimeMillis();
            logger.info("消耗时间：" + (b - a) / 1000 + "秒");
            preparedStatement.close();
            connection.close();
    }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    }


