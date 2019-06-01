package meta;

import java.util.ArrayList;

public class Principale 
{
	public static void main(String[] args)
	{
		
		//////////::ATTENTION REGENERER LE GRAPHE SI ON CHECK 2 SOLUTIONS 
		
		
		/// checker marche
		/// borne inf marche
		///TODO: borne sup en lançant les route une après l'autre et checker si le sup est valide (il doit l'etre!!)
		
		
		Graph graphe = Lecteur.readData("Instances\\exemple.txt");
		
		
		// test checker
		// on créé une solution à la main mais il faudrait la lire !!
		ArrayList<Solution_Node> sol_node = new ArrayList<Solution_Node>() ;
		sol_node.add(new Solution_Node(graphe.findNodeEvacID(1),3));
		sol_node.add(new Solution_Node(graphe.findNodeEvacID(2),0));
		sol_node.add(new Solution_Node(graphe.findNodeEvacID(3),0));	
		
	//	Solution sol = new Solution("S1 de mariejo", 3, sol_node, true, 37, 1000, "a la main comme des nazes");
		
		// on teste yes
		//boolean valide = Checker.check(sol, graphe) ;
		
		//System.out.println(valide);
		
		// test bornes
		// inf
		System.out.println("inf: "+Borne_finder.find_inf(graphe));
		
		// sup
		System.out.println("sup: "+Borne_finder.find_sup(graphe));
		
		Solution solution_sup = Borne_finder.find_sup(graphe) ;
		// intensification
		System.out.println("intens: "+ Recherche_voisinage.recherche(graphe,solution_sup));
		
		
		System.out.println("divers: "+ Diversification.diversification(graphe));
	/*	
		graphe = Lecteur.readData("/home/marotte/Bureau/4A/S2/Metaheuristique/Instances/dense_10_30_3_7.full");
		System.out.println("inf: "+Borne_finder.find_inf(graphe));
		System.out.println("sup: "+Borne_finder.find_sup(graphe));
		
		graphe = Lecteur.readData("/home/marotte/Bureau/4A/S2/Metaheuristique/Instances/medium_10_30_3_8.full");
		System.out.println("inf: "+Borne_finder.find_inf(graphe));
		System.out.println("sup: "+Borne_finder.find_sup(graphe));
		
		graphe = Lecteur.readData("/home/marotte/Bureau/4A/S2/Metaheuristique/Instances/sparse_10_30_3_3.full");
		System.out.println("inf: "+Borne_finder.find_inf(graphe));
		System.out.println("sup: "+Borne_finder.find_sup(graphe));
	*/	
		
		
	}
	
}
