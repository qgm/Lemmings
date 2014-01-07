package lemmingsModele;
public class DecorEntree implements Decor{

	public char representationDecor='O';

	/**Donne la representation d'un decor sous la forme d'un char*/
	public char decorToChar(){
		return 'O';
	}


	public Decor charToDecor(){
		Decor decor=new DecorEntree();
		return decor;
	}

	/**Cette methode dit si l'obstacle est destructible ou pas en fonction de la position du lemming*/
	public boolean estDestructible(Position positionLemming, Position positionObstacle){
		return false;
	}

	public void detruireObstacle(){
		this.representationDecor=' ';
	}

	public boolean estMortelle(Position positionLemming, Position positionObstacle){
		return (false);
	}
}
