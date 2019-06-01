package meta;

public class Solution_Node {

	private Node_evac node ;
	private int date ;
	
	public Solution_Node(Node_evac n, int d)
	{
		this.node = n ;
		this.date = d ;
	}
	
	// getter
	public Node_evac getNode()
	{
		return this.node ;
	}
	
	public int getDate()
	{
		return this.date ;
	}
	
	// fonctions
	public String toString()
	{
		return " node: "+ this.node.getId() + " depart: " + this.date ;
	}
}
