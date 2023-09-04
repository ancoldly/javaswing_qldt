package Connection;
import java.sql.*;

public class Connections {
    private static Connection conn;

    public static void getColection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String user = "sa";
        String pass = "18072004";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName = QLDOANHTHU; encrypt = false; trustSeverCerLificate = true", user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Hàm chạy câu lệnh select
    public static ResultSet ThucThiLenhSelect(String CauLenhSQL) {
        try{
            Statement stm = conn.createStatement();
            return stm.executeQuery(CauLenhSQL);
        } catch (SQLException ex) {
            System.out.println("Lỗi thực hiện lệnh truy vấn SQL");
            System.out.println("Câu lệnh của bạn: "+CauLenhSQL);
            System.out.println("Lỗi chi tiết : " + ex.getMessage());
        }
        return null; // truong hop loi
    }
    public static int ThucThi3Lenh (String CauLenhSQL) /*Thực thi 3 lệnh insert, update, delete*/{
        try{
            Statement stm = conn.createStatement();
            return stm.executeUpdate(CauLenhSQL);
        } catch (SQLException ex) {
            System.out.println("Lỗi thực hiện lệnh truy vấn SQL");
            System.out.println("Câu lệnh của bạn: "+CauLenhSQL);
            System.out.println("Lỗi chi tiết : " + ex.getMessage());
        }
        return 0;
    }

    public static void main(String args []) {
        getColection();
    }
}