//import util.ConnectionUtil;
//
//import java.sql.*;
//
//void main() throws SQLException {
//
//    Connection connection = ConnectionUtil.getConnection();
//
//    createTable(connection);
//
////    insertTable(connection);
//
////    String sqlSelect = "SELECT * FROM TB_BOOK";
////    try (PreparedStatement statement= connection.prepareStatement(sqlSelect)){
////
////        ResultSet resultSet = statement.executeQuery();
////        while (resultSet.next()){
////            System.out.println(resultSet.getString(2));
//
//        }
//    }
//
//}
//
////private void insertTable(Connection connection) throws SQLException {
//    String query = "INSERT INTO TB_BOOK (id,title,author,available)" +
//            "VALUES (?,?,?,?)";
//    try (PreparedStatement statement = connection.prepareStatement(query)) {
//        statement.setInt(1, 6);
//        statement.setString(2, "Screen Shot");
//        statement.setString(3, "Neda");
//        statement.setBoolean(4, true);
//
//        int resultSet = statement.executeUpdate();
//    }
//}
//
//
//private static void createTable(Connection connection) throws SQLException {
//
//    String query = "CREATE TABLE IF NOT EXISTS TB_BOOK (" + "id int PRIMARY KEY ," +
//            "title varchar(30) NOT NULL, " +
//            "author varchar(30) NOT NULL ," +
//            "available boolean" +
//            ");";
//
//    try (Statement statement = connection.createStatement()) {
//        statement.execute(query);
//    }
//
//    query = "CREATE TABLE IF NOT EXISTS TB_MEMBER (" + "id int PRIMARY KEY ," +
//            "name varchar(30) NOT NULL, " +
//            "tel varchar(20) NOT NULL ," +
//            "address varchar(30)," +
//            "email varchar(50)" +
//            ");";
//
//    try (Statement statement = connection.createStatement()) {
//        statement.execute(query);
//    }
//
//
//    query = "CREATE TABLE IF NOT EXISTS loan " +
//            "(id SERIAL PRIMARY KEY,           " +
//            " loan_date DATE NOT NULL,            " +
//            "return_date DATE NOT NULL,            " +
//            "member_id INT NOT NULL,            " +
//            "book_id INT NOT NULL,           " +
//            " CONSTRAINT fk_loan_member FOREIGN KEY (member_id) REFERENCES TB_MEMBER(id), " +
//            " CONSTRAINT fk_loan_book FOREIGN KEY (book_id) REFERENCES TB_BOOK(id)      " +
//            "  );        ";
//
//    try (Statement statement = connection.createStatement()) {
//        statement.execute(query);
//    }
//}
//
