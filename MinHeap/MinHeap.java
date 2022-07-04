import java.util.NoSuchElementException;
import java.util.Arrays;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    	public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    	private T[] backingArray;
    	private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    	public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        	backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    	}

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    	public void add(T data) {
      	if (data == null) {
			throw new IllegalArgumentException("Cannot add null data");
		}
		else if (size == 0) {
			backingArray[1] = data;
			size++;
		}
		else {
			if (size == backingArray.length-1) {
				backingArray = resize(backingArray, backingArray.length*2);
			}
			int i = size+1;
			backingArray[i] = data;
			while (backingArray[i/2].compareTo(backingArray[i]) > 0) {
				T storage = backingArray[i/2];
				backingArray[i/2] = backingArray[i];
				backingArray[i] = storage;
				i = i/2;
				if (i == 1) {
					break;
				}
			}
			size++;
		}
    	}

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    	public T remove() {
		int n = 1;
		T value = backingArray[n];
       	if (size == 0) {
			throw new NoSuchElementException("Cannot remove from an empty heap");
		}
		//Step 1
		backingArray[n] = backingArray[size];
		backingArray[size] = null;
		size--;

		//Step 2
		while (n <= size/2) {
			if (backingArray[2*n+1] == null) {
				if (backingArray[n].compareTo(backingArray[2*n])>0) {
					T storage = backingArray[n];
					backingArray[n] = backingArray[2*n];
					backingArray[2*n] = storage;
				}
				break;
			}
			else if (backingArray[2*n+1] != null && backingArray[2*n] != null) {
				if (backingArray[n].compareTo(backingArray[2*n])<0 && backingArray[n].compareTo(backingArray[2*n+1])<0) {
					break;
				}
				if (backingArray[n].compareTo(backingArray[2*n])>0 || backingArray[n].compareTo(backingArray[2*n+1])>0) {
					if (backingArray[2*n].compareTo(backingArray[2*n+1]) < 0) {
						T storage = backingArray[n];
						backingArray[n] = backingArray[2*n];
						backingArray[2*n] = storage;
						n = 2*n;
					}
					else if (backingArray[2*n].compareTo(backingArray[2*n+1]) > 0) {
						T storage = backingArray[n];
						backingArray[n] = backingArray[2*n+1];
						backingArray[2*n+1] = storage;
						n = 2*n+1;
					}
				}
			}
		}
		return value;
    	}

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
   	 public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        	return backingArray;
    	}

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    	public int size() {
        // DO NOT MODIFY THIS METHOD!
        	return size;
    	}

	private T[] resize(T[] arr, int capacity){
		T[] temp = (T[]) new Comparable[capacity];
		for (int i = 0; i < arr.length; i++){
			temp[i] = arr[i];
		}
		arr = temp;
		return arr; 
	}

	public void print(){
		int i;
		if (size == 0) {
			System.out.printf("\nArray is Empty\n");
			return;
		}
		for (i = 0; i < backingArray.length; i++){
			System.out.printf(" %d <--", backingArray[i]);
		}
		return;
	}

	public static void main(String[] args) {
		MinHeap<Integer> backingArray = new MinHeap<>();
		backingArray.add(0);
		backingArray.add(1);
		backingArray.add(2);
		backingArray.add(4);
		backingArray.add(3);
		backingArray.add(5);
		backingArray.add(7);
		backingArray.add(6);
		backingArray.add(8);
		backingArray.add(9);
		backingArray.add(10);
		backingArray.add(11);
		backingArray.add(12);
		backingArray.add(13);
		backingArray.remove();
		backingArray.remove();
		
		backingArray.print();
	}
}