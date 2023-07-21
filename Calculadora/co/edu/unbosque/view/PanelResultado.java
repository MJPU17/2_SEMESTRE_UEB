package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class PanelResultado extends JPanel{
	
	private JTextArea tresultado;
	
	public PanelResultado() {
		setLayout(new GridLayout());
		
		incializarComponentes();
		
		setVisible(true);
	}

	private void incializarComponentes() {
		
		tresultado=new JTextArea();
		tresultado.setFont(cambiarFuente("Calculator", 45));
		tresultado.setBackground(Color.LIGHT_GRAY);
		tresultado.setBorder(new LineBorder(new Color(17,51,97),15));
		tresultado.setForeground(Color.black);
		tresultado.setEditable(false);
		add(tresultado);
		
	}
	
	public Font cambiarFuente(String name,int size) {
		Font subir=new Font("Arial", ALLBITS, size);
		try {
			subir=Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Imagenes_Fuentes/"+name+".ttf"));
		} catch (FontFormatException e) {
			subir=new Font("Arial", ALLBITS, size);
		} catch (IOException e) {
			subir=new Font("Arial", ALLBITS, size);
		}
		Font fuente=subir.deriveFont(ALLBITS,size);
		return fuente;
	}

	public JTextArea getTresultado() {
		return tresultado;
	}

	public void setTresultado(JTextArea tresultado) {
		this.tresultado = tresultado;
	}
	
}
