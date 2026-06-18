import java.util.Arrays;
import java.util.HashSet;

class RemoveDuplicatesFunc{
    public int[] removeDuplicates(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        for(int n:arr){
            set.add(n);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] removeDuplicatesTwoPointer(int[] arr){
        int i=0;
        Arrays.sort(arr);
        int n=arr.length;
        for(int j=1;j<n;j++){
            if(arr[j]!=arr[i]){
                i++;
                arr[i]=arr[j];
            }
        }
        return  Arrays.copyOfRange(arr,0,i+1);
    }
}

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        RemoveDuplicatesFunc rd=new RemoveDuplicatesFunc();
        int[] arr={1,2,3,3,3,4,3,4,5,6,5};
       int[] res= rd.removeDuplicates(arr);
       int[] res2=rd.removeDuplicatesTwoPointer(arr);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));

    }
}
