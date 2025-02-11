public class LinkedQueue <T> extends Queue <T> {
    
    Node queue;

    //Node front, back;

    private class Node{
        T item;
        Node next;

        private Node(T itm, Node nxt){
            this.item = itm;
            this.next = nxt;
        }
    }

    public LinkedQueue(){
        this.queue = null;
        //this.front = this.back = null;
    }

    public void enqueue(T item){
        this.queue = new Node(item, queue);

        /* *
        Node n = new Node(item, null);
        if(this.back == null){
            this.front = n;
            this.back = n;
            return;
        }
        this.back.next = n;
        this.back = n;

        //*/
    }

    public T dequeue(){
        /* */
        if(this.queue == null) return null;
        Node prv = null;
        Node nxt = this.queue;
        while(nxt.next != null){
            prv = nxt;
            nxt = nxt.next;
        }
        if(prv == null) this.queue = null;
        else prv.next = null;
        return nxt.item;
        //*/
        /* *
        if(this.front == null) return null;
        T itm = this.front.item;
        this.front = this.front.next;
        return itm;
        //*/
    }
    
    /* *
    public String toString(){
		String s = "";
		Node ye = this.queue;
        if(ye == null) return "-null-";
		while (ye.next != null){
		    s = s + ye.item + ", ";
		    ye = ye.next;
		}
		s = s + ye.item;
		return s;
	}
    //*/
}
