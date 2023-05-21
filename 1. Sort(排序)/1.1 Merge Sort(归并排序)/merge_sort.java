
import java.util.Scanner;
import java.util.Arrays;

public class merge_sort{


    /**
     * @param arr
     * @return return a sorted int array
     */
    public static int[] MergeSort(int[] arr){

        //Base Case: When the lenght of arr is 1, return it
        if (arr.length ==1){
            return arr;
        } 

        //Recursive Case: 
        else{
            int start = 0;
            int end = arr.length;
            int mid = start + (end-start)/2;
            int[] left = new int[mid];
            int[] right = new int[end-mid];

            for (int i=0; i<left.length; i++){
                left[i] = arr[i];
            }
            for (int i=0; i<right.length; i++){
                right[i] = arr[mid+i];
            }
            return Merge(MergeSort(left), Mergesort(right));
        }
            
    } 

    public static int[] Merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int index =0;

        while (left.length >0 || right.length>0){
            int left_length = left.length;
            int right_length = right.length;

            if(left.length >0){
                int leftFirst = left[0];
            }else{
                result[index] = right[0];
                right = Arrays.copyOfRange(right, 1, right_length);
                index++;
                continue;
            }
            
            if(right.length >0){
                int rightFirst = right[0];
            }else{
                result[index] = left[0];
                left = Arrays.copyOfRange(left, 1, left_length);
                index++;
                continue;
            }
            System.out.println(rightFirst);
            if (rightFirst < leftFirst) {
                // First element in Right is smaller, add it to result
                result[index] = rightFirst;
            
                // Remove the popped element from the right array
                right = Arrays.copyOfRange(right, 1, right_length);
            } else {
                 // First element in Left is smaller or equal to right, add it to result
                 result[index] = leftFirst;

                 // Remove the popped element from the right array
                 left = Arrays.copyOfRange(left, 1, left_length);
            }
            index++;
        }
        return result;
    }



    public static void main(String[] args){
        int[] test = {10,2,7,4,5,11,7,8,23};
        System.out.println(MergeSort(test));
    }
}