public class MapTest{
    
    public static void printMap(){
        Map map = new Map("trains.csv");
        int n = 1;
        for(int i = 0; i < 73; i++){
            if(map.cities[i] == null);
            else{
                City temp = map.cities[i];
                while(temp != null){
                    System.out.println();
                    System.out.print("(" + n + ") " + "Index: " + i + " | City: " + temp.name + " | Connections: ");
                    int j = 0;
                    while(j < temp.size){
                        System.out.print(temp.neighbours[j].city.name + "(" + temp.neighbours[j].distance + "), ");
                        j++;
                    }
                    n++;
                    temp = temp.next;
                }
                
            }
        }
    }

    public static void main(String[] args) {
        printMap();

    }
}
