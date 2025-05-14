import java.util.*;
class Main {
    public static void main(String[] args) {
       int nums[]={5,3,6,4,2,1};
        nums=mergeSort(nums);
       for (int a : nums)System.out.print(a+" ");
    }
    public static int[] mergeSort(int nums[]){
        if (nums.length==1) return nums;
        int start=0;
        int end=nums.length-1;
        int mid=start+(end-start)/2;
        int left[]=mergeSort(Arrays.copyOfRange(nums,start,mid+1));
        int right[]=mergeSort(Arrays.copyOfRange(nums,mid+1,end+1));
        return merge(left,right);
    }
    public static int[] merge(int []left,int right[]){
        int m=left.length;
        int n=right.length;
        int i=0;
        int j=0;
        int k=0;
        int res[]=new int[m+n];
        while (i<m && j<n){
            if (left[i]<right[j]){
                res[k++]=left[i++];
            }
            else res[k++]=right[j++];
        }
        while (i< m) res[k++]=left[i++];
        while (j<n) res[k++]=right[j++];
        return res;
    }
}
