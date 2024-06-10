package exam;

import com.mysql.cj.xdevapi.UpdateStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String addtousers = "insert into users values (?,?,?)";
    private static final String addtousers1 = "insert into users (username, password) values ('Rafik','Rafik')";
    public static void main(String[] args) throws SQLException {
        DBWorker worker = new DBWorker();
        String query = "select * from users";

        Statement statement1 = null;
        try {
            statement1 = worker.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //statement1.executeUpdate(addtousers1);
        try {
            PreparedStatement preparedStatement = worker.getConnection().prepareStatement(addtousers);
            preparedStatement.setInt(1,4 );
            preparedStatement.setString(2,"Hamlet");
            preparedStatement.setString(3,"Narek111");
            //preparedStatement.execute();
            Statement statement = worker.getConnection().createStatement();
            //massifrom rows of table
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}