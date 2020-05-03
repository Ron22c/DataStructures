package searchandsort;
import java.util.Arrays;

public class Sort {
    public void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public int[] bubbleSort(int[] arr) {
        Boolean noSwap;
        for(int i=arr.length-1; i>=0; i--) {
            noSwap=true;
            for(int j=0; j<i; j++) {
                if(arr[j]>arr[j+1]) {
                    swap(arr, j, j+1);
                    noSwap=false;
                }
            }
            if(noSwap) {
                break;
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr) {
        int min;
        for(int i=0; i<arr.length; i++) {
            min=i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[min]>arr[j]) {
                    min=j;
                }
            }
            this.swap(arr, min, i);
        }
        return arr;
    }

    public int[] insersionSort(int[] arr) {
        int value;
        int j;
        for(int i=0; i<arr.length; i++) {
            value=arr[i];
            for(j=i-1; j>0 && value<arr[j]; j--) {
                arr[j+1]=arr[j];
            }
            arr[j+1]=value;
        }
        return arr;
    }

    public int[] marge_function(int[] arr1, int[] arr2) {
        int[] output = new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int arrCount=0;

        while(i<arr1.length && j<arr2.length) {
            if(arr1[i]<arr2[j]) {
                output[arrCount]=arr1[i];
                i++;
            } else {
                output[arrCount]=arr2[j];
                j++;
            }
            arrCount++;
        }

        while(i<arr1.length) {
            output[arrCount]=arr1[i];
            i++;
            arrCount++;
        }

        while(j<arr2.length) {
            output[arrCount]=arr2[j];
            j++;
            arrCount++;
        }
        return output;
    }

    public int[] merge_sort(int[] arr) {
        if(arr.length<=1) return arr;
        int mid = arr.length/2;
        int[] left= Arrays.copyOfRange(arr,0, mid);
        int[] right=Arrays.copyOfRange(arr, mid, arr.length);
        return marge_function(merge_sort(left),merge_sort(right));
    }

    public int pivot_helper(int[] arr, int start, int end) {
        int pivot = arr[start];
        int index = start;

        for (int i= start+1; i<=end; i++) {
            if(pivot>arr[i]) {
                index++;
                this.swap(arr, index, i);
            }
        }
        this.swap(arr, index, start);
        return index;
    }

    public int[] quick_sort(int[] arr, int start, int end) {
        if(end>start) {
            int pivot = this.pivot_helper(arr,start,end);
            this.quick_sort(arr, start, pivot-1);
            this.quick_sort(arr, pivot+1,end);
        }
        return arr;
    }

    public int getNumber(int number, int position) {
        return (int)(number/Math.pow(10,position))%10;
    }

    public int size(int number) {
        return (int) Math.log10(number)+1;
    }

    public int maxNumber(int[] arr) {
        int max =0;
        for(int i=0; i<arr.length; i++) {
            if(max<this.size(arr[i])) {
                max=this.size(arr[i]);
            }
        }
        return max;
    }

    public void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
