package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelDatos extends JPanel{
	
	private JButton[][]bcalculadora;
	private JButton bborrar, bquitar;
	private JLabel iboton;
	
	
	public PanelDatos() {
		setLayout(new GridBagLayout());
		setBackground(new Color(17,51,97));
		
		inicializarComponentes();
		
		setVisible(true);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gcb= new GridBagConstraints();
		ImageIcon subir=new ImageIcon(getClass().getResource("/Imagenes_Fuentes/boton.png"));
		ImageIcon imagen=new ImageIcon(subir.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH));
		subir=new ImageIcon(getClass().getResource("/Imagenes_Fuentes/quitar.png"));
		ImageIcon quitar=new ImageIcon(subir.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH));
		
		String[][]tbotones= {
				{"(",")","%","/"},
				{"7","8","9","X"},
				{"4","5","6","-"},
				{"1","2","3","+"},
				{"+/-","0",".","="},
		};
		
		String[][] abotones= {
				{"IPARENTESIS","FPARENTESIS","PORCENTAJE","DIVISION"},
				{"SIETE","OCHO","NUEVE","MULTIPLICACION"},
				{"CUATRO","CINCO","SEIS","MENOS"},
				{"UNO","DOS","TRES","MAS"},
				{"OPUESTO","CERO","PUNTO","IGUAL"},
		};
		
		bborrar=new JButton("C");
		bborrar.setActionCommand("BORRAR");
		bborrar.setFont(cambiarFuente("EABOTON",45));
		bborrar.setContentAreaFilled(false);
		bborrar.setFocusPainted(false);
		bborrar.setBorderPainted(false);
		bborrar.setForeground(Color.white);
		iboton=new JLabel(imagen);
		gcb.gridy=0;
		gcb.gridx=0;
		gcb.gridwidth=2;
		gcb.gridheight=1;
		gcb.weightx=1.0;
		gcb.weighty=1.0;
		gcb.fill=GridBagConstraints.BOTH;
		add(bborrar,gcb);
		add(iboton,gcb);
		
		bquitar=new JButton(quitar);
		bquitar.setActionCommand("QUITAR");
		bquitar.setFont(cambiarFuente("EABOTON", 45));
		bquitar.setContentAreaFilled(false);
		bquitar.setFocusPainted(false);
		bquitar.setBorderPainted(false);
		bquitar.setForeground(Color.white);
		iboton=new JLabel(imagen);
		gcb.gridx=2;
		add(bquitar,gcb);
		add(iboton,gcb);
		
		bcalculadora=new JButton[5][4];
		
		for(int y=0;y<tbotones.length;y++) {
			for(int x=0;x<tbotones[y].length;x++) {
				bcalculadora[y][x]=new JButton(tbotones[y][x]);
				bcalculadora[y][x].setActionCommand(abotones[y][x]);
				bcalculadora[y][x].setFont(cambiarFuente("EABOTON", 45));
				bcalculadora[y][x].setContentAreaFilled(false);
				bcalculadora[y][x].setFocusPainted(false);
				bcalculadora[y][x].setBorderPainted(false);
				bcalculadora[y][x].setForeground(Color.white);
				iboton=new JLabel(imagen);
				gcb.gridx=x;
				gcb.gridy=y+1;
				gcb.gridwidth=1;
				add(bcalculadora[y][x],gcb);
				add(iboton,gcb);
			}
		}
	}
	
	public Font cambiarFuente(String name,int size) {
		Font subir=new Font("Arial",ALLBITS,size);
		try {
			subir=Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Imagenes_Fuentes/"+name+".ttf"));
		} catch (FontFormatException e) {
			subir=new Font("Arial",ALLBITS,size);
		} catch (IOException e) {
			subir=new Font("Arial",ALLBITS,size);
		}
		Font fuente=subir.deriveFont(ALLBITS,size);
		return fuente;
	}
	
	

	public JButton[][] getBcalculadora() {
		return bcalculadora;
	}

	public void setBcalculadora(JButton[][] bcalculadora) {
		this.bcalculadora = bcalculadora;
	}

	public JButton getBborrar() {
		return bborrar;
	}

	public void setBborrar(JButton bborrar) {
		this.bborrar = bborrar;
	}

	public JButton getBquitar() {
		return bquitar;
	}

	public void setBquitar(JButton bquitar) {
		this.bquitar = bquitar;
	}

	public JLabel getIboton() {
		return iboton;
	}

	public void setIboton(JLabel iboton) {
		this.iboton = iboton;
	}

}
