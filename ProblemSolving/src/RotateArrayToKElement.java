//Rotate Array Rotate an array to the right by k steps. Input: [1,2,3,4,5], k=2 → Output: [4,5,1,2,3]

import java.util.Arrays;

class Reverse{
    public void reversal(int[] arr ,int left,int right){
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public void mainReverse(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        reversal(arr,0,n-1);
        reversal(arr,0,k-1);
        reversal(arr,k,n-1);
    }
}
public class RotateArrayToKElement {
    public static void main(String[] args) {
        Reverse r=new Reverse();
        int[] arr={1,2,3,4,5};
        r.mainReverse(arr,2);
        System.out.println(Arrays.toString(arr));



    }
}
