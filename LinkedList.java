import java.util.HashSet;
import java.util.Stack;

public class LinkedList {
  public static void add(LinkedListNode head, int data) {
    LinkedListNode curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = new LinkedListNode(data);
  }

  public static void addMultiple(LinkedListNode head, int... dataArr) {
    LinkedListNode curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    for (int i = 0; i < dataArr.length; i++) add(curr, dataArr[i]);
  }

  public static void printList(LinkedListNode head) {
    LinkedListNode curr = head;
    while (curr != null) {
      System.out.printf("%d -> ", curr.data);
      curr = curr.next;
    }
    System.out.println("NULL");
  }

  public static boolean containsDuplicates(LinkedListNode head) {
    HashSet<Integer> listValues = new HashSet<>();
    LinkedListNode curr = head;
    while (curr != null) {
      if (listValues.contains(curr.data)) return true;
      else {
        listValues.add(curr.data);
        curr = curr.next;
      }
    }
    return false;
  }

  public static void removeAtIndex(LinkedListNode head, int index) {
    LinkedListNode curr = head;
    LinkedListNode prev = curr;
    for (int i = 0; i < index; i++) {
      prev = curr;
      curr = curr.next;
    }
    prev.next = curr.next;
  }

  public static void removeDupsWithBuffer(LinkedListNode head) {
    HashSet<Integer> listValues = new HashSet<>();
    LinkedListNode curr = head;
    LinkedListNode prev = null;
    while (curr != null) {
      if (listValues.contains(curr.data)) {
        prev.next = curr.next;
      } else {
        listValues.add(curr.data);
        prev = curr;
      }
      curr = curr.next;
    }
  }

  public static void removeDupsNoBuffer(LinkedListNode head) {
    LinkedListNode curr = head;
    while (curr != null) {
      LinkedListNode runner = curr;
      while (runner.next != null) {
        if (runner.next.data == curr.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      curr = curr.next;
    }
  }
  
  public static void removeKthToLastElement(LinkedListNode head, int listSize, int k) {
    int index = listSize - k;
    removeAtIndex(head, index);
  }
  
  public static void removeKthToLastElement(LinkedListNode head, int k) {
    int listSize = 0;
    LinkedListNode curr = head;
    while (curr != null) {
      listSize++;
      curr = curr.next;
    }

    removeKthToLastElement(head, listSize, k);
  }

  public static void removeNonBeginningOrEndElem(LinkedListNode node) {
    System.out.printf("The node that will be taken out is %d.%n", node.data);
    node.data = node.next.data;
    node.next = node.next.next;

  }
  
  // TODO
  // TEST
  public static void partition(LinkedListNode head, int partitionVal) {
    
  }

  public static LinkedListNode reverse(LinkedListNode head) {
    LinkedListNode prev = null, curr = head, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
    return head;
  }

  public static void printInReverse(LinkedListNode head) {
    if (head == null) {
      return;
    }
    printInReverse(head.next);
    System.out.println(head.data);
  }

  public static int get(LinkedListNode head, int index) {
    // Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    LinkedListNode curr = head;
    for (int i = 0; i < index; i++) curr = curr.next;
    
    return curr.data;
}
    
  public static LinkedListNode addAtHead(LinkedListNode head, int data) {
    // Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    
    LinkedListNode newNode = new LinkedListNode(data);
    newNode.next = head;
    return newNode;
}

  public static LinkedListNode addAtTail(LinkedListNode head, int data) {
    // Append a node of value val as the last element of the linked list.
    LinkedListNode newNode = new LinkedListNode(data);
    
    LinkedListNode curr = head;
    if (curr == null) {
        return newNode;
    }
    while (curr.next != null) curr = curr.next;
    curr.next = newNode;
    return head;
}

  public static LinkedListNode addAtIndex(LinkedListNode head, int index, int data) {
    // Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
    
    int size = getSize(head);

    if (index > size) return head;

    if (index == 0) {
      return addAtHead(head, data);
    }

    if (index == size) {
      return addAtTail(head, data);
    }
    
    LinkedListNode newNode = new LinkedListNode(data);
    
    LinkedListNode curr = head, prev = null;
    for (int i = 0; i < index; i++) {
      prev = curr;
      curr = curr.next;
    }
    newNode.next = curr;
    prev.next = newNode;
    return head;
  }

  public static LinkedListNode deleteAtHead(LinkedListNode head) {
    if (head == null) return null;
    else return head.next;
  }

  public static LinkedListNode deleteAtTail(LinkedListNode head) {
    if (head == null) return null;
    if (head.next == null) {
      return null;
    }
    
    LinkedListNode curr = head;
    while (curr.next.next != null) curr = curr.next;
    curr.next = null;
    return head;
  }

  public static LinkedListNode deleteAtIndex(LinkedListNode head, int index) {
    // Delete the indexth node in the linked list, if the index is valid.
    int size = getSize(head);
    
    if (index < 0 || index >= size) return head;
    if (index == 0) {
      return deleteAtHead(head);
    }
    
    LinkedListNode curr = head, prev = null;
    for (int i = 0; i < index; i++) {
      prev = curr;
      curr = curr.next;
    }
    prev.next = curr.next;
    return head;
  }

  public static boolean isPalindrome(LinkedListNode head) {
    int size = getSize(head);
    
    if (size % 2 == 0) return isEvenPalindrome(head, size);
    else return isOddPalindrome(head, size);
}

public static int getSize(LinkedListNode head) {
    int size = 0;
    
    while (head != null) {
        head = head.next;
        size++;
    }
    
    return size;
}

public static boolean isEvenPalindrome(LinkedListNode head, int size) {
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0; i < size / 2; i++) {
        stack.push(head.data);
        head = head.next;
    }
    
    for (int i = 0; i < size / 2; i++) {
        if (head.data != stack.pop()) return false;
        head = head.next;
    }
    return true;
}

public static boolean isOddPalindrome(LinkedListNode head, int size) {
  Stack<Integer> stack = new Stack<>();

  for (int i = 0; i < size / 2; i++) {
    stack.push(head.data);
    head = head.next;
  }

  head = head.next;

  for (int i = 0; i < size / 2; i++) {
    if (head.data != stack.pop()) return false;
    head = head.next;
  }
  return true;
}

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(0);
    addMultiple(head, 1,2,1);
    System.out.println(isPalindrome(head));
  }

  public static class LinkedListNode {
    // instance vars
    private int data;
    private LinkedListNode next;

    // constructor
    public LinkedListNode(int data) {
      this.data = data;
      this.next = null;
    }

    // methods
    public int getData() {
      return this.data;
    }

    public void setData(int newData) {
      this.data = newData;
    }

    public LinkedListNode getNext() {
      return this.next;
    }

    public void setNext(LinkedListNode newNext) {
      this.next = newNext;
    }
  }
}
