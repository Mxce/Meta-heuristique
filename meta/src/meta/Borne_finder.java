package meta;

import java.util.ArrayList;
import java.util.Iterator;

public class Borne_finder 
{
	
	// ---------------------------- BORNE SUP ------------------------------------------
	public static Solution find_sup(Graph graphe)
	{
		int temps = 0 ;
		Iterator<Node_evac> it = graphe.getNodes_evac().iterator() ;
		ArrayList<Solution_Node> liste_solnode= new ArrayList<Solution_Node>();
		while(it.hasNext())
		{
			Node_evac ne = it.next();
			liste_solnode.add(new Solution_Node(ne,temps));
			int t = find_temps(ne) ;
			temps = temps+t ;
			
		}
		Solution sol = new Solution("sol_sup", graphe.getNodes_evacSize(), liste_solnode ,  temps, 0, "borne sup",graphe);
		return sol ;			
	}
	
/*
	private static int find_temps_pop(Node_evac ne, int pop)
	{
		int temps = 0 ;
		
		Iterator<Edge> it = ne.getRoute().getRoute().iterator() ;
		while(it.hasNext())
		{
			Edge e = it.next() ;
			temps = temps + e.getLength() ;
		}
		
		temps = temps + (pop/ne.getMax_rate()) + (pop%ne.getMax_rate()) ;
		return temps ;
	}
	
*/
	
	
	// ---------------------------- BORNE INF ------------------------------------------
	
	// verifie si la borne inf est réalisable -> on a la solution optimale
	
	
	
	// Trouve la borne inf: si on les fait partir tous à 0 quel temps ca met ?
	public static Solution find_inf(Graph graphe)
	{
		int temps = 0 ;
		Iterator<Node_evac> it = graphe.getNodes_evac().iterator() ;
		ArrayList<Solution_Node> liste_solnode= new ArrayList<Solution_Node>();
		while(it.hasNext())
		{
			Node_evac ne = it.next();
			liste_solnode.add(new Solution_Node(ne,0));
			int t = find_temps(ne) ;
			if(t>temps)
			{
				temps = t ;
			}
		}
		Solution sol = new Solution("sol_inf", graphe.getNodes_evacSize(), liste_solnode ,  temps, 0, "borne inf",graphe);
		return sol ;
	}
	
	
	// --------------------------- FONCTIONS -----------------------------------------
	// utile pour trouver les bornes
	private static int find_temps(Node_evac ne)
	{
		int temps = 0 ;
		
		Iterator<Edge> it = ne.getRoute().getRoute().iterator() ;
		while(it.hasNext())
		{
			Edge e = it.next() ;
			temps = temps + e.getLength() ;
		}
		
		temps = temps + (ne.getPopDepart()/ne.getCapaRoute()) + (ne.getPopDepart()%ne.getCapaRoute()) ;
		return temps ;
	}
	
	
	
	
	
	
}
