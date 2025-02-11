import java.io.BufferedReader;
import java.io.FileReader;

public class Zip2 {
    Area[] postnr;
    int max = 10000;

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

    public Zip2(String file){
        this.postnr = new Area[this.max];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            int i = 0;
            while((line = br.readLine()) != null && i < this.max){
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                postnr[i++] = new Area(code, row[1], Integer.valueOf(row[2]));
            }
            this.max = i;
        }   catch(Exception e){
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean linSearch(Integer key){
        int i = 0;
        while(i < this.max && this.postnr[i].code < key)
            if(this.postnr[i++].code == key) return true;
        return false;
    }

    public boolean binSearch(Integer key){
        int first = 0;
        int last = this.max;

        while(true){
            int index = (first + last)/2;

            if(this.postnr[index].code == key) return true;

            if(this.postnr[index].code < key && index < last){
                first = index + 1;
                continue;
            } 
            else if(this.postnr[index].code > key && index > first){
                last = index - 1;
                continue;
            } else return false;
        }
    }

}
