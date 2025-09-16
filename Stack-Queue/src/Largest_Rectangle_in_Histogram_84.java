public class Largest_Rectangle_in_Histogram_84 {

    public  static int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];

        int min = Integer.MAX_VALUE;
        int len = 0;
        int i = 0;
        int prvMax = 0;
        int max = 0;

        while(i < heights.length)
        {
            len++;

            if(heights[i] < min){
                min = heights[i];
            }

            if(heights[i] >= min) {
                if ((len * min) >= max && (len * min) >= heights[i]) {
                    max = len * min;
                } else {
                    max = heights[i];
                    len = 1;
                    min = heights[i];
                }
            }

            i++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2 , 1 , 5 , 6, 2 , 3}));
    }
}
