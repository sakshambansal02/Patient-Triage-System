package priorityqueue;

import java.util.Comparator;

public class Heap<T> implements PriorityQueueADT<T> {

  private int numElements;
  private T[] heap;
  private boolean isMaxHeap;
  private Comparator<T> comparator;
  private final static int INIT_SIZE = 5;

  /**
   * Constructor for the heap.
   * @param comparator comparator object to define a sorting order for the heap elements.
   * @param isMaxHeap Flag to set if the heap should be a max heap or a min heap.
   */
  public Heap(Comparator<T> comparator, boolean isMaxHeap) {
      //TODO: Implement this method.
      this.comparator = comparator;
		this.isMaxHeap = isMaxHeap;
		heap = (T[]) new Object[INIT_SIZE];
		numElements = 0;
  }

  /**
   * This results in the entry at the specified index "bubbling up" to a location
   * such that the property of the heap are maintained. This method should run in
   * O(log(size)) time.
   * Note: When enqueue is called, an entry is placed at the next available index in 
   * the array and then this method is called on that index. 
   *
   * @param index the index to bubble up
   * @throws IndexOutOfBoundsException if invalid index
   */
  public void bubbleUp(int index) {
      //TODO: Implement this method.
      T addNewElem = heap[numElements - 1];
		while( compareElements(getHeadValue(index), addNewElem) < 0 && index > 0) {
			heap[index] = getHeadValue(index);
			index = headCounter(index);
		}
		heap[index] = addNewElem;
  }

  private int headCounter(int index) {
    return (index - 1) / 2;
  }

  private T getHeadValue(int index) {
    return heap[headCounter(index)];
  }

  /**
   * This method results in the entry at the specified index "bubbling down" to a
   * location such that the property of the heap are maintained. This method
   * should run in O(log(size)) time.
   * Note: When remove is called, if there are elements remaining in this
   *  the bottom most element of the heap is placed at
   * the 0th index and bubbleDown(0) is called.
   * 
   * @param index
   * @throws IndexOutOfBoundsException if invalid index
   */
  public void bubbleDown(int index) {
      //TODO: Implement this method.
      int flag = 0;
		boolean nextElem = true;
    T base= heap[0];
    int nextChildIndex;
    T childValue;
    
			while (nextElem) {
				nextChildIndex = childLeftIndex(flag);
				if (nextChildIndex <= index) {
					childValue = getValueLeftKid(flag);
					if (childRightIndex(flag) <= index && compareElements(getValueRightKid(flag), childValue) > 0) {
						nextChildIndex = childRightIndex(flag);
						childValue = getValueRightKid(flag);
					}
					if (compareElements(childValue, base) > 0) {
						heap[flag] = childValue;
						flag = nextChildIndex;
          } 
          else {
						nextElem = false;
					}
				} 
        else {
					nextElem = false;
				}
			}
			heap[flag] = base;
  }

  private int childLeftIndex(int index) {
    return (index * 2) + 1;
  }
  private int childRightIndex(int index) {
    return (index * 2) + 2;
  }
  private T getValueLeftKid(int index) {
    return heap[childLeftIndex(index)];
  }
  private T getValueRightKid(int index) {
    return heap[childRightIndex(index)];
  }
  /**
   * Test for if the queue is empty.
   * @return true if queue is empty, false otherwise.
   */
  public boolean isEmpty() {
    boolean isEmpty = false;
      //TODO: Implement this method.
      if(numElements == 0){
        isEmpty = true;
      }
    return isEmpty;
  }

  /**
   * Number of data elements in the queue.
   * @return the size
   */
  public int getSize(){
    int size = -100;
      //TODO: Implement this method.
      size = numElements;
      return size;
  }

  /**
   * Compare method to implement max/min heap behavior. It changes the value of a variable, compareSign, 
   * based on the state of the boolean variable isMaxHeap. It then calls the compare method from the 
   * comparator object and multiplies its output by compareSign.
   * @param element1 first element to be compared
   * @param element2 second element to be compared
   * @return positive int if {@code element1 > element2}, 0 if {@code element1 == element2}, 
   * negative int otherwise (if isMaxHeap),
   * return negative int if {@code element1 > element2}, 0 if {@code element1 == element2}, 
   * positive int otherwise (if ! isMinHeap).
   */
  public int compareElements(T element1 , T element2) {
    int result = 0;
    int compareSign =  -1;
    if (isMaxHeap) {
      compareSign = 1;
    }
    result = compareSign * comparator.compare(element1, element2);
    return result;
  }

  /**
   * Return the element with highest (or lowest if min heap) priority in the heap 
   * without removing the element.
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T peek() throws QueueUnderflowException {
     T data = heap[0];
      //TODO: Implement this method.
      if (data == null){
			throw new QueueUnderflowException();
    }
return data;
}  

  /**
   * Removes and returns the element with highest (or lowest if min heap) priority in the heap.
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T dequeueElement() throws QueueUnderflowException{
    T data = null;
    int lastIndex;
    T lastValue;
      //TODO: Implement this method.
      lastIndex = numElements - 1;
      data = heap[0];
      lastValue = heap[lastIndex];
      if (lastIndex > 0) {
        heap[0] = lastValue;
        bubbleDown(numElements-1);
      }
      heap[lastIndex] = null;
      numElements--;
      return data;
  }

  /**
   * Enqueue the element.
   * @param the new element
   */
  public void enqueueElement(T newElement) {
      //TODO: Implement this method.
      increaseLength();
      heap[numElements++] = newElement;
      bubbleUp(numElements - 1);
    }

    private void increaseLength() {
      T[] temp;
      int flag;
      if (numElements == heap.length) {
        temp = (T[]) new Object[heap.length * 2];
        for (flag = 0; flag < numElements; flag++)
          temp[flag] = heap[flag];
        heap = temp;
      }
    }
}

  
  
