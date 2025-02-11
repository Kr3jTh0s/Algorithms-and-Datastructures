import java.io.BufferedReader;
import java.io.FileReader;

public class Zip5 {
    Area[] postnr;
    int max = 13513;
    int M = 13513;

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

    public Zip5(String file){
        this.postnr = new Area[this.max];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Integer hashIndex = (code % M);
                while(hashIndex < this.max){
                    if(postnr[hashIndex] == null){
                        postnr[hashIndex] = new Area(code, row[1], Integer.valueOf(row[2]));
                        break;
                    }
                    hashIndex++;
                }
            }
        }   catch(Exception e){
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup(Integer key){
        //Integer k = Integer.valueOf(key.replaceAll("\\s", ""));
        Integer k = key;
        Integer hashIndex = (k%M);
        if(this.postnr[hashIndex] != null){
            while(this.postnr[hashIndex] != null){
                if(this.postnr[hashIndex].code.compareTo(k) == 0) return true;
                hashIndex++;
            }
        }
        return false;
    }

}
