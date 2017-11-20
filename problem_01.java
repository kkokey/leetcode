// <!-- Problem_01 by kkokey -->

/*

문자에 포함된 서로 다른 문자열의 개수를 구하시오.
단, 이 문자는 앞과 끝이 이어져 있어 첫번 째 문자열부터 시작해서 다른 문자열이 나타나는 순간부터가 문자를 카운팅하는 시점이다.

그렇기 때문에 양 끝 문자가 동일하다면 마지막 동일한 문자의 개수와 맨 앞에서 다른 문자열이 나타나기 전까지 동일한 문자의 개수가 마지막 문자열의 개수에 합산된다.

만약에 양 끝 문자가 다르다면 첫 번째 문자의 개수는 결과 값의 마지막에 추가된다.

입력된 문자는 최대 N만큼의 크기를 가진다.

1 < N < 100,000

예)
입력된 문자 : abaccchhaa
결과 : b1a1c3h2a3

/*

package problems;

public class Problem_01 {
	
	public static String problem01(){
		
		final int defaultCountVal = 1;
		String str = "abbaccchhaa";
		str = "a";
		
		StringBuffer stb = new StringBuffer();
		int arrFirstIdx = 0;

		// str.length 가 65535가 넘어가면 아래 로직은 사용할 수 없다.
		char[] strArr = str.toCharArray(); // 문자열을 char 배열로 변경.
		char lastVal = strArr[arrFirstIdx];	// 반복문이 완료된 후에 마지막 문자열과 비교해서 합산.
		char tmp = 32; // 빈 값.
		int cnt = str.length();
		int charCount = defaultCountVal; // 문자열이 변경되기 전까지의 횟수를 카운팅.
		int firstCharCount = arrFirstIdx;
		int i=arrFirstIdx;
		
		// 값이 1개일 경우 for문 전에 처리.
		if(strArr.length == 1){
			stb.append(defaultCountVal);
			stb.append(strArr[arrFirstIdx]);
			return stb.toString();
		}
		
		for(i=arrFirstIdx; i<cnt; i++){
          tmp = strArr[i];     // 현재 값을 임시로 담아둔다.
          if(lastVal == strArr[i]){
        	  firstCharCount++;
          }
		  if(charCount == defaultCountVal){
		    // 임시값이 변경된 후이거나 맨 처음 값인 경우므로 stb에 첫 문자열을 추가한다.
		    stb.append(strArr[i]);
		  }
		  if(strArr.length > i+1 && tmp == strArr[i+1]){    // 이전 For문에서 임시로 담아둔 값을 현재 값과 비교.
		    // 비교 결과가 같은 경우 charCount++
		    charCount++;
		  } else {
			// 반복문이 다 돌고난 후 첫 번째 값에 대한 처리.
			if(strArr.length == i+1 ){
				if(tmp == lastVal){
				  charCount++;
				  // 비교 결과가 다른 경우 지금까지 카운팅한 숫자를 버퍼에 담는다.
				  // 그리고 카운트 하는 변수를 기본값 으로 초기화 한다.
				  stb.append(String.valueOf(charCount));
				  charCount = defaultCountVal;
				}else{
				  // 첫 번째 값과 마지막 값이 다른 경우 합산된 마지막 값의 개수 추가 한다.
				  stb.append(String.valueOf(charCount));
				  
				  // 첫번째 값에 대한 값 추가.
				  stb.append(lastVal);
				  stb.append(String.valueOf(firstCharCount));
				  charCount = defaultCountVal;
				}
			}else{
			  // 비교 결과가 다른 경우 지금까지 카운팅한 숫자를 버퍼에 담는다.
			  // 그리고 카운트 하는 변수를 기본값 으로 초기화 한다.
			  stb.append(String.valueOf(charCount));
			  charCount = defaultCountVal;
			}
		  }
		}
		stb.delete(arrFirstIdx, 2);
		return stb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(problem01());
	}

}
