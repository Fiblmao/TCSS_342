import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

/**
 * @author Kian Rivera
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fileName = "";
        int orderCount = 0;

        try {
            System.out.println("What is the name if your file?");
            fileName = scan.nextLine();
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine() && orderCount < 99) {
                String order = input.nextLine();
                System.out.println("Processing Order " + orderCount + ": " + order);
                parseLine(order);
                orderCount++;
            }



        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e);
        }
        //testMyStack();
        //testBurger();
    }

    static void parseLine(String line) {
        int pattyCount = 1;
        boolean theWorks = false;
        String [] order = line.split(" ");
        for (int i = 0; i < order.length; i++) {
            if (order[i].equals("Baron")) {
                theWorks = true;
            }
            if (order[i].equals("Double")) {
                pattyCount++;
            } else if (order[i].equals("Triple")) {
                pattyCount++;
                pattyCount++;
            }
        }
        Burger burger = new Burger(theWorks);
        for (int i = 1; i < pattyCount; i++) {
            burger.addPatty();
        }

        if (!theWorks) {
            int withDex = 0;
            int noDex = 0;
            for (int j = 0; j < order.length; j++) {
                if (order[j].equals("Chicken")) {
                    burger.changePatties("Chicken");
                } else if (order[j].equals("Veggie")) {
                    burger.changePatties("Veggie");
                } else if (order[j].equals("with")) {
                    withDex += j;
                }
            }
            if (withDex != 0 ) {
                for (int k = withDex + 1; k < order.length; k++) {
                    if (order[k].equals("Cheese")) {
                        burger.addCategory("Cheese");
                    } else if (order[k].equals("Sauce")) {
                        burger.addCategory("Sauces");
                    } else if (order[k].equals("Veggies")) {
                        burger.addCategory("Veggies");
                    } else if (order[k].equals("no")) {
                        noDex += k;
                    } else {
                        burger.addIngredient(order[k]);
                    }
                }
            }
            if (noDex != 0) {
                for (int l = noDex + 1; l < order.length; l++) {
                    burger.removeIngredient(order[l]);
                }
            }
        } else {
            int noIndex = 0;
            int butIndex = 0;
            for (int k = 0; k < order.length; k++) {
                if (order[k].equals("but")) {
                    butIndex += k;
                } else if (order[k].equals("no")) {
                    noIndex += k;
                }
            }
            if (noIndex != 0) {
                for (int l = noIndex + 1; l < order.length; l++) {
                    if (order[l].equals("Cheese")) {
                        burger.removeCategory("Cheese");
                    } else if (order[l].equals("Sauce")) {
                        burger.removeCategory("Sauces");
                    } else if (order[l].equals("Veggies")) {
                        burger.removeCategory("Veggies");
                    } else {
                        burger.removeIngredient(order[l]);
                    }
                }
            }
            if (butIndex != 0) {
                for (int m = butIndex + 1; m < order.length; m++) {
                    burger.addIngredient(order[m]);
                }
            }
        }

        System.out.println(burger);
    }

    static void testMyStack() {
        MyStack<String> test = new MyStack<String>();
        if (test.isEmpty()) {
            System.out.println("it's empty");
        }
        test.push("Lilibet");
        test.push("Marnie");
        test.push("Fu Hua");
        System.out.println(test);
        System.out.println(test.size());
        if (!test.isEmpty()) {
            System.out.println("These are all your girls Fibel.");
        }
        System.out.println(test.peek());
        test.pop();
        System.out.println(test);
        System.out.println(test.size());
    }

    static void testBurger() {
        Burger testBurger = new Burger(false);
        System.out.println(testBurger);
        testBurger.addPatty();
        testBurger.addPatty();
        testBurger.addPatty();
        System.out.println(testBurger);
        testBurger.changePatties("Veggie");
        System.out.println(testBurger);
        testBurger.addIngredient("Cheddar");
        testBurger.removeIngredient("Cheddar");
        testBurger.addCategory("Cheese");
        testBurger.addCategory("Veggies");
        testBurger.removeCategory("Cheese");
        testBurger.addCategory("Sauce");
        System.out.println(testBurger);

    }
}
