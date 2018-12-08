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
        bubbleSort(array);
        printArray(array);
    }
}
