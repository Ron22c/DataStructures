package searchandsort;

public class Search {
    public int linearSearch(int[]arr, int value) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==value) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int value) {
        int left=0;
        int right=arr.length-1;
        while(right>=left) {
            int mid = (right+left)/2;
            if(arr[mid]==value) {
                return mid;
            } else if(arr[mid] < value) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return -1;
    }

    public int stringSearch(String one, String two) {
        int count=0;
        for(int i=0; i<one.length(); i++) {
            for(int j=0; j<two.length(); j++) {
                if(one.charAt(i+j)!=two.charAt(j)){
                    break;
                }
                if(j==two.length()-1){
                    count+=1;
                }
            }
        }
        return count;
    }
}
