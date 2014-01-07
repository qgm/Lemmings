package lemmingsVue;
import java.awt.event.*;

import lemmingsModele.Jeu;
import lemmingsModele.Position;


public class ActionAjoutWalker implements ActionListener {
	
	private Jeu jeu;
	private Position position;
	
	public ActionAjoutWalker ( Jeu jeu, Position pos ) {
		this.jeu = jeu;
		this.position = pos;
	}
	
	public void actionPerformed ( ActionEvent e ) {
		this.jeu.addWalker(this.jeu,position);
	}

}
