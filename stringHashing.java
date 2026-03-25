/*
문제:
정수를 저장할 수 있는 자료구조 S가 있습니다. 이 자료구조에는 command 명령이 있고, 정수 N에 대하여 다음과 같이 동작합니다.
command N: S에 N이 없으면 추가하고 있으면 삭제한다.
비어있는 S에 순서대로 command를 실행할 정수들이 들어있는 queries가 매개변수로 주어질 때, 전부 처리한 뒤 자료구조 S에 있는 정수의 개수를 return 하는 solution 함수를 작성해 주세요.
*/
import java.util.HashSet;//HashSet을 사용하기 위한 import문
class Solution {
    public int solution(int[] queries) {
        HashSet<Integer> set = new HashSet<Integer>();//HashSet형태의 변수선언, 결과를 answer에 담기 위해 최상단에 선언한다.
        for(int query:queries){
          // 문제는 정수형 자료구조 S에 N이 없으면 추가, 이미 있다면 삭제하도록 동작하게 한다. 
            if(set.contains(query)){
                set.remove(query);
            }else{
                set.add(query);
            }
        }
        
        int answer = 0;
        answer = set.size();
        return answer;
    }
}
