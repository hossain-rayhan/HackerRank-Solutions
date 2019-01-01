import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int length = s.length();
        int n = (length*(length+1))/2;
        int[][] count = new int[n][26];
        int subStringCounter = 0;
        int matchCounter = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j <= i; j++){
                String subString = s.substring(j, i+1);
                for(int k = 0; k < subString.length(); k++){
                    count[subStringCounter][subString.charAt(k) - 'a']++;
                }

                if(subStringCounter > 0){
                    for(int m = 0; m < subStringCounter; m++){
                        boolean matchFound = true;
                        for(int p = 0; p < 26; p++){
                            if(count[m][p] != count[subStringCounter][p]){
                                matchFound = false;
                                break;
                            }
                        }
                        if(matchFound){
                            matchCounter++;
                        }
                    }
                }
                subStringCounter++;
            }
        }
        return matchCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

