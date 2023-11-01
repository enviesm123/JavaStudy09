package ch14_jdbc;

import java.sql.*;

public class JdbcUpdate {
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
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);

            StringBuffer query = new StringBuffer();

            query.append("  UPDATE               ");
            query.append("       members         ");
            query.append("  SET                  ");
            query.append("       mem_score = ?   ");

            ps = conn.prepareStatement(query.toString());
            int idx = 1;
            ps.setInt(idx++, 0);

            int result = ps.executeUpdate();
            System.out.println(result);

            // 추가적으로 SELECT문 실행
            ps.close();
            query = new StringBuffer();

            query.append("  SELECT               ");
            query.append("    mem_id             ");
            query.append("  , mem_pw             ");
            query.append("  , mem_name           ");
            query.append("  , mem_score AS score ");
            query.append("  FROM                 ");
            query.append("  members              ");

           ps = conn.prepareStatement(query.toString());

           rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("mem_id"));
                System.out.println(rs.getString("mem_pw"));
                System.out.println(rs.getString("mem_name"));
                // SELECT 문 컬럼에 AS가 있다면 해당 알리아스에 맞춰야 한다
                System.out.println(rs.getInt("score"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // 8. DB 연결에 사용된 객체들 close 해주기
            // 선언된 순서의 반대로 close 해주는것을 추천
            if(rs != null){ try { rs.close();} catch (SQLException e) { e.printStackTrace();}}
            if(ps != null){ try { ps.close();} catch (SQLException e) { e.printStackTrace();}}
            if(conn != null){ try { conn.close();} catch (SQLException e) { e.printStackTrace();}}
        }


    }
}
