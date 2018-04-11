package problem690;

/*
//Employee info
class Employee {
 // It's the unique id of each node;
 // unique id of this employee
 public int id;
 // the importance value of this employee
 public int importance;
 // the id of direct subordinates
 public List<Integer> subordinates;
};
*/
class Solution {
 Map<Integer, Employee> empMap;

 public int getImportance(List<Employee> employees, int id) {
     
     empMap = new HashMap();
     
     for (Employee emp : employees) {
         empMap.put(emp.id, emp);
     }
     
     return bfs(id);                        
 }
 
 int bfs(int id)
 {
     Queue<Employee> q = new LinkedList();
     
     q.add(empMap.get(id));
     
     int tot = 0;
     while(!q.isEmpty())
     {
         Employee emp = q.poll();
         
         tot += emp.importance;
         
         for (Integer tmpId : emp.subordinates) {
             q.add(empMap.get(tmpId));
         }
     }
     return tot;
 }
}