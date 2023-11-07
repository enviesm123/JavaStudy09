package ch16_network.open_api.dao;

import ch16_network.open_api.dto.MedicineDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineDAO {

    // 싱글톤

    private static MedicineDAO instance = new MedicineDAO();

    public static MedicineDAO getInstance(){
        return instance;
    }

    // 데이터 업데이트 (INSERT)



    public int insertMedicine(Connection conn, MedicineDTO medicine) throws SQLException {

        StringBuffer query = new StringBuffer();
        query.append("INSERT                ");
        query.append("      INTO            ");
        query.append("      medicines (     ");
        query.append("   entp_name          ");
        query.append(" , item_name          ");
        query.append(" , efcyQesitm         ");
        query.append("  ) VALUES (          ");
        query.append("   ?                  ");
        query.append("  , ?                  ");
        query.append("  , ?                  ");
        query.append("    )                 ");

        PreparedStatement ps = conn.prepareStatement(query.toString());



        int idx = 1;

        ps.setString(idx++, medicine.getEntpName());
        ps.setString(idx++, medicine.getItemName());
        ps.setString(idx++, medicine.getEfcyQesitm());

        int result = ps.executeUpdate();

        ps.close();

        return result;

    }

    public ArrayList<MedicineDTO> recommend(Connection conn, String select) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append(" SELECT            ");
        query.append("        entp_name  ");
        query.append("       ,item_name  ");
        query.append("       ,efcyQesitm ");
        query.append(" FROM              ");
        query.append("      medicines    ");
        query.append(" WHERE  1=1        ");
        query.append("  AND efcyQesitm   ");
        query.append("  LIKE             ");
        query.append("    ?              ");

        PreparedStatement ps = conn.prepareStatement(query.toString());
        ps.setString(1, "%" + select + "%");

        ResultSet rs = ps.executeQuery();

        ArrayList<MedicineDTO> result = new ArrayList<>();

        while (rs.next()){
            MedicineDTO medicine = new MedicineDTO();

            medicine.setItemName(rs.getString("item_name"));
            medicine.setEfcyQesitm(rs.getString("efcyQesitm"));
            medicine.setEntpName(rs.getString("entp_name"));

            result.add(medicine);
        }



        rs.close();
        ps.close();

        return result;

    }

}
