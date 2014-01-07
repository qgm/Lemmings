package lemmingsControler;


import lemmingsModele.Jeu;

public class Controleur {
	
	public Controleur(Jeu jeu) {
		super();
		this.jeu = jeu;
	}

	public Jeu jeu;
	
	public void executePas(Jeu jeu) {
		jeu.pas();
	}
	
	public void initialise(Jeu jeu) {
		jeu.init();
	}

}


	

