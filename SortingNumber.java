/*
정수 배열 arr가 주어집니다. arr에서 각 자릿수의 합이 sum인 수가 있으면, 그러한 수의 개수가 cnt일 때 [sum, cnt]를 담고 있는 2차원 배열을 반환하는 solution 함수를 완성해주세요.

단, 반환하는 배열은 sum이 작은 것부터 오름차순으로 정렬합니다.
*/
//8일차 까지 진행하면서 가장 어려웠던 문제, 자주 확인해보면 좋을 것 같다.
class Solution {
    public int[][] solution(int[] arr) {
        int[]count = new int[82];//해당 count값이 왜 82인지 가장 헷갈렸던 문제, 해설만 보고는 이해가 되지 않았다.
        /*
         문제에 주어진 제한값은 1 ≤ arr의 원소 ≤ 1,000,000,000 
         만약 11이라면 2를 return하는 식이기 때문에 각자리수마다 나올 수 있는 최댓값은 9,
         이를 전부 합하면 81+1.
        */
        int length = 0;
        for(int a:arr){
            //처음에는 charAt을 활용해서 각자리수를 합치는 방식을 고려해봤지만, 문제해설에서 사용된 방법이 더 깔끔한것 같아서 그대로 사용했다.
            int sum=0;
            while(a>0){//a가 0이 될때까지 반복되도록 만든 while문
                sum+=a%10;//while문이 반복되는 동안 sum값을 계산하도록 만든 코드, 만약 154가 a의 초기값이라면 10으로 나눴을때 4를 더한다
                a/=10;//뒤에 자리수를 뺴기위한 나누기코드, 10으로 나누게 되면 154> 15가 된다, 정수는 소숫값을 저장하지 않기 떄문에 소수값은 더이상남지 않는다.
                //이를 반복하면 15가 남고 이를 10으로 나눈 나머지 5를 더하고 1이 남고 1을 더하고, 10으로 나누면 소수값은 남지 않기떄문에 0만 남는다.
            }
            if(count[sum]==0){
                length+=1;//answer의 길이를 정하기 위한 if문, count[sum]이 0인경우에만 length를 증가하도록 해서 문제의 배열길이의 값을 정하기 위한 코드이다.
            }
            count[sum]+=1;
        }
        int[][] answer = new int[length][2];
        int index=0;
        //index를 선언하고 for문내부에서 if문실행후 카운트 증가하게 하는 방식은 생각하지 못했다.
        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                answer[index][0]=i;
                answer[index][1]=count[i];
                index++;
            }
            
        }
        return answer;
    }
}
