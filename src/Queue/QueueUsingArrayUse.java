package Queue;

public class QueueUsingArrayUse {

	public static void main(String[] args)throws QueueEmptyException{ //QueueFullException  {
		// TODO Auto-generated method stub
		QueueUsingArray queue = new QueueUsingArray(5);
		
		System.out.println("Is Empty"+" "+ queue.isEmpty());
		queue.enqueue(5);
		queue.enqueue(3);
		queue.enqueue(10);
		queue.enqueue(100);
		queue.enqueue(4);
//		System.out.println(queue.dequeue());
		queue.enqueue(109);
		queue.enqueue(109);
		queue.enqueue(109);
		queue.enqueue(109);
		queue.enqueue(109);
		queue.enqueue(109);
		
//		System.out.println(queue.dequeue());
		System.out.println("Front:"+" "+ queue.front());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
		System.out.println("Size"+" "+ queue.size());
		System.out.println("Is Empty"+" "+ queue.isEmpty());
		System.out.println("Front:"+" "+ queue.front());
	}

}
