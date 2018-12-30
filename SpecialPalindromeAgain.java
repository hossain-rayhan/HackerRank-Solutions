import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static class P{
        char c;
        long count;
        public P(char c, long count){
            this.c = c;
            this.count = count;
        }
    }
    public static long getTotalSubstr(long n){
            return n*(n+1) / 2;
    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        List<P> list = new ArrayList<>();
        long counter = 1;
        char ch = s.charAt(0);
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == ch){
                counter++;
            }else{
                list.add(new P(ch, counter));
                ch = s.charAt(i);
                counter = 1;
            }
        }
        list.add(new P(ch, counter));
        

        long totalPalindrome = getTotalSubstr(list.get(0).count);
        int size = list.size();
        for(int i = 1; i < size; i++){
            totalPalindrome += getTotalSubstr(list.get(i).count);
            if(i == size-1){
                break;
            }
            if(list.get(i).count == 1){
                P previous = list.get(i-1);
                P next = list.get(i+1);
                if(previous.c == next.c){
                    totalPalindrome += Math.min(previous.count, next.count);
                }
            }
        }
        return totalPalindrome;
    }

    static boolean isPalindrome(String s){
        int l = s.length();
        char[] a = s.toCharArray();
        if(l == 1){
            return true;
        }else if(l % 2 == 0){
            for(int i = 0; i < l; i++){
                if(a[i] != a[0]){
                    return false;
                }
            }
            return true;
        }else{
            int mid = l/2;
            for(int i = 0; i < l; i++){
                if(i == mid)
                    continue;
                if(a[i] != a[0]){
                    return false;
                }
            }
            return true;
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

