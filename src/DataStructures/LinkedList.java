package DataStructures;

public class LinkedList<T> implements List<T>{
    private Node<T> head;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*  public LinkedList(Node<T> head) {
          this.head = head;
      }
  */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void addToFront(T data) {
        Node<T> newNode = new Node<T>();
        newNode.setNext(head);
        newNode.setData(data);
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        Node<T> temp = head;
        if(head == null)
        {
            throw new EmptyListException();
        }
        head = temp.getNext();
        size--;
        return temp.getData();
    }
}