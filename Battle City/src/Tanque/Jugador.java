package Tanque;

import java.awt.event.KeyEvent;

public class Jugador {
	private float posX;
	private float posY;
	private boolean PuedoMoverme;
	private int velocidad;
	
	public Jugador(float x, float y){
		velocidad=1;
		posX= x;
		posY= y;
	}
	/*
	 * Actualiza la posicion del jugador en funcion de la tecla pasada por parametro
	 */
	public void mover(int k){
		if (PuedoMoverme){
			PuedoMoverme=false;
			switch(k){
			case KeyEvent.VK_UP :
				posY-=5*velocidad;
				break;
			case KeyEvent.VK_DOWN :
				posY+=5*velocidad;
				break;
			case KeyEvent.VK_RIGHT :
				posX-=5*velocidad;
				break;
			case KeyEvent.VK_LEFT :
				posX+=5*velocidad;
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
