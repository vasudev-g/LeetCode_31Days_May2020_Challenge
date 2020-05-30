/* There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible. */
			 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0)
            return true;
        List<Integer>[] graph = new ArrayList[numCourses];
        Set<Integer> gray = new HashSet<>();
        Set<Integer> black = new HashSet<>();
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i = 0; i < numCourses; i++) {
            if(dfs(graph, i, gray, black))
                return false;
        }
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, int vertex, Set<Integer> gray,
                       Set<Integer> black) {
        gray.add(vertex);
        for(int i = 0; i < graph[vertex].size(); i++) {
            int neighbour = graph[vertex].get(i);
            if(black.contains(neighbour))
                continue;
            if(gray.contains(neighbour))
                return true;
            if(dfs(graph, neighbour, gray, black))
                return true;
        }
        gray.remove(vertex);
        black.add(vertex);
        return false;
    }
}