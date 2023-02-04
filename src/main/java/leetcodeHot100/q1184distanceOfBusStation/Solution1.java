package leetcodeHot100.q1184distanceOfBusStation;

public class Solution1 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int length = distance.length;
        //向右花费
        int costRight = distance[start];
        //如果大于了当前数组范围则取余至正常值 %length
        for (int startRight = (start+1+length)%length;startRight!=destination;startRight=(startRight+1+length)%length){
            costRight = costRight + distance[startRight];
        }
        //向左花费
        int costLeft = 0;
        //如果小于了当前数组范围则取余至正常值 %length
        for (int startLeft = (start-1+length)%length;startLeft!=(destination-1+length)%length;startLeft=(startLeft-1+length)%length){
            costLeft = costLeft + distance[startLeft];
        }
        return costRight<=costLeft?costRight:costLeft;
    }
    public static void main(String[] args) {
        int [] distance = {1,2,3,4};
        System.out.println(new Solution1().distanceBetweenBusStops(distance,3,0));
    }
}
