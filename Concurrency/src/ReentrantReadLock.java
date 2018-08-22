import java.util.Map;

public class ReentrantReadLock {
	
	Map<Thread, Integer> map;
	int readers;
	int writers;
	int writeRequests;
	
	public synchronized void readLock() {
		while (!canReadLock()) 
			wait();
		
		readers ++;
		map.put(Thread.currentThread(), map.get(Thread.currentThread())+1);
	}
	
	boolean canReadLock() {
		if (writers > 0) return false;
		if (map.get(Thread.currentThread())!= null) return true;
		if (writeRequests > 0) return false;
		
		return true;
		
	}
	
	public synchronized void readUnlock() {
		readers --;
		Integer x = map.getOrDefault(Thread.currentThread(), 0);
		//if (x > 0)
		map.put(Thread.currentThread(), x - 1);
		notifyAll();
	}

}
