import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DiningPhilosophers {
	
	
	public void play()
	{
		Chopstick c1 = new Chopstick();
		Chopstick c2 = new Chopstick();
		Chopstick c3 = new Chopstick();
		Chopstick c4 = new Chopstick();
		Chopstick c5 = new Chopstick();
		
		Philosopher p1 = new Philosopher("Musa",  c1, c2);
		Philosopher p2 = new Philosopher("Sayat", c2, c3);
		Philosopher p3 = new Philosopher("Igor",  c3, c4);
		Philosopher p4 = new Philosopher("Asset", c4, c5);
		Philosopher p5 = new Philosopher("Askar", c5, c1);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		Thread t5 = new Thread(p5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		
	}
	
	public class Chopstick{
		Lock lock;
		Philosopher owner;
		boolean isOwned = false;
		
		public Chopstick()
		{
			super();
			lock = new ReentrantLock();
		}
		public boolean acquire(Philosopher callingPhilosopher)
		{
			boolean result =  lock.tryLock();
			
			if (result)
			{
				owner = callingPhilosopher;
				isOwned = true;
			}
			
			return result;

		}
		
		public boolean release(Philosopher callingPhilosopher)
		{
			
			if (isOwned == true && owner == callingPhilosopher)
			{
				isOwned = false;
				lock.unlock();			
				return true;
			}
			else
				return false;
			
		}
	}
	
	public class Philosopher implements Runnable
	{
		String name;
		Chopstick left;
		Chopstick right;
		boolean holdingLeft = false;
		boolean holdingRight = false;
		
		public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick)
		{
			super();
			this.name  = name;
			this.left  = leftChopstick;
			this.right = rightChopstick;
			holdingLeft = false;
			holdingRight = false;
		}
		
		public void run(){
			
			
			
			int eatTimes = 10;
			int rightChopWaitCycles;
			
			System.out.println(name+" says HI");
			
			while (eatTimes > 0)
			{
				
				while (!holdingLeft)
				{
					if (left.acquire(this))
					{
						holdingLeft = true;
						System.out.println(name+ " holds left chopstick");
					}
					else
					{
						holdingLeft = false;
						System.out.println(name+ " waits for left chopstick");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				rightChopWaitCycles = 5;
				while (holdingLeft && !holdingRight)
				{
					
										
					if (right.acquire(this))
					{
						holdingRight = true;
						System.out.println(name+ " holds right chopstick");
						
					}
					else
					{
						holdingRight = false;
						System.out.println(name+ " waits for right chopstick");
						
						if (rightChopWaitCycles > 0)
						{
						
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}							
						
						rightChopWaitCycles --;
						}
						else
						{
							if (left.release(this))
							{
								System.out.println(name+ " releases left chopstick");
								holdingLeft = false;
								break;
							}
						}
							
					}
				}
				
				if (holdingLeft && holdingRight)
				{
					System.out.println(name+" is eating");
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(name+" done eating");
					eatTimes --;
					holdingLeft = left.release(this);
					holdingRight = right.release(this);
					//break;	
							
				}
				
			}
			
			System.out.println(name+" is full");
		}
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Chopstick a1 = new Chopstick();
		DiningPhilosophers game = new DiningPhilosophers();
		game.play();

	}

}
