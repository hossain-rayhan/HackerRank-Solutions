import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0,2));
        String min_sec = s.substring(2,8);
        String result = "";
        if(s.endsWith("PM")){
            if(hour < 12){
                hour = hour + 12;
                result = hour + min_sec;
            }else{
                result = s.substring(0,8);
            }
        }else{
            if(hour == 12){
                result = "00" + min_sec;
            }else{
                result = s.substring(0,8);
            }
                
        }
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

