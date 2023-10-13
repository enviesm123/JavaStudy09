package ch09_class.school;

import ch09_class.common.UtilClass;
import ch09_class.nextit.NextStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SchoolMain {
    public static void main(String[] args) {
        // 학교의 학생 성적 입력, 관리하는 프로그램 만들예정
        // 각 학생에 대해 객체로 만들어 써야겠다.
        // 학생은 이름, 국어, 영어, 수학, 평균을 가진다.

        Student minjae = new Student("민재", 65, 34, 42, (65+33+42)/3.0);

        System.out.println(minjae);

        Student yumin = new Student("유민", 78, 82, 100);

        System.out.println(yumin);

        System.out.println(yumin.getMath());

        // 필드 변수값 수정
        yumin.setMath(97);
        System.out.println(yumin); // 평균이 변하지 않음

        // 필드변수 수정에 대한 제어
//        yumin.math
        yumin.setEng(83);
        System.out.println(yumin);

        // 평균을 수정한다는건 있을 수 없는 일
        // 평균에 대한 setter를 지우기
//        yumin.setAvg(90.5);
        System.out.println(yumin);

        // 기본적으로 클래스 내 메소드는
        // 해당 클래스를 객체로 생성한 후 사용
//        Student.getMath();

        // Math 클래스 내 메소드를
        // Math를 객체로 생성하지 않아도 사용 가능
        Math.random();
        Math.round(3.14);

        // static이 붙어있는 필드변수와 메소드는
        // 해당 클래스를 객체로 생성하지 않아도 사용가능
        UtilClass util = new UtilClass();
        UtilClass.myRound(3.1452, 2);

        yumin.setKor(86);
        System.out.println(yumin);

        System.out.println("\n=====================\n");

        ArrayList<Student> stuList = new ArrayList<>();

        stuList.add(minjae);
        stuList.add(yumin);
        stuList.add(new Student("지우", 76, 98, 75));
        stuList.add(new Student("동우", 86, 88, 85));
        stuList.add(new Student("강연", 77, 99, 65));

        for(int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

        // stuList에 담긴 학생들의 평균을 이용해서
        // 종합 성적표를 출력해보기

        for(int k = 0; k < stuList.size() -1 ; k++){
            for(int i = 0; i < stuList.size() -1; i++){
            if(stuList.get(i).getAvg() < stuList.get(i+1).getAvg()) {
                Student tmp = stuList.get(i);
                stuList.set(i, stuList.get(i+1));
                stuList.set(i+1, tmp);
            }
            }
        }
        for(int i = 0; i < stuList.size(); i++){
            System.out.println((i+1) + "등 " + stuList.get(i));
        }

        Collections.sort(stuList, (stuA, stuB) -> (stuA.getAvg() - stuB.getAvg() < 0) ? -1 : 0);
        Collections.sort(stuList, (stuA, stuB) -> {
            return (stuA.getAvg() - stuB.getAvg() < 0) ? -1 : 0;

        });
        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student stuA, Student stuB) {
                return (stuA.getAvg() - stuB.getAvg() < 0) ? -1 : 0;
            }
        });










    }
}
