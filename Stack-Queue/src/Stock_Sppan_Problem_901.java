import java.util.*;

public class Stock_Sppan_Problem_901 {

    Stack<int[]> s; // each element is {price, index}
    int idx;

    public Stock_Sppan_Problem_901() {
        s = new Stack<>();
        idx = -1;
    }

    public int next(int price) {
        idx++;

        // Pop smaller or equal prices
        while (!s.isEmpty() && s.peek()[0] <= price) {
            s.pop();
        }

        // If stack is empty, means all previous prices are <= current price
        int ans = idx - (s.isEmpty() ? -1 : s.peek()[1]);

        // Push current (price, index)
        s.push(new int[]{price, idx});

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Stock_Sppan_Problem_901 st = new Stock_Sppan_Problem_901();
        list.add(st.next(7));
        list.add(st.next(2));
        list.add(st.next(1));
        list.add(st.next(3));
        list.add(st.next(3));
        list.add(st.next(1));
        list.add(st.next(8));

        for(int n : list){
            System.out.print(n + " ");
        }
        System.out.println();
    }
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
