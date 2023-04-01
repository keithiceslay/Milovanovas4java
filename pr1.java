package s4;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class pr1 {
    public static void main(String[] args) {
        // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.
        Scanner scan = new Scanner(System.in);
        LinkedList<String> startList = new LinkedList<String>();
        System.out.println("How long do you wish your list to be?");
        int k = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < k; i++) {
            System.out.println("Input an element you wish to have in your list");
            String input = scan.nextLine();
            startList.addLast(input);
        }
        System.out.println("Your list: " + startList);
        LinkedList <String> newList = new LinkedList<String>();
        invertList(startList, newList);
        scan.close();
    }

    static void invertList (LinkedList<String> startList, LinkedList<String> newList) {
        try{
            String temp = startList.getLast();
            if (temp != null) {
                newList.addLast(temp);
                startList.removeLast();
                invertList(startList, newList);
            }
        }
        catch (Exception NoSuchElementException) {}
        finally {
            System.out.println("You list turned over: " + newList);
        }
    }
    

}
