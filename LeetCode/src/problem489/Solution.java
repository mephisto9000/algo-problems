package problem489;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    private static int UP_i = -1;
    private static int UP_j = 0;
    private static int DOWN_i = 1;
    private static int DOWN_j = 0;
    private static int LEFT_i = 0;
    private static int LEFT_j = -1;
    private static int RIGHT_i = 0;
    private static int RIGHT_j = 1;
    
    private static int UP = 0;
    private static int RIGHT = 1;
    private static int DOWN = 2;
    private static int LEFT = 3;
    
    Map<String, Integer> passMap; 
    int dir;
    Map<Integer, Integer> iMap;
    Map<Integer, Integer> jMap;
    
    
    Robot robot;
    public void cleanRoom(Robot robot) {
        passMap = new HashMap<>();
        dir = UP;
        this.robot = robot;
        iMap = new HashMap<>();
        jMap = new HashMap<>();
        
        iMap.put(UP, UP_i);
        iMap.put(LEFT, LEFT_i);
        iMap.put(RIGHT, RIGHT_i);
        iMap.put(DOWN, DOWN_i);
        
        jMap.put(UP, UP_j);
        jMap.put(LEFT, LEFT_j);
        jMap.put(RIGHT, RIGHT_j);
        jMap.put(DOWN, DOWN_j);
        
        rec(0,0);
        
    }
    
    
    void rec(int i, int j) {
        String key = i+"x"+j;
        
        int tmpRightDir = rightDir();
        int tmpBackDir = rightDir();
        int tmpLeftDir = rightDir();
        rightDir();
        int tmpDir;
        
        if (passMap.containsKey(key)) {
            //nothing
             while(dir != tmpBackDir) {
                rightDir();
                robot.turnRight();
            }
            robot.move();
            return;    
            
        }
        else //havent been here
        {
        //clean    
        robot.clean();
        
        passMap.put(key, 1);
            
        //forward
        if (robot.move()) {
            rec(i+iMap.get(dir), j+jMap.get(dir));
        }    
            
        //turn left
        while(dir != tmpLeftDir) {
            leftDir();
            robot.turnLeft();
        }
        
        if (robot.move())
            rec(i+iMap.get(dir), j+jMap.get(dir));
                        
        //turn right
        while(dir != tmpRightDir) {    
            rightDir();                    
            robot.turnRight();
        }
        if (robot.move())
            rec(i+iMap.get(dir), j+jMap.get(dir));
        }

        //go down
        if (i==0 && j== 0) {

            while(dir != tmpBackDir) {
                rightDir();
                robot.turnRight();
            }
            if (robot.move())
                rec(i+iMap.get(dir), j+jMap.get(dir));
        } else {
            //go back
            while (dir != tmpBackDir) {
                rightDir();
                robot.turnRight();
            }
            robot.move();
        }
        // done
    }
    
    int rightDir() {
        dir++; 
        if (dir == 4) 
            dir = 0;        
        return dir;
    }
    
    int leftDir() {
        dir--; 
        if (dir == -1) 
            dir = 3;        
        return dir;
    }
        
}