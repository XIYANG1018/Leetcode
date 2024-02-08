class Solution1 {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        int minPenalty = Integer.MAX_VALUE;
        int closeHour = 0;

        for (int i=0; i<=customers.length(); i++) {
            for (int j=0; j<customers.length(); j++) {
                if ((j >= i) && (customers.charAt(j) == 'Y')) {
                    penalty += 1;
                } 
                if ((j < i) && (customers.charAt(j) == 'N')) {
                    penalty += 1;
                }
            }
            if (minPenalty > penalty) {
                minPenalty = penalty;
                closeHour = i;
            }
            penalty = 0;

        }
        return closeHour;
    }
}



