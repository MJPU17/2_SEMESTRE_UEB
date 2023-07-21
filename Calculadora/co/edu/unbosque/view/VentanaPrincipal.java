package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	private PanelDatos pdatos;
	private PanelResultado presultado;
	
	public VentanaPrincipal() {
		setTitle("Calculadora");
		setSize(520, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(new Color(17,51,97));;
		
		incializarComponentes();
		
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void incializarComponentes() {
		
		GridBagConstraints gcb=new GridBagConstraints();
		
		presultado=new PanelResultado();
		gcb.gridx=0;
		gcb.gridy=0;
		gcb.gridwidth=4;
		gcb.gridheight=3;
		gcb.weightx=1.0;
		gcb.weighty=1.0;
		gcb.fill=GridBagConstraints.BOTH;
		add(presultado,gcb);
		
		pdatos=new PanelDatos();
		gcb.gridy=3;
		gcb.gridheight=5;
		add(pdatos,gcb);
	
	}

	public PanelDatos getPdatos() {
		return pdatos;
	}

	public void setPdatos(PanelDatos pdatos) {
		this.pdatos = pdatos;
	}

	public PanelResultado getPresultado() {
		return presultado;
	}

	public void setPresultado(PanelResultado presultado) {
		this.presultado = presultado;
	}
	
}
