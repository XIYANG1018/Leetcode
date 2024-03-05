// Step 1
class Solution1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        // identify the smallest number
        while (left < right) {
            int mid = (left+right)/2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = left;
        left = 0;
        right = nums.length-1;
        
        // locate which part the target in
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        // find the target using binary search
        while (left <= right) {
            int mid = (left+right)/2;
            if (target == nums[mid]){
                return mid;
            } 
            if (target < nums[mid]) {
                right = mid-1;
            } else {
                left = mid +1;
            }
        }

        return -1;
    }
}


class Solution2 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left+right)/2;

            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[left]){
                    right = mid -1;
                } else {
                    left = mid +1;
                }
            } else {
               if (target > nums[mid] && target <= nums[right]) {
                   left = mid + 1;
               } else {
                   right = mid -1;
               }

            }
        }


        return -1;
    }
}