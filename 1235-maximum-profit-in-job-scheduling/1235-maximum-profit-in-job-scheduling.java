class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(job -> job.endTime));
        
        int n = startTime.length;
        int[] dp = new int[n+1];
        
        for (int i = 0; i< n; i++) {
            int et = jobs.get(i).endTime;
            int st = jobs.get(i).startTime;
            int pf = jobs.get(i).profit;
            
            int idx = upperBound(jobs, i, st);
            dp[i+1] = Math.max(dp[i], dp[idx] + pf);
        }
        
        return dp[n];
    }
    
    private int upperBound(List<Job> jobs, int endIdx, int targetTime) {
        int low = 0;
        int high = endIdx;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (jobs.get(mid).endTime > targetTime) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}

class Job {
    int startTime;
    int endTime;
    int profit;
    
    public Job(int st, int et, int pf) {
        this.startTime = st;
        this.endTime = et;
        this.profit = pf;
    }
}