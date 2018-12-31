import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int[] imporSorted = new int[contests.length];
        int importantCounter = 0;
        int sumImportant = 0, sumUnImportant = 0;

        for(int i = 0; i < contests.length; i++){
            int value = contests[i][0];
            if(contests[i][1] == 1){
                sumImportant += value;
                importantCounter++;

                int hole = importantCounter-1;
                while(hole > 0 && imporSorted[hole-1] < value){
                    imporSorted[hole] = imporSorted[hole-1];
                    hole--;
                }
                imporSorted[hole] = value;
            }else{
                sumUnImportant += value;
            }
            
        }

        int kSum = 0;
        for(int j = 0; j < k; j++){
            kSum += imporSorted[j];
        }

        return (sumUnImportant + kSum - (sumImportant-kSum));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

