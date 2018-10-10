package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    private long[] unsorted;

    public BinarySearch(){
        this.unsorted = new long[8];
        this.unsorted[0] = 1;
        this.unsorted[1] = 2;
        this.unsorted[2] = 3;
        this.unsorted[3] = 5;
        this.unsorted[4] = 7;
        this.unsorted[5] = 9;
        this.unsorted[6] = 11;
        this.unsorted[7] = 15;
    }

    public BinarySearch(int size, long maxNum){
        this.unsorted = new long[size];
        ArrayList<Long> tempList = new ArrayList<Long>();

        for(long i = 0; i < maxNum; i++){
            //tempList.add(i+1);
            tempList.add(i+1);
        }

        for(int i = 0; i < this.unsorted.length; i++){
            int index = new Random().nextInt(tempList.size());
            this.unsorted[i] = tempList.get(index);
            tempList.remove(index);
        }

        Arrays.sort(this.unsorted);
    }

    public void search(long num){
        if(this.unsorted==null || this.unsorted.length == 0)
            return;

        binarySearch(0,this.unsorted.length-1, num);
    }

    public void binarySearch(int start, int end, long num){

        if(end < start)
            return;

        int mid = start+((end-start)/2);

        if(this.unsorted[mid]==num){
            //return mid;
            System.out.println(">>>>>>> searchNum : "+num);
            System.out.println(">>>>>>> this.unsorted["+mid+"] : "+this.unsorted[mid]);
        }

        if(this.unsorted[mid] > num){
            binarySearch(start,mid-1,num);
        }

        if(this.unsorted[mid] < num){
            binarySearch(mid+1, end, num);
        }
    }

    public void print(){
        for(int i = 0; i < this.unsorted.length; i++){
            System.out.print(this.unsorted[i]+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        //BinarySearch bs = new BinarySearch(8, 1000);
        BinarySearch bs = new BinarySearch();
        bs.print();
        bs.search(5);
    }
}
