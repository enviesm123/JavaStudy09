package ch15_inout;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileBasic {
    public static void main(String[] args) {
        // 현재 디렉토리의 경로 가져오기
        String path = System.getProperty("user.dir");
        System.out.println(path); // /home/pc23/IdeaProjects/JavaStudy

        // JavaStudy 내 src 폴더를 자바단의 File 객체로 불러오기
        // /home/pc23/IdeaProjects/JavaStudy = path + "/src"
        // File의 생성자 안에 파일의 경로를 넣어주면 해당 File 객체는
        // 실제 로컬 파일에 해당하게 된다.
        File src = new File(path + "/src");

        // toString 실행시 해당 File 객체의 풀 경로만 출력됨
        System.out.println(src);

        // 해당 File 객체가 폴더인지 파일인지 확인
        System.out.println(src.isDirectory());

        // 폴더 내 파일 목록 출력
        // File 배열을 리턴
        File[] fileArray = src.listFiles();

        for (int i = 0; i < fileArray.length; i++) {
            System.out.println(fileArray[i]);   // 파일의 풀경로
            System.out.println(fileArray[i].getName()); // 파일명만
        }

        System.out.println(fileArray[1]);

        File comment = new File(fileArray[1]+"/StringMain.java");
        System.out.println(comment);

        // 실제로 존재하지 않는 경로에 대해서도 File 객체는 만들어진다.
        File temp = new File(fileArray[1]+"/Comments.java");
        System.out.println(temp);

        // File 객체가 실제 로컬 파일을 가르키고 있는지 확인
        System.out.println(comment.exists());
        System.out.println(temp.exists());

        // 실제 파일에 대한 정보 보기
        // .length() 파일 크기 리턴 (byte)
        // 1Kb = 1024byte
        // 1Mb = 1024Kb
        // 1Gb = 1024Mb
        // 1Tb = 1024Gb
        System.out.println(comment.length());
        System.out.println(temp.length()); // 0 출력

        // .lastModified() 마지막 수정 날짜
        System.out.println(comment.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(comment.lastModified()));

        // 존재 하지 않는 파일 생성
        // temp 객체는 /home/pc23/IdeaProjects/JavaStudy/src/ch02_variable/Comments.java
        // 해당 경로에 대한 로컬파일이 생성됨
        try {
            temp.createNewFile(); // 존재할때 실행시 에러가 나지는 않음
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 폴더 만들기
        // /src/files 폴더 만들기
        File folder = new File(path + "/src/files");

        folder.mkdir();

        System.out.println("\n============================\n");

        ArrayList<String> stuList = new ArrayList<>();

        stuList.add("강연");
        stuList.add("동우");
        stuList.add("태곤");
        stuList.add("창연");
        stuList.add("성복");
        stuList.add("장선");
        stuList.add("지우");
        stuList.add("유민");
        stuList.add("민재");

        // /home/pc23/stuList 폴더 안에
        // 각 학생들 이름으로 구성된 폴더를 만들어 보기
        // 각 학생들 이름의 폴더안에 id.txt 파일 한개씩 만들기


        File stuFile = new File("/home/pc23/stuList");
        stuFile.mkdir();

        for (int i = 0; i < stuList.size(); i++) {
            File stu = new File("/home/pc23/stuList/" + stuList.get(i) + "/id.txt");
            try {
                stu.createNewFile(); // 존재할때 실행시 에러가 나지는 않음
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(stuList.get(i));
        }


    }
}
