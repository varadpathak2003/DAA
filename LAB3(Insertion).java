import java.util.*;
class Main {
    static List <Integer> comparisons=new ArrayList<>();
    static List <Integer> swap=new ArrayList<>();
    static List <Long> time=new ArrayList<>();
    
    public static void main(String[] args) {
       int nums[]={5,3,6,4,2,1};
       int n=nums.length;
       //1
        long startTime = System.nanoTime();
        insertionR(Arrays.copyOf(nums,n), 1, 0, 0);
        long endTime = System.nanoTime();
        time.add(endTime - startTime);
       
       //2
       startTime = System.nanoTime();
       insertionI(Arrays.copyOf(nums,n));
       endTime = System.nanoTime();
       time.add(endTime - startTime);
       
       //tabular output
       System.out.println("\nSwaps\tComparisons\tExecution time");
       for (int i=0;i<swap.size();i++){
           System.out.println(swap.get(i)+"      \t  "+comparisons.get(i)+"      \t"+time.get(i));
       }
    }
    
    public static void insertionR(int []nums,int start,int compare,int swaps){
        int n=nums.length;
        if (start==n-1){
            comparisons.add(compare);
            swap.add(swaps);
            printResult(nums);
            return ;
        }
            
        int next=start+1;
        while (next> 0 && nums[next]<nums[next-1]){
            compare++;
            swaps++;
            swap(nums,next,next-1);
            next--;
        }
        insertionR(nums,start+1,compare,swaps);
    }

    public static void insertionI(int []nums){
        int compare=0;
        int swaps=0;
        int n=nums.length;
        for (int i=0;i<n-1;i++){
            int next=i+1;
            while (next>0 && nums[next]<nums[next-1]){
                compare++;
                swaps++;
                swap(nums,next,next-1);
                next--;
            }
        }
        printResult(nums);
        comparisons.add(compare);
        swap.add(swaps);
    }
        
    public static void swap(int nums[],int i ,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    public static void printResult(int []nums){
        System.out.println("\nInsertion Sort \n");
        for (int a : nums) System.out.print(a+" ");
    }
}
