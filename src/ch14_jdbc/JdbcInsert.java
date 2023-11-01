package ch14_jdbc;

import java.sql.*;

public class JdbcInsert {
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

            // 4. 쿼리문 작성
            StringBuffer query = new StringBuffer();
            // 문자열 더하기 중에 여백 없이 딱 붙는 경우가 없도록 하기
            query.append("INSERT INTO        ");
            query.append("    members (       ");
            query.append("        mem_id      ");
            query.append("      , mem_pw      ");
            query.append("      , mem_name    ");
            query.append("      , mem_score   ");
            query.append("  ) VALUES (        ");
            query.append("        ?           ");  // query문 문자열 안에 ; 를 넣지 않아야 함
            query.append("      , ?           ");
            query.append("      , ?           ");
            query.append("      , ?           ");
            query.append(" )                  ");

            ps = conn.prepareStatement(query.toString());

            // 쿼리문 내 ? 에 값을 채워주기
            // 첫번째 물음표의 인덱스는 0이 아니라 1부터 시작
            int idx = 1;
            ps.setString(idx++, "f001");
            ps.setString(idx++, "123f");
            ps.setString(idx++, "쨈아저씨");
            ps.setInt(idx++, 45);

            // insert, update, delete문은 executeUpdate()로 실행
            // 결과는 int 타입이 리턴된다.
            int result = ps.executeUpdate();    // update rows의 값을 리턴

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
