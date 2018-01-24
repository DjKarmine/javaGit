/*
--Linked List implementation
--Linked List Traversal
*/
class MyList  {
  Node head; //Head of LinkedList

  //class defined for a singly-linked Node
  static class Node {
    int data;
    Node next;
    Node(int val)
    {
      this.data=val;
    }
  }

  //recursive function defined to print and traverse the LinkedList
  void printList(Node head)
   {
       if(head != null){
           System.out.print(head.data + " ");
           printList(head.next);
       }
       else
           return ;
   }   //OR we can also implement printList function as folowing
   /* public void printList()
    {
        Node n = head;
        while (n != null)
        {
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
     */

     //function to insert at the begining of the linked list
     public void insertAtBeginning(int val)
     {
       Node new_node = new Node(val); //create a new node
       new_node.next = head; //make it point to the current head node
       head = new_node; //now allocate the address of new_node to head node
     }
     //function to insert at the end of the linked list
     public void insertAtEnd(int val)
     {
       Node new_node = new Node(val);

       //check if list is empty,then insett the node as it is
       if(head == null)
       {
         head = new Node(val);
         return;
       }

       //as it will be the last node in the list make it point to null
       new_node.next = null;
       //now traverse to the last node in the current list and make it point to the new_node
       Node last = head;
       while(last.next != null)
       {
         last = last.next;
       }

       last.next = new_node;
       return;
     }

    public void insertInMiddle(int val,Node prev_node)
    {
      if (prev_node == null)
      {
        System.out.println("The given previous node cannot be null");
        return;
      }
      Node new_node = new Node(val);

      new_node.next = prev_node.next;

      prev_node.next = new_node;

    }

  public static void main(String[] args) {
//main function begins
    MyList klist = new  MyList(); //create a new LinkedList
    klist.head = new Node(12); //assign the head a value
    Node second = new Node(45); //assign the next two nodes their values
    Node third = new Node(78);

    klist.head.next = second; //assign the address of second node to head node
    second.next = third;//assign the address of third node to second node
    third.next = null;//assign the value of null to the last node

    klist.printList(klist.head); //call the printList function to print ab=nd traverse the LinkedList

    klist.insertAtBeginning(89);
    System.out.println();
    klist.printList( klist.head);

    klist.insertAtEnd(1);
    System.out.println();
    klist.printList( klist.head);

    klist.insertInMiddle(7,klist.head.next);
    System.out.println();
    klist.printList( klist.head);

  }
}
