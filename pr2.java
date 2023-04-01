package s4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class pr2 {
    public static void main(String[] args) {
        /* 
         * Реализуйте очередь с помощью LinkedList со следующими методами:
            • enqueue() — помещает элемент в конец очереди,
            • dequeue() — возвращает первый элемент из очереди и удаляет его,
            • first() — возвращает первый элемент из очереди, не удаляя.
         */

         //До меня не совсем дошло, что имелось ввиду под "реализуйте очередь", поэтому ай тук сам креэйтив либерити
        Scanner scan = new Scanner(System.in);
        System.out.println("How long would you like your queue to be?");
        int k = scan.nextInt();
        scan.nextLine();
        Queue<String> newQueue = new LinkedList<String>();
        for (int i = 0; i < k; i++){
            System.out.println("What would you like to add to the queue?");
            String temp = scan.nextLine();
            newQueue.add(temp);
        }
        System.out.println("You queue: " + newQueue);
        System.out.println("Oh no! \nThe programm modifying your queue!");
        for (int i = 0; i < k/2; i++){
            enqueue(newQueue);
        }
        System.err.println("Look at what happened: " + newQueue);
        System.out.println("I hope nothing happens next...");
        System.out.println(queueFirst(newQueue)); 
        System.out.println("It printed the first element?..");
        System.out.println("... \n... \n...");
        for (int i = 0; i < k / 3; i++){
            dequeue(newQueue);
            System.out.println(newQueue);
        }
        System.out.println("I'm so sorry...");
        scan.close();

    }

    static Queue<String> enqueue(Queue<String> newQueue){
        newQueue.add(newQueue.element());
        newQueue.remove();
        return newQueue;
    }

    static String queueFirst(Queue<String> newQueue){
        String result = newQueue.element();
        return result;
    }

    static Queue<String> dequeue(Queue<String> newQueue){
        System.err.println(queueFirst(newQueue)); 
        newQueue.remove(newQueue.element());
        return newQueue;
    }
}
