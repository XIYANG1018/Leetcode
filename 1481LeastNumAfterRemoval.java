class Solution1 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // min heap
        // hash map 

        Map<Integer, Integer> map = new HashMap<>();

        int i;
        int ans=0;

        // create the map
        for (i=0; i<arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                ans++;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        
        // create a min heap to track the frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());


        for (i=k; i>0; i--) {
            int frequency = pq.peek();
            if (frequency == 1) {
                pq.poll();
                ans--;
            } else {
                while(frequency>0 && i>0) {
                    i--;
                    frequency--;
                }

                if (frequency<= 0) {
                    pq.poll();
                    ans--;
                }
                i++;
            }
        }

        return ans;
    }
}

class Solution2 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // min heap
        // hash map 

        Map<Integer, Integer> map = new HashMap<>();

        int i;
        int ans=0;

        // create the map
        for (i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        
        // create a min heap to track the frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());

        while (!pq.isEmpty()) {
            ans += pq.peek();

            if (ans>k) {
                return pq.size();
            }

            pq.poll();
        }

        return 0;
    }
}