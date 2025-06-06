import java.util.HashMap;
import java.util.Map;


public class PrefixSum {
    public int subarraySum(int[] arr, int p) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == p) {
                count++;
            }

            int diff = sum - p;
            if (prefixSum.containsKey(diff)) {
                count += prefixSum.get(diff);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}