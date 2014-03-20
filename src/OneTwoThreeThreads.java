
public class OneTwoThreeThreads extends Thread {
	public OneTwoThreeThreads(int threadNumber, boolean first)
	{
		this.threadNumber = threadNumber;
		this.first = first;
	}
	
	public void init(Thread nextThread)
	{
		this.nextThread = nextThread;
	}
	
	private int threadNumber;
	private boolean first;
	private Thread nextThread;

	@Override
	public void run() {
		synchronized(this) {
			while (true)
			{
				if (!first)
				{
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					first = false;
				}
				System.out.printf("%d", threadNumber);
				synchronized(nextThread)
				{
					nextThread.notify();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		OneTwoThreeThreads thread1 = new OneTwoThreeThreads(1, true);
		OneTwoThreeThreads thread2 = new OneTwoThreeThreads(2, false);
		OneTwoThreeThreads thread3 = new OneTwoThreeThreads(3, false);
		thread1.init(thread2);
		thread2.init(thread3);
		thread3.init(thread1);
		thread1.start();
		thread2.start();
		thread3.start();
		}
	}
}
