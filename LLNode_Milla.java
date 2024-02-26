public class LLNode_Milla<T> implements Node<T> {
  private T data;
  private LLNode_Milla<T> next;

  public LLNode_Milla(T data){
    this.data = data;
    this.next = null;
  }
  public LLNode_Milla<T> getNext(){
    return next;
  }

  public void setNext(Node <T> newNext){
    this.next = (LLNode_Milla<T>) newNext; 
  }

  public T getData(){
    return data;
  }

  public void setData(T newData){
    this.data = newData;
  }
}