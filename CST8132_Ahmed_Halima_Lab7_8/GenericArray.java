/* 
 * Name: Halima Ahmed
 * Student ID:040825884
 * Course & Section: CST8132_302
 * Assignment:Lab7/Lab8
 * Date: November 19th,2018
 * Updated on: December 8th,2018 
 */

public class GenericArray<T> {

	/***
	 * The purpose of this class is to convert the given StringArray class into
	 * Generic that will read through the Bank system
	 * 
	 * @author Halima Ahmed
	 * @version 1.0
	 * @since 1.8
	 */

	/** The current capacity of the array **/
	private int capacity;
	/** The current size of the array **/
	private int size;
	/** The current array **/
	private T[] tArray;

	/** GenericArray version of previous stringArray **/
	public GenericArray() {
		// empty GenericArray with an initial capacity of 10
		this.capacity = 10;
	}

	/** GenericArray version of previous stringArray **/
	// initializing the size of initial capacity
	// If initial Capacity is less than zero throw an IllegalArgumentException

	public GenericArray(int initialCapacity) throws IllegalArgumentException {
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		size = 0;
		capacity = initialCapacity;
		tArray = (T[]) new Object[initialCapacity];
	}

	/** GenericArray version of previous stringArray **/
	public GenericArray(GenericArray<T> sa) throws NullPointerException {
		this(sa.capacity);

		if (sa == null)
			throw new NullPointerException();

		size = sa.size;

		for (int i = 0; i < size; i++) {
			tArray[i] = (T) sa.tArray[i];
		}
	}

	/** GenericArray version of previous stringArray **/
	public void add(T s) throws NullPointerException {

		try {
			add(size, s);
		} catch (NullPointerException ex) {
			throw ex;
		} catch (IndexOutOfBoundsException ex) {

		}
	}

	/** GenericArray version of previous stringArray **/
	public void add(int index, T s) throws NullPointerException, IndexOutOfBoundsException {
		if (s == null)
			throw new NullPointerException();

		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == capacity) {
			ensureCapacity(capacity + capacity / 2);
		}
		for (int i = size; i > index; i--) {
			tArray[i] = tArray[i - 1];
		}

		tArray[index] = s;
		size++;
	}

	/** return the capacity **/
	public int capacity() {
		return capacity;
	}

	/** GenericArray version of previous stringArray **/
	public void clear() {
		for (; size > 0; size--) {
			tArray[size - 1] = null;
		}
	}

	/** GenericArray version of previous stringArray **/
	// return the index and throw NullPointerException if its less than 1
	public boolean contains(T s) throws NullPointerException {
		return indexOf(s) > -1;
	}

	/** GenericArray version of previous stringArray **/
	// minCapacity is less than or equal to zero throw CapacityOutOfBoundsException

	public void ensureCapacity(int minCapacity) throws CapacityOutOfBoundsException {

		if (minCapacity <= size) {
			throw new CapacityOutOfBoundsException();
		}

		if (capacity < minCapacity) {

			capacity = minCapacity;

			T[] temp = (T[]) new Object[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = tArray[i];
			}
			tArray = temp;
		}
	}

	/** GenericArray version of previous stringArray **/
	public T get(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return tArray[index];
	}

	/** GenericArray version of previous stringArray **/
	// If s is null throw NullPointerException
	public int indexOf(T s) throws NullPointerException {
		if (s == null) {
			throw new NullPointerException();
		}

		int found = -1;

		for (int i = 0; i < size; i++) {
			if (s.equals(tArray[i])) {
				found = i;
				break;
			}
		}

		return found;
	}

	// checking if the array is empty
	public boolean isEmpty() {
		return size == 0;
	}

	/** GenericArray version of previous stringArray **/
	// return old string
	// if index is greater than or equal to the size or less than zero throw
	// IndexOutOfBoundsException
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		T oldString = tArray[index];

		for (; index < size; index++) {
			tArray[index] = tArray[index + 1];
		}
		size--;
		return oldString;
	}

	/** GenericArray version of previous stringArray **/
	// return the index and throw NullPointerException
	public boolean remove(T s) throws NullPointerException {
		int index = indexOf(s);
		remove(index);
		return index > -1;
	}

	/** GenericArray version of previous stringArray **/
	// throw IndexOutOfBoundsException if the index is greater than size or less
	// than index
	// if s is null throw NullPointerException
	public T set(int index, T s) throws IndexOutOfBoundsException, NullPointerException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (s == null) {
			throw new NullPointerException();
		}

		T oldString;

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

	/** GenericArray version of previous stringArray **/
	// return the size
	public int size() {
		return size;
	}
}
