package lemmingsModele;
/**Ce fichier contiendra les flots d'informations lues a partir du fichier texte
 * et constituera le modele du jeu
 * */
import java.util.ArrayList;
import java.awt.Color;

import lemmingsObserver.*;

public class Jeu implements Observable {
	
	/* Constructeurs */
	public Jeu(){
		this.map=new Map();
	}
	
	public boolean pause ; // le jeu est-il en pause ?
	public int speed ; // vitesse jeu
	public int time ;  // temps de jeu restant
	public int count;  // nombre total de lemmings restant à poper
	public int rescue; // nombre de lemmings qu'il faut sauver
	public int lemmingsApparus; // nombre de lemmings ayant étés popés
	public int climber; 
	public int floater;
	public int blocker;
	public int bomber;
	public int builder;
	public int basher;
	public int digger;
	public int miner;
	public Map map; 
	public ArrayList<ArrayList<Decor>> mapDecor;
	public ArrayList<Lemming> listLemmings = new ArrayList<Lemming> (count);
	private ArrayList<Observer> listObserver = new ArrayList<Observer>(); // Nos observateurs
	
	
	// initialisation d'une partie
	public void init() {
		
	}
	
	// On incremente le mouvement de tous les lemmings d'un pas
	public void pas(){

	}
	
	// Implementation des Observable
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver() {
		for(Observer obs : this.listObserver )
			obs.update();
	}
	
	public void removeObserver() {
		this.listObserver = new ArrayList<Observer>();
	}
	
	
	
	
	/**Une procedure d'affichage des différentes fonctions*/

	public void afficherJeu(){
		System.out.printf("Count: " +this.getCount()+ "\n");
		System.out.printf("Time: " +this.getTime()+ "\n");
		System.out.printf("Speed: " +this.getSpeed()+ "\n");
		System.out.printf("Rescue: " +this.getRescue()+ "\n");
		System.out.printf("Climber: " +this.getClimber()+ "\n");
		System.out.printf("Floater: " +this.getFloater()+ "\n");
		System.out.printf("Blocker: " +this.getBlocker()+ "\n");
		System.out.printf("Bomber: " +this.getBomber()+ "\n");
		System.out.printf("Builder: " +this.getBuilder()+ "\n");
		System.out.printf("Dasher: " +this.getBasher()+ "\n");
		System.out.printf("Digger: " +this.getDigger()+ "\n");
		System.out.printf("miner: " +this.getMiner()+ "\n");
	}


	public void afficherMap(int tailleMax){
	}



/**Les differentes fonctions qui permettent d'incrémenter ou diminuer les compteurs*/

	public void incrementerRescue() {
		this.rescue++;
	}

	public void decrementerDigger() {
		this.digger--;
	}

	public void decrementerBasher() {
		this.basher--;
	}

	public void decrementerMiner() {
		this.miner--;
	}

	public void decrementerBomber(){
		this.bomber--;
	}

	public void decrementerBlocker(){
		this.blocker--;
	}

	public void decrementerBuilder(){
		this.builder--;
	}

	public void decrementerFloater(){
		this.floater--;
	}

	public void decrementerClimber(){
		this.climber--;
	}

	public void decrementerCount(){
		this.count--;
	}

	public void decrementerTime(){
		this.time--;
	}



	/* Getters et Setters */
	public Map getMap(){
		Map aux=this.map;
		return aux;
	}

	public ArrayList<ArrayList<Decor>> getMapDecor(){
		ArrayList<ArrayList<Decor>> aux=this.mapDecor;
		return aux;
	}

	public void setMapDecor(ArrayList<ArrayList<Decor>> tab){
		this.mapDecor=tab;
	}

	public void setMap(Map map){
		this.map=map;
	}


	public int getSpeed(){
		int aux=this.speed;
		return(aux);
	}

	public void setSpeed(int speed){
		this.speed=speed;
	}

	public int getTime(){
		int aux=this.time;
		return(aux);
	}

	public void setTime(int time){
		this.time=time;
	}

	public int getCount(){
		int aux=this.count;
		return(aux);
	}
	
	public void setCount(int count){
		this.count=count;
	}

	public int getRescue(){
		int aux=this.time;
		return(aux);
	}
	
	public void setRescue(int rescue){
		this.rescue=rescue;
	}

	public int getClimber(){
		int aux=this.climber;
		return(aux);
	}
	
	public void setClimber(int climber){
		this.climber=climber;
	}

	public int getFloater(){
		int aux=this.floater;
		return(aux);
	}
	public void setFloater(int floater){
		this.floater=floater;
	}

	public int getBlocker(){
		int aux=this.blocker;
		return(aux);
	}
	
	public void setBlocker(int blocker){
		this.blocker=blocker;
	}

	public int getBomber(){
		int aux=this.time;
		return(aux);
	}

	public void setBomber(int bomber){
		this.bomber=bomber;
	}

	public int getBuilder(){
		int aux=this.builder;
		return(aux);
	}

	public void setBuilder(int builder){
		this.builder=builder;
	}

	public int getBasher(){
		int aux=this.basher;
		return(aux);
	}
	
	public void setBasher(int basher){
		this.basher=basher;
	}

	public int getDigger(){
		int aux=this.digger;
		return(aux);
	}

	public void setDigger(int digger){
		this.digger=digger;
	}
	

	public int getMiner(){
		int aux=this.miner;
		return(aux);
	}
	
	public void setMiner(int miner){
		this.miner=miner;
	}	
	
	public boolean isPause() {
		return pause;
	}


	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public ArrayList<Lemming> getListLemmings() {
		return listLemmings;
	}
	
	public void setListLemmings(ArrayList<Lemming> listLemmings) {
		this.listLemmings = listLemmings;
	}

	/** Toutes les methodes relatives à l'ajout de lemmings particuliers ou a l'assignation de competences
	 *  ou a leur mort
	 */
	public void addWalker(Jeu jeu, Position position) {
		
		Direction directionDefaut = new Direction(false,false,true);
		
		Competence w = new Walker();
		
		Lemming walker = new Lemming (this.lemmingsApparus, position, directionDefaut, Color.white, (float) 1.0, w);
		jeu.listLemmings.add(walker);
		lemmingsApparus += 1;	
	}
	
	/** Changer la competence d'un Lemming ( s'il ne s'agit pas d'un Bomber ou d'un Blocker )
	 */
	public void newComp(Jeu jeu, Position position,Competence competence) {
		
		int ind = 0;
		int i = 0 ;
		
		while (!(jeu.listLemmings.get(i).getPosition().equals(position))) {
				i ++;
		}

		if (i == jeu.listLemmings.size()) {
			System.out.println("Pas de Lemming trouve a cette position"); 
		}
			// On a trouve un Lemming a cette position
		else {
			ind = i;
			// et il ne s'agit ni d'un Bomber ni d'un Blocker
			if (!(competence.getClass().toString().equals("class lemmingsModele.Blocker") 
				|| (competence.getClass().toString().equals("class lemmingsModele.Bomber")))) {
				jeu.listLemmings.get(ind).setCompetence(competence);
			}
			else {
			   System.out.println("On ne peut pas modifier la competence d'un Blocker ou d'un Bomber");
			}
		}
	}		
}