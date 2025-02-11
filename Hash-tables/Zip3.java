import java.io.BufferedReader;
import java.io.FileReader;

public class Zip3 {
    Area[] postnr;
    Integer[] keys;
    int max = 100000;

    public class Area{
        Integer code;
        String name;
        Integer pop;

        public Area(Integer c, String n, Integer p){
            this.code = c;
            this.name = n;
            this.pop = p;
        }
    }

    public Zip3(String file){
        this.postnr = new Area[this.max];
        this.keys = new Integer[10000];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            Integer i = 0;
            while((line = br.readLine()) != null && i < this.max){
                String[] row = line.split(",");
                Integer key = Integer.valueOf(row[0].replaceAll("\\s", ""));
                postnr[key] = new Area(key, row[1], Integer.valueOf(row[2]));
                keys[i++] = key;
            }
            this.max = i;
        }   catch(Exception e){
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup(Integer key){
        //Integer k = Integer.valueOf(key.replaceAll("\\s", ""));
        if(this.postnr[key] != null){ 
            if(this.postnr[key].code.compareTo(key) == 0) 
            return true;
        }
        return false;
    }

    public void collisions(int mod){

        int mx = 20;

        int[] data = new int[mod]; // amount of keys mapped to an index 
        int[] cols = new int[mx];

        for(int i = 0; i < this.max; i++){
            Integer index = (this.keys[i] % mod);
            data[index]++;
        }

        for(int i = 0; i < mod; i++){
            if(data[i] < mx) cols[data[i]]++;
        }

        System.out.print(mod + ": ");
        for(int i = 1; i < mx; i++) System.out.print("\t" + cols[i]);
        System.out.println();
    }

}
