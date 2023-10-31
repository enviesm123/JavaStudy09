package ch13_thread;

public class MakeString {

    public static void main(String[] args) {
        // 문자열을 아주 길~~~~~게 만들기

        // 동기화를 지원
        // 쓰레드가 A가 strBuff를 건드리면 쓰레드 B, C가 이를 안다
        StringBuffer strBuff = new StringBuffer();

        // 동기화 미지원
        // 쓰레드 A가 strBuilder를 건드리면 쓰레드 B, C가 이를 모를수도 있다.
        StringBuilder strBuilder = new StringBuilder();

        Thread threadA = new Thread(() -> {
            for(int i = 0; i < 50000000; i++){
                strBuilder.append((int)(Math.random()*10));
            }
            System.out.println(strBuilder.length());
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for(int i = 0; i < 50000000; i++){
                strBuilder.append((int)(Math.random()*10));
            }
            System.out.println(strBuilder.length());
        });
        threadB.start();









    }
}
