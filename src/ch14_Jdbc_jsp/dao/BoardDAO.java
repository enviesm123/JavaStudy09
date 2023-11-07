package ch14_Jdbc_jsp.dao;

import ch14_Jdbc_jsp.dto.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


// DAO 쿼리문 작성
public class BoardDAO {

    private BoardDAO(){

    }

    private static BoardDAO instance = new BoardDAO();

    public static BoardDAO getInstance(){
        return instance;
    }

    // 게시글 조회(SELECT) 메소드

   public ArrayList<BoardDTO> getBoardList(Connection conn) throws SQLException {
        StringBuffer query = new StringBuffer();
       query.append("SELECT                     ");
       query.append("    b.bo_no                ");
       query.append("  , b.bo_title             ");
       query.append("  , b.bo_content           ");
       query.append("  , b.bo_id                ");
       query.append("  , b.bo_date              ");
       query.append("  , m.mem_name             ");
       query.append("FROM                       ");
       query.append("   boards b, members m     ");
       query.append("WHERE 1=1                  ");
       query.append(" AND b.bo_id = m.mem_id    ");
       query.append(" AND b.del_yn = 'N'        ");
       query.append("ORDER BY b.bo_no DESC      ");

       PreparedStatement ps = conn.prepareStatement(query.toString());

       ResultSet rs = ps.executeQuery();

       ArrayList<BoardDTO> result = new ArrayList<>();

       while(rs.next()){
           BoardDTO board = new BoardDTO();

           board.setBoNo(rs.getInt("bo_no"));
           board.setBoTitle(rs.getString("bo_title"));
           board.setBoContent( rs.getString("bo_content"));
           board.setBoId(rs.getString("bo_id"));
           board.setBoDate(rs.getString("bo_date"));
           board.setMemName(rs.getString("mem_name"));

           result.add(board);

       }
       rs.close();
       ps.close();

       return result;
   }


   // 글 작성 메소드 (INSERT)

    public int write(Connection conn, BoardDTO board) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO                ");
        query.append("    boards (               ");
        query.append("    bo_no                  ");
        query.append("  , bo_title               ");
        query.append("  , bo_content             ");
        query.append("  , bo_id                  ");
        query.append("  , bo_date                ");
        query.append("  , del_yn                 ");
        query.append(" ) VALUES (                ");
        query.append("   seq_board.NEXTVAL       ");
        query.append("   , ?                     ");
        query.append("   , ?                     ");
        query.append("   , ?                     ");
        query.append("   , SYSDATE               ");
        query.append("   , 'N'   )               ");

        PreparedStatement ps = conn.prepareStatement(query.toString());



        int idx = 1;
        ps.setString(idx++,board.getBoTitle());
        ps.setString(idx++,board.getBoContent());
        ps.setString(idx++,board.getBoId());

        int result = ps.executeUpdate();

        ps.close();

        return result;

    }


    // 글 상세 보기 (SELECT)

    public BoardDTO viewBoard(Connection conn, int boNo) throws SQLException {
        //SELECT bo_title, mem_name, bo_date, bo_content
        //FROM boards b, members m
        //WHERE b.bo_id = m.mem_id;
        StringBuffer query = new StringBuffer();
        query.append("SELECT                     ");
        query.append("    b.bo_no                ");
        query.append("  , b.bo_title             ");
        query.append("  , b.bo_content           ");
        query.append("  , b.bo_id                ");
        query.append("  , b.bo_date              ");
        query.append("  , m.mem_name             ");
        query.append("FROM                       ");
        query.append("   boards b, members m     ");
        query.append("WHERE 1=1                  ");
        query.append(" AND b.bo_id = m.mem_id    ");
        query.append(" AND b.bo_no = ?           ");


        PreparedStatement ps = conn.prepareStatement(query.toString());

        ps.setInt(1, boNo);

        ResultSet rs = ps.executeQuery();

        BoardDTO board = new BoardDTO();

        if(rs.next()){

            board.setBoNo(rs.getInt("bo_no"));
            board.setBoTitle(rs.getString("bo_title"));
            board.setBoContent( rs.getString("bo_content"));
            board.setBoId(rs.getString("bo_id"));
            board.setBoDate(rs.getString("bo_date"));
            board.setMemName(rs.getString("mem_name"));

        }

        rs.close();
        ps.close();

       return board;
    }


    // 글 삭제 (UPDATE)
    public int delBoard(Connection conn,int num) throws SQLException {


        StringBuffer query = new StringBuffer();
        query.append("UPDATE             ");
        query.append("     boards        ");
        query.append(" SET               ");
        query.append("  del_yn = 'Y'     ");
        query.append("   WHERE  1=1      ");
        query.append(" AND bo_no = ?     ");
//        query.append(" AND bo_id = ?     ");


        PreparedStatement ps = conn.prepareStatement(query.toString());

        ps.setInt(1, num);

        int result = ps.executeUpdate();

        ps.close();

        return result;
    }

}
