public class StaticStack {
    int[] stack;
    int top;

    public StaticStack(int size){
        stack = new int[size];
        top = 0;
    }

    public void push(int val) throws ArrayIndexOutOfBoundsException{
        if(top == (stack.length)) throw new ArrayIndexOutOfBoundsException("Stack Overflow");
        
        stack[top++] = val;
    }

    public int pop()throws ArrayIndexOutOfBoundsException{
        if(top == 0) throw new ArrayIndexOutOfBoundsException("Stack is empty");
        
        return stack[--top];
    }
}
