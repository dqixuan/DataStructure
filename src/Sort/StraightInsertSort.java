package Sort;

import java.util.concurrent.ThreadPoolExecutor;

public class StraightInsertSort {
    //直接插入排序
    public static void insertSort(int[] array){
        if( array.length == 0 || array.length == 1)
            return;
        for(int i = 1; i < array.length; ++i){
            int k = array[i];
            int j = i;
            for(; j > 0 && k < array[j - 1]; j--)
                array[j] = array[j - 1];
            array[j] = k;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array){
        if(array.length == 0 || array.length == 1)
            return;
        for(int i = 0; i < array.length - 1; ++i){
            for(int j = 0; j < array.length - i - 1; ++j){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array, int left, int right){
        if(left >= right)
            return;
        int index = oneQuickSort(array,left, right);
        quickSort(array, left, index - 1);
        quickSort(array, index + 1, right);
    }
    public static int oneQuickSort(int[] array, int left, int right){
        int i = left, j = right;
        int key = array[right];
        while( i < j){
            while( i < j && array[i] <= key)
                i++;
            array[j] = array[i];
            while( i < j && array[j] >= key)
                j--;
            array[i] = array[j];
        }
        array[i] = key;
        return i;
    }


    //归并排序
    public static void merge(int[] array, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right + 1 - left];
        int k = 0;
        while( i <= mid && j <= right){
            if(array[i] >= array[j])
                temp[k++] = array[j++];
            else
                temp[k++] = array[i++];
        }
        while(i <= mid)
            temp[k++] = array[i++];
        while(j <= right)
            temp[k++] = array[j++];
        for(k = 0; k < temp.length; ++k)
            array[k+left] = temp[k];
    }
    public static void mergeSort(int[] array, int left, int right){
        if(left < right){
            int mid = ( right + left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array,mid+ 1, right);
            merge(array,left,mid,right);
        }
    }

    //堆排序
    public static void heapSort(int[] array){
        int len = array.length;
        if(len == 0  || len == 1)
            return;
        //初始化堆
        for(int i = len /2; i >= 0; i--)
            headAdjust(array,i, len - 1);

        //堆排序
        for(int i = len - 1; i > 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            headAdjust(array,0, i);
        }
    }
    public static void headAdjust(int[] array, int parent, int length){
        int temp = array[parent];
        int child = parent * 2 + 1;
        while(child < length){
            if(child + 1 < length && array[child] < array[child + 1])
                child++;
            if(temp >= array[child])
                break;
            array[parent] = array[child];
            parent = child;
            child = 2 * child + 1;
        }
        array[parent] = temp;
    }

    //希尔排序
    public static void shellSort(int[] array){
        int len = array.length;
        for(int i = len/2; i > 0; i /= 2){
            for(int j = i; j < len; j ++){
                int key = array[j];
                int k = j;
                for(; k > i - 1 && key < array[k - i]; k -= i){
                    array[k] = array[k - i];
                }
                array[k] = key;
            }
        }
    }

    //打印数组
    public static void printArray(int [] array){
        if(array == null)
            return;
        for(int i = 0; i < array.length; ++i){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    //test
    public static void main(String[] args){
        int [] array = {2,1,40,3,4,0,10};
        //insertSort(array);
        //bubbleSort(array);
        //mergeSort(array,0, array.length - 1);
        //quickSort(array,0,array.length - 1);
        //shellSort(array);
        heapSort(array);

        printArray(array);
    }
}
