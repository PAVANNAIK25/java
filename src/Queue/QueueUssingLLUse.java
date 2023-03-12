package Queue;

public class QueueUssingLLUse {

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		QueueUsingLL <Integer> queue = new QueueUsingLL<>();
		System.out.println("Is Empty"+" "+ queue.isEmpty());
		queue.enqueue(5);
		queue.enqueue(3);
		queue.enqueue(10);
		queue.enqueue(100);
		queue.enqueue(4);
		System.out.println(queue.dequeue());
		
		
		System.out.println(queue.dequeue());
		System.out.println("Front:"+" "+ queue.front());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
		System.out.println("Size"+" "+ queue.size());
		System.out.println("Is Empty"+" "+ queue.isEmpty());
		System.out.println("Front:"+" "+ queue.front());
	}


}

