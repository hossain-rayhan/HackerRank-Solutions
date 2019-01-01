import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int noticeCounter = 0;
        int[] count = new int[201];
        for(int i = 0; i < d; i++){
            count[expenditure[i]]++;
        }
        for(int i = d; i < expenditure.length; i++){
            int index = -1, medianIndex1 = -1, medianIndex2 = -1;
            if(d % 2 == 1){
                medianIndex2 = d/2;
            }else{
                medianIndex2 = d/2;
                medianIndex1 = medianIndex2 - 1;
            }
            float median = 0;
            boolean meadianFound = false;
            for(int j = 0; j < count.length; j++){
                if(count[j] > 0){
                    int value = count[j];
                    while(value > 0){
                        index++;
                        if(medianIndex1 >= 0  &&index == medianIndex1){
                            median += j;
                        }
                        if(index == medianIndex2){
                            median += j;
                            meadianFound = true;
                            break;
                        }
                        value--;
                    }
                    
                }
                if(meadianFound){
                    break;
                }
            }
            if(d % 2 == 0){
                median = median / 2.0f;
            }
            if(expenditure[i] >= 2*median){
                noticeCounter++;
            }

            count[expenditure[i-d]]--;
            count[expenditure[i]]++;
            
        }
        return noticeCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

