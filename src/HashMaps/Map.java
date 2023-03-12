package HashMaps;

import java.util.ArrayList;

public class Map<K,V> {
	
	ArrayList<MapNode<K,V>> buckets;
	int count;
	static int numBuckets;
	
	public Map() {
		buckets= new ArrayList<>();
		numBuckets = 5;
		for(int i=0; i<numBuckets; i++) {
			buckets.add(null);
		}
	}
	
	private int getbucketInd(K key) {
		int index = key.hashCode();
		int bucketInd = index%numBuckets;
		return bucketInd;
	}
	
	private void rehash() {
		ArrayList<MapNode<K,V>> temp = buckets;
		buckets= new ArrayList<MapNode<K,V>>();

		for(int i=0; i<numBuckets*2; i++) {
			buckets.add(null);
		}
		count=0;
		numBuckets= 2*numBuckets;
		
		for(int i=0; i< temp.size(); i++) {
			MapNode<K, V> head = temp.get(i);
			while(head!=null) {
				K key = head.key;
				V value = head.value;
				insert(key, value);
				head=head.next;
			}
		}
		
	}
	
	public void insert(K key, V value) {
		int bucketInd = getbucketInd(key);
		
		MapNode<K, V> head = buckets.get(bucketInd);
		while(head!=null) {
			if(key.equals(head.key)) {
				head.value=value;
				return;
			}
			head = head.next;
		}
		head= buckets.get(bucketInd);
		MapNode<K,V> newNode = new MapNode(key, value);
		newNode.next=head;
		buckets.set(bucketInd, newNode);
		count++;
		double loadFactor = (1.0*count)/numBuckets;
		if(loadFactor > 0.7) {
			rehash();
		}
	}
	
	public double loadFactor() {
		double loadFactor = (1.0*count)/numBuckets;
		return loadFactor;
	}
	
	public int size() {
		return count;
	}
	
	public V getValue(K key) {
		int bucketInd = getbucketInd(key);
		MapNode<K,V> head = buckets.get(bucketInd);
		while(head!=null) {
			if(key.equals(head.key)) {
				return head.value;
			}
			head=head.next;
		}
		return null;
	}
	
	public V removeKey(K key) {
		int bucketInd = getbucketInd(key);
		MapNode<K,V> head = buckets.get(bucketInd);
		MapNode<K,V> prev = null;
		while(head!=null) {
			if(key.equals(head.key)) {
				if(prev !=null) {
					prev.next=head.next;
					
				}else {
					buckets.set(bucketInd, head.next);
				}
				count--;
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
}
