package lemmingsModele;

import java.lang.System;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class Reader{


	protected int timeRead;
	protected int countRead;
	protected int speedRead;
	protected int floaterRead;
	protected int climberRead;
	protected int rescueRead;
	protected int blockerRead;
	protected int bomberRead;
	protected int builderRead;
	protected int basherRead;
	protected int diggerRead;
	protected int minerRead;

	public Reader(){
		this.timeRead=0;
		this.countRead=0;
		this.speedRead=0;
		this.floaterRead=0;
		this.climberRead=0;
		this.rescueRead=0;
		this.blockerRead=0;
		this.bomberRead=0;
		this.builderRead=0;
		this.basherRead=0;
		this.diggerRead=0;
		this.minerRead=0;
	}


	/**VerificationDeLaCarte: 
	 * si tous les elements necessaires a la definition du jeu ont ete annonce une et une seule fois
	 * alors cette fonction renvoie vrai.
	 * */
	public boolean verificationDeLaCarte(){
		return(this.timeRead==1&&this.countRead==1&&this.speedRead==1&&this.floaterRead==1&&this.climberRead==1&&this.rescueRead==1&&
			this.blockerRead==1&&this.bomberRead==1&&this.builderRead==1&&this.basherRead==1&&this.diggerRead==1&&this.minerRead==1);
	}


	public void recognize(String ligne,Jeu jeu){
		String chaine0;
		String chaine1;
		StringTokenizer st = new StringTokenizer(ligne);
		if (st.hasMoreTokens()){
		chaine0=st.nextToken();
			if (st.hasMoreTokens()){
				chaine1=st.nextToken();
			}
			else { 
			chaine1="0";
			}
		}
		else{
			chaine0="0";
			chaine1="0";
		}
		if (chaine0.equals("speed")){
			jeu.setSpeed(associate(chaine1));
			this.speedRead++;
		}
		if (chaine0.equals("count")){
			this.countRead++;
			jeu.setCount(associate(chaine1));
		}
		if (chaine0.equals("time")){
			this.timeRead++;
			jeu.setTime(associate(chaine1));
		}
		if (chaine0.equals("rescue")){
			this.rescueRead++;
			jeu.setRescue(associate(chaine1));
		}
		if (chaine0.equals("climber")){
			this.climberRead++;
			jeu.setClimber(associate(chaine1));
		}
		if (chaine0.equals("floater")){
			this.floaterRead++;
			jeu.setFloater(associate(chaine1));
		}
		if (chaine0.equals("blocker")){
			this.blockerRead++;
			jeu.setBlocker(associate(chaine1));
		}
		if (chaine0.equals("bomber")){
			this.bomberRead++;
			jeu.setBomber(associate(chaine1));
		}
		if (chaine0.equals("builder")){
			this.builderRead++;
			jeu.setBuilder(associate(chaine1));
		}
		if (chaine0.equals("basher")){
			this.basherRead++;
			jeu.setBasher(associate(chaine1));
		}
		if (chaine0.equals("digger")){
			this.diggerRead++;
			jeu.setDigger(associate(chaine1));
		}
		if (chaine0.equals("miner")){
			this.minerRead++;
			jeu.setMiner(associate(chaine1));
			}
		if (chaine0.equals("map")){
			jeu.map.setMapDetecte(true);
		}
	}

	/**Donne la valeur en entier d'un string
	 * */

	public int associate(String mot){
		int retour;
		retour=Integer.parseInt(mot);
		return retour;
	}		




	public void initialiserLeJeu(Jeu jeu,String nomDuFichierMap){
		try{
		/**On cree ici le buffer qui nous sert a lire le fichier texte*/
		InputStream ips=new FileInputStream(nomDuFichierMap);
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		String ligne;
		/**On lit ici toutes les donnees sur les lemmings*/
		while ((ligne=br.readLine())!=null&&!jeu.map.getMapDetecte()){ // Des que l'on lit le mot map on sort de la boucle
			recognize(ligne,jeu);
		}
		if (!verificationDeLaCarte()) {
			throw new ConfigurationException("La carte en argument n'est pas correctement definie! \n");
		}
		else {
		jeu.afficherJeu();
		/**Des qu'on lit le mot map on passe a l'etape d'enregistrement
		 * de la map*/
		if (jeu.map.getMapDetecte()){
			jeu.map.setTailleLigne(ligne.length());
			jeu.map.setMap(new ArrayList<ArrayList<Character>>(ligne.length()));
			jeu.map.setNouvelleLigneMap(ligne);

			int i=1; //On cree ici un compteur pour recenser le nombre de colonnes
			while (((ligne=br.readLine())!=null)&&(ligne.length()==jeu.map.getTailleLigne())){
				jeu.map.setNouvelleLigneMap(ligne);
				i++;
			}
			jeu.map.setTailleColonne(i);
			jeu.map.afficherMap();
			jeu.setPause(true);
		}
		}

		br.close();
	}
	catch (Exception e) {
		System.out.println(e.toString());
	}


	}
	

}
