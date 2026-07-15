
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



        int aa[]=new int[]{10,20};
        int bb[]=new int[2];bb[0]=10;bb[1]=20;
        int cc[]=new int[]{10,20};

        System.out.println(aa==bb);
        System.out.println(aa==cc);
        System.out.println(cc==bb);

    }
}
