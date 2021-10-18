import java.util.Iterator;
import java.util.LinkedList;

public class ToDoList {
  public class ToDo {
    // instance vars
    private String text;
    private String details;
    private Priority priority;
  
    // constructors
    public ToDo(String text, String details, Priority priority) {
      this.text = text;
      this.details = details;
      this.priority = priority;
    }
  
    public ToDo(String text, Priority priority) {
      this.text = text;
      this.priority = priority;
  
      this.details = "<fill details here>";
    }
  
    public ToDo(String text) {
      this.text = text;
  
      this.details = "<fill details here>";
      this.priority = Priority.LOW;
    }
  
    // methods
    public String toString() {
      return this.text + "\n" + "Priority: " + this.priority + "\n" + this.details;
    }
  
    public String getToDoText() {
      return this.text;
    }
  
    public String getToDoDetails() {
      return this.details;
    }
  
    public void setToDoText(String text) {
      this.text = text;
    }
  
    public void setToDoDetails(String details) {
      this.details = details;
    }
  }  
  
  // instance variables
  private String nameOfList;
  private LinkedList<ToDo> toDoList;
  private LinkedList<ToDo> completedToDos;

  // constructors
  public ToDoList(String nameOfList) {
    this.nameOfList = nameOfList;
    this.toDoList = new LinkedList<>();
    this.completedToDos = new LinkedList<>();
  }

  public ToDoList() {
    this.nameOfList = "Default List";
    this.toDoList = new LinkedList<>();
    this.completedToDos = new LinkedList<>();
  }
  
  // methods
  public void printList() {
    System.out.println("List Name: " + this.nameOfList);

    int counter = 1;
    Iterator<ToDo> iterator = toDoList.iterator();
    while (iterator.hasNext()) {
      ToDo next = iterator.next();
      
      System.out.println("To Do #" + counter);
      System.out.println(next.getToDoText());
      System.out.println();
      System.out.println(next.getToDoDetails());
      System.out.println();

      counter++;
    }
    System.out.println("END OF LIST");
    System.out.println();
  }

  public void printCompleted() {
    System.out.println("Completed To-Do's");

    int counter = 1;
    Iterator<ToDo> iterator = completedToDos.iterator();
    while (iterator.hasNext()) {
      ToDo next = iterator.next();
      
      System.out.println("To Do #" + counter);
      System.out.println(next.getToDoText());
      System.out.println();
      System.out.println(next.getToDoDetails());
      System.out.println();

      counter++;
    }
    System.out.println("END OF LIST");
    System.out.println();
  }

  public void printAll() {
    this.printList();
    this.printCompleted();
  }

  public void addToDo(String text, String details, Priority priority) {
    toDoList.add(new ToDo(text, details, priority));
  }

  public void addToDo(String text, Priority priority) {
    toDoList.add(new ToDo(text, priority));
  }

  public void addToDo(String text) {
    toDoList.add(new ToDo(text));
  }

  // TODO
  public void sortHighToLowPriority() {

  }

  // TODO
  public void sortLowToHighPriority() {

  }

  // TODO
  public void clearCompleted() {

  }

  // TODO
  public void clearAll() {

  }

  // TODO
  public void markAllCompleted() {
    
  }
}