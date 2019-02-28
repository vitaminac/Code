package code.adt.stack;

import code.adt.LinkedList;
import code.adt.Stack;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new LinkedList<>();
        while (scanner.hasNextInt()) {
            stack.push(scanner.nextInt());
        }
        for (int i : stack) {
            System.out.println(i);
        }
    }
}