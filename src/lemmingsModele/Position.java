package lemmingsModele;
/** La classe position qui repr�sente les coordonn�es d'un lemming donn�
 * @author Quentin Glinel-Mortreuil
 */


public class Position {
 
	 public int abscisse; // l'ordonn�e o� se trouve le lemming 
	 public int ordonnee;  // l'abscisse o� se trouve le lemming

 
 /* Constructeur inverse afin de rester coherent par rapport a la
  * maniere de recuperer la map
  */
 public Position(int x,int y) {
  this.abscisse = x;
  this.ordonnee = y;
 }
 
 public int getAbscisse() {
  return abscisse;
 }
 public void setAbscisse(int abscisse) {
  this.abscisse = abscisse;
 }
 public int getOrdonnee() {
  return ordonnee;
 }
 public void setOrdonnee(int ordonnee) {
  this.ordonnee = ordonnee;
 }
 
 
}

