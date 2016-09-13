import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class GUI extends JFrame{
	private JPanel panel,panelFondo;
	private JLabel label;
	
	public GUI(){
		super();
		setSize(new Dimension(440, 400)); // 1024 768
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		panelFondo=new JPanel();
		panelFondo.setLayout(null);
		label = new JLabel();
		

		//setContentPane(panel);
		panelFondo = new JPanel();
		panelFondo.setLayout(null);
		
		
		panelFondo.setOpaque(false);
		armarMapa(); 
		
		
		label.setBounds(0, 0,50,50);
		label.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/37.png")));
		panelFondo.add(label);
		this.setVisible(true);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0.getKeyCode());
			}
		});
			
		}
	
	private void mover(int k){
		switch(k){
		case KeyEvent.VK_UP :
			label.setBounds((int) label.getBounds().getX(),(int) label.getBounds().getY() - 10, 50, 50);
			break;
		case KeyEvent.VK_DOWN :
			label.setBounds((int) label.getBounds().getX(),(int) label.getBounds().getY()  +10 , 50, 50);
			break;
		case KeyEvent.VK_RIGHT :
			label.setBounds((int) label.getBounds().getX() +10,(int) label.getBounds().getY(), 50, 50);
			break;
		case KeyEvent.VK_LEFT :
			label.setBounds((int) label.getBounds().getX() -10,(int) label.getBounds().getY(), 50, 50);
			break;
		
	}
		label.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/"+k+".png")));
	}
	
	private void armarMapa(){
		BufferedReader br = null;
		String file = "mapa1.txt";
		String sCurrent;
		JLabel aux;
		try {
			br = new BufferedReader(new FileReader(file));
			int columna=0;
			while((sCurrent = br.readLine())!=null){
				for(int i=0;i<sCurrent.length();i++){
					char ch=sCurrent.charAt(i);
					switch(ch){
						case'1': 	aux=new JLabel();
									
									aux.setBounds(i*50,columna*50,50,50);
								
									
									aux.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/Agua.png")));
									aux.setOpaque(false);
									panelFondo.add(aux,i,columna); 
									
									System.out.println("lei un 1 y estoy en F:"+i+" C:"+columna);
								break;
						case '2':aux=new JLabel();
						aux.setBounds(i*50,columna*50,50,50);
						
						aux.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/Arbol.png")));
						panelFondo.add(aux,i,columna);
								break;
						case '3':panelFondo.add(new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Ladrillo.png"))),i,columna);
								break; 
						case '4': panelFondo.add(new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Pared.png"))),i,columna);
								break;
					}
				}
				columna+=1;
			}
	  		
		System.out.println("checkpoint");
		panelFondo.setVisible(true);
		
		setContentPane(panelFondo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	}


