package s4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class pr3 {
    public static void main(String[] args) {
        // В калькулятор добавьте возможность отменить последнюю операцию.
        Scanner scan = new Scanner(System.in);
        System.out.println("How many operation do you wish to commit? \n(This calculator works in a linear matter)");
        int opNum = scan.nextInt();
        Deque<Object> orQ = new LinkedList<Object>();
        orQ = getQueue(opNum, scan);
        System.out.println("Your line of operation: " + orQ);
        int check = checkQueue(orQ, scan);
        int times = checkTimes(check, scan);
        orQ = editQueue(orQ, times, check);
        System.out.println(orQ);
        Double result = equationResult(orQ, times);
        System.out.printf("Your result: %f", result);
        scan.close();
    }

    static Deque<Object> getQueue (int opNum, Scanner scan){
        Deque<Object> opQ = new LinkedList<Object>();
        for (int i = 1; i <= (opNum*2 + 1); i++){
            if (i % 2 != 0){
                System.out.println("Input a number");
                Double temp = scan.nextDouble();
                opQ.addLast(temp);
                scan.nextLine();
            }
            if (i % 2 == 0){
                System.out.println("Input an operation {+, -, *, /}");
                String temp = scan.nextLine();
                opQ.addLast(temp);
            }
        }
        return opQ;
    }

    static int checkQueue (Deque<Object> orQ, Scanner scan){
        System.out.println("Do you wish to delete the last operation?\n0: no\n1: yes");
        int check = 0;
        try {
            int choice = scan.nextInt();
            if (choice == 0){
            }
            else if (choice >= 1){
                check = checkTimes(choice, scan);
            }
        }
        catch (Exception e) {
            System.out.println("Please, input a number");
            checkQueue(orQ, scan);
        }
        return check;
    }

    static int checkTimes(int check, Scanner scan){
        System.out.println("How many times whould you like to do that?");
        int times = 1;
        try {
            times = scan.nextInt();
        }
        catch (Exception e) {
            System.out.println("Please input a valid number");
            checkTimes(times, scan);
        }
        return times;
    }

    static Deque<Object> editQueue(Deque<Object> orQ, int times, int choice){
        if (choice == 0)
            return orQ;
        else if (choice >= 1){
            for (int i = 0; i < times; i++){
                orQ.removeLast();
                orQ.removeLast();
            }
            return orQ;
        }
        return orQ;
    }
    static Double equationResult(Deque<Object> orQ, int times){
        Double a = (Double) orQ.peek();
        orQ.removeFirst();
        while (orQ.size() > 0){
            String op = (String) orQ.peek();
            orQ.removeFirst();
            Double b = (Double) orQ.peek();
            orQ.removeFirst();
            a = calc(a, b, op);
        }
        return a;
    }

    static Double calc(Double a,Double b, String op){
        switch (op) {
            case "*": 
                a = a * b;  
                System.out.printf("a * b = %f\n", a);
                break;
            case "/": 
                a = a / b;
                System.out.printf("a / b = %f\n", a);
                break;
            case "+": 
                a = a + b;
                System.out.printf("a + b = %f\n", a);
                break;
            case "-": 
                a = a - b;
                System.out.printf("a - b = %f\n", a);
                break;
        }
        return a;

    }
}
