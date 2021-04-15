import java.util.Scanner;

public class URI1068 {
 
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        String form;
        boolean isCorrect;
        PilhaLucas p;


        while (entrada.hasNext()){
            p = new PilhaLucas();
            isCorrect = true;
            form = entrada.nextLine();

            for (int i=0; i < form.length(); i++){
                char c = form.charAt(i);
                if (c == '('){
                    p.push(c);
                }
                else if (c == ')'){
                    if (p.isEmpty()){
                        isCorrect = false;
                        break;
                    }
                    else{
                        char x = p.pop();
                    }
                }
            }
            if (isCorrect && p.isEmpty()){
                System.out.println("correct");
            }
            else{
                System.out.println("incorrect");
            }
        }
    }

     
    private static class PilhaLucas{
        private int topo;
        private char[] itens;

        public PilhaLucas(){
            topo = -1;
            itens = new char[1000];
        }

        public boolean isEmpty(){
            return (topo == -1);
        }

        public void push(char e){
            topo++;
            itens[topo] = e;
        }

        public char pop(){
            char i = itens[topo];
            topo--;
            return i;
        }
    }
 
}