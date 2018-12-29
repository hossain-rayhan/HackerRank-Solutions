import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        long counter = doMergeSort(arr);
        return counter;
    }

    public static long doMergeSort(int[] arr){
        int length = arr.length;
        if(length < 2)
            return 0;
        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length-mid];

        for(int i = 0; i < left.length; i++){
            left[i] = arr[i];
        }

        for(int j = 0; j < right.length; j++){
            right[j] = arr[mid + j];
        }

        long lCounter = doMergeSort(left);
        long rCounter = doMergeSort(right);
        long swap = merge(arr, left, right);
        return lCounter + rCounter + swap;
    }
    public static long merge(int[] arr, int[] left, int[] right){
        int l = left.length, r = right.length, i = 0, j = 0, n = 0;
        long counter = 0;
        while(i < l && j < r){
            if(left[i] <= right[j]){
                arr[n++] = left[i++];
            }else{
                arr[n++] = right[j++];
                counter += l - i;
            }
        }
        while(i < l){
            arr[n++] = left[i++];
        }
        while(j < r){
            arr[n++] = right[j++];
        }
        return counter;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

