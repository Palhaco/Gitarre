public class RingBuffer {
	
    int maxCapacity = 0;
    int first = 0;
    int last = 0;
    int size = 0;
	
    double[] buffer;
	
    /**
     * constructor to create an empty buffer, with given max capacity
     * @param capacity
     */
    RingBuffer(int capacity)
    {
	maxCapacity = capacity;
	buffer = new double[maxCapacity];
    }  
	  
    /**
     * return number of items currently in the buffer
     * @return
     */
    public int size()  
    {
	return size;
    }   
             
    /**
     * is the buffer empty (size equals zero)?
     * @return
     */
    public boolean isEmpty()
    {
	return size == 0;
    }    
	  
    /**
     * is the buffer full  (size equals capacity)?
     * @return
     */
    public boolean isFull()   
    {
	return maxCapacity == size;
    } 
	  
    /**
     * add item x to the end
     * @param x
     */
    public void enqueue(double x) 
    {
	if(isFull())
	    return;
		  
	size++;
		  
	last++;
	if (last >= maxCapacity)
	    last = 0; 
		  
	buffer[last] = x;
    } 
	  
    /**
     * delete and return item from the front
     * @return
     */
    public double dequeue()
    {
	if(isEmpty())
	    return Double.NaN;
		  
	size--;
		  
	first++;
	if (first >= maxCapacity)
	    first = 0;
		  
	return buffer[first];
    }
	  
    /**
     * return (but do not delete) item from the front
     * @return
     */
    public double peek() 
    {
	if(isEmpty())
	    return Double.NaN;
		  
	return buffer[first];  
    } 
}
