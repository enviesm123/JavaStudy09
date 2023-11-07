package ch16_network.open_api.dto;

public class MedicineDTO {
    private String entpName;        /* 회사이름 */
    private String itemName;        /* 제품이름 */
    private String efcyQesitm;      /* 효능 */

    public MedicineDTO() {
    }

    public MedicineDTO(String entpName, String itemName, String efcyQesitm) {
        this.entpName = entpName;
        this.itemName = itemName;
        this.efcyQesitm = efcyQesitm;
    }

    public String getEntpName() {
        return entpName;
    }

    @Override
    public String toString() {
        return "DateDTO{" +
                "entpName='" + entpName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", efcyQesitm='" + efcyQesitm + '\'' +
                '}';
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getEfcyQesitm() {
        return efcyQesitm;
    }

    public void setEfcyQesitm(String efcyQesitm) {
        this.efcyQesitm = efcyQesitm;
    }
}
