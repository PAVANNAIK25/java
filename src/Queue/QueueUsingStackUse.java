package Queue;

public class QueueUsingStackUse {

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
		
		System.out.println("Is Empty"+" "+ queue.isEmpty());
		queue.enqueue(5);
		queue.enqueue(3);
		System.out.println("Front:"+" "+ queue.front());
		queue.enqueue(10);
		System.out.println(queue.dequeue());
		queue.enqueue(100);
		System.out.println("Front:"+" "+ queue.front());
		queue.enqueue(4);
		
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
		System.out.println("Size"+" "+ queue.size());
		System.out.println("Is Empty"+" "+ queue.isEmpty());
	}

}
