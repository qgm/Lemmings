package lemmingsModele;
import java.awt.event.ActionListener;
import java.lang.System;

import lemmingsVue.FenetreJeu;
import lemmingsVue.FenetreJeu.ActionTourDeJeu;
import lemmingsControler.*;
import javax.swing.Timer;



public class Main { 

	public static void main(String args[]) throws ConfigurationException {


	try{
		if (args.length != 1) {
			throw new ConfigurationException("nombre d'arguments invalide : " +
			args.length + " au lieu de 1.");
		}
		else {
			
			
			Position origine = new Position (31,2);
			Direction directionDefaut = new Direction (false,false,true);
			Jeu jeu=new Jeu();
			Controleur controleur = new Controleur(jeu);
			jeu.setMap(new Map());
			Reader reader=new Reader();
			reader.initialiserLeJeu(jeu,"exemple.lemmings");
			jeu.setMapDecor(jeu.getMap().mapCharToDecor());
			/* On teste le decor*/
			System.out.println(jeu.getMap().getDevant(origine,directionDefaut,jeu.getMap()).decorToChar());
			System.out.println(jeu.getMapDecor().get(5).get(3).decorToChar());
			
			FenetreJeu fenetre = new FenetreJeu(jeu,controleur);
			
			/* On teste le deplacement des differents types de lemmings */
			jeu.addWalker(jeu,origine);
			jeu.newComp(jeu,origine,new Basher());
			
			/* Implementation du Timer */
			ActionListener tourDeJeu = fenetre.new ActionTourDeJeu(controleur , fenetre);
			
			int delay = 1000; //milliseconds
			Timer timer = new Timer(delay, tourDeJeu);
			
			timer.start();
			
		}
	}

	catch (ConfigurationException e){
		System.out.print("Erreur : " +e.getMessage());
	}
    }
}


