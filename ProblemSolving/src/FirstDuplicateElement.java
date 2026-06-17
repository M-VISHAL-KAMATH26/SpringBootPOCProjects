import java.util.HashSet;

//2. Find the Duplicate
//
//Given an array of integers, find the first duplicate element.
//
//        Input: [1, 3, 4, 2, 2] → Output: 2
class FirstDuplicate{
    public int findFirstDuplicate(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        for(int n:arr){
            if(!set.add(n)){
                return n;
            }
        }
        return -1;
    }
}
public class FirstDuplicateElement {
    public static void main(String[] args) {
        FirstDuplicate obj=new FirstDuplicate();
        int[] arr={1,2,3,4,4,5,5};
        System.out.println(obj.findFirstDuplicate(arr));
    }
}
