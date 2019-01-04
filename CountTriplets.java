import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> rightMap = new HashMap<>();
        HashMap<Long, Long> leftMap = new HashMap<>();
        for(Long item : arr){
            long freq = rightMap.getOrDefault(item, 0L);
            rightMap.put(item, freq + 1);
        }
        long numberOfGeometricPairs = 0;
    
        for (long val : arr) {
          long countLeft = 0;
          long countRight = 0;
          long lhs = 0;
          long rhs = val * r;
          if (val % r == 0) {
            lhs = val / r;
          }
          Long occurence = rightMap.get(val);
          rightMap.put(val, occurence - 1L);

          if (rightMap.containsKey(rhs)) {
            countRight = rightMap.get(rhs);
          }
          if (leftMap.containsKey(lhs)) {
            countLeft = leftMap.get(lhs);
          }
          numberOfGeometricPairs += countLeft * countRight;

          long count = leftMap.getOrDefault(val, 0L);
          leftMap.put(val, count + 1);
        }
        return numberOfGeometricPairs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

