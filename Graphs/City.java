public class City{
    String name;
    Connection[] neighbours;
    City next;
    int size;

    public City(String name){
        this.name = name;
        this.next = null;
        this.size = 1;
        this.neighbours = new Connection[this.size];
    }

    public void connect(City nxt, Integer dst){
        int i = 0;
        if(this.neighbours[i] != null){
            while(i < this.size)
                if(this.neighbours[i++].city == nxt) return;
            Connection[] copy = new Connection[++this.size];
            for(int j = 0; j < i; j++) copy[j] = this.neighbours[j];
            this.neighbours = copy;
        }
        this.neighbours[i] = new Connection(nxt, dst);
    }
}
