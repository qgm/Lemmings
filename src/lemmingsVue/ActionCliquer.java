package lemmingsVue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionCliquer extends MouseAdapter {

	private int x; // abscisse de la case
	private int y; // ordonnee de la case
	
	public ActionCliquer ( int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}


}
