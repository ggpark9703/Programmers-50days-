/*
도서관 데이터베이스에서 책을 장르별로 분류하려고 합니다. 책별 장르들의 목록이 주어졌을 때 각 장르별로 책이 몇개씩 존재하는 지를 저장해두려고 합니다.

2차원 문자열 배열 genres와 문자열 배열 queries가 주어집니다. genres는 각 책의 장르와 정보를 담고 있습니다.
각 책은 최대 3개의 장르를 가질 수 있으며, 만약 하나의 책의 장르가 3개 미만이라면 부족한 인덱스들은 전부 "-"로 대체됩니다. 
queries는 어떤 장르에 몇 개의 책이 존재하는지 질문하는 문자열 배열입니다.
queries에 담긴 장르들의 순서에 맞게 책의 개수를 저장한 배열을 return 하는 solution 함수를 완성해 주세요. 만약 해당 장르에 맞는 책이 없다면 0을 저장합니다.
*/
import java.util.HashMap;

class Solution {
    public int[] solution(String[][] genres, String[] queries) {
        //return해야하는 장르는 이미 queries에 담겨져 있음, 즉 genres내에 존재하는 장르들의 cnt값만 증가시키면 답을 구할 수 있음
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String[] genre:genres){
            //genres는 2중 배열이기때문에, 장르값만 가져오기 위해 2중 for문 사용
            for(String gen:genre){
                if(map.containsKey(gen)){
                    map.replace(gen,map.get(gen)+1);//해당 장르가 map안에 이미 존재할경우 1씩 증가하도록 할당
                }else{
                    map.put(gen,1);//장르의 초기값은 1부터 시작하기 때문에 초기값 1로 할당
                }
            }
        }
        int[] answer = new int[queries.length];
        //map안에 cnt를 활용해 장르에 cnt값을 answer에 return해주면 문제가 요구하는 return값이 완성된다.
        for(int i=0;i<queries.length;i++){
            answer[i]=map.getOrDefault(queries[i],0);//처음보는 메서드 getOrDefault > get값이 있을경우는 get값을 아닌경우는 할당된 n값이 리턴된다.
        }
        return answer;
    }
}
