class PlayWithArrayPointers{
    public  void printArray(int[] arr){
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println(" ");
    }

    public void changeArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=777;
        }
    }  
}
public class Day2 {
    public static void main(String[] args) {
        PlayWithArrayPointers ply=new PlayWithArrayPointers();
        int[] numbers=new int[]{10,20,30,40,50};
        ply.printArray(numbers);
        ply.changeArray(numbers);
        ply.printArray(numbers);
    }
}
