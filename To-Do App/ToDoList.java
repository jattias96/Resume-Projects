import java.util.Iterator;
import java.util.LinkedList;

public class ToDoList {
  public class ToDo implements Comparable<ToDo> {
    // instance vars
    private String text;
    private String details;
    private Priority priority;
    // private boolean done = false // should I implement it this way?
  
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

    @Override
    public int compareTo(ToDoList.ToDo o) {
      if (this.priority == o.priority) return 0;
      else if (this.priority == Priority.HIGH && (o.priority == Priority.MEDIUM || o.priority == Priority.LOW)) return 1;
      else if (this.priority == Priority.MEDIUM && o.priority == Priority.LOW) return 1;
      else return -1;
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

  public void clearCompleted() {
    this.completedToDos.clear();
  }

  public void clearNonCompleted() {
    this.toDoList.clear();
  }

  public void clearAll() {
    this.toDoList.clear();
    this.completedToDos.clear();
  }

  public void markCompleted(int index) { // index begins with 1
    index--;

    ToDo removedToDo = toDoList.remove(index);
    completedToDos.add(removedToDo);
  }

  public void markAllCompleted() {
    while (!toDoList.isEmpty()) {
      completedToDos.add(toDoList.removeLast());
    }
  }

  public void markAllNotCompleted() {
    while (!completedToDos.isEmpty()) {
      toDoList.add(completedToDos.removeLast());
    }
  }
}