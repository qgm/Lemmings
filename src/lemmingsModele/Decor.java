package lemmingsModele;
public interface Decor{

/**Donne la representation d'un decor sous la forme d'un char*/
	public char decorToChar();
/**Donne le decor associe a la representation sous forme de char*/
	public Decor charToDecor();
/**Donne le caractere destructible d'un element du decor en fonction de la position relative d'un lemming par rapport a celui-ci**/
	public boolean estDestructible(Position positionLemming, Position positionObstacle);
/**Detruit un decor*/
	public void detruireObstacle();
/**Dit si cet element du decor est mortelle ou pas pour le Lemming indique par sa position relative*/
	public boolean estMortelle(Position positionLemming, Position positionObstacle);
}



	

