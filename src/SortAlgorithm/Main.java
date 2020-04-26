package SortAlgorithm;

public class Main {
    static int [] a={
            3,2,6,5,4,9
    };
    static float[] b={
            0.8f,0.9f,0.4f,0.2f,0.5f
    };
    private static Algorithm algorithm=new Algorithm();

    public static void main(String[] args) {
        //algorithm.bubbleSort(a);
        //algorithm.selectionSort(a);
        //algorithm.insertionSort(a);
        //algorithm.MergeSort(a,0,a.length-1);
        //algorithm.QuickSort(a,0,a.length-1);
        //algorithm.HeapSort(a);
        //algorithm.ShellSort(a);

//        BST bst=new BST();
//        bst.buildByArray(a);
//        bst.printSortResult(bst.getRoot());

        //algorithm.BucketSort(b);
        //algorithm.CountSort(a);
        //algorithm.RadixSort(a);
        algorithm.BitSort(a);

        //printall
        int len=a.length;
        for(int i=0;i<len;i++){
            System.out.print(a[i]+",");
        }
    }

}