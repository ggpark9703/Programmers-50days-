/*
오름차순으로 정렬된 정수 배열 arr1과 arr2가 주어집니다. 두 배열을 이어 붙인 후 오름차순으로 정렬한 배열을 return 하는 solution 함수를 작성해 주세요.
*/
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length+arr2.length];
        int index=0;//day 8에서 사용한, index를 재활용했다. 해당 개념을 사용하니 두 배열을 이어붙히는게 쉬워짐
        for(int i=0;i<arr1.length;i++){
         answer[index]=arr1[i];
         index++;
        }
        for(int i=0;i<arr2.length;i++){
         answer[index]=arr2[i];
         index++;
        }
        //오름차순이기 때문에 별도의 조건을 붙히지 않고 sort를 활용해 배열 재정렬
        Arrays.sort(answer);
        return answer;
    }
}
