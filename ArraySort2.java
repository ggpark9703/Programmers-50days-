/*
문제:
크기가 같은 배열 a, b에 대해서 배열 a * b를 다음과 같이 정의합니다.

a의 길이를 N이라고 할 때, 0 ≤ i ≤ N - 1에 대해 (a * b)[i] = (a에서 i + 1번째로 작은 수) × (b에서 i + 1번째로 큰 수)

두 정수 배열 a, b가 매개변수로 주어질 때, 정수 배열 a * b를 return 하는 solution 함수를 작성해 주세요.

내가 생각한 풀이법: Sort를 활용해서 오름차순 > a배열, 내림차순 > b배열 으로 재정렬 후 배열값을 곱해주기

문제내에서 a와 b는 길이가 같다고 했으니 for문 하나로 해결 가능하다고 판단

막힌 부분: 내림차순 배열에서 에러발생 > int타입은 sort를 활용해서 내림차순으로 만드려하면 에러가 난다

해결방안 : Integer타입으로 새롭게 배열생성 or for문을 통해 수작업으로 배열 내림차순 변경
*해설에서 사용한 해결방안: 람다식 활용 l1-l2 >return시 내림차순으로 변경 후 출력( 람다식에 대한 이해도를 높혀야겠다 )

사용한 방안: Interget타입으로 새롭게 배열생성 후 Collections의 reverseOrder()메서드를 활용해 내림차순으로 변경

*/
import java.util.Collections;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] a, int[] b) {
        int[] answer = new int[a.length];
        Integer[] b2 = new Integer[b.length];
        for(int i=0;i<b.length;i++){
            b2[i]=b[i];
        }
        Arrays.sort(a);
        Arrays.sort(b2,Collections.reverseOrder());
        for(int i=0;i<a.length;i++){
            answer[i] = a[i]*b2[i];
        }
        return answer;
    }
}
