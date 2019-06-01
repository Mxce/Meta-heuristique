package meta;

import java.util.ArrayList;
import java.util.Iterator;


public class Graph 
{
	
	//TODO: si l'algo est trop lent -> faire une map
	
	
	private ArrayList<Node> nodes ;
	private ArrayList<Edge> edges ;
	private ArrayList<Node_evac> nodes_evac ;
	
	private int time ;
	
	// -------- Constructeur
	public Graph()
	{
		this.nodes = new ArrayList<Node>() ;
		this.edges = new ArrayList<Edge>() ;
		this.nodes_evac = new ArrayList<Node_evac>() ;
		this.time=0;
	}
	
	public void reset() {
		this.time=0 ;
		Iterator<Edge> itE = edges.iterator();
		while(itE.hasNext())
		{
			Edge e = itE.next() ;
			e.resetFlot();
		}
		Iterator<Node_evac> itN = nodes_evac.iterator() ;
		while(itN.hasNext())
		{
			Node_evac n = itN.next() ;
			n.reset() ;
		}
	}
	// ---------- Getter
	public int getNodesSize()
	{
		return nodes.size();
	}
	public int getEdgesSize()
	{
		return edges.size();
	}
	public int getNodes_evacSize()
	{
		return nodes_evac.size();
	}
	public int getTime()
	{
		return time;
	}
	public ArrayList<Node_evac> getNodes_evac()
	{
		return this.nodes_evac ;
	}
	public ArrayList<Edge> getEdge()
	{
		return this.edges ;
	}
	// ------- Setter
	public void incrementTime()
	{
		this.time++;
	}
	
	
	// ------- Fonctions
	public void addNode (Node n)
	{
		this.nodes.add(n) ;
	}
	public void addNode_Evac (Node_evac n)
	{
		this.nodes_evac.add(n) ;
	}
	
	public void addArc (Edge e)
	{
		this.edges.add(e) ;
	}
	
	public String toString()
	{
		return ("Nodes : \n" + this.getNodesSize() + nodes.toString()+ "\nEdges : \n" + this.getEdgesSize() + edges.toString());

	}

	public Node findNodeID(int id)
	{
		Iterator<Node> it =  nodes.iterator() ;
		while(it.hasNext())
		{
			Node n=it.next();
			if (n.getId()==id)
			{
				return n;
			}
			
		}
		return null;
	}
	
	public Node_evac findNodeEvacID(int id)
	{
		Iterator<Node_evac> it =  nodes_evac.iterator() ;
		while(it.hasNext())
		{
			Node_evac n=it.next();
			if (n.getId()==id)
			{
				return n;
			}
			
		}
		return null;
	}
	
	public Node getNodeIndex(int i)
	{
		return this.nodes.get(i) ;
	}
	
	public Node_evac getNodeEvacIndex(int i)
	{
		return this.nodes_evac.get(i) ;
	}
	
	
	public Edge getEdgeIndex(int i)
	{
		return this.edges.get(i) ;
	}
	
	public Edge findEdgeFromNodesIndex(int n1, int n2)
	{
		Iterator<Edge> it = this.edges.iterator() ;
		while(it.hasNext())
		{
			Edge e = it.next() ;
			if((n1==e.getNode1().getId() && n2==e.getNode2().getId()) || (n2==e.getNode1().getId() && n1==e.getNode2().getId()) )
			{
				return e ;
			}
		}
		
		return null ;
	}
	
	// met à zero
	public void resetFlot()
	{
		Iterator<Edge> it = this.edges.iterator() ;
		while(it.hasNext())
		{
			it.next().resetFlot();
		}
	}
}