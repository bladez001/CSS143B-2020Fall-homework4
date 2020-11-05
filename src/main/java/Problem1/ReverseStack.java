package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int pop = stack.pop(); //pop until empty
            reverseStack(stack);
            reInsert(stack, pop); //re-inserts
        }
    }

    private static void reInsert(Stack<Integer> stack, int pop) {
        if (stack.isEmpty()) {
            stack.push(pop);
            return;
        }

        int newPop = stack.pop(); //remove everything in stack within this method
        reInsert(stack, pop); //push newPop to bottom
        stack.push(newPop); //put everything else back
    }
}