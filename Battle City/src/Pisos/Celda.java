package Pisos;

public abstract class Celda {
	private float posX,posY;
	
	public Celda(float x, float y){
		posX = x;
		posY = y;
	}
	
	public void setX(float x){
		posX= x;
	}
	
	public void setY(float y){
		posY= y;
	}
	
	public float getX() {
		return posX;
		
	}
	
	public float getY() {
		return posY;
	}
	
}
