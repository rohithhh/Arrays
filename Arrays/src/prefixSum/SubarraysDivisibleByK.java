package prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivisibleByK {
	public static void main(String[] args) {
		int[] nums = {4,5,0,-2,-3,1};
		System.out.println(subarraysDivByK(nums, 5));
	}
	
    public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}