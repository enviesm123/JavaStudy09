package ch15_inout;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public static void main(String[] args) {
        try(FileReader reader = new FileReader("/home/pc23/stuList/total.txt");) {

            // 데이터를 옮길 그릇 생성
            char[] word = new char[1]; // fis 처럼 넉넉하게 주어도 문제 없다.

            StringBuffer strBuff = new StringBuffer();

            while(true){
              int cnt = reader.read(word);
              if(cnt == -1){
                  break;
              }
                System.out.println(word[0]);
              // char[] -> String
                String text = new String(word);
                strBuff.append(text);
            }
            System.out.println(strBuff);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
