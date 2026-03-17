package ShortestPathAlgo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Cheapest_Flights_Within_K_Stops_787 {

    public static void main(String[] args) {
        Cheapest_Flights_Within_K_Stops_787 obj = new Cheapest_Flights_Within_K_Stops_787();
        int n = 5;
        //[[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
        int[][] flights = {
                {0, 1, 5},
                {1, 2, 5},
                {0, 3, 2},
                {3, 1, 2},
                {1, 4, 1},
                {4, 2, 1}
        };
        int src = 0;
        int dst = 2;
        int k = 2;

        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
        int i = 0;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.price - y.price);
        int[] dis = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        pq.add(new Tuple(src, 0, k));

        while(!pq.isEmpty()){

            Tuple cur = pq.poll();
            int node = cur.node , price = cur.price, step = cur.step;

            for(int i = 0; i < flights.length; i++){

                if(flights[i][0] == node &&
                        step != -1 &&
                        (flights[i][2]+price) < dis[flights[i][1]]
                ){
                    if((step-1) == -1 && flights[i][1] != dst){
                        continue;
                    }
                    dis[flights[i][1]] = flights[i][2]+price;
                    pq.add(new Tuple(flights[i][1] , price+flights[i][2], step-1));
                }
            }
        }

        if(dis[dst] != Integer.MAX_VALUE){
            return dis[dst];
        }

        return -1;
    }
}

class Tuple {
    int node;
    int price;
    int step;

    public Tuple(int _n, int _p, int _s) {
        node = _n;
        price = _p;
        step = _s;
    }
}
