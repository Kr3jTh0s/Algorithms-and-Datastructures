/* */
import java.io.*;

public class HP35 {

    public static void main(String[] args) throws IOException {
        
        DynamicStack stack = new DynamicStack();
        //StaticStack stack = new StaticStack(3);

        System.out.println("HP-35 pocket calculator");

        boolean run = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(run){
            System.out.print(" > ");
            String input = br.readLine();
            switch (input){
                case "+":
                    int sum = stack.pop();
                    for(int i = stack.top; i > 0; i--){
                        sum += stack.pop();
                    }
                    stack.push(sum);

                    break;

                case "*":
                    int prod = stack.pop();
                    for(int i = stack.top; i > 0; i--){
                        prod *= stack.pop();
                    }
                    stack.push(prod);
                    
                    break;
                    
                case "-":
                    int dif = stack.pop();
                    for(int i = stack.top; i > 0; i--){
                        dif -= stack.pop();
                    }
                    dif *= -1;
                    stack.push(dif);

                    break;

                case "":
                    run = false;
                    break;
                
                default:
                    Integer nr = Integer.parseInt(input);
                    stack.push(nr);
                    break;
            }
        }
        System.out.printf("the result is: %d\n\n", stack.pop());
        System.out.printf("I love reversed polish notation, don't you?\n");
    }
}
//*/