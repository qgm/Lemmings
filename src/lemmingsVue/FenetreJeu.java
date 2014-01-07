package lemmingsVue;

import javax.swing.*;
import java.awt.BorderLayout;

import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lemmingsControler.Controleur;
import lemmingsModele.Direction;
import lemmingsModele.Jeu;
import lemmingsModele.Position;
import lemmingsModele.ConfigurationException;

public class FenetreJeu {
	
	private JFrame fenetre1;
	
	private JLabel[][] zoneMap ;
	private JLabel Time;
	private JLabel Speed;
	private JLabel Out;
	private JLabel Home;
	private JLabel Total;
	private JLabel Niveau;
	private JLabel lemming;
	private JLabel Courage;
	
	private ImageIcon icon;
	private ImageIcon icon0;
	private ImageIcon icon1;
	private ImageIcon icon2;
	private ImageIcon icon3;
	private ImageIcon icon4;
	
	private JButton climber;
	private JButton floater;
	private JButton blocker;
	private JButton bomber;
	private JButton builder;
	private JButton basher;
	private JButton digger;
	private JButton miner;
	
	private JButton vitessePlus;
	private JButton vitesseMoins;
	private JButton quitter;
	
	private JFrame fenetre2;
	private JLabel vitesse;
	private JLabel aptitude;
	private JLabel temps_r;
	
	public Controleur controleur;
	
	
	public  FenetreJeu(Jeu jeu, Controleur controleur) {
		
		// Notre controleur
		this.controleur = controleur;
		
		// construction des objets graphiques
		this.fenetre1 = new JFrame(" Lemmings");
		this.fenetre1.setSize(600, 600);
        this.fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenetre1.setLocationRelativeTo(null);
        
        this.fenetre2 = new JFrame(" Lemming");
		this.fenetre2.setSize(300, 300);
        this.fenetre2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenetre2.setLocationRelativeTo(null);
		
        icon0 = new ImageIcon("b_t.png");
        icon1 = new ImageIcon("indestructible.jpg");
        icon2 = new ImageIcon("trappe.png");
        icon3 = new ImageIcon("flamme.gif");
        icon4 = new ImageIcon("portes (3).gif");
        
	 zoneMap = new JLabel[jeu.getMap().getTailleLigne()][ jeu.getMap().getTailleColonne()];
	
	 
	 for(int i=0; i< jeu.getMap().getTailleLigne(); i++){
			for(int j=0; j<jeu.getMap().getTailleColonne(); j++){
				zoneMap[i][j] = new JLabel("+");
				zoneMap[i][j].addMouseListener(new ActionCliquer(i, j));
			}
	 }
	 
	 
			
			
		 //construction matrice
			
			GridLayout carte = new GridLayout(jeu.getMap().getTailleColonne(), jeu.getMap().getTailleLigne());
			JPanel zonecarte = new JPanel();
			
			zonecarte.setLayout(carte);
			
			for(int j=0; j< jeu.getMap().getTailleColonne(); j++){
				for(int i=0; i<jeu.getMap().getTailleLigne(); i++){
					
					
						zonecarte.add(zoneMap[i][j]);
					}
				}
			
			
		// construction des boutons de jeu bas et info
	
			this.climber = new JButton ("Climber :" + jeu.getClimber()); // recupere le nombre restant 
			this.floater = new JButton ("Floater :" + jeu.getFloater()); // d aptitude et les affiche
			this.blocker = new JButton ("Blocker :" + jeu.getBlocker());
			this.bomber  = new JButton ("Bomber :"  + jeu.getBomber());
			this.builder = new JButton ("Builder :" + jeu.getBuilder());
			this.basher  = new JButton ("Basher :"  + jeu.getBasher());
			this.digger  = new JButton ("Digger :"  + jeu.getDigger());
			this.miner   = new JButton ("Miner :"   + jeu.getMiner());
			
			Time = new JLabel("Time :"   + jeu.getTime());
			Speed = new JLabel("Speed :" + jeu.getSpeed());
			Out = new JLabel("Out :"     + jeu.getCount());    // afficher les données de la partie
			Home = new JLabel("Home :"   + jeu.getRescue());
			Total = new JLabel("Total :");
			Niveau = new JLabel("Niveau :");
			Courage = new JLabel("Courage !");
		
		// construction des boutons coté droit 
		this.quitter = new JButton("Quitter");
		this.vitessePlus = new JButton("V+");
		this.vitesseMoins = new JButton("V-");
		
		icon = new ImageIcon("Lemming-thumb.jpg");
		this.lemming= new JLabel (icon ,JLabel.CENTER); 
		
		// association des actions aux boutons
			
		GestionQuitter gestionQuitter = new GestionQuitter();
		this.quitter.addActionListener(gestionQuitter);
			
		VitessePlus vitessePlus = new VitessePlus(jeu);
		this.vitessePlus.addActionListener(vitessePlus);
			
		VitesseMoins vitesseMoins = new VitesseMoins(jeu);
		this.vitesseMoins.addActionListener(vitesseMoins);
			
			
		// reste a gerer les appels au competences qui doivent faire decrementer le compteur via actionlistener
	      
		/*ActionAjoutWalker ajoutWalker = new ActionAjoutWalker(jeu,position);*/
		
		
		// Disposition des boutons et infos du bas
		
		JPanel BoutonsBas= new JPanel();
		GridLayout dispositionBoutonsBas = new GridLayout(2, 8);
		
		BoutonsBas.setLayout(dispositionBoutonsBas);
		BoutonsBas.add(this.climber);
		BoutonsBas.add(this.floater);
		BoutonsBas.add(this.blocker);
		BoutonsBas.add(this.bomber);
		BoutonsBas.add(this.builder);
		BoutonsBas.add(this.basher);
		BoutonsBas.add(this.digger);
		BoutonsBas.add(this.miner);
		
		BoutonsBas.add(this.Time);
		BoutonsBas.add(this.Speed);
		BoutonsBas.add(this.Out);
		BoutonsBas.add(this.Home);
		BoutonsBas.add(this.Total);
		BoutonsBas.add(this.Niveau);		
		BoutonsBas.add(this.Courage);
		
		// Disposition des boutons du coté droit
		JPanel BoutonsDroit = new JPanel();
		GridLayout dispositionBoutonsDroit = new GridLayout(4,1);
		
		BoutonsDroit.setLayout(dispositionBoutonsDroit);
		BoutonsDroit.add(this.quitter);
		BoutonsDroit.add(this.vitessePlus);
		BoutonsDroit.add(this.vitesseMoins);
		BoutonsDroit.add(this.lemming);
		
		// Disposition Globale
		
		Container conteneur = fenetre1.getContentPane();
		conteneur.setLayout(new BorderLayout());
		
		conteneur.add(zonecarte);
		conteneur.add(BoutonsDroit,BorderLayout.EAST);
		conteneur.add(BoutonsBas, BorderLayout.SOUTH);
		
		
		
	      
	      
	      
	      
	      
	    //Deuxieme fenetre
	      this.vitesse = new JLabel("Vitesse :");
	      this.aptitude = new JLabel("Aptitude :");
	      this.temps_r = new JLabel("temps restant aptitude :");
	      
	      Container conteneur2 = fenetre2.getContentPane();
	      GridLayout dispositionBoutons2f = new GridLayout(4, 1);
	      conteneur2.setLayout(dispositionBoutons2f);
	      conteneur2.add(this.vitesse);
	      conteneur2.add(this.aptitude);
	      conteneur2.add(this.temps_r);
	      
	     
	  
		
	
		
		// Affichage de la fenetre
	      
	      this.fenetre1.pack();
	      this.fenetre1.setVisible(true);
	      
	      this.fenetre2.pack();
	      this.fenetre2.setVisible(true);
	}



			
	public void afficherCarte(Jeu jeu) {
		for(int i=0; i< jeu.getMap().getTailleLigne(); i++){
			for(int j=0; j<jeu.getMap().getTailleColonne(); j++){
				
				
				
				if(jeu.getMap().getMap().get(j).get(i) == ' '){
					zoneMap[i][j]= new JLabel(" "); // modif
				}
				if(jeu.getMap().getMap().get(j).get(i) == '*'){
					zoneMap[i][j]= new JLabel(icon1, JLabel.CENTER);
				}
				if(jeu.getMap().getMap().get(j).get(i) == '!'){
					zoneMap[i][j]= new JLabel(icon3, JLabel.CENTER);
				}
				if(jeu.getMap().getMap().get(j).get(i) == '>'){
					zoneMap[i][j]= new JLabel(">");
				}
				if(jeu.getMap().getMap().get(j).get(i) == '<'){
					zoneMap[i][j]= new JLabel("<");
				}
				if(jeu.getMap().getMap().get(j).get(i) == 'v'){
					zoneMap[i][j]= new JLabel("v");
				}
				if(jeu.getMap().getMap().get(j).get(i) == '@'){
					zoneMap[i][j]= new JLabel(icon4, JLabel.CENTER);
				}
				if(jeu.getMap().getMap().get(j).get(i) == '%'){
					zoneMap[i][j]= new JLabel("%");
				}
				if(jeu.getMap().getMap().get(j).get(i) == 'O'){
					zoneMap[i][j]= new JLabel("O");
				}
				if(jeu.getMap().getMap().get(j).get(i) == '+'){
					zoneMap[i][j]= new JLabel(icon0,JLabel.CENTER);
				}
			}
		
		}
 }	
	
	
	/* Implementation du Timer */
	ActionListener tourDeJeu = new ActionTourDeJeu(controleur,this);
	
	int delay = 1000; //milliseconds
	Timer timer = new Timer(delay, tourDeJeu);
	
	//timer.start();
	
	public class ActionTourDeJeu implements ActionListener {
		
		private Controleur controleur;
		private FenetreJeu fenetre;
		
		public ActionTourDeJeu(Controleur controleur, FenetreJeu fenetre) {
		
			this.controleur =  controleur;
			this.fenetre = fenetre;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			
			try {
			
			Position origine = new Position (31,2);
			Direction directionDefaut = new Direction (false,false,true);
			
			char direction = ' ';
			
			if (controleur.jeu.listLemmings.get(controleur.jeu.lemmingsApparus - 1).direction.gauche){
				direction = 'g';
			}
			if (controleur.jeu.listLemmings.get(controleur.jeu.lemmingsApparus - 1).direction.droite){
				direction = 'd';
			}
			if (controleur.jeu.listLemmings.get(controleur.jeu.lemmingsApparus - 1).direction.bas){
				direction = 'b';
			}
			// Donnees relatives au lemming
			System.out.println("Competence = " +controleur.jeu.listLemmings.get(controleur.jeu.lemmingsApparus - 1).competence.getClass().toString());
      		System.out.println("Abscisse = " +controleur.jeu.listLemmings.get(controleur.jeu.lemmingsApparus -1).position.abscisse);
			System.out.println("Ordonnee =  " +controleur.jeu.listLemmings.get(controleur.jeu.lemmingsApparus -1).position.ordonnee);
			System.out.println("Direction = " +direction);
			System.out.println(" Devant = "+ controleur.jeu.getMap().getDevant(origine,directionDefaut,controleur.jeu.getMap()).decorToChar());
			System.out.println(" Dessous = "+ controleur.jeu.getMap().getDessous(origine,directionDefaut,controleur.jeu.getMap()).decorToChar());
			System.out.println("---------------------------------------------------");
			
			// Rafraichissement de la carte et execution d'un tour
			controleur.jeu.listLemmings.get(controleur.jeu.lemmingsApparus - 1).competence.executer(origine, controleur.jeu.map, controleur.jeu.listLemmings.get(controleur.jeu.lemmingsApparus - 1));
			fenetre.afficherCarte(controleur.jeu);
			
			}
			
			catch ( ConfigurationException e) {
				e.getMessage();
			}
			
		}
		
	
	
	}

	
	
}







