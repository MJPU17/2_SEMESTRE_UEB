package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelMostrar extends JPanel{
	
	private JLabel emostrar;
	private JComboBox<String> cbmostrar;
	private JButton batras,baceptar;
	
	public PanelMostrar() {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridBagLayout());
		
		inicializarComponentes();
		
		setVisible(false);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		emostrar=new JLabel("Seleccione una opcion: ");
		emostrar.setFont(new Font("Arial", ALLBITS, 15));
		emostrar.setForeground(Color.white);
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=2;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(emostrar,gbc);
		
		cbmostrar=new JComboBox<>();
		cbmostrar.setFont((new Font("Arial",Font.BOLD,20)));
		cbmostrar.setBorder(new LineBorder(new Color(0,13,112),3));
		cbmostrar.addItem("Mostrar colombianos");
		cbmostrar.addItem("Mostrar extranjeros");
		cbmostrar.addItem("Mostrar todos");
		gbc.gridy=1;
		add(cbmostrar,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS MOSTRAR");
		batras.setFont(new Font("Arial",Font.BOLD,20));
		batras.setForeground(Color.white);
		batras.setBackground(new Color(0,13,112));
		batras.setBorder(new LineBorder(Color.white,2));
		batras.setFocusPainted(false);
		batras.setPreferredSize(new Dimension(150,50));
		gbc.gridy=2;
		gbc.gridwidth=1;
		add(batras,gbc);
		
		baceptar=new JButton("Acpeptar");
		baceptar.setActionCommand("MOSTRAR");
		baceptar.setFont(new Font("Arial",Font.BOLD,20));
		baceptar.setForeground(Color.white);
		baceptar.setBackground(new Color(0,13,112));
		baceptar.setBorder(new LineBorder(Color.white,2));
		baceptar.setFocusPainted(false);
		baceptar.setPreferredSize(new Dimension(150,50));
		gbc.gridx=1;
		add(baceptar,gbc);
		
		
	}

	public JLabel getEmostrar() {
		return emostrar;
	}

	public void setEmostrar(JLabel emostrar) {
		this.emostrar = emostrar;
	}

	public JComboBox<String> getCbmostrar() {
		return cbmostrar;
	}

	public void setCbmostrar(JComboBox<String> cbmostrar) {
		this.cbmostrar = cbmostrar;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}

	public JButton getBaceptar() {
		return baceptar;
	}

	public void setBaceptar(JButton baceptar) {
		this.baceptar = baceptar;
	}

}
