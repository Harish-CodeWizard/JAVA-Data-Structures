package DS.TUF_Sheet;

public class Sorting_Algos {

    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

     static void bubbleSort(int[] arr){
        int n=arr.length;
        int temp;
        for(int i=0;i<n-1;i++){
            boolean isAlreadySorted = true; // Flag to check if the array is already sorted
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isAlreadySorted = false; // A swap was made, so the array might not be sorted
                }

            }
            // After each outer loop iteration, the largest element is bubbled to the end
            System.out.println("runs " + (i + 1) + " times");
            if (isAlreadySorted) {
                break; // If no swaps were made, the array is sorted
            }
        }
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j = i - 1;
            while(j>= 0 && arr[j] > key){
                int temp= arr[j];
                arr[j]=key;
                arr[j+1]=temp;
                j--;
            }
        }
    }   
    void merge()

    static void mergeSort(int[] arr, int low, int high) {
        int mid= (low + high) / 2;
        if(low<=high){
            mergeSort(arr, low, mid); // Sort first half
            mergeSort(arr, mid + 1, high); // Sort second half
            merge(arr, low, mid, high); // Merge the sorted halves
        }

        }

    public static void main(String[] args) {
        // int[] selectionSortarr = {64, 34, 25, 12, 22, 11, 90};
        // selectionSort(selectionSortarr);
        // System.out.println("Sorted array");
        // for (int i : selectionSortarr) {
        //     System.out.print(i + " ");
        // }

        // int[] sorted = {1, 2, 3, 4, 5}; // time complexity O(1) as the array is already sorted
        // bubbleSort(sorted);
        // System.out.println("Sorted array: ");
        // for (int num : sorted) {
        //     System.out.print(num + " ");
        // }

        // int[] insertionSortarr = {64, 34, 25, 12, 22, 11, 90};
        // insertionSort(insertionSortarr);
        // System.out.println("Sorted array: ");
        // for (int num : insertionSortarr) {
        //     System.out.print(num + " ");
        // }


        int[] mergeSortarr = {12, 11, 13, 5, 6, 7};
        mergeSort(mergeSortarr, 0, mergeSortarr.length - 1);
        System.out.println("Sorted array: ");
        for (int num : mergeSortarr) {
            System.out.print(num + " ");
        }   
    }

}
