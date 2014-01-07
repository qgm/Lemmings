package lemmingsModele;
public class DecorDestructibleBas implements Decor{

	public char representationDecor='v';

	/**Donne la representation d'un decor sous la forme d'un char*/
	public char decorToChar(){
		return 'v';
	}


	public Decor charToDecor(){
		Decor decor=new DecorDestructibleBas();
		return decor;
	}

	/**Cette methode dit si l'obstacle est destructible ou pas en fonction de la position du lemming*/
	public boolean estDestructible(Position positionLemming, Position positionObstacle){
		return (positionLemming.getOrdonnee()-positionObstacle.getOrdonnee())>0;
	}

	public void detruireObstacle(){
		this.representationDecor=' ';
	}

	public boolean estMortelle(Position positionLemming, Position positionObstacle){
		return (false);
	}
}

