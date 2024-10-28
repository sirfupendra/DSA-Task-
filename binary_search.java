package dsatask2;
public class binary_search {
    public static void main(String[] args) {
        int[]nums={1,2,3,4,5};
        int target=4;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                return i;
            }
        }
        return -1;
        
    }

    
} 