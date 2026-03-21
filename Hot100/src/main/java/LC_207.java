import java.util.*;

public class LC_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        // 存边[[2,3]]：0->2, 0->3 （因为i=0）
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<>();
        }
        // 记录入度
        int[] du = new int[numCourses];
        for (int[] course: prerequisites){
            // 记录边
            edges[course[1]].add(course[0]);
            // 入度+1
            du[course[0]]++;
        }
        // 将入度为0的课程加入队列
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0;i < du.length; i++){
            if (du[i] == 0){
               dq.offer(i);
            }
        }
        int course = 0;
        while (!dq.isEmpty()){
            int num = dq.poll();
            course++;
            List<Integer> nextCourses = edges[num];
            for (int next: nextCourses){
                du[next]-=1;
                if (du[next] == 0){
                dq.offer(next);
            }
            }
        }
        return course == numCourses;
    }
}
