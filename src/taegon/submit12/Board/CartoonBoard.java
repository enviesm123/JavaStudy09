package taegon.submit12.Board;

public class CartoonBoard extends BoardParent {
    private String imgFile;

    public CartoonBoard(String imgFile) {
        this.imgFile = imgFile;
    }

    public CartoonBoard(int number, String title, String date, String content, String imgFile) {
        super(number, title, date, content);
        this.imgFile = imgFile;
    }

    @Override
    public String toString() {
        return "CartoonBoard{" +
                "imgFile='" + imgFile + '\'' +
                '}';
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }
}
