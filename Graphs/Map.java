import java.io.BufferedReader;
import java.io.FileReader;

public class Map{
    public City[] cities; // ska egentligen vara private
    private final int mod = 73;

    public Map(String file){
        this.cities = new City[mod];
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                String[] row = line.split(",");
                City one = lookup(row[0]);
                City two = lookup(row[1]);
                Integer dist = Integer.valueOf(row[2]);
                one.connect(two, dist);
                two.connect(one, dist);
            }
        } catch(Exception e){
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    public City lookup(String city){
        Integer indx = hash(city, mod);
        if(this.cities[indx] != null){
            City current = this.cities[indx];
            City previous = null;
            while(current != null){
                if(current.name.compareTo(city) == 0) return current;
                previous = current;
                current = current.next;
            }
            previous.next = new City(city);
            return previous.next;
        }
        this.cities[indx] = new City(city);
        return this.cities[indx];
    }

    private static Integer hash(String name, int mod){
        int hash = 0;
        for(int i = 0; i < name.length(); i++)
            hash = (hash*31 + name.charAt(i)) % mod;
        return hash;
    }
}
