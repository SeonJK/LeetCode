class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        // 리스트 공간 생성
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<>());
        }

        // 강의별 선수과목 리스트 추가
        for (int i = 0; i< n; i++) {
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // 강의가 선수과목으로 등록된 카운트
        int[] in = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int course : arr.get(i)) {
                in[course]++;
            }
        }

        // 선수과목으로 등록안된 강의들 먼저 추가
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0)
                q.add(i);
        }

        // q에 있는 강의의 선수과목을 탐색
        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int i : arr.get(node)) {
                in[i]--;
                if (in[i] == 0)
                    q.add(i);
            }
        }
        return result.size() == numCourses;
    }
}