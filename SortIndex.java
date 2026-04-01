/*
문제:
1 이상 1,000,000,000 이하의 서로 다른 정수들로 이루어진 배열 arr이 주어집니다.
배열 arr을 오름차순으로 정렬했을 때 정렬하기 전의 arr에서의 
인덱스를 순서대로 담은 배열을 return 하는 solution 함수를 작성해 주세요.

해결방법:
기존 주어진 문자열과 인덱스값을 저장하기 위해서 HashMap을 활용하면 좋겠다고 먼저 생각했다
1. 해쉬맵에 기존 배열 인덱스 값 저장 
2. 주어진 배열 .sort 메서드로 오름차순 정렬
3. 오름차순으로 정렬된 결과 값을 순서대로 읽을 루프문 작성 
3.1 해당 루프문에서 map이 가지고 있는 index값을 answer값으로 대체

결과 : > 정답처리 
추가 해결: 해답을 보니 HashMap을 활용하지 않아도 좀더 간결하게 코드작성 가능, > 단순 인덱스값만으로 문제해결 가능 기존 코드 아래에 추가
*/
//기존문제 해결코드
import java.util.HashMap;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            answer[i]=map.get(arr[i]);
        }
        return answer;
    }
}
//해답에서 사용한 해결코드
import java.util.Arrays;
class Solution{
  public Integer[] solution(int[] arr)}{
    Integer[] answer = new Integer[arr.length];
    for(int i=0;i<answer.length;i++){
      answer[i]=i;
    }
    Arrays.sort(answer,(a,b)->{
     return arr[a]-arr[b]
    });
    return answer;
  }
}
