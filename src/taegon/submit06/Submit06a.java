package taegon.submit06;

import java.util.Arrays;

public class Submit06a {
	public static void main(String[] args) {

//      Q. 01
//      한국 배우들의 명단을 배열로 만들어보았습니다.
//              for문을 이용하여 "이"씨 성을 가진 사람이 몇명인지 출력해주세요.
		String[] nameList = { "이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민",
				"최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬" };

//      Hint
//      for문으로 각각의 요소에 접근, 각 요소를 substring으로 맨 앞글자만 자른 뒤

		int cnt = 0;
		for (int i = 0; i < nameList.length; i++) {
			// System.out.println(nameList[i].substring(0, 1)); // 첫글자만 자르기 (성)
			if (nameList[i].substring(0, 1).equals("이")) {
				cnt++;
			}
			// 자른 글자가 “이"와 같은지 비교하여 같다면 카운팅

		}
		System.out.println("이씨 성을 가진 배우가 총 " + cnt + "명 있습니다");

		System.out.println("\n=================\n");

//      Q. 02
//
//      최댓값, 최솟값 구하기
		int[] intArr = { 23, 456, 213, 32, 464, 1, 2, 4 };
//      for문을 이용해 intArr의 최댓값과 최솟값을 출력해주세요.

//      Hint
//      for문 바깥에 int 변수 하나 선언해둔 뒤, for문을 돌리면서 각각의 요소가 int 변수보다 큰지 비교
		int max = intArr[0];
		int min = intArr[0];
		for(int i = 0; i < intArr.length; i++){
			// 크다면 int 변수에 해당 요소의 값 저장
			// 최대값
			if(max < intArr[i]){
				max = intArr[i];

			}else if (min > intArr[i]){
				min = intArr[i];
			}
		}
		System.out.println("최소값: " + min);
		System.out.println("최댓값: " + max);

		int temp = intArr[0];
		for(int i = 0; i < intArr.length; i++){
			if(temp > intArr[i]){
				temp = intArr[i];
			}
		}
		System.out.println("최소값 " + temp);
		temp = intArr[0];
		for(int i = 0; i < intArr.length; i++){
			if(temp < intArr[i]){
				temp = intArr[i];
			}
		}
		System.out.println("최대값 " + temp);

		System.out.println("\n=================\n");

//
//      Q. 03
//
//      로또 번호 생성기
//
//      1~45 까지의 랜덤 숫자 6개를 배열에 중복되지 않도록 담고, 이를 정렬한 배열을 리턴하는 makeLotto() 함수를 만들어주세요.

		int[] myLotto = makeLotto();
		for(int i = 0; i < myLotto.length; i++){
			System.out.print(myLotto[i] + " ");
		}




	} // 메인의 끝

	public static int[] makeLott(){
		int[] numArr = new int[6];
		int idx = 0;

		while(idx < 6){
			// 랜덤 숫자 생성
			int rand = (int) (Math.random() * 45) + 1;
			// 랜덤 숫자가 현재 배열 내 존재하는지 체크
			boolean  isDuple = false;
			for(int i = 0; i < numArr.length; i++){
				if(numArr[i] == rand){
					//랜덤 숫자가 현재 배열에 존재
					isDuple = true;
				}
			}
			// 위 for문이 끝날때까지 if문이 단 한번이라도 실행이 되었는지 체크
			// isDuple이 false일때 rand를 배열에 담기
			if(!isDuple){
				numArr[idx] = rand;
				idx++;
			}
		}
		Arrays.sort(numArr);

		return numArr;

	}

	public static int[] makeLotto(){
		// 로또 번호를 담을 배열 생성 (6자리)
		int[] lottoNumbers = new int[6]; // 0, 0, 0, 0, 0, 0
		// 랜덤한 숫자 6개를 반복을 돌린다 => 6자리 채워주기 위해
		// 몇번 반복해야 하는지 애매한 상황 = while문
		for(int i = 0; i < lottoNumbers.length; i++){
			// 1 ~ 45까지 랜덤한 숫자를 빈배열에 담는다
			lottoNumbers[i] = (int)(Math.random() * 45) + 1;
			// 중복 숫자 검사 하기
			// 중복된 숫자가 나오면 담지 않고 다시 랜덤 번호를 뽑으러 간다
			// 첫번째와 두번째를 비교해서 이전숫자들이 중복되는지 알아보는 조건 만들기
			// i가 0 일때는 false
			// i가 1 일때는 k가 0번째랑 비교
			// i가 2 일때는 k가 0번째랑 1번째랑 비교
			// i가 3 일때는 k가 0, 1, 2번째랑 비교
			for(int k = 0; k < i; k++){
				if(lottoNumbers[i] == lottoNumbers[k]) {
					// 중복된 숫자가 있으면 -i번째로 다시 돌아가서 번호를 뽑고 중복검사 로직을 멈춘다
					i--;
					break;
				}
			}
		}
		// 보기 좋게 오름차순 정렬해준다
		Arrays.sort(lottoNumbers);
	
		
		return lottoNumbers;
		
	}







}
