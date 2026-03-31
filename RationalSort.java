import java.util.Arrays;
class Solution {
    public int[][] solution(int[][] rational) {
        Arrays.sort(rational,(a,b)->{
            double a0= a[0];
            double a1= a[1];
            double b0= b[0];
            double b1= b[1];
            if(a0/a1 > b0/b1){
                return 1;
            }
            if(a0/a1 < b0/b1){
                return -1;
            }
            return a[1]-b[1];
        });
        return rational;
    }
}
