package lemmingsModele;
public class DecorLanceFlamme implements Decor{

	public char representationDecor='!';

	/**Donne la representation d'un decor sous la forme d'un char*/
	public char decorToChar(){
		return '!';
	}


	public Decor charToDecor(){
		Decor decor=new DecorLanceFlamme();
		return decor;
	}

	/**Cette methode dit si l'obstacle est destructible ou pas en fonction de la position du lemming*/
	public boolean estDestructible(Position positionLemming, Position positionObstacle){
		return false;
	}

	public void detruireObstacle(){
		this.representationDecor=' ';
	}

	/**Le piege est mortel pour les lemmings qui se trouvent a une case du lance flamme en horizontal et sur le meme plan vertical**/

	public boolean estMortelle(Position positionLemming, Position positionObstacle){
		return (Math.abs(positionLemming.getAbscisse()-positionObstacle.getAbscisse())<=1);
	}
	
}

