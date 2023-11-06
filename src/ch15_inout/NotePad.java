package ch15_inout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class NotePad {

    public static void main(String[] args) {
        // 프로그램 실행시
        // 파일명과 내용을 입력받아
        // /home/pc23/stuList 폴더 내에 해당 파일명으로 입력한
        // 내용이 들어간 텍스트 파일 생성하기
        Scanner scan = new Scanner(System.in);

        System.out.println("파일명을 입력해주세요");
        System.out.print(">>> ");
        String fileName = scan.nextLine();


        System.out.println("파일명 내용을 입력해 주세요");
        System.out.print(">>> ");
        String fileContent = scan.nextLine();

        File file = new File("/home/pc23/stuList/" + fileName + ".txt");
        try {
            file.createNewFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try( FileWriter content = new FileWriter(file, true);) {
            content.write(fileContent + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
