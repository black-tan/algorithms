package sort;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
    private int[] unsorted;

    public QuickSort(){}

    public QuickSort(int size){
        this.unsorted = new int[size];
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i < this.unsorted.length; i++){
            tempList.add(i+1);
        }

        for(int i = 0; i < this.unsorted.length; i++){
            int index = new Random().nextInt(tempList.size());
            this.unsorted[i] = tempList.get(index);
            tempList.remove(index);
        }
    }

    public void sort(){
        if(this.unsorted==null || this.unsorted.length == 0)
            return;

        quickSort(0, this.unsorted.length-1);
    }

    public void quickSort(int low, int high){
        int i = low;
        int j = high;

        int pivot = this.unsorted[low+(high-low)/2];

        while(i <= j){

            while(this.unsorted[i] < pivot){
                i++;
            }

            while(this.unsorted[j] > pivot){
                j--;
            }

            if(i <= j){
                swap(i,j);
                i++;
                j--;
            }
        }

        if(low < j){
            quickSort(low, j);
        }

        if(i < high){
            quickSort(i, high);
        }
    }

    public void swap(int i, int j){
        int temp = this.unsorted[i];
        this.unsorted[i] = this.unsorted[j];
        this.unsorted[j] = temp;
    }

    public void print(){
        for(int i = 0; i < this.unsorted.length; i++){
            System.out.print(this.unsorted[i]+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // write your code here
        QuickSort quickSort = new QuickSort(10);
        System.out.println("정렬 전 >>>>>>>>>>>>>>>>>>>> ");
        quickSort.print();
        quickSort.sort();
        System.out.println("정렬 후 >>>>>>>>>>>>>>>>>>>> ");
        quickSort.print();
    }
}
