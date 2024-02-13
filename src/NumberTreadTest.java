import java.util.ArrayList;
import java.util.List;

public class NumberTreadTest {
    public static void main(String[] args) {
       ProcessThread C = new ProcessThread((number) ->
       {if(number% 3 ==0 && number%5 ==0){
           System.out.println("fizzbuzz");}});
        ProcessThread A = new ProcessThread((number) ->
        {if(number% 3 ==0 && number % 5 !=0){
            System.out.println("fizz");}});
        ProcessThread B = new ProcessThread((number) ->
        {if(number% 5 ==0 && number % 3 !=0){
            System.out.println("buzz");}});
        ProcessThread D = new ProcessThread((number) ->
        {if(number% 3 !=0 && number% 5 !=0){
            System.out.println(number);}});
        List<ProcessThread> threads = new ArrayList<>();
        threads.add(A);
        threads.add(B);
        threads.add(C);
        threads.add(D);
        for (ProcessThread thread: threads){
            thread.start();
        }
        for (int i = 1; i <=300; i++) {
            for (ProcessThread thread: threads){
                thread.process(i);}
        while (true){
            int prCoun = 0;
            for (ProcessThread thread: threads){
                if (thread.isPfocesed()){
                    prCoun++;
                }
            }
          if (prCoun == 4){
              break;
          }
        }
    }

    }
}
