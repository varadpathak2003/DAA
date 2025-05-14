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
        selectionR(Arrays.copyOf(nums,n), 0, 0, 0);
        long endTime = System.nanoTime();
        time.add(endTime - startTime);
       
       //2
       startTime = System.nanoTime();
       selectionI(Arrays.copyOf(nums,n));
       endTime = System.nanoTime();
       time.add(endTime - startTime);
       
       //tabular output
       System.out.println("\nSwaps\tComparisons\tExecution time");
       for (int i=0;i<swap.size();i++){
           System.out.println(swap.get(i)+"      \t  "+comparisons.get(i)+"      \t"+time.get(i));
       }
       
    }
    public static void selectionR(int []nums,int start,int compare,int swaps){
        int n=nums.length;
        if (start==n-1){
            swap.add(swaps);
            comparisons.add(compare);
            System.out.println("Selection Using Recursion\n");
            for (int a : nums) System.out.print(a+" ");
            return ;
        }
        int minIndex=start;
        for (int j=start+1;j<n;j++){
            compare++;
            if (nums[j]<nums[minIndex]){
                minIndex=j;
            }
        }
        swaps++;
        swap(nums,start,minIndex);
        selectionR(nums,start+1,compare,swaps);
    }
    public static void selectionI(int []nums){
        int compare=0;
        int swaps=0;
        int n=nums.length;
        for (int i=0;i<n-1;i++){
            int minIndex=i;
            for (int j=i+1;j<n;j++){
                compare++;
                if (nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            swaps++;
           swap(nums,i,minIndex);
        }
        System.out.println("\nSelection Using Iteration\n");
        for (int a : nums) System.out.print(a+" ");
        comparisons.add(compare);
        swap.add(swaps);
    }
    public static void swap(int nums[],int i ,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
