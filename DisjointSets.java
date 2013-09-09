import java.util.HashMap;
import java.util.Set;




public class DisjointSets<T> {
	HashMap<T, Node<T>> hashMap;
	/**
	 * @param setItems
	 *            the initial items (sameSet and merge will never be called with
	 *            items not in this set, this set will never contain null
	 *            elements)
	 */
	
	public DisjointSets(Set<T> setItems) {
		hashMap = new HashMap<T, Node<T>>();
		for(T v: setItems){
			Node<T> node = new Node<T>(v);
			node.rank = 0;
			hashMap.put(v, node);
		}
	}
	
	/**
	 * @param u
	 * @param v
	 * @return true if the items given are in the same set, false otherwise
	 */
	public boolean sameSet(T u, T v) {
		Node<T> uu = hashMap.get(u);
		Node<T> vv = hashMap.get(v);
		return find(uu).equals(find(vv));
	}
	

	private Node<T> find(Node<T> target){
		if(target != target.parent)
			target.parent = find(target.parent);
		return target.parent;
	}
	

	/**
	 * merges the sets u and v are in, do nothing if they are in the same set
	 * 
	 * @param u
	 * @param v
	 */
	public void merge(T u, T v) {
        Node<T> first = find(hashMap.get(u));
        Node<T> second = find(hashMap.get(v));

        if(first.rank > second.rank)
            second.parent = first;
        else if(first.rank < second.rank)
            first.parent = second;
        else{
            second.parent = first;
            first.rank++;
        }
    }
	
	private class Node<T>{
		T data;
		int rank;
		Node<T> parent;
		
		public Node(T v){
			this.data = (T) v;
			parent = this;
		}
		
		
	}
}
