package DS.Algorithms;

import java.util.PriorityQueue;

public class pendulumStore {
    int[] arr = {64, 34, 25, 12, 22, 11, 90};
    int n = arr.length;
    PriorityQueue<Integer> pq= new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
        pq.offer(arr[i]);
    }
    int[] sortedArr = new int[n];
    int left = 0, right = n - 1;
    while(left < right) {
        if (left == right) {
            sortedArr[left] = pq.poll();
            break;
        }
        sortedArr[left++] = pq.poll();
        sortedArr[right--] = pq.poll();
    }
    for (int num : sortedArr) {
        System.out.print(num + " ");
    }

}
