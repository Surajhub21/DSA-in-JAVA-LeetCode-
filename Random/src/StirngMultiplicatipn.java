public class StirngMultiplicatipn {

    public static void main(String[] args) {
        String a = "ab";
        String b = "cd";

        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                String s = new String(a.charAt(i) + "" + b.charAt(j));
                System.out.println(s);
            }
        }
    }
}
