package Pisos;

public abstract class Celda {
	protected float posX,posY;

	
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
