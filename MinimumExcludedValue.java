/*
mex란 minimum excluded의 약어로, 임의의 0 이상의 정수로 이루어진 집합에서 존재하지 않는 가장 작은 값을 의미합니다.

예를 들어, 집합 {0, 1, 2, 5, 6}이 있다면 0, 1, 2가 집합 안에 존재하고 그다음 값인 3이 존재하지 않기 때문에 이 집합의 mex값은 3이 됩니다.

배열 arr가 주어집니다. 이때 arr의 원소들로 이루어진 집합의 mex 값을 return 하는 solution 함수를 완성해주세요.
*/
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] count = new int[1000001];//해당 문제의 arr의 원소값의 제한이 0부터 1000,000이기 때문에 0부터 1000,000 까지 총 1000,001개의 카운트 선언
        for(int ar:arr){
            // 값이 존재하는지 확인하기 위한 count문 예시대로 0,1,2,5,6이라면 해당 인덱스 값이 1씩 증가한다. 
            count[ar]+=1;
        }
        for(int i=0;i<count.length;i++){
            // 존재하는 값중 mex값을 구하기 위한 for문, count배열을 순차적으로 순회하기 시작한다. 중간에 비어있는값 0가 나오면 해당값을 바로 return
            // 0,1,2,5,6 이라면 3,4가 비어있지만 최소값만 구하면 되므로 3에서 멈추고 3을 return한다.
            if(count[i]==0){
                return i;
            }
        }
        return answer;
    }
}
