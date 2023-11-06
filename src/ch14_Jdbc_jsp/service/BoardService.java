package ch14_Jdbc_jsp.service;

import ch14_Jdbc_jsp.dao.BoardDAO;
import ch14_Jdbc_jsp.dto.BoardDTO;
import ch14_Jdbc_jsp.jdbc.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardService {

    private BoardService(){

    }

    private static BoardService instance = new BoardService();

    public static BoardService getInstance(){
        return instance;
    }

    private ConnectionPool cp = ConnectionPool.getInstance();
    private BoardDAO dao = BoardDAO.getInstance();

    // 게시글 목록
    public ArrayList<BoardDTO> getBoardList(){
        Connection conn = cp.getConnection();
        ArrayList<BoardDTO> result = new ArrayList<>();

        try {
          result = dao.getBoardList(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        cp.releaseConnection(conn);
        }
        return result;
    }


    // 글작성 메소드


    // 글쓰기 (board 객체 내부에는 title,content, id가 들어가 있어야 한다)
    public void write(BoardDTO board){
        Connection conn = cp.getConnection();

        try {
            dao.write(conn, board);
            System.out.println("글쓰기 성공");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("글쓰기 실패");
        }finally {
            cp.releaseConnection(conn);
        }
    }

    // 글 상세보기 메소드

    public BoardDTO viewBoard(int boNo){
        Connection conn = cp.getConnection();
        BoardDTO result = new BoardDTO();

        try {
            result = dao.viewBoard(conn, boNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cp.releaseConnection(conn);
        }

        return result;
    }

    // 글 삭제 (UPDATE)

    public void delBoard(int num){
        Connection conn = cp.getConnection();


        try {
            dao.delBoard(conn, num);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cp.releaseConnection(conn);
        }



    }

}
