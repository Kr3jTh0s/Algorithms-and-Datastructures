import java.io.BufferedReader;
import java.io.FileReader;

public class Zip4 {
    Area[] postnr;
    int max = 13513;
    int M = 13513;

    public class Area{
        Integer code;
        String name;
        Integer pop;
        Area next;

        public Area(Integer c, String n, Integer p){
            this.code = c;
            this.name = n;
            this.pop = p;
            this.next = null;
        }
    }

    public Zip4(String file){
        this.postnr = new Area[this.max];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            Integer i = 0;
            while((line = br.readLine()) != null && i < this.max){
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Integer hashIndex = (code % M);
                if(postnr[hashIndex] == null) postnr[hashIndex] = new Area(code, row[1], Integer.valueOf(row[2]));
                else{
                    Area current = postnr[hashIndex];
                    while(current.next != null) current = current.next;
                    current.next = new Area(code, row[1], Integer.valueOf(row[2]));
                }
                i++;
            }
            this.max = i;
        }   catch(Exception e){
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup(Integer key){
        //Integer k = Integer.valueOf(key.replaceAll("\\s", ""));
        Integer k = key;
        Integer hashIndex = (k%M);
        if(this.postnr[hashIndex] != null){
            Area current = this.postnr[hashIndex];
            while(current != null){
                if(current.code.compareTo(k) == 0) return true;
                current = current.next;
            }
        }
        return false;
    }

}
