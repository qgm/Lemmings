package lemmingsModele;
/** L'interface comp�tence qui va permettre de d�finir une m�thode
 * 	executer() diff�rente suivant les comp�tences du lemming s�lectionn�
 * @author Quentin Glinel-Mortreuil
 *
 */

public interface Competence  {

	// La m�thode executer() commune � tous les types de lemmings
	public void executer(Position positionInitiale, Map map,Lemming lemming)  throws ConfigurationException;
	
	//public boolean finAscension(Position positionInitiale, Map map,Lemming lemming);
	
}
