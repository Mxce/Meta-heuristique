package meta;

import java.util.ArrayList;
import java.util.Iterator;

public class Diversification {

	// ---------------------------- BORNE SUP ------------------------------------------
	public static Solution find_sup_random(Graph graphe)
	{

		ArrayList<Node_evac> lne = new ArrayList<Node_evac>();
		
		for (Node_evac ne : graphe.getNodes_evac()) {
			lne.add(ne);
		}
		ArrayList<Node_evac> lneRand = new ArrayList<Node_evac>();
		while (!lne.isEmpty()) {
			int ind = (int)(Math.random()*lne.size());
			System.out.println(ind);
			lneRand.add(lne.get(ind));
			lne.remove(ind);
		}
		
		ArrayList<Solution_Node> liste_solnode= new ArrayList<Solution_Node>();
		int temps = 0 ;
		for (Node_evac ne : lneRand) {
			liste_solnode.add(new Solution_Node(ne,temps,ne.getCapaRoute())); //TODO: verifier
			int t = find_temps(ne) ;
			temps = temps+t ;
		}
		Solution sol = new Solution("sol_sup", graphe.getNodes_evacSize(), liste_solnode ,  temps, 0, "borne sup",graphe);
		return sol ;			
	}	
	

	public static Solution diversification(Graph graphe)
	{
		Solution solution = null;
		int nbIt = 40;
		
		while (nbIt>0) {
			Solution soltemp = Intensification.recherche(graphe, find_sup_random(graphe));
			if (solution ==null || soltemp.getObjectif()<solution.getObjectif()) {
				solution =soltemp;
			}
			nbIt--;
		}

			
		return solution ;	
	
	}
		
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
