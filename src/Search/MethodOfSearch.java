package Search;

public class MethodOfSearch {
    public int binarySearch(int[] array, int key){
        int l = 0, r = array.length - 1;
        int mid = 0;
        while( l <= r){
            //防止加法导致的越界
            mid = l + (r - l) / 2;
            if(array[mid] == key)
                return mid;
            if(array[mid] > key)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
