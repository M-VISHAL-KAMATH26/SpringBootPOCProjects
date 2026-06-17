//3. Two Sum
//
//Given an array and a target, return indices of two numbers that add up to the target.
//
//Input: [2, 7, 11, 15], target = 9 → Output: [0, 1]


import java.util.Arrays;
import java.util.HashMap;

class TwoSumFunc{
    public int[] twosumFunc(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int need=target-arr[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
}
public class Twosum {
    public static void main(String[] args) {
        TwoSumFunc twofunc=new TwoSumFunc();
        int[] arr={1,2,3,4,5};
        int target=3;
        int[] res=twofunc.twosumFunc(arr,target);
        System.out.println(Arrays.toString(res));
    }
}
