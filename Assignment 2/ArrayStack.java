/*	Assignment: HW2 Q1
 * 	Purpose: 	implementing an array to act like an Array List
 * 
 * 	Code written by: Logan White
 * 
 * 
 */


public class ArrayStack<E>{
	
	private Object[] nowArray; 
	//REQ specified initial capacity
    private static final int InitCapacity = 10;  
	private int size; 


    public ArrayStack() {
    	//REQ Constructing stack with initial capacity
	   	nowArray = new Object[InitCapacity];  
        size = 0;
    }
    
    private void resize() {
        //REQ Double the size of the array when it's full
        Object[] newArray = new Object[nowArray.length * 2];
        System.arraycopy(nowArray, 0, newArray, 0, nowArray.length);
        nowArray = newArray;
    }
	
	public int getSize() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		return (E) nowArray[size-1];
	}
	
	public void push(E o) {
        if (size == nowArray.length) {
            resize();
        }
		nowArray[size +1] = o;
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		try {
		    Object lastElement = nowArray[nowArray.length - 1];

		    Object[] newArray = new Object[nowArray.length - 1];
		    System.arraycopy(nowArray, 0, newArray, 0, newArray.length);

		    nowArray = newArray;

		    return (E) lastElement;
		}
		catch(Exception e){
			throw new IndexOutOfBoundsException("Array is empty");
		}
	}
	
	public boolean isEmpty() {
		if(size > 0){
			return false;
		}
		else {
			return true;
		}
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack: [");
        for (int i = 0; i < size; i++) {
            sb.append(nowArray[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}