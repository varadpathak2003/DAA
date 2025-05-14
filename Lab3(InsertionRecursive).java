class Main {
    public static void main(String[] args) {
       int nums[]={5,3,6,4,2,1};
        insertion(nums,0);
       for (int a : nums)System.out.print(a+" ");
    }
    public static void insertion(int []nums,int start){
        int n=nums.length;
        if (start==n-1) return ;
        int next=start+1;
        while (next> 0 && nums[next]<nums[next-1]){
            swap(nums,next,next-1);
            next--;
        }
        insertion(nums,start+1);
    }
    public static void swap(int nums[],int i ,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
