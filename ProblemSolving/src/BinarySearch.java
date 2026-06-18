import java.util.Arrays;
import java.util.Collections;

class BinarySearchFunc{
    public int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearchFunc bs=new BinarySearchFunc();
        int[] arr={5,8,9,1,2};
        Arrays.sort(arr);
       int index= bs.binarySearch(arr,2);
        System.out.println(index);

    }
}
