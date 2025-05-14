class Main{
    public static void main(String[] args) {
        int nums[]={5,3,6,4,2,1};
        selection (nums);
        for (int a : nums) System.out.print(a+" ");
    }
    public static void selection(int []nums){
        int n=nums.length;
        for (int i=0;i<n-1;i++){
            int minIndex=i;
            for (int j=i+1;j<n;j++){
                if (nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[minIndex];
            nums[minIndex]=temp;
        }
    }
}
