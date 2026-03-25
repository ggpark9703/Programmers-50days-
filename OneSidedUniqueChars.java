/*
알파벳 소문자로 이루어진 두 문자열 str1과 str2가 주어질 때, 둘 중 한쪽에만 있는 문자의 개수를 return 하는 solution 함수를 완성하세요.
*/
import java.util.HashSet;
class Solution {
    public int solution(String str1, String str2) {
        //각 문자열의 비교를 위해서 HashSet을 두개 선언했다. HashSet 사용이유 > 중복값은 필요없기 때문
        HashSet<Character> set = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();
      
        int answer = 0;
        /*
        아래 for에서 length()로 사용하던데, 일반 문자열에서는 length자체만 사용해도 돼서 궁금해서 찾아봤다.
        String 값 > length값을 가지고 있지 않음, 그래서 length() < 메서드다. 로 사용
        array(배열) > length값을 가지고 있음, 그래서 length만 사용해도 값을 계산할 수 있음
        */
        for(int i=0;i<str1.length();i++){
            set.add(str1.charAt(i));//charAt(i) < 유용한 기능 문자열에서 특정 인덱스에 있는 문자만 뽑아올수 있다.
        }
        
        for(int i=0;i<str2.length();i++){
            set2.add(str2.charAt(i));
        }
       //위에서 HashSet은 완성이 되고 아래는 단순 비교를 통해 한쪽에만 있는 값 계산
        for(char s:set){
            if(!set2.contains(s)){
                answer +=1;
            }
        }
        for(char s:set2){
            if(!set.contains(s)){
                answer +=1;
            }
        }
        return answer;
    }
}
