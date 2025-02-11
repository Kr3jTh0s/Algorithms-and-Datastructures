public class DynamicStack {
    int[] stack;
    int size;
    int top;

    public DynamicStack(){
        size = 8;
        stack = new int[size];
        top = 0;
    }

    public void push(int value){
        if(top == (size)){
            int copy[] = new int[size*2];
            for(int i = 0; i < size; i++) copy[i] = stack[i];
            stack = copy;
            size = stack.length;
        }

        stack[top++] = value;
    }

    public int pop() throws ArrayIndexOutOfBoundsException{
        if(top == 0) throw new ArrayIndexOutOfBoundsException("Stack is empty");
        
        if(((top + 1) < (size / 2)) && (size != 4)){
            int copy[] = new int[size/2];
            for(int i = 0; i < copy.length; i++) copy[i] = stack[i];
            stack = copy;
            size = stack.length;
        }

        return stack[--top];
    }
}
