package ch16_network.open_api.service;

import ch14_Jdbc_jsp.dao.BoardDAO;
import ch14_Jdbc_jsp.jdbc.ConnectionPool;
import ch16_network.open_api.dao.MedicineDAO;
import ch16_network.open_api.dto.MedicineDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineService {

    private static ConnectionPool cp = ConnectionPool.getInstance();
    private static MedicineDAO dao = MedicineDAO.getInstance();

    private static MedicineService instance = new MedicineService();

    public static MedicineService getInstance(){
        return instance;
    }

    // 데이터 테이블에 넣기 (INSERT)

    public void insertMedicine(MedicineDTO medicine){
       Connection conn = cp.getConnection();

        try {
            dao.insertMedicine(conn, medicine);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cp.releaseConnection(conn);
        }


        

    }
        // 사용자에게 약 추천

    public ArrayList<MedicineDTO> recommend(String select){
        Connection conn = cp.getConnection();
        ArrayList<MedicineDTO> result = new ArrayList<>();

        try {
           result = dao.recommend(conn, select);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.releaseConnection(conn);
        }

        return result;
    }
}
