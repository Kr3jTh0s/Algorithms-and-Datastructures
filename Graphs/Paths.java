public class Paths{

    City[] path;
    int sp;
    Integer opt;

    public Paths(){
        path = new City[54];
        sp = 0;
        opt = null;
    }

    private static Integer shortest(City from, City to, Paths p, Integer time){
        if(from == to) return 0;
        if(p.opt != null && time > p.opt) return null;
        for(int i = 0; i < p.sp; i++)
            if(p.path[i] == from) return null;

        Integer shrt = null;
        
        p.path[p.sp++] = from;
        for(int i = 0; i < from.size; i++){
            Connection conn = from.neighbours[i];
            shrt = time + conn.distance;
            /* *
            //System.out.println(from.name + " " + conn.city.name + "[" + i + "] -- (" + time + " + " + conn.distance + "): " + shrt + " | " + p.opt);
            //for(int j = 0; j < p.sp; j++) System.out.println(p.path[j].name);
            /* */
            Integer dst = shortest(conn.city, to, p, shrt);
            if(dst != null){
                shrt += dst;
                if(p.opt == null || shrt < p.opt) p.opt = shrt;
            }
        }
        p.path[p.sp--] = null;
        shrt = p.opt;
        return shrt;
    }

    /* */
    public static void merge_sort(int[] array){
        if(array.length == 0) return;
        int[] sub = new int[array.length];
        for(int i = 0; i < array.length; i++) sub[i] = array[i];
        merge_sort(array, sub, 0, array.length - 1);
    }
    //*/

    /* */
    private static void merge_sort(int[] array, int[] sub, int low, int high){
        if(low != high){
            int mid = low + (high - low)/2;
            merge_sort(sub, array, low, mid);
            merge_sort(sub, array, mid+1, high);
            merge(array, sub, low, mid, high);
        }
    }
    //*/

    /* */
    private static void merge(int[] array, int[] sub, int low, int mid, int high){
        int i = low;
        int j = mid + 1;

        for(int k = low; k <= high; k++){
            if(i > mid) array[k] = sub[j++];
            else if(j > high) array[k] = sub[i++];
            else if(sub[i] < sub[j]) array[k] = sub[i++];
            else array[k] = sub[j++];
        }
    }


    public static void main(String[] args) {

        Map map = new Map("trains.csv");

        int[] distances = new int[52];
        int n = 0;

        /* *
        String[] from = {"Malmö", "Göteborg", "Malmö", "Stockholm", "Stockholm", "Göteborg", "Sundsvall", "Umeå", "Göteborg", "Malmö"};
        String[] to = {"Göteborg", "Stockholm","Stockholm", "Sundsvall", "Umeå", "Sundsvall", "Umeå", "Göteborg", "Umeå", "Kiruna"};

        for(int i = 0; i < 10; i++){
            Paths p = new Paths();
            System.out.print(from[i] + " & " + to[i]);
            long t0 = System.nanoTime();
            Integer dist = shortest(map.lookup(from[i]), map.lookup(to[i]), p, 0);
            long time = (System.nanoTime() - t0)/1_000_000;
            distances[n++] = dist;
            System.out.println(" & $" + dist + " min$ & $" + time + " ms$ \\\\");
            
        }

        /* */
        String from = "Malmö";
        for(int i = 0; i < 73; i++){
            if(map.cities[i] != null){
                City temp = map.cities[i];
                while(temp != null){
                    Paths p = new Paths();
                    String to = temp.name;
                    System.out.print(to);
                    long t0 = System.nanoTime();
                    Integer dist = shortest(map.lookup(from), map.lookup(to), p, 0);
                    long time = (System.nanoTime() - t0)/1_000_000;
                    distances[n++] = dist;
                    System.out.println(" shortest: " + dist + " min (" + time + " ms)");
                    temp = temp.next;
                }
            }
        }


        merge_sort(distances);

        for(int i = 0; i < 52; i++){
            System.out.println((i + 1) + "  " + distances[i]);
        }
        
        /* *
        String from = args[0];
        String to = args[1];

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), p, 0);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("shortest: " + dist + " min (" + time + " ms)");
        /* */
    }
}
