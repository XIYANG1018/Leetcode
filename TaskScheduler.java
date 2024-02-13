class Solution1 {
    public int leastInterval(char[] tasks, int n) {
        /*
        A A A B B C   n = 2

        A - - A - - A 
        A B C A B - A

        (maxFrequency -1)*(n+1) + remains 


        A A A B B B  n=0
        A B A B A B


        A A A B B   n=0
        A B A B A 

         */

        int[] frequency = new int[26];
        int size = tasks.length;
        int max = Integer.MIN_VALUE;
        int remains = 0;

        for (int i=0; i<size; i++) {
            frequency[tasks[i]-'A']++;
            if (frequency[tasks[i]- 'A'] > max) {
                max = frequency[tasks[i]- 'A'];
            }
        }

        for (int i=0; i<26; i++) {
            if (frequency[i] == max) {
                remains += max - (max-1);
            }
        }

        return Math.max((max-1)*(n+1) + remains, size);
        /*
         * A A A B C D E F G    n=1
         * A B A C A D E F G    
         * In this case, the max frequency case cannot include other characters
         * So we compare the max condition and the size case 
         */

    }
}

class Solution2 {
    public int leastInterval(char[] tasks, int n) {

        if(tasks.length<=0)
            return 0;

        if(n==0)
            return tasks.length;

          //find max task (heighest freq task )
          // find no of max task (how many heighest freq)
          //(max task -1){cool down} * (n+1) +(no of max task)
        
        int freq[]= new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }

        int max=0;
        for(int f:freq){
            max=Math.max(f,max);
        }
        int noOfMax=0;
         for(int f:freq){
            if(f==max)
                noOfMax++;
        }
        int res=(max-1)*(n+1)+noOfMax;
        return Math.max(res,tasks.length);
    }
}



