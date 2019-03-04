

public class Solution {

    // Complete the equal function below.
    static int equal(int[] arr) {

        int tmp[] = new int[arr.length];
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        pq.add(routine(arr,tmp, 0));
        pq.add(routine(arr,tmp, 1));
        pq.add(routine(arr,tmp, 2));
        pq.add(routine(arr,tmp, 5));

        return pq.poll();

        


    }

    public static int routine(int arr[], int tmp[],   int offset ) {
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i];
        }
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }


        min -= offset;
        tmp[minIdx] -= offset;
        int moves = 0;
        if (offset != 0)
            moves++;
        
        for (int i = 0; i < arr.length; i++) {
            if (tmp[i] > min) {
                moves += Solution.divReminderBy(tmp, i, min, 5);
                moves += Solution.divReminderBy(tmp, i, min, 2);
                moves += Solution.divReminderBy(tmp, i, min, 1);
            }
        }

        return moves;
    }

    public static int divReminderBy(int arr[], int i, int min, int div) {
        int moves = 0;
        if (arr[i] > min) {
              int rem = (arr[i] - min) % div;
              moves += (arr[i] - min - rem)/div;
              arr[i] = min + rem;
        }
        return moves;
    }

