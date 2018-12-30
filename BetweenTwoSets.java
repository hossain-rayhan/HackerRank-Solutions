import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        int lcmA = lcm(a);
        int gcdB = gcd(b);

        int result = 0;
        int p = 1, lcmOfA = lcmA;
        while(gcdB / lcmOfA > 0){
            if(gcdB % lcmOfA == 0){
                result++;
            }
            p++;
            lcmOfA = lcmA * p;
        }
        return result;
    }
    public static int gcd(int a, int b){
        while(b > 0){
            int modulus = a % b;
            a = b;
            b = modulus;
        }
        return a;
    }
    public static int gcd(int[] input){
        int result = input[0];
        for(int i = 1; i < input.length; i++){
            result = gcd(result, input[i]);
        }
        return result;
    }

    public static int lcm(int a, int b){
        return (a*b) / gcd(a,b);
    }

    public static int lcm(int[] input){
        int result = input[0];
        for(int i = 1; i < input.length; i++){
            result = lcm(result, input[i]);
        }
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}

