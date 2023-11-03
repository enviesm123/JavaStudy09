package ch14_Jdbc_jsp.dto;

// members 테이블과 조인한 SELECT문의 실행 결과를 담을 DTO
public class BoardDTO {
    private int boNo;               /* 글 번호 */
    private String boTitle;         /* 글 제목 */
    private String boContent;       /* 글 내용 */
    private String boId;            /* 작성자ID */
    private String boDate;          /* 작성날짜 */
    private String memName;         /* 작성자닉네임 */
    private String delYn;

    public BoardDTO() {
    }

    public BoardDTO(String boTitle, String boContent, String boId) {
        this.boTitle = boTitle;
        this.boContent = boContent;
        this.boId = boId;
    }

    public BoardDTO(int boNo, String boTitle, String boContent, String boId, String boDate, String memName) {
        this.boNo = boNo;
        this.boTitle = boTitle;
        this.boContent = boContent;
        this.boId = boId;
        this.boDate = boDate;
        this.memName = memName;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "boNo=" + boNo +
                ", boTitle='" + boTitle + '\'' +
                ", boContent='" + boContent + '\'' +
                ", boId='" + boId + '\'' +
                ", boDate='" + boDate + '\'' +
                ", memName='" + memName + '\'' +
                '}';
    }

    public int getBoNo() {
        return boNo;
    }

    public void setBoNo(int boNo) {
        this.boNo = boNo;
    }

    public String getBoTitle() {
        return boTitle;
    }

    public void setBoTitle(String boTitle) {
        this.boTitle = boTitle;
    }

    public String getBoContent() {
        return boContent;
    }

    public void setBoContent(String boContent) {
        this.boContent = boContent;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getBoDate() {
        return boDate;
    }

    public void setBoDate(String boDate) {
        this.boDate = boDate;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }
}
