/*
어떤 컴퓨터에서 새 폴더를 만들 때 이름을 짓는 규칙은 다음과 같습니다.

이전까지 한 번도 사용하지 않은 이름으로 새 폴더를 만들면 그 이름 그대로 폴더를 만듭니다.
이전에 사용한 이름이라면 이전까지 같은 이름으로 만든 폴더의 개수를 X라고 할 때 이름 뒤에 "_X"를 붙여 폴더를 만듭니다.
예를 들어 새 폴더를 만들려는 이름이 순서대로 ["bfs", "sort", "bruteforce", "hash", "bfs", "dfs", "sort", "sort"]라면, 1번째부터 4번째까지 폴더는 이름이 겹치지 않으므로 그대로 만들어지고, 
5번째로 만들려는 폴더의 이름은 "bfs"이고 이전에 같은 이름으로 만든 폴더의 개수가 1개이므로 이때는 "bfs_1"로 폴더가 만들어집니다. 7번째, 8번째로 만드는 폴더의 이름은 "sort"이고 이전에 같은 이름으로 만든 폴더의 개수가 각각 1개,
2개이므로 만들어지는 폴더의 이름은 각각 "sort_1", "sort_2"가 됩니다.

처음에 이 컴퓨터에는 아무 폴더도 없는 상태입니다. 새 폴더를 만들려고 하는 이름이 순서대로 담긴 문자열 배열 folder_names가 주어질 때, 만들어진 폴더의 이름을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
*/

import java.util.HashMap;//해당 문제는 HashMap을 이용해서, 폴더종류와 같은폴더명의 cnt값을 활용할 줄 아는지 확인하는 문제로 파악되어 HashMap import
class Solution {
    public String[] solution(String[] folder_names) {
        String[] answer = new String[folder_names.length];//항상 놓치는 부분, 정답에 길이가 정해져있다면(해당문제에서는 folder_names의 길이만큼 정답의 길이가 정해짐) 미리 선언해주는 습관을 들이자
        HashMap<String,Integer> map= new HashMap<>();
        //결국 return값은 처음주어진 folder_names에 인덱스값만 붙히는 형식 > 루프를 여러번 탈 필요는 없음
        for(int i=0;i<folder_names.length;i++){
            //해쉬맵에 이미 폴더명이 있는경우 value값을 1씩증가하도록 루프 작성, 없는 경우 value초기값 0 > 중복의 경우 _1 부터 인덱스 증가하기 때문
            if(map.containsKey(folder_names[i])){
                map.replace(folder_names[i],map.get(folder_names[i])+1);
                answer[i]=folder_names[i]+"_"+map.get(folder_names[i]);
            }else{
                map.put(folder_names[i],0);
                answer[i]=folder_names[i];
            }
        }
        return answer;
    }
}
