// Import array list and scanner
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Create array list and scanner
    private static ArrayList<String> myArrList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        // Loop until user quits
        while (!quit) {
            // Display menu and get user choice
            displayMenu();
            String choice = SafeInput.getRegExString(in, "Enter your choice (A/D/P/Q):", "[AaDdPpQq]");
            // Call appropriate method based on user choice
            switch (choice.toUpperCase()) {
                case "A":
                    // Add item to list
                    addItemToList();
                    break;
                case "D":
                    // Delete item from list
                    deleteItemFromList();
                    break;
                case "P":
                    // Print list
                    displayList();
                    break;
                case "Q":
                    // Ask user if they want to quit
                    quit = confirmQuit();
                    break;
            }
        }
        System.out.println("Exiting the program");
        in.close();
    }

    // Method to display menu
    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    // Method to add item to list
    private static void addItemToList() {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        myArrList.add(item);
        System.out.println("Item added successfully!");
    }

    // Method to delete item from list if list is not empty
    private static void deleteItemFromList() {
        // Check if list is empty and return if it is
        if (myArrList.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        // Display the list. Won't be empty if we get here so we don't need to worry about it printing "List is empty" twice
        displayList();
        int itemNumber = SafeInput.getRangedInt(in, "Enter the item number to delete", 1, myArrList.size());
        String deletedItem = myArrList.remove(itemNumber - 1);
        System.out.println("Item \"" + deletedItem + "\" removed from the list.");
    }

    // Method to display list as long as it is not empty
    private static void displayList() {
        if (myArrList.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Numbered list:");
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.println((i + 1) + ". " + myArrList.get(i));
            }
        }
    }

    // Method to confirm if user wants to quit
    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit? (Y/N)");
    }
}