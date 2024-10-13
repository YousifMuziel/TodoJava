import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<ToDo> toDoList = new LinkedList<>();

        // Add 4 nodes to the linked list with the provided item details
        toDoList.add(new ToDo("Walk Dog", false));
        toDoList.add(new ToDo("Walk Cat", true));
        toDoList.add(new ToDo("Walk Hamster", false));
        toDoList.add(new ToDo("Walk Kids", false));

        // Set a time for the completed task (Item 2: Walk Cat)
        toDoList.get(0).convertTime("12:00");
        toDoList.get(1).convertTime("11:00");
        toDoList.get(2).convertTime("01:00");
        toDoList.get(3).convertTime("03:00");


        // Output the list of items in the list
        System.out.println("To-Do List:");
        for (ToDo item : toDoList) {
            item.printItem();
        }
    }
}
