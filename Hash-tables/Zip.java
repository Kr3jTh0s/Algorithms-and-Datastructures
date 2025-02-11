import java.io.BufferedReader;
import java.io.FileReader;

public class Zip{
    
    Area[] postnr;
    int max = 10000;

    public class Area{
        String code;
        String name;
        Integer pop;

        public Area(String c, String n, Integer p){
            this.code = c;
            this.name = n;
            this.pop = p;
        }
    }

    public Zip(String file){
        this.postnr = new Area[this.max];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            int i = 0;
            while((line = br.readLine()) != null && i < this.max){
                String[] row = line.split(",");
                postnr[i++] = new Area(row[0], row[1], Integer.valueOf(row[2]));
            }
            this.max = i;
        }   catch(Exception e){
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean linSearch(String key){
        int i = 0;
        while(i < this.max && this.postnr[i].code.compareTo(key) < 0)
            if(this.postnr[i++].code.equals(key)) return true;
        return false;
    }

    public boolean binSearch(String key){
        int first = 0;
        int last = this.max;

        while(true){
            int index = (first + last)/2;

            if(this.postnr[index].code.equals(key)) return true;

            if(this.postnr[index].code.compareTo(key) < 0 && index < last){
                first = index + 1;
                continue;
            } 
            else if(this.postnr[index].code.compareTo(key) > 0 && index > first){
                last = index - 1;
                continue;
            } else return false;
        }
    }

}
