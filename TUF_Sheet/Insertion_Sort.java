package DS.TUF_Sheet;

public class Insertion_Sort {

    static int binarySearch(int[] arr, int low, int high, int target) {
        int mid=low+(high-low)/2;
        System.out.println(low + " " + high + " " + mid);
        if(arr[mid]==target) return mid;
        if(low>=high) return -1;
        else if(arr[mid]<target) return binarySearch(arr, mid+1, high, target);
        else return binarySearch(arr, low, mid-1, target);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 1;
        int a=binarySearch(arr,0,5,3);
        System.out.println("Element found at index: " + a);
    }
    
}
