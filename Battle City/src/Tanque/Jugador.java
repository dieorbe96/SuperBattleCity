package Tanque;

import java.awt.event.KeyEvent;

public class Jugador {
	private float posX;
	private float posY;
	private boolean PuedoMoverme;
	
	public Jugador(){
		
	}
	/*
	 * Actualiza la posicion del jugador en funcion de la tecla pasada por parametro
	 */
	public void mover(int k){
		if (PuedoMoverme){
			PuedoMoverme=false;
			switch(k){
				case KeyEvent.VK_UP :
					//aca iria lo del for con la velocidad, en cada case habria que modificar las posiciones
					break;
				case KeyEvent.VK_DOWN :
			
					break;
				case KeyEvent.VK_RIGHT :
			
					break;
				case KeyEvent.VK_LEFT :
			
					break;
			}
		PuedoMoverme=true;
		}
	}
	public float getX(){
		return posX;
	}
	public float getY(){
		return posY;
	}
	
}
