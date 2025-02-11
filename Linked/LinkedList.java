public class LinkedList implements List{
    
    private Cell first;

    private static class Cell{
        public int head;
        public Cell tail;

        public Cell(int value, Cell next){
            head = value;
            tail = next;
        }   
    }

    public LinkedList(int n){
        Cell last = null;
        for(int i = 0; i < n; i++) last = new Cell(i, last);
        first = last;
    }

    public String toString(){
		String s = "";
		Cell c = first;
		while (c.tail != null){
		    s = s + c.head + ", ";
		    c = c.tail;
		}
		s = s + c.head;
		return s;
	}

    public int length(){
        int size = 0;
        Cell c = first;
        while(c != null){
            size++;
            c = c.tail;
        }
        return size;
    }

    public void add(int value){
        Cell added = new Cell(value, first);
        first = added;
    }

    public boolean find(int item){
        Cell c = first;
        while(c != null){
            if(c.head == item) return true;
            c = c.tail;
        }
        return false;
    }

    public void remove(int item){
        Cell c = first;
        Cell d = first.tail;
        if(c.head == item) first = new Cell(d.head, d.tail);
        else{
            while(c != null){
                if(d.head == item){
                    c.tail = d.tail;
                    break;
                }
                else{
                    c = c.tail;
                    d = d.tail;
                }
            }
        }
    }

    public void append(LinkedList b){
        Cell nxt = this.first;
        while(nxt.tail != null) nxt = nxt.tail;
        nxt.tail = b.first;
        b.first = new Cell(0, null);
    }

}
