import java.util.Stack;

public class Asteroid_Collision_735 {



    public static void main(String[] args) {
        int[] arr = findAsteroid(new int[]{-5 , 3 , 0 , 3 , -6 , -3 , -5 ,6 , 3 , 9  ,-20});

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int[] findAsteroid(int[] asteroids) {
        if(asteroids.length < 2) return asteroids;
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < asteroids.length ; i++){
            int num = asteroids[i];

            if(!s.isEmpty() && num < 0){
                if(s.peek() >= 0) {
                    boolean isTrue = false;
                    while (!s.isEmpty() && s.peek() >= 0) {
                        if (abs(num) > s.peek()) {
                            s.pop();
                            isTrue = true;
                        }
                        else if (abs(num) == s.peek()) {
                            s.pop();
                            isTrue = false;
                            break;
                        }
                        else {
                            isTrue = false;
                            break;
                        }
                    }
                    if (isTrue){
                        s.push(num);
                    }
                }
                else {
                    s.push(num);
                }
            }
            else {
                s.push(num);
            }
        }

        int[] res = new int[s.size()];
        int i = 0;
        while(!s.isEmpty()){
            res[i++] = s.peek();
            s.pop();
        }

        i = 0;
        int j = res.length - 1;

        while(i < j){
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;

            i++;
            j--;
        }
        return res;
    }

    private static int abs(int num) {
        return Math.abs(num);
    }
}
