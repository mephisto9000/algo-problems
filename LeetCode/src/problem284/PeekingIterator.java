package problem284;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
 
 Iterator<Integer> iterator;
 
 boolean hasNextVal = true;
 Integer nextInt;

	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
	    
     if (iterator.hasNext())
     {
         nextInt = iterator.next();            
     }
     else
         hasNextVal = false;
	}
 

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
     
     if (hasNextVal)
         return nextInt;
     return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (hasNextVal)
     {
         int tmp = nextInt;
         
         if (iterator.hasNext())
         {
             nextInt = iterator.next();
             
         }
         else
             hasNextVal = false;
         
         return tmp;
     }
     else
         //throw new NoSuchElementException("no such element");
         return null;
	}

	@Override
	public boolean hasNext() {
	    return hasNextVal;
	}
}