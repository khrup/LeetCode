import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            if (bill == 5) {
                map.merge(bill, 1, (k, v) -> map.get(bill) + 1);
            } else if (bill == 10) {
                map.merge(bill, 1, (k, v) -> map.get(bill) + 1);
                Integer result = map.computeIfPresent(5, (k, v) -> map.get(5) - 1);
                if (result == null || result < 0) {
                    return false;
                }
            } else if (bill == 20) {
                Integer result10 = map.computeIfPresent(10, (k, v) -> map.get(10) - 1);
                if (result10 == null || result10 < 0) {
                    map.put(10,0);
                    Integer result5 = map.computeIfPresent(5, (k, v) -> map.get(5) - 3);
                    if (result5 == null || result5 < 0) {
                        return false;
                    }
                } else {
                    Integer result5 = map.computeIfPresent(5, (k, v) -> map.get(5) - 1);
                    if (result5 == null || result5 < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}