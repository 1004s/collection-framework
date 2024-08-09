package structure.data.stack;

import java.util.Iterator;

public class MyStackMain {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack();

        stack.push("white");
        stack.push("red");
        stack.push("green");
        stack.push("blue");
        stack.push("yellow");


        Iterator iterator = stack.iterator();
        while(iterator.hasNext()) {
            System.out.println("stack:" + iterator.next());
        }

        System.out.println("#################");
        String top = stack.peek().toString();
        System.out.println("top:" + top);
        System.out.println("#################");
        System.out.println("green-sequence: " + stack.search("green") );
        System.out.println("yellow-sequence: " + stack.search("yellow") );
        System.out.println("#################");
        String whiteColor = stack.pop().toString();
        System.out.println("pop:" + whiteColor);
        String redColor = stack.pop().toString();
        System.out.println("pop:" + redColor);

    }
}
