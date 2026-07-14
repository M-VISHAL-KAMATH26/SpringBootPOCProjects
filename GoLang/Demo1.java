
import java.util.Arrays;

public class Demo1 {
    

    public static void main(String[] args) {
        
        int arr[]=new int[]{1,2,3,4};
        System.out.println(Arrays.toString(arr));

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        for(int i:arr){
            System.out.print(i );
        }
        System.out.println();
    }
}
