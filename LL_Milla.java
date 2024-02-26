import java.util.*;

public class LL_Milla<T> implements LinkedListInterface<T> 
{
  private LLNode_Milla<T> first;

  public LL_Milla()
  {
    first = null;
  }

  public boolean contains(T element) {
    LLNode_Milla<T> current = first;
    while (current != null) {
      if (current.getData().equals(element)) {
        return true;
      }
      current = (LLNode_Milla)current.getNext();
    }
  return false;
  }

  public int indexOf(T element) {
    LLNode_Milla<T> current = first;
    int index = 0;
    while (current != null) {
      if (current.getData().equals(element)) {
        return index;
      }
      current = current.getNext();
      index++;
    }
    return -1;
  }

  public int lastIndexOf(T element) {
    LLNode_Milla<T> current = first;
    int lastIndex = -1;
    int index = 0;
    while (current != null) {
      if (current.getData().equals(element)) {
        lastIndex = index;
      }
      current = current.getNext();
      index++;
    }
    return lastIndex;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    int count = 0;
    LLNode_Milla<T> current = first;
    while (current != null) {
      count++;
      current = current.getNext();
    }
    return count;
  }

  public T get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    LLNode_Milla<T> current = first;
    for(int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  public void set(int index, T element) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    LLNode_Milla<T> current = first;
    for(int i = 0; i < index; i++) {
      current = current.getNext();
    }
    current.setData(element);
  }

  public void clear() {
    first = null;
  }

  public void add(T element) {
    LLNode_Milla<T> newNode = new LLNode_Milla<>(element);

    if (first == null) {
      first = newNode;
    } else {
      LLNode_Milla<T> current = first;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
  }

  public void add(int index, T element) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    LLNode_Milla<T> newNode = new LLNode_Milla<>(element);

    if(index ==0) {
      newNode.setNext(first);
    first = newNode;
  } else {
    LLNode_Milla<T> current = first;
    for (int i = 0; i < index - 1; i++){
      current = current.getNext();
    }
    newNode.setNext(current.getNext());
    current.setNext(newNode);
  }
    }

  public T remove(int index) {
    if(index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    LLNode_Milla<T> removedElement;

    if (index == 0) {
      removedElement = first;
      first = first.getNext();
    } else {
      LLNode_Milla<T> current = first;
      for(int i = 0; i < index - 1; i++) {
        current = current.getNext();
      }
      removedElement = current.getNext();
      current.setNext(removedElement.getNext());
    }
    return removedElement.getData();
  }

  public boolean remove(T element) {
    LLNode_Milla<T> current = first;
    LLNode_Milla<T> previous = null;

    while (current != null) {
      if (current.getData().equals(element)) {
        if(previous == null) {
          first = current.getNext();
        } else {
          previous.setNext(current.getNext());
        }
        return true;
      }
      previous = current;
      current = current.getNext();
    }
    return false;
  }
  
}