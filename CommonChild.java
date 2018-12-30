import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        return lcs(s1.toCharArray(), s2.toCharArray());

    }

public static int lcs(char[] a, char[] b){
        int[][] matrix = new int[a.length + 1][b.length + 1];

        for(int i = 1; i <= a.length; i++){
            for(int j = 1; j <= b.length; j++){
                //if both of the chars are same, diagonal plus one
                if(a[i-1] == b[j-1]){
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                }else{
                    // if the chars do not match, max of(left, top)
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }
        return matrix[a.length][b.length];
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

