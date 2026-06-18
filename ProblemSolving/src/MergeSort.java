import java.util.Arrays;

class MergeSortFunc{
    public void mergeSort(int[] arr,int left,int  right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    public void merge(int[] arr,int left,int mid,int right){
        int n1=mid+1-left;
        int n2=right-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++) L[i]=arr[left+i];
        for(int j=0;j<n2;j++) R[j]=arr[mid+1+j];
        int i=0,j=0;
        int k=left;
        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1) arr[k++]=L[i++];
        while(j<n2) arr[k++]=R[j++];
    }
}


public class MergeSort {
    public static void main(String[] args) {
        MergeSortFunc mergeSortFunc=new MergeSortFunc();
        int[] arr={3,4,5,1,2};
       mergeSortFunc.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
