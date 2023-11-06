package ch15_inout;

import java.io.*;

public class ImageCopy {
    public static void main(String[] args) {
        File readImg = new File("/home/pc23/Downloads/test.webp");
        File writeImg = new File("/home/pc23/stuList/태곤/꼴오키지.png");

        try(FileInputStream fis = new FileInputStream(readImg)){
            FileOutputStream fos = new FileOutputStream(writeImg);

            System.out.println(fis.available());
            byte[] bowl = new byte[fis.available()];

            fis.read(bowl);

            fos.write(bowl);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
