//LeetCode problem No.4 : Median of two sorted arrays
class MedianTwoArrays {
    //Beats 100% in runtime, 45% in runtime.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Always want the smaller array to be the first one
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        // Perform binary search on the smaller array (nums1)
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            // Handle edge cases with out-of-bound accesses
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if partition is correct
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // We found the correct partition
                if ((m + n) % 2 == 0) {
                    // Even length, median is the average of the two middle elements
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // Odd length, median is the max of the left partition
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move partition1 to the left
                right = partition1 - 1;
            } else {
                // Move partition1 to the right
                left = partition1 + 1;
            }
        }

        // If we reach here, something went wrong
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}