import java.util.*;
class Main {
    static int swaps=0;
   static int compare=0;
    public static void main(String[] args) {
        int nums[]={6,5,2,3,1};
    
        quickSort(nums,0,nums.length-1);
        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("Total Comparisons: " + compare);
        System.out.println("Total Swaps: " + swaps);
    }
    static void quickSort(int []arr,int start,int end){
        if (start>=end) return ;
        int pi=partition(arr,start,end);
        quickSort(arr,start,pi);
        quickSort(arr,pi+1,end);
    }
    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
    
        while (true) {
            while (arr[start] < pivot){
                start++;
                compare++;
            } 
            while (arr[end] > pivot){
               end--;
               compare++;
            } 
    
            if (start >= end) return end;
            swaps++;
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
