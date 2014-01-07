package lemmingsVue;
import java.awt.event.*;

import lemmingsModele.Jeu;

class VitesseMoins implements ActionListener{
	private Jeu jeux;
	
	public VitesseMoins(Jeu jeu){
		this.jeux = jeu;
		
	}
	public void actionPerformed( ActionEvent e){
		this.jeux.setSpeed(this.jeux.getSpeed() - 10); // 10 purement subjectif
}
}