package dsatask2;
public class MedianOfArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeSortedArrays(nums1, nums2, 0, 0, 0, new int[nums1.length + nums2.length]);
        return findMedian(mergedArray);
    }

    private static int[] mergeSortedArrays(int[] nums1, int[] nums2, int i, int j, int k, int[] mergedArray) {
        if (i == nums1.length) {
            while (j < nums2.length) {
                mergedArray[k++] = nums2[j++];
            }
            return mergedArray;
        }
        if (j == nums2.length) {
            while (i < nums1.length) {
                mergedArray[k++] = nums1[i++];
            }
            return mergedArray;
        }
        if (nums1[i] <= nums2[j]) {
            mergedArray[k] = nums1[i];
            return mergeSortedArrays(nums1, nums2, i + 1, j, k + 1, mergedArray);
        } else {
            mergedArray[k] = nums2[j];
            return mergeSortedArrays(nums1, nums2, i, j + 1, k + 1, mergedArray);
        }
    }

    public static double findMedian(int[] array) {
        int n = array.length;
        if (n % 2 == 1) {
            return array[n / 2];
        } else {
            return (array[(n / 2) - 1] + array[n / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
        
    }
    
}
