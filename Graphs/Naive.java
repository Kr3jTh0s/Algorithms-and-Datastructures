public class Naive{

    private static Integer shortest(City from, City to, Integer max){
        if(max < 0) return null;
        if(from == to) return 0;

        Integer shrt = null;

        for(int i = 0; i < from.neighbours.length; i++){
            if(from.neighbours[i] != null){
                Connection conn = from.neighbours[i];
                Integer dst = null;
                if(conn.city.neighbours[0].city.name.compareTo(from.name) != 0){
                    dst = conn.distance;
                    max -= dst;
                    if(shortest(conn.city, to, max) != null) dst += shortest(conn.city, to, max);
                    else break;
                }
                if(dst != null){
                    if(shrt == null) shrt = dst;
                    else if(dst < shrt) shrt = dst;
                }
            }
        }
        return shrt;
    }


    public static void main(String[] args) {
        
        Map map = new Map("trains.csv");

        String from = args[0];
        String to = args[1];
        Integer max = Integer.valueOf(args[2]);

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}
