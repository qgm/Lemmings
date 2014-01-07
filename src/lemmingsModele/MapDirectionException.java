package lemmingsModele;
/** La classe MapDirectionException gere les exceptions de direction de la classe Map
 * @author Quentin Glinel-Mortreuil
 */


public class MapDirectionException extends Exception {
	
	public MapDirectionException () {
		System.out.println("Direction du lemming incoherente");
	}
	
}
