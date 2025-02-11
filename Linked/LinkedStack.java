public class LinkedStack {
    
    private Stack top;
    public int pointer;

    private static class Stack{
        public int current;
        public Stack previous;

        public Stack(int value, Stack prv){
            current = value;
            previous = prv;
        }
    }

    public LinkedStack(){
        top = null;
        pointer = 0;
    }

    public void push(int value){
        top = new Stack(value, top);
        pointer++;
    }

    public int pop(){
        int val = top.current;
        Stack popped = top.previous;
        if(popped == null) top = null;
        else top = new Stack(popped.current, popped.previous);
        pointer--;
        return val;
    }

    public String toString(){
		String s = "";
		Stack ye = top;
        if(ye == null) return "-null-";
		while (ye.previous != null){
		    s = s + ye.current + ", ";
		    ye = ye.previous;
		}
		s = s + ye.current;
		return s;
	}

    public void append(LinkedStack b){
        Stack prv = this.top;
        while(prv.previous != null) prv = prv.previous;
        prv.previous = b.top;
        b.top = null;
    }
}
