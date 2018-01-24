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

  }
}
