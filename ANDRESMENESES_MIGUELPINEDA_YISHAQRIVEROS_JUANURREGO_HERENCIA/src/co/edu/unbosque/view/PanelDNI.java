package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDNI extends JPanel{
	
	private JLabel edni;
	private JTextField fdni;
	private JButton batras,bbuscar,beliminar,bactualizar;
	
	public PanelDNI() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		inicializarComponentes();
		
		setVisible(false);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		edni=new JLabel("Ingrese el DNI de la persona que quiere eliminar:");
		edni.setForeground(Color.white);
		edni.setFont(new Font("Calisto MT",ALLBITS, 25));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.gridheight=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		add(edni,gbc);
		
		fdni=new JTextField();
		fdni.setFont(new Font("Calisto MT",ALLBITS, 25));
		gbc.gridy=1;
		gbc.ipadx=500;
		add(fdni,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS DNI");
		batras.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		batras.setForeground(Color.white);
		batras.setBackground(Color.cyan);
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.ipadx=20;
		gbc.ipady=10;
		add(batras,gbc);
		
		beliminar=new JButton("Eliminar");
		bbuscar=new JButton("Buscar");
		bactualizar=new JButton("Aceptar");
		beliminar.setActionCommand("ELIMINAR");
		bbuscar.setActionCommand("OBTENER");
		bactualizar.setActionCommand("ACTUALIZADO");
		beliminar.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bbuscar.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bactualizar.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		beliminar.setForeground(Color.white);
		bbuscar.setForeground(Color.white);
		bactualizar.setForeground(Color.white);
		beliminar.setBackground(Color.cyan);
		bbuscar.setBackground(Color.cyan);
		bactualizar.setBackground(Color.cyan);
		beliminar.setVisible(false);
		bbuscar.setVisible(false);
		bactualizar.setVisible(false);
		gbc.gridx=1;
		add(beliminar,gbc);
		add(bbuscar,gbc);
		add(bactualizar,gbc);
	}

	public JLabel getEdni() {
		return edni;
	}

	public void setEdni(JLabel edni) {
		this.edni = edni;
	}

	public JTextField getFdni() {
		return fdni;
	}

	public void setFdni(JTextField fdni) {
		this.fdni = fdni;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}

	public JButton getBeliminar() {
		return beliminar;
	}

	public void setBeliminar(JButton bagregar) {
		this.beliminar = bagregar;
	}

	public JButton getBbuscar() {
		return bbuscar;
	}

	public void setBbuscar(JButton bbuscar) {
		this.bbuscar = bbuscar;
	}

	public JButton getBactualizar() {
		return bactualizar;
	}

	public void setBactualizar(JButton bactualizar) {
		this.bactualizar = bactualizar;
	}

}
