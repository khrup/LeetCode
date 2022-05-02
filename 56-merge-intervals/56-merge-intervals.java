class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<List<Integer>> answer = new ArrayList<>();

        int prevIntervalStart = intervals[0][0];
        int prevIntervalEnd = intervals[0][1];

        if(intervals.length > 1) {
            for (int i = 1; i < intervals.length; i++) {
                //이전 end값이 더 크다는 것은 overlap 되는것이다.
                if (prevIntervalEnd >= intervals[i][0]) {
                    if (prevIntervalEnd < intervals[i][1])
                        prevIntervalEnd = intervals[i][1];
                }

                //이전 end값이 더 작으면 overlap이 끝난것이다.
                if (prevIntervalEnd < intervals[i][0]) {
                    answer.add(List.of(prevIntervalStart, prevIntervalEnd));
                    prevIntervalStart = intervals[i][0];
                    prevIntervalEnd = intervals[i][1];
                }

                if (i == intervals.length - 1) {
                    answer.add(List.of(prevIntervalStart, prevIntervalEnd));
                }
            }
        }else{
            answer.add(List.of(prevIntervalStart, prevIntervalEnd));
        }

        int[][] arrayAnswer = new int[answer.size()][2];

        for (int i = 0; i < answer.size(); i++) {
            arrayAnswer[i][0] = answer.get(i).get(0);
            arrayAnswer[i][1] = answer.get(i).get(1);
            //System.out.println(arrayAnswer[i][0] + ", " + arrayAnswer[i][1]);
        }

        return arrayAnswer;
    }
}