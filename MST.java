import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MST {
	

	/**
	 * Run Kruskal's algorithm on the given graph and return the MST, return
	 * null if no MST exists for the graph
	 * 
	 * @param g
	 *            the graph, g will never be null
	 * @return the MST of the graph, null of no valid MST exists
	 */
	public static Collection<Edge> kruskals(Graph g) {
		Collection<Edge> edges = new ArrayList<Edge>();
		DisjointSets<Vertex> set = new DisjointSets<Vertex>(g.getVertices());
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

		for(Edge e: g.getEdgeList())
			pq.add(e);
			while(!pq.isEmpty() ) {
				Edge edge = pq.remove();
				Vertex v1 = edge.getU();
				Vertex v2 = edge.getV();
				if(!set.sameSet(v1, v2)) {
					set.merge(v1,v2);
					edges.add(edge);
				}
			}
			
		return edges;

	}
}
