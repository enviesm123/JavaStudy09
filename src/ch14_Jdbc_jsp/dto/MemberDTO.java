package ch14_Jdbc_jsp.dto;

// DTO : Data Transfer Object
// members 테이블의 데이터와 1:1 매핑이 되는 클래스
// SELECT 쿼리문의 실행 결과와 1:1 매핑이 되는 클래스
public class MemberDTO {
    // DB의 컬럼명이 mem_id 라면 자바에서는 memID로 씀
    private String memID;
    private String memPw;
    private String memName;
    private int memScore;

    public MemberDTO() {
    }

    public MemberDTO(String memID, String memPw, String memName, int memScore) {
        this.memID = memID;
        this.memPw = memPw;
        this.memName = memName;
        this.memScore = memScore;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memID='" + memID + '\'' +
                ", memPw='" + memPw + '\'' +
                ", memName='" + memName + '\'' +
                ", memScore=" + memScore +
                '}';
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public int getMemScore() {
        return memScore;
    }

    public void setMemScore(int memScore) {
        this.memScore = memScore;
    }
}
