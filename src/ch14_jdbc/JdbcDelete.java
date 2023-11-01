package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDelete {
    public static void main(String[] args) {
        // 1. ojdbc 라이브러리 내 OracleDriver 클래스를 깨우기
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e); // 프로그램 멈춤
            System.exit(0); // 프로그램 종료
        }
        // 2. DB 연결을 위한 URL, 계정 ID/PW 준비
        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std202";
        String pw = "oracle21c";

        Connection conn = null;
        PreparedStatement ps = null;
        // ResultSet 은 SELECT문에서만 사용

        try {
            conn = DriverManager.getConnection(url, id, pw);

            StringBuffer query = new StringBuffer();

            query.append("   DELETE               ");
            query.append("   members              ");
            query.append("   WHERE                ");
            query.append("   mem_name = ?         ");

            ps = conn.prepareStatement(query.toString());

            int idx = 1;

            ps.setString(idx++, "세균맨");

            int result = ps.executeUpdate();
            System.out.println(result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // 8. DB 연결에 사용된 객체들 close 해주기
            // 선언된 순서의 반대로 close 해주는것을 추천
            if(ps != null){ try { ps.close();} catch (SQLException e) { e.printStackTrace();}}
            if(conn != null){ try { conn.close();} catch (SQLException e) { e.printStackTrace();}}
        }



    }
}
