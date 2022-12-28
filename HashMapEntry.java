/***Veronique Justinvil 
 * The use of a Hash map to create a dictionary stored from a file and evaluate the function of searching from each 
 * data structure 
 * 11/17/2022 
 */ 
public class HashMapEntry<K, V> {
	private K key;
	private V value;
	public HashMapEntry(K k, V v) {
		key = k;
		value = v;
	}
	public K getKey() { return key; }
	public V getValue() { return value; }
	public void setKey(K k) {
		key = k;
	}
	public void setValue(V v) {
		value=v;
	}
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}
