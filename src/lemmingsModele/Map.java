package lemmingsModele;
import java.util.ArrayList;


public class Map {
	
	public ArrayList<ArrayList<Character>> map; // La matrice de caracteres representant la map
	public int curseur; // Ce curseur permet de dire a quelle ligne on se trouve
	public int tailleLigne; // largeur de la map	
	public int tailleColonne; // hauteur de la map
	public boolean mapDetecte; // existence ou non de la map
	public Position positonTrappe; // o� les lemmings entrent
	public Position positionSortie; // o� ils sortent

	public Map(){
		this.curseur=0;
		this.tailleLigne=0;
		this.tailleColonne=0;
		this.mapDetecte=false;
		this.map=new ArrayList<ArrayList<Character>>();
	}
	
	/*
	 * Ci-dessous plusieurs fonctions renvoyant les d�cors autour d'une position donn�e
	 */
	
	public Decor getDecor( Position positionLemming, Map map ) throws ConfigurationException{
		
		Decor posLemming;
		ArrayList<ArrayList<Decor>> mapDecor = map.mapCharToDecor();
		ArrayList<Decor> ligneDecor = mapDecor.get(positionLemming.ordonnee);
	    posLemming = ligneDecor.get(positionLemming.abscisse);
		return posLemming;
		
	}
	
	public Decor getDevant (Position positionLemming, Direction direction, Map map)  throws ConfigurationException
	/*throws MapDirectionException*/ {
	
		Decor devant = new DecorVide();
		ArrayList<ArrayList<Decor>> mapDecor = map.mapCharToDecor();

		/*if ( ((!direction.droite) && (!direction.gauche) && (direction.haut)) 
			||((!direction.droite) && (!direction.gauche) && (!direction.bas) && (!direction.haut)) 
			|| ((direction.droite) && (direction.gauche))) {
			throw new MapDirectionException();
		}*/
		
		if (direction.droite) {
			return mapDecor.get(positionLemming.ordonnee).get(positionLemming.abscisse + 1);   	
		}
		
		if (direction.gauche) {
			return mapDecor.get(positionLemming.ordonnee).get(positionLemming.abscisse - 1);
		}
		
		return devant;	
	}
	
	public Decor getDessous (Position positionLemming, Direction direction, Map map)  throws ConfigurationException
	/*throws MapDirectionException*/ {
		
		/*if ( ((!direction.droite) && (!direction.gauche) && (direction.haut)) 
			||((!direction.droite) && (!direction.gauche) && (!direction.bas) && (!direction.haut)) 
			|| ((direction.droite) && (direction.gauche))) {
			throw new MapDirectionException();
		}*/
		
		ArrayList<ArrayList<Decor>> mapDecor = map.mapCharToDecor();
		
		ArrayList<Decor> ligneDecor = mapDecor.get(positionLemming.ordonnee + 1);
		return ligneDecor.get(positionLemming.abscisse);
		
	}
	
	public Decor getDessus (Position positionLemming, Direction direction, Map map)  throws ConfigurationException
	/*throws MapDirectionException*/ {
		
		/*if ( ((!direction.droite) && (!direction.gauche) && (direction.haut)) 
			||((!direction.droite) && (!direction.gauche) && (!direction.bas) && (!direction.haut)) 
			|| ((direction.droite) && (direction.gauche))) {
			throw new MapDirectionException();
		}*/
		
		ArrayList<ArrayList<Decor>> mapDecor = map.mapCharToDecor();
		
		ArrayList<Decor> ligneDecor = mapDecor.get(positionLemming.ordonnee - 1);
		return ligneDecor.get(positionLemming.abscisse);
		
	}
	
	public Decor getDerriere (Position positionLemming, Direction direction, Map map)  throws ConfigurationException
	/*throws MapDirectionException*/ {
			
		Decor derriere = new DecorVide();
		ArrayList<ArrayList<Decor>> mapDecor = map.mapCharToDecor();
		
		/*if ( ((!direction.droite) && (!direction.gauche) && (direction.haut)) 
			||((!direction.droite) && (!direction.gauche) && (!direction.bas) && (!direction.haut)) 
			|| ((direction.droite) && (direction.gauche))) {
			throw new MapDirectionException();
		}*/
		
		if (direction.droite) {
			ArrayList<Decor> ligneDecor = mapDecor.get(positionLemming.ordonnee );
		    derriere = ligneDecor.get(positionLemming.abscisse -1);
		}
		
		if (direction.gauche) {
			ArrayList<Decor> ligneDecor = mapDecor.get(positionLemming.ordonnee);
		    derriere = ligneDecor.get(positionLemming.abscisse + 1);
		}
		
		return derriere;	
	}
	
	/**On convertit un ensemble de character en un ensemble de Decor**/
	public ArrayList<ArrayList<Decor>> mapCharToDecor() throws ConfigurationException  {
		ArrayList<ArrayList<Decor>> mapDecor= new ArrayList<ArrayList<Decor>>();
		int i,j;
		for (i=0;i<this.tailleColonne;i++){
			ArrayList<Character> ligneCharacter=this.map.get(i);
			mapDecor.add(new ArrayList<Decor>(this.tailleLigne));
			for (j=0;j<this.tailleLigne;j++){
				mapDecor.get(i).add(traductionCharToDecor(ligneCharacter.get(j)));
			}
		}
		return mapDecor;
	}
	
	public boolean caracteredefini(char c){
        return (c==' '||c=='%'||c=='<'||c=='>'||c=='+'||c=='*'||c=='O'||c=='v'||c=='@'||c=='!');
        }

	/* Et inversement */
	public Decor traductionCharToDecor (char c) throws ConfigurationException {
        Decor decor=null;
        if (c=='%'){
        	decor= new DecorLanceFlamme();
        }
        if (c=='!'){
        	decor= new DecorBroyeur();
        }
        if (c=='>'){
        	decor=new DecorDestructibleGauche();
        }
        if (c=='<'){
        	decor=new DecorDestructibleDroite();
        }
        if (c=='v'){
        	decor=new DecorDestructibleBas();
        }
        if (c=='*'){
        	decor= new DecorIndestructible();
        }
        if (c=='+'){
        	decor=new DecorDestructible();
        }
        if (c==' '){
        	decor=new DecorVide();
        }
        if (c=='@'){
        	decor=new DecorSortie();
        }
        if (c=='O'){
        	decor=new DecorEntree();
        }
        if (!caracteredefini(c)) {
        	throw new ConfigurationException("L'element "+c+ " n'est pas defini comme etant un decor\n");
        }
        return decor;
    }
	
	


	
	
	public void afficherLigne(ArrayList<Character> ligne){
		int i;
		for (i=0;i<this.tailleLigne;i++){
			System.out.print(ligne.get(i));
		}
		System.out.printf("\n");
	}

	public void afficherMap(){
		
		ArrayList<ArrayList<Character>> map =this.map;
		int i;
		for (i=0;i<this.tailleColonne;i++){
			afficherLigne(map.get(i));
		
		}
	}

	/**On construit une nouvelle ligne de la Carte*/
	public void setNouvelleLigneMap(String ligne){
		
		int i;
		this.map.add(new ArrayList<Character>(this.tailleLigne));
		char[] tab=ligne.toCharArray();
		ArrayList<Character> ligneTraitee=this.map.get(this.curseur);
		for (i=0;i<this.tailleLigne;i++){
			ligneTraitee.add(tab[i]);
		}
		this.curseur++;
	}
	
	
	
	/** Requetes et accesseurs */
	public Position getPositionSortie() {
		return positionSortie;
	}

	public void setPositionSortie(Position positionSortie) {
		this.positionSortie = positionSortie;
	}

	public int getCurseur() {
		return curseur;
	}

	public void setCurseur(int curseur) {
		this.curseur = curseur;
	}

	public Position getPositonTrappe() {
		return positonTrappe;
	}

	public void setPositonTrappe(Position positonTrappe) {
		this.positonTrappe = positonTrappe;
	}

	public ArrayList<ArrayList<Character>> getMap() {
		return map;
	}

	public int getTailleLigne() {
		return tailleLigne;
	}

	public int getTailleColonne() {
		return tailleColonne;
	}

	public boolean getMapDetecte(){
		boolean aux=this.mapDetecte;
		return aux;
	}

	public void setMap(ArrayList<ArrayList<Character>> nouvelleMap){
		this.map=nouvelleMap;
	}

	public void setMapDetecte(boolean bool){
		this.mapDetecte=bool;
	}

	public void setTailleLigne(int taille){
		this.tailleLigne=taille;
	}

	public void setTailleColonne(int taille){
		this.tailleColonne=taille;
	}



}
 
