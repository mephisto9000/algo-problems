import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import java.

public class LocksTryouts {

	Lock lock;
	int counter = 0;
	
	public LocksTryouts()
	{
		super();
		lock = new ReentrantLock();
	}
	
	public void process() throws InterruptedException
	{
		lock.lock();
		
		counter ++;
		
		lock.unlock();
		
		lock.wait(); //wait();
		lock.notify();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocksTryouts lt = new LocksTryouts();
		System.out.println(lt.counter);
		lt.process();
		System.out.println(lt.counter);
		
		//wait();

	}

}
