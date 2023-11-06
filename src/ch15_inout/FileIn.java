package ch15_inout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIn {
    public static void main(String[] args) {
        // 읽고자 하는 파일을 File 객체로 불러오기
        File total = new File("/home/pc23/stuList/total.txt");

        // 해당 File 객체를 InputStream 내 넣어주기
        try (FileInputStream fis = new FileInputStream(total);) {

            // 데이터를 가져올 그릇(byte[]) 생성
            byte[] bowl = new byte[3]; // byte[1] 은 그릇의 크기가 1바이트임

            String result = "";
            while (true) {
                // 해당 파일을 읽어서 bowl에 담음
                // cnt에는 담긴 개수가 담김
                int cnt = fis.read(bowl);
                // 만약에 cnt에 -1이 담기면 더이상 담을게 없었다는 뜻
                if (cnt == -1) {
                    break;
                }

                // bowl은 byte[] 이므로
                System.out.println(bowl[0]);
                // byte[] -> String 변환
                String read = new String(bowl);
                System.out.println(read);
                result += read;

            }
            System.out.println(result); // 문자열(한글)이 망가져 있음

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("\n======================================\n");


        try (FileInputStream fis = new FileInputStream(total);) {

            // 데이터를 가져올 그릇(byte[]) 생성
            // 한번에 가져올 수 있도록 그릇의 크기를 최대로 만들기
            System.out.println(fis.available()); // inputStream이 바라보고 있는 File의 byte크기 리턴
            byte[] bowl = new byte[fis.available()];

            // 해당 파일을 읽어서 bowl에 담음
            // cnt에는 담긴 개수가 담김
            int cnt = fis.read(bowl);
            // 만약에 cnt에 -1이 담기면 더이상 담을게 없었다는 뜻
            // byte[] -> String 변환
            String read = new String(bowl);
            System.out.println(read);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

