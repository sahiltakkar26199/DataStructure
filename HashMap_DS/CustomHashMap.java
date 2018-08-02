package HashMap_DS;

import java.util.ArrayList;

public class CustomHashMap<K, V> {

	final int BUCKET_DEFAULT_SIZE = 10;
	ArrayList<MapNode<K, V>> bucket;
	int bucketLength;
	int noOfEntries;

	CustomHashMap() {
		bucket = new ArrayList<>(BUCKET_DEFAULT_SIZE);
		bucketLength = BUCKET_DEFAULT_SIZE;
		for (int i = 0; i < bucketLength; i++) {
			bucket.add(null);
		}
		noOfEntries = 0;
	}

	void put(K key, V value) {
		int index = getIndex(key);
		MapNode<K, V> head = bucket.get(index);
		while (head != null) {
			if (key == head.key) {
				head.value = value;

				return;
			}
			head = head.next;
		}
		MapNode<K, V> nyaNode = new MapNode<>(key, value);
		nyaNode.next = bucket.get(index);
		bucket.set(index, nyaNode);
		noOfEntries++;
		if (noOfEntries * (1.0) / bucketLength > .7) {
			grow();
		}
	}

	private void grow() {
		ArrayList<MapNode<K, V>> temp = bucket;
		bucketLength = 2 * bucketLength;
		bucket = new ArrayList<MapNode<K, V>>(bucketLength);
		for (int i = 0; i < bucketLength; i++) {
			bucket.add(null);
		}
		for (MapNode<K, V> head : temp) {
			while (head != null) {
				put(head.key, head.value);
				head = head.next;
			}
		}

	}

	private int getIndex(K key) {
		int hashCode = key.hashCode();
		return compress(hashCode);

	}

	V get(K key) {
		int index = getIndex(key);
		MapNode<K, V> head = bucket.get(index);
		while (head != null) {
			if (key.equals(head.key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	V delete(K key) {
		int index = getIndex(key);
		MapNode<K, V> head = bucket.get(index);
		if (head == null) {
			return null;
		}
		if (head.key.equals(key)) {
			noOfEntries--;
			V temp = head.value;
			bucket.set(index, head.next);
			return temp;
		}
		while (head.next != null) {
			if (key.equals(head.next.key)) {
				noOfEntries--;
				V temp = head.next.value;
				head.next = head.next.next;
				return temp;
			}
			head = head.next;
		}
		return null;
	}

	private int compress(int hashCode) {
		return hashCode % bucketLength;
	}

	ArrayList<K> getAllKeys() {
		ArrayList<K> keys = new ArrayList<>();
		for (MapNode<K, V> head : bucket) {
			while (head != null) {
				keys.add(head.key);
				head = head.next;
			}
		}
		return keys;
	}

	ArrayList<V> getAllValues() {
		ArrayList<V> values = new ArrayList<>();
		for (MapNode<K, V> head : bucket) {
			while (head != null) {
				values.add(head.value);
				head = head.next;
			}
		}
		return values;
	}

}
