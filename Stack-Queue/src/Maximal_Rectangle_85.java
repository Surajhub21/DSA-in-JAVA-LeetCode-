import java.util.Stack;

public class Maximal_Rectangle_85 {

    public int maxHistogram(int[] arr){
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < arr.length; i++){

            while(!s.isEmpty() && arr[s.peek()] > arr[i]){

                int elm = s.peek();
                s.pop();

                int nse = i;
                int pse = s.isEmpty() ? -1 : s.peek();

                maxArea = Math.max(maxArea , arr[elm] * (nse - pse - 1));
            }
            s.push(i);
        }

        while(!s.isEmpty()){

            int nse = arr.length;
            int elm = s.peek();
            s.pop();
            int pse = s.isEmpty() ? -1 : s.peek();

            maxArea = Math.max(maxArea , (nse - pse - 1) * arr[elm]);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int maxArea = 0;
        int[][] prefixSum = new int[r][c];

        for(int i = 0; i < c; i++){
            int sum = 0;
            for(int j = 0; j < r; j++){
                sum += matrix[j][i] - '0';
                if((matrix[j][i] - '0') == 0) sum = 0;
                prefixSum[j][i] = sum;
            }
        }

        for(int i = 0; i < r; i++){

            maxArea = Math.max(maxArea , maxHistogram(prefixSum[i]));

        }

        return maxArea;
    }

    public static void main(String[] args) {
        Maximal_Rectangle_85 m = new Maximal_Rectangle_85();
        char[][] matrix = {
                {'0'}
        };
        System.out.println(m.maximalRectangle(matrix));
    }
}
