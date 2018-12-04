package Sort;

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

    //归并排序

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
        mergeSort(array,0, array.length - 1);

        printArray(array);
    }
}
