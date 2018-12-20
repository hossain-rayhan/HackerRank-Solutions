import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        boolean intoValley = false;
        int valleyCounter = 0;
        int counter  = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'U')
                counter++;
            else if(s.charAt(i) == 'D')
                counter--;
            
            if(intoValley == false && counter == -1){
                intoValley = true;
            }else if(intoValley == true && counter==0){
                intoValley = false;
                valleyCounter += 1;
            }
        }
        return valleyCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

