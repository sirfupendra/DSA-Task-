package dsatask2;
//  Container with most water
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;

            maxArea = Math.max(maxArea, currentArea);

            // Move the pointers based on the height of the walls
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = s.maxArea(height);
        System.out.println("Maximum Area: " + result);
    }
}

// maxi mum product
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap max and min when the current element is negative
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Compute the new maximum and minimum product
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            // Update the result with the maximum product found so far
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}

// subarray sum
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count=0;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum-k))
            {
                 count+= map.get(sum-k);
            }
            if(map.containsKey(sum))
            {
                map.put(sum,map.get(sum)+1);
            }
            else
            {
                map.put(sum,1);
            }
        }
        return count;
    }
}

// counting numberof nice arrays
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int prefSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefSum += (nums[i] % 2 == 1) ? 1 : 0;
            ans += freq.getOrDefault(prefSum - k, 0);
            freq.put(prefSum, freq.getOrDefault(prefSum, 0) + 1);
        }
        return ans;
    }
}