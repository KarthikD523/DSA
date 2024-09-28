
class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];
            adj.get(from).add(to);
        }

        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i))
              indegree[it]++;
        }
    Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
              q.add(i);
        }
    ArrayList<Integer> topo=new ArrayList<>();

        while(!q.isEmpty()){
            int node=q.poll();
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                  q.add(it);
            }
        }

        if(topo.size()==numCourses)
         return true;
        return false;
    }
}