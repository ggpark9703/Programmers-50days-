/*
문제:
어떤 문자열에 특정 알파벳이 존재한다면 그 알파벳이 "등장"한다고 합시다.
문자열 목록을 나타내는 문자열 배열 strs가 주어집니다. 문자열 목록들 중 가장 많은 문자열에서 "등장"한 알파벳 문자열을 반환하는 solution 함수를 완성하세요.
만약 가장 많이 등장한 문자가 여러 개라면 모든 문자를 담은 문자열을 사전순으로 정렬해서 반환합니다.
*/
import java.util.HashSet;
class Solution {
    public String solution(String[] strs) {
        int[] count = new int[26];//a부터 z까지 알파벳의 갯수가 26개로 정해져 있어서 다음과 같이 선언

        for(String str: strs){
            HashSet<Character> set = new HashSet<>();//HashSet을 for문 내부에서 선언한 이유 > 문자열에서 가장 많이 등장한 알파벳을 구해야 하므로, 여러번 반복해서 알파벳 등장횟수를 계산하기 위해+중복제거
            for(int i=0;i<str.length();i++){
                set.add(str.charAt(i));
            }
            for(Character c:set){
            count[c-'a']+=1;
              /*
                가장 이해가 안됐던 부분, 굳이 'a'를 빼는 이유를 몰랐다 > 'a'는 숫자로 자동으로 변환됨(유니코드) 즉 'a'는 97이라는 값을 가짐 이는,
                'b'> 98
                'c'> 99
                위와 같이 1씩 증가함, 그래서 만약 set에 a란 값이 들어가 있다면 count['a'-'a']+=1; 즉 count[0]+=1; count[0]을 'a'라는 알파벳 문자열이라고 치고, 해당 문자열이 몇번 등장하는지 계산하기 위한 방법
                + b라면 count[98-97]이므로 count[1]+=1;을 수행하게 됨
              */
            }
        }
        int max=0;
        for(int i=0;i<count.length;i++){
          //최댓값을 구하기 위한 함수, 처음에는 각 알파벳마다 최댓값을 구하지 않을까 의아함 > 어차피 최댓값을 가진 알파벳만 보여주므로 하나만 구해도 된다.
            if(max<count[i]){
                max=count[i];
            }
        }
        String answer= "";
        for(int i=0;i<count.length;i++){
            if(count[i]==max){
                /*
                  최댓값을 가진 알파벳만 문자열에 더해준다. 가장많이 등장한 알파벳이 a,b라면 각각 count[0]와count[1]이 max과 동일하다.
                  count배열에 유니코드를 활용해서 0부터 알파벳과 매치했기때문에 'a'+i를 활용하면 알파벳을 구할 수 있다.
                  'a'+0 >a를 리턴
                  'a'+1 >b를 리턴
                  즉 ab를 리턴함
                */
                answer+=(char)('a'+i);
            }
        }
        return answer;
    }
}
