import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int counter = 0;
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        for(int i = 0; i < x.length; i++){
            int index = -1;
            for(int j = 0; j < y.length; j++){
                if(y[j] == x[i]){
                    index = j;
                    break;
                }
            }
            if( index >= 0){
                counter++;
                y[index] = '#';
            }
        }
        return (a.length()+b.length())-(2*counter);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

