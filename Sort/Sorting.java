import java.util.Random;

public class Sorting{
    
    // Merge sort
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
    //*/

    /* */
    private static long mergeSort(int n, int loop){
        Random rnd = new Random();

        int[][] array = new int[loop][n];
        for(int i = 0; i < loop; i++) 
            for(int j = 0; j < n; j++)
                array[i][j] = rnd.nextInt(n*10);
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        long t0 = System.nanoTime();
        for(int i = 0; i < loop; i++)
            merge_sort(array[i]);
        long t1 = System.nanoTime();
        
        /* *
        for(int i = 0; i < loop; i++){
            System.out.println();
            System.out.print(i + 1 + " | ");
            for(int j = 0; j < n; j++)
                System.out.print(array[i][j] + ", ");
        }
        //*/

        return (t1 - t0);
    }
    //*/

    public static void main(String[] args) {
        
        // Test
        /* *
        System.out.println();
        long t = mergeSort(10, 5);
        System.out.println(t);
        //*/

        // Merge sort
        /* */
        int[] sizes = {10, 20, 40, 80, 160, 320, 640, 1280, 2540, 5120, 10240};
        
        int loop = 1000;
        int k = 10;

        // JIT warmup
        mergeSort(2000, 2000);

        for(int n : sizes){
            long min = Long.MAX_VALUE;
            for(int i = 0; i < k; i++){
                long t = mergeSort(n, loop);
                if (t < min) min = t;
            }
            System.out.println(n + " " + ((double)min)/loop + " ns");
        }
        //System.out.println("-----------------------------");
        //*/
    }
}
