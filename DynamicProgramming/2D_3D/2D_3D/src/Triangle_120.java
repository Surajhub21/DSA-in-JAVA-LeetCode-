import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {

    public static void main(String[] args) {
        /*
           2
  3 4
 6 5 7
4 1 8 3
         */
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3 , 4)));
        triangle.add(new ArrayList<>(List.of(6 , 5 , 7)));
        triangle.add(new ArrayList<>(List.of(4, 1,  8, 3)));

        int n = triangle.size()-1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < triangle.get(n).size(); i++){

            min = Math.min(min, f(triangle , n, i));
        }

        System.out.println(min);
    }

    private static int f(List<List<Integer>> triangle , int n, int idx){
        if(n == 0){
            return triangle.get(0).get(0);
        }
        if(n < 0 || idx < 0 || idx > triangle.get(n).size()-1){
            return Integer.MAX_VALUE;
        }

        int ith = f(triangle , n-1, idx);
        int iminus1 = f(triangle , n-1 , idx-1);

        return triangle.get(n).get(idx) + Math.min(ith , iminus1);
    }

}
