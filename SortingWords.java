/*
문제:
영문 알파벳으로만 구성된 문자열들로 이루어진 words가 매개변수로 주어집니다. 이 문자열들을 길이가 짧은 것부터, 길이가 같다면 문자열에 속한 문자를 전부 영소문자로 비교했을 때
기준 사전순으로 정렬한 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

생각한 해답: Arrays의 sort를 활용해 정렬조건만 지정해주면 해결될것으로 생각
먼저 길이값을 비교해서 return후 길이가 같다면 문자열에 속한 문자 비교후 정렬하는 방식으로 해결

어려웠던 부분: compareTo 메서드는 해답을 보고 알았다. 단순 for문과 charAt메서드 그리고 toLowerCase로 문제를 해결하려고 했음 > 오답처리, compateTo메서드 적용 후 > 정답처리

개선해야할 부분: 굳이 if문을 두번사용하지 않아도, 문자열길이가 같은지만 확인 후 하나의 if문으로 개선가능
기존작성코드: if(a.length()<b.length()){return -1;}if(a.length()>b.length()){return 1;} 
변경 후 : 
if(a.length()!=b.length()){
 return a.length()-b.length();
}
> 길이를 떠나서 훨씬더 간결하게 코드작성 가능
*/
import java.util.Arrays;
class Solution {
    public String[] solution(String[] words) {

        Arrays.sort(words,(a,b)->{
            if(a.length()<b.length()){
                return -1;
            }
            if(a.length()>b.length()){
                return 1;
            }
            String lowerA = a.toLowerCase();
            String lowerB = b.toLowerCase();
            return lowerA.compareTo(lowerB);
        });
        return words;
    }
}
