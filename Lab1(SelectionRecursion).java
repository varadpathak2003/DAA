class Main {
    public static void main(String[] args) {
       int nums[]={5,3,6,4,2,1};
       selection(nums,0);
       for (int a : nums) System.out.print(a+" ");
    }
    public static void selection(int []nums,int start){
        int n=nums.length;
        if (start==n-1)return ;
        int minIndex=start;
        for (int j=start+1;j<n;j++){
            if (nums[j]<nums[minIndex]){
                minIndex=j;
            }
        }
        int temp=nums[start];
        nums[start]=nums[minIndex];
        nums[minIndex]=temp;
        selection(nums,start+1);
    }
        
}
