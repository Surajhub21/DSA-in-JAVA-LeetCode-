public class Main {

    public static void main(String[] args) {
        String s = "0110111";
        System.out.println(numSub(s));
    }

    public static int numSub(String s) {
        if(s.isEmpty()) return 0;

        long total = 0;
        int l = 0;
        int r = 0;

        while(r < s.length()){
            char curChar = s.charAt(r);

            if(curChar == '1' && l == -1){
                l = r;
            }
            else if(curChar == '0' && l != -1){
                int n = r - l;
                total += n * (n + 1) / 2;
                l = -1;
            }

            r++;
        }

        int n = r - l;
        total += n * (n + 1) / 2;

        return (int) total % 1000000007;
    }

}