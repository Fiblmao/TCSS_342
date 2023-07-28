/**
 * @author Kian Rivera
 * @version 1.0
 */

public class Burger {
    MyStack<String> order;
    MyStack<String> baronBurger = new MyStack<String>();
    int pattyCount = 0;
    String thePatty = "Beef";


    Burger(boolean theWorks) {
        order = new MyStack<String>();

        baronBurger.push("Bun");
        baronBurger.push("Ketchup");
        baronBurger.push("Mustard");
        baronBurger.push("Mushrooms");
        baronBurger.push(thePatty);
        baronBurger.push("Cheddar");
        baronBurger.push("Mozzarella");
        baronBurger.push("Pepperjack");
        baronBurger.push(thePatty);
        baronBurger.push(thePatty);
        baronBurger.push("Onions");
        baronBurger.push("Tomato");
        baronBurger.push("Lettuce");
        baronBurger.push("Baron-Sauce");
        baronBurger.push("Mayonnaise");
        baronBurger.push("Bun");
        baronBurger.push("Pickle");

        if (!theWorks) {
            order.push("Bun");
            order.push(thePatty);
            order.push("Bun");
            pattyCount++;
        } else {
            order.push("Bun");
            order.push("Ketchup");
            order.push("Mustard");
            order.push("Mushrooms");
            order.push(thePatty);
            order.push("Cheddar");
            order.push("Mozzarella");
            order.push("Pepperjack");
            order.push("Onions");
            order.push("Tomato");
            order.push("Lettuce");
            order.push("Baron-Sauce");
            order.push("Mayonnaise");
            order.push("Bun");
            order.push("Pickle");
        }
    }

    public void changePatties(String pattyType) {
        MyStack<String> temp = new MyStack<String>();
        MyStack<String> temp2 = new MyStack<String>();
        while (!order.isEmpty()) {
            if (order.peek().equals(thePatty)) {
                order.pop();
                temp.push(pattyType);
            } else {
                temp.push(order.pop());
            }
        }
        while (!baronBurger.isEmpty()) {
            if (baronBurger.peek().equals(thePatty)) {
                baronBurger.pop();
                temp2.push(pattyType);
            } else {
                temp2.push(baronBurger.pop());
            }
        }
        thePatty = pattyType;
        while (!temp.isEmpty()) {
            order.push(temp.pop());
        }
        while (!temp2.isEmpty()) {
            baronBurger.push(temp2.pop());
        }
    }

    public void addPatty() {
        if (pattyCount < 3) {
            pattyCount++;
            MyStack<String> temp = new MyStack<String>();
            while (!(order.peek().equals("Pepperjack") ||
                    order.peek().equals("Mozzarella")||
                    order.peek().equals("Cheddar")||
                    order.peek().equals(thePatty))) {
                temp.push(order.pop());
            }
            temp.push(thePatty);
            while(!temp.isEmpty()) {
                order.push(temp.pop());
            }
        }
    }

    public void addCategory(String type) {
        if (type.equals("Cheese")) {
            addIngredient("Cheddar");
            addIngredient("Mozzarella");
            addIngredient("Pepperjack");
        } else if (type.equals("Veggies")) {
            addIngredient("Pickle");
            addIngredient("Lettuce");
            addIngredient("Tomato");
            addIngredient("Onions");
            addIngredient("Mushrooms");
        } else if (type.equals("Sauces")) {
            addIngredient("Ketchup");
            addIngredient("Mustard");
            addIngredient("Mayonnaise");
            addIngredient("Baron-Sauce");
        }
    }

    public void removeCategory(String type) {
        if (type.equals("Cheese")) {
            removeIngredient("Cheddar");
            removeIngredient("Mozzarella");
            removeIngredient("Pepperjack");
        } else if (type.equals("Veggies")) {
            removeIngredient("Lettuce");
            removeIngredient("Tomato");
            removeIngredient("Onions");
            removeIngredient("Pickle");
            removeIngredient("Mushrooms");
        } else if (type.equals("Sauces")) {
            removeIngredient("Ketchup");
            removeIngredient("Mustard");
            removeIngredient("Mayonnaise");
            removeIngredient("Baron-Sauce");
        }

    }
    public void addIngredient(String type) {
        MyStack<String> temp = new MyStack<String>();
        MyStack<String> temp2 = new MyStack<String>();
        String ingredient = "";
        boolean withPickle = false;
        if (type.equals("Pickle")) {
            withPickle = true;
        }
        while (!order.isEmpty()) {
            temp.push(order.pop());
        }
        while (!baronBurger.isEmpty()) {
            if (baronBurger.peek().equals(type)) {
                ingredient = type;
            }
            temp2.push(baronBurger.pop());
        }
        while (!temp2.isEmpty() && !temp.isEmpty()) {
            if ((temp2.peek()).equals(temp.peek())) {
                order.push(temp.pop());
            } else if ((temp2.peek().equals(ingredient))) {
                order.push(ingredient);
            }
            baronBurger.push(temp2.pop());
        }
        if (withPickle) {
            temp.push(type);
            while (!order.isEmpty()) {
                temp.push(order.pop());
            }
            while (!temp.isEmpty()) {
                order.push(temp.pop());
            }
        }
    }

    public void removeIngredient(String type) {
        MyStack<String> temp = new MyStack<String>();
        MyStack<String> trash = new MyStack<String>();
        while (!order.isEmpty()) {
            if (order.peek().equals(type)) {
                trash.push(order.pop());
            }
            temp.push(order.pop());
        }
        while (!temp.isEmpty()) {
            order.push(temp.pop());
        }
    }

    public String toString() {
        return order.toString();
    }
}
