import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to your To-Do list app!");
    System.out.println();

    System.out.print("Please enter the name of your new To-Do list and press Enter, or just press Enter for the default name: ");
    String listName = scanner.nextLine();
    ToDoList list;
    if (listName.length() == 0) list = new ToDoList();
    else list = new ToDoList(listName);

    System.out.println("You have just created a To-Do list and it's empty.");
    System.out.println("What would you like to do now?");
    
    while (true) {
      boolean exit = false;

      System.out.println("To add a to-do enter 1.");
      System.out.println("To print the current list, enter 2.");
      System.out.println("To view all completed to-do's, enter 3.");
      System.out.println("To print both not completed and completed to-do's, enter 4.");
      System.out.println("To exit program, enter 5.");
      System.out.println();

      System.out.print("Please enter your choice now: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1: // add a to-do
          addToDo(scanner, list);
          break;
        case 2: // print the current list
          list.printList();
          break;
        case 3: // view all completed to-do's
          list.printCompleted();
          break;
        case 4: // print both not completed and completed to-do's
          list.printAll();
          break;
        case 5: // exit program
          exit = true;
          break;
        default: // choice not recognized
          System.out.println("I'm sorry, I don't recognize the choice you entered.");
          System.out.println();
          break;
      }

      if (exit) break;
    }

    scanner.close();
  }

  public static void addToDo(Scanner scanner, ToDoList list) {
    System.out.print("Please enter the text of your to-do item: ");
    String text = scanner.nextLine();
    System.out.println();

    System.out.print("Please enter the details of your to-do item (to leave this field empty, simply press Enter): ");
    String details = scanner.nextLine();
    System.out.println();

    System.out.print("Please enter the priority of your to-do item (for HIGH enter 3, for MEDIUM enter 2, and for LOW enter 1. If you don't enter any of these, the default is LOW): ");
    int choice = scanner.nextInt();
    scanner.nextLine();
    Priority priority;
    switch (choice) {
      case 3:
        priority = Priority.HIGH;
        break;
      case 2:
        priority = Priority.MEDIUM;
        break;
      case 1:
        priority = Priority.LOW;
        break;
      default:
        priority = Priority.LOW;
        break;
    }

    if (details.length() == 0) list.addToDo(text, priority);
    else list.addToDo(text, details, priority);
  }
}
