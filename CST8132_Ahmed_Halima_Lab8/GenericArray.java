/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment: Lab 8
 * Date: November 19th, 2018  
 */

public class GenericArray<T> {

	/***
	 * The purpose of this class is using Java generics to allow your GenericArray
	 * class to store any generic types
	 * 
	 * @author Halima Ahmed
	 * @version 1.0
	 * @since 1.8
	 */

	/** The current capacity of the array**/ 
	private int capacity;
	/** The current size of the array**/ 
	private int size;
	/** The current array**/ 
	private Object[] tArray;

	/** GenericArray version of previous stringArray**/
	public GenericArray() {
		//empty GenericArray with an initial capacity of 10 
		this.capacity = 10;
	}
	/** GenericArray version of previous stringArray**/
	public GenericArray(GenericArray<T> Object[], int initialCapacity) throws IllegalArgumentException {
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		this.size = 0;
		capacity = initialCapacity;
		tArray = (Object[]) new Object[initialCapacity];
	}
	/** GenericArray version of previous stringArray**/
	public GenericArray(GenericArray<T> sa) throws NullPointerException {
		if (sa == null)
			throw new NullPointerException();

		size = sa.size;
		capacity = sa.capacity();
		tArray = new Object[capacity()];

		for (int i = 0; i < sa.tArray.length; i++) {

			tArray[i] = sa.tArray[i];
			tArray[i] = new Object();
		}
	}
	/** GenericArray version of previous stringArray**/
	public void add(GenericArray<T> s) throws NullPointerException {
		try {
			add(s, size);
		} catch (NullPointerException ex) {
			throw ex;
		} catch (IndexOutOfBoundsException ex) {

		}
	}
	/** GenericArray version of previous stringArray**/
	public void add(GenericArray<T> s, int index) throws NullPointerException, IndexOutOfBoundsException {
		if (s == null)
			throw new NullPointerException();

		if (index > size)
			throw new IndexOutOfBoundsException();

		if (size == capacity)
			ensureCapacity(capacity + capacity / 2);

		for (int i = size; i > index; i--) {
			tArray[i] = tArray[i - 1];
		}

		tArray[index] = s;

		size++;
	}
	/**Returns the capacity**/
	public int capacity() {
		return capacity;
	}
	/** GenericArray version of previous stringArray**/
	public void clear(GenericArray<T> clear) {
		for (; size > 0; size--)
			tArray[size - 1] = null;
	}
	/** GenericArray version of previous stringArray**/
	public boolean contains(GenericArray<T> s) throws NullPointerException {
		return indexOf(s) > -1;
	}
	/** GenericArray version of previous stringArray**/
	public void ensureCapacity(int minCapacity) throws CapacityOutOfBoundsException {
		if (minCapacity <= size)
			throw new CapacityOutOfBoundsException();

		if (capacity < minCapacity) {
			capacity = minCapacity;

			Object[] temp = (Object[]) new Object[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = tArray[i];
			}
			tArray = temp;
		}
	}
	/** GenericArray version of previous stringArray**/
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		return tArray[index];
	}
	/** GenericArray version of previous stringArray**/
	public int indexOf(GenericArray<T> s) throws NullPointerException {
		if (s == null)
			throw new NullPointerException();

		int found = -1;

		for (int i = 0; i < size; i++) {
			if (s.equals(tArray[i])) {
				found = i;
				break;
			}
		}

		return found;
	}
	/** GenericArray version of previous stringArray**/
	public boolean isEmpty(GenericArray<T> tArray) {
		return size == 0;
	}
	/** GenericArray version of previous stringArray**/
	public Object remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Object oldString = tArray[index];

		for (; index < size; index++) {
			tArray[index] = tArray[index + 1];
		}

		size--;
		return oldString;
	}
	/** GenericArray version of previous stringArray**/
	public boolean remove(GenericArray<T> s) throws NullPointerException {
		int index = indexOf(s);
		remove(index);
		return index > -1;
	}
	/** GenericArray version of previous stringArray**/
	public Object set(int index, String s) throws IndexOutOfBoundsException, NullPointerException {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (s == null)
			throw new NullPointerException();

		Object oldString;

		if (index > capacity) {
			ensureCapacity(index + 1);
			oldString = null;
		} else {
			oldString = tArray[index];
		}

		if (index >= size) {
			size = index + 1;
		}

		tArray[index] = s;
		return oldString;
	}
	
	/**Returns the size**/
	public int size() {	
		return size;
	}

}
