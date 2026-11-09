class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) 
    {

        TreeSet<Integer> set = new TreeSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        int[] count = new int[k];

        for (int i = 0; i < k; i++) set.add(i);

        for (int i = 0; i < arrival.length; i++) 
        {

            while (!pq.isEmpty() && pq.peek()[0] <= arrival[i])
                set.add(pq.poll()[1]);

            if (set.isEmpty()) continue;

            int s = i % k;
            Integer x = set.ceiling(s);

            if (x == null) x = set.first();

            set.remove(x);
            count[x]++;
            pq.offer(new int[]{arrival[i] + load[i], x});
        }

        int max = Arrays.stream(count).max().getAsInt();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++)
            if (count[i] == max) ans.add(i);

        return ans;
    }
}