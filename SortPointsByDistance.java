/*
문제:
알고리즘 문제에서는 다양한 정렬기준으로 원소들을 정렬합니다. 여러 종류의 원소들을 다루고 또 직접 정렬기준을 만들어 정렬하는 법을 연습해야 합니다.

2차원 좌표계에서 점들을 특정 기준점에 가까운 순서대로 정렬하는 문제를 해결해봅시다.
단순히 거리만으로 두 점을 비교하면 기준 점으로부터 같은 거리에 있지만 서로 다른 두 점이 생길 수 있습니다.
따라서 다른 기준을 같이 제공해야 합니다. 이번에는 거리가 같으면 x좌표가 더 작은값이, x좌표까지 같으면 y좌표 더 작은값이 먼저 오도록 정렬하도록 합니다.

기준점의 x좌표와 y좌표인 정수 x0, y0가 주어집니다. 이어서 점들의 목록 points가 주어집니다. points는 각 점들의 x, y 좌표가 [x, y] 형태로 저장된 2차원 정수 배열입니다. points를 위 정렬 기준에 맞게 정렬한 2차원 정수 배열을 반환하는 solution 함수를 완성해 주세요.

생각한 문제 해결방안: 내용자체가 복잡해서, 한가지 씩 먼저해결하기로 결정 다음은 구현 순서
1. 먼저 Arrays.sort에 조건문을 활용해서 결과값을 리턴하는 함수 구현
2. Arrays.sort에서 람다식을 활용하여 조건에 맞는 조건 작성
3. sorting된 결과값 리턴
다만 2에서 거리가 같은경우 x좌표와 y좌표값에 따라서 결과값을 정하는 조건은 미처 생각하지 못하여 정답을 참고했음

중요했던 부분: 거리에 따른 좌표값을 구하는 공식을 기본적으로 알고 있어야 하는 문제였다. 코드자체의 지식도 중요하지만, 수학적인 알고리즘 구현방식을 테스트
하는 문제로 보임, 
거리따른 좌표값 도출공식을 이해하고 있으면 쉽게 풀 수 있었던 문제

제시된 좌표값 (x,y)에 대해 거리에 따른 좌표값 도출공식

>0,0에 대한 좌표값 : x*x+y*y(각 좌표에 대한 제곱값) > 완벽한 값을 출력하기 위해선 루트를 씌워야하지만 해당 문제에서는 단순 거리 비교만 하기에 필요X
>1,3에 대한 좌표값 : (1-x)*(1-x)+(3-y)*(3-y) > 각좌표값에 대해 제시된 좌표값의 x,y값을 빼준다.
*/
/*
  기존 작성 코드: 채점결과 63점
  틀린이유: 오버플로우로 인한 오류발생으로 생각됨 > Integer변환 후 다시 int[][]형태로 변환하면서 실행시간 혹은 오버플로우 발생으로 오류 발생 > 채점 결과 실패
  해당코드를 이렇게 작성한 이유: 람다식에 대한 정확한 이해가 부족했음, 바로전 문제가 int[] arr > 람다식으로 실행 시 문제발생 즉 int형이면 정렬결과 람다식으로 변환 시
  Integer 변화 < 꼭 필요한 과정이라고 생각했음, 다만 int[]처럼 1차원 배열은 각 원소가 객체가 아니기 때문에 Comparator 적용이 안됨, 하지만 int[][]는 각 배열의 원소가
  객체 이기 때문에 따로 형변환이 필요하지 않음
*/
//아래는 기존작성코드 : 오답을 기록할 필요는 없어서 따로 기록안했지만, 해당 문제는 오답도 확인하며 비교가 필요할것 같아 남김
import java.util.Arrays;
class Solution {
    public int[][] solution(int x0, int y0, int[][] points) {
        int[][] answer = new int[points.length][2];
        
        Integer[][] points2 = new Integer[points.length][2];
        for(int i=0;i<points2.length;i++){
            points2[i][0]=points[i][0];
            points2[i][1]=points[i][1];
        }
        Arrays.sort(points2,(a,b)->{
            int distA=(a[0]-x0)*(a[0]-x0)+(a[1]-y0)*(a[1]-y0);
            int distB=(b[0]-x0)*(b[0]-x0)+(b[1]-y0)*(b[1]-y0);
            if(distA != distB){
                return distA-distB;
            }
            if(a[0] != b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        for(int i=0;i<answer.length;i++){
            answer[i][0]=points2[i][0];
            answer[i][1]=points2[i][1];
        }
        return answer;
    }
}

//정답코드
import java.util.Arrays;
class Solution {
    public int[][] solution(int x0, int y0, int[][] points) {
        
        Arrays.sort(points,(a,b)->{
            int distA=(x0-a[0])*(x0-a[0])+(y0-a[1])*(y0-a[1]);
            int distB=(x0-b[0])*(x0-b[0])+(y0-b[1])*(y0-b[1]);
            if(distA != distB){
                return distA-distB;
            }else{
                
            
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
            return a[1]-b[1];
            }
            }
        });

        return points;
    }
}
