import java.util.*;
class MyArrayQ
{ Scanner scan = new Scanner(System.in);
  int arr[];
  int front;
  int rear;
  int size,capacity;
  public MyArrayQ(int capacity)
  {
    this.capacity = capacity;
    arr = new int[this.capacity];
    front = this.size=0;
    rear = capacity-1;

  }
  public void enquee(int item)
  {
    if(isFull(this))
      System.out.println("Overflow!");
    else
    {
      this.rear = (this.rear + 1)%this.capacity;
      this.arr[this.rear] = item;
      this.size =  this.size + 1;
      System.out.println(item + " Enqueued");
    }

  }

  public int dequee()
  {
    if(isEmpty(this))
     return 0;
    else
    {
      int item =  this.front;
      this.front = (this.front + 1)%this.capacity;
      this.size = this.size -1;
      return item;
    }
  }
  public boolean isEmpty(MyArrayQ q)
  {
    return  (q.size == 0);

  }

  public boolean isFull(MyArrayQ q)
  {
    return  (q.size==q.capacity);


    //We can also use
    //return(this.size == this.capacity)
  }
  public int front()
  {
    if (isEmpty(this))
      return 0;
    else return this.arr[this.front];
  }
  public int rear()
  {
    if (isEmpty(this))
      return 0;
    else return this.arr[this.rear];
  }
  public static void main(String[] args) {
    MyArrayQ myQ =  new MyArrayQ(100);
    myQ.enquee(10);
    myQ.enquee(20);
    myQ.enquee(30);
    System.out.println(myQ.front() + " dequee from queue");
    myQ.dequee();
    System.out.println("Front of the queue is: " + myQ.front());
    System.out.println("Rear of the queue is: " + myQ.rear());
  }
}
