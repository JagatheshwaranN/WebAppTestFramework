package utils;

import java.sql.*;
import java.util.HashMap;

public class DataBaseReader {

    public synchronized HashMap<String, String> getDBResultAsMap(String query) {
        HashMap<String, String> dataMap = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        String connectionURL = "jdbc:mysql://localhost:3306/qdpm?serverTimeZone=UTC";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    dataMap.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
                }
            }
            System.out.println(dataMap);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                assert statement != null;
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataMap;
    }
    
}
