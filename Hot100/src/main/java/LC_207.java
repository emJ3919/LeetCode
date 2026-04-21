import java.util.*;

/**
 * 题目：课程表
 * 思路：拓扑排序。
 * 将课程关系构建成有向图，edges记录每个课程的后续课程，du记录每个课程的入度。
 * 将入度为0的课程加入队列，这些课程没有前置要求可以先学。
 * 取出队首课程学习，将其后续课程的入度减一，若入度变为0则加入队列。
 * 循环直到队列为空，最后判断学习的课程数是否等于总课程数。
 * 若等于说明可以完成全部课程（有向图无环），否则不能（有环）。
 * 时间复杂度：O(V+E)，空间复杂度：O(V+E)。
 */
public class LC_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        // 存边[[2,3]]：0->2, 0->3 （因为i=0）,edges[i]表示课程i的后续课程
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<>();
        }
        // 记录入度，du[i]表示课程i的入度
        int[] du = new int[numCourses];
        for (int[] course: prerequisites){
            // course[1]->course[0]
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
        // 记录已学习的课程数
        int course = 0;
        while (!dq.isEmpty()){
            int num = dq.poll();
            course++;
            // 当前学习课程的所有后续课程
            List<Integer> nextCourses = edges[num];
            for (int next: nextCourses){
                // 后续课程入入度-1，如果入度为0，加入队列
                du[next]-=1;
                if (du[next] == 0){
                dq.offer(next);
            }
            }
        }
        return course == numCourses;
    }
}
