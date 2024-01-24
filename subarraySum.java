import java.util.ArrayList;
import java.util.List;

// Solution 1

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        List<Integer> sumList = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == k) {
                result += 1;
            }

            if (sumList.isEmpty()) {
                sumList.add(nums[i]);
            } else {
                for (int j=0; j < sumList.size(); j++) {
                    sumList.set(j, sumList.get(j) + nums[i]);
                    if (sumList.get(j) == k) {
                        result += 1;
                }
            }

            sumList.add(nums[i]);
            
            }
            
        }

        return result;
    }
}


// Leetcode 560
// O(n^2)

// Time exceeded

// Solution 2: O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> arr_sums = new HashMap();
        arr_sums.put(0, 1);

        int result = 0;
        int sum = 0;

        for (int i=0; i<nums.length; i++) {
           sum += nums[i];

           if (arr_sums.containsKey(sum-k)) {
               result += arr_sums.get(sum-k);
           }
           arr_sums.put(sum, arr_sums.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}