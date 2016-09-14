import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import PU.*;
import Pisos.*;
import Tanque.*;



public class Mapa extends JFrame{
	private JPanel panel,panelObstaculos,panelFondo;
	private JLabel label;
	private ImageIcon[] celdaGrafico;
	private ImageIcon[] jugadorGrafico;
	private ImageIcon[] enemigosGrafico;
	private Jugador player;
	private Enemigo[] enemigos;
	private PowerUp powerUpActivo;
	private static final int h=32;
	private static final int w=32;
	
	public Mapa(){
		super();
		setSize(new Dimension(384, 384)); // 1024 768
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelFondo=new JPanel();
		
		
		panelObstaculos=new JPanel();
		panelObstaculos.setLayout(null);
		panelObstaculos.setBackground(Color.BLACK);
		
		
		inicializarImagenes();
		
		
		
		
		setContentPane(panelObstaculos);
		
		armarMapa(); 
		panelObstaculos.setVisible(true);
		
		
		label = new JLabel();
		label.setBounds(0, 0,h-2,w-2);
		
		label.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/37.png")));
		label.setOpaque(false);
		player = new Jugador(0,0);
		
		panelObstaculos.add(label);
		
		getContentPane().setComponentZOrder(label, 0);
		this.setVisible(true);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0.getKeyCode());
			}
		});
			
		}
	
	private void mover(int k){
//		switch(k){
//		case KeyEvent.VK_UP :
//			label.setBounds((int) label.getBounds().getX(),(int) label.getBounds().getY() - 10, h-2, w-2);
//			break;
//		case KeyEvent.VK_DOWN :
//			label.setBounds((int) label.getBounds().getX(),(int) label.getBounds().getY()  +10 , h-2, w-2);
//			break;
//		case KeyEvent.VK_RIGHT :
//			label.setBounds((int) label.getBounds().getX() +10,(int) label.getBounds().getY(), h-2, w-2);
//			break;
//		case KeyEvent.VK_LEFT :
//			label.setBounds((int) label.getBounds().getX() -10,(int) label.getBounds().getY(), h-2,w-2 );
//			break;
//		
//		} CODIGO VIEJO, LO DEJO POR LAS DUDAS
		player.mover(k);//Movemos el jugador
		label.setBounds((int)player.getX(),(int)player.getY(),h-2,w-2);//Repainteamos
		label.setIcon(jugadorGrafico[k-37]);
		
	}
	
	private void armarMapa(){
		BufferedReader br = null;
		String file = "mapa1.txt";
		String sCurrent;
		JLabel aux;
		try {
			br = new BufferedReader(new FileReader(file));
			Celda celda;
			int columna=0;
			while((sCurrent = br.readLine())!=null){
				for(int i=0;i<sCurrent.length();i++){
					char ch=sCurrent.charAt(i);
					switch(ch){
						case'1': 	aux=new JLabel();
									aux.setBounds(i*h,columna*w,h,w);
									celda=new Agua(i*h,columna*w);
									//celda.setX(i*h);		//	
									//celda.setY(columna*w);	// Nose si seria necesario conocer la ubicacion de la celda
									aux.setIcon(celdaGrafico[0]);
									aux.setOpaque(false);
									panelObstaculos.add(aux,i,columna); 
									
									//System.out.println("lei un 1 y estoy en F:"+i+" C:"+columna);
								break;
						case '2':	aux=new JLabel();
									aux.setBounds(i*h,columna*w,h,w);
									celda=new Arbol(i*h,columna*w);
									aux.setIcon(celdaGrafico[1]);
									aux.setOpaque(false);
									panelObstaculos.add(aux,i,columna); 
								break;
						case '3':	aux=new JLabel();
									aux.setBounds(i*h,columna*w,h,w);
									celda=new Ladrillo(i*h,columna*w);
									aux.setIcon(celdaGrafico[2]);
									aux.setOpaque(false);
									panelObstaculos.add(aux,i,columna); ;
								break; 
						case '4': 	aux=new JLabel();
									aux.setBounds(i*h,columna*w,h,w);
									celda=new Metal(i*h,columna*w);
									aux.setIcon(celdaGrafico[3]);
									aux.setOpaque(false);
									panelObstaculos.add(aux,i,columna); ;
								break;
					}
				}
				columna+=1;
			}
	  		
		System.out.println("checkpoint");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void inicializarImagenes(){
		jugadorGrafico=new ImageIcon[4];
		jugadorGrafico[0]=new ImageIcon(this.getClass().getResource("/imagenes/37.png"));
		jugadorGrafico[1]=new ImageIcon(this.getClass().getResource("/imagenes/38.png"));
		jugadorGrafico[2]=new ImageIcon(this.getClass().getResource("/imagenes/39.png"));
		jugadorGrafico[3]=new ImageIcon(this.getClass().getResource("/imagenes/40.png"));
		
		celdaGrafico=new ImageIcon[4];
		celdaGrafico[0]=new ImageIcon(this.getClass().getResource("/imagenes/Agua.png"));
		celdaGrafico[1]=new ImageIcon(this.getClass().getResource("/imagenes/Arbol.png"));
		celdaGrafico[2]=new ImageIcon(this.getClass().getResource("/imagenes/Ladrillo.png"));
		celdaGrafico[3]=new ImageIcon(this.getClass().getResource("/imagenes/Pared.png"));
	}
	}


