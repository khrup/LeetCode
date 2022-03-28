import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArray = new int[nums1.length + nums2.length];
        double answer = 0;

        for (int i = 0; i < nums1.length; i++) {
            mergeArray[i] = nums1[i];
        }

        for (int i = nums1.length; i < nums2.length + nums1.length; i++) {
            mergeArray[i] = nums2[i - nums1.length];
        }

        List<Integer> mergeList = Arrays.stream(mergeArray).sorted().boxed().collect(Collectors.toList());
        int size = mergeList.size();
        if (size % 2 == 1) {
            answer = mergeList.get((int) Math.ceil(size / 2));
        } else {
            answer = (mergeList.get(size / 2) + mergeList.get(size / 2 - 1)) / 2.0;
        }
        
        return answer;
    }
}