package dsatask2;
public class search_insert_position {
    public static void main(String[] args) {
        int []nums={1,2,3,4,5};
        int target=4;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
         int mid=(low+high)/2;
         if(nums[mid]==target){
             return mid;
         }
         else if(nums[mid]>target){
             high=mid-1;
         }
         else{
             low=mid+1;
         }
        }
        return low;
         
     }
    
}
