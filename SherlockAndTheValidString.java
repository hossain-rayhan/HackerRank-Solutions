import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] frequency = new int[26];
        for(int i = 0; i < s.length(); i++){
            frequency[s.charAt(i) - 'a']++;
        }
        int max = 0;
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i] > max)
                max = frequency[i];
        }
        int maxCounter = 0, oneCounter = 0, otherCounter = 0;
        if(max == 1){
            return "YES";
        }else{
            for(int i = 0; i < frequency.length; i++){
                if(frequency[i] == max){
                    maxCounter++;
                }else if(frequency[i] == 1){
                    oneCounter++;
                }else if(frequency[i] != 0){
                    otherCounter++;
                    if(max - frequency[i] >= 2 )
                        return "NO";
                }
                if(maxCounter >= 2 && otherCounter >= 1){
                    return "NO";
                }else if(maxCounter >= 1 && oneCounter >= 2){
                    return "NO";
                }else if(maxCounter > 0 && oneCounter > 0 && otherCounter >0){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

