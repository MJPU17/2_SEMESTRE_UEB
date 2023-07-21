package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelActualizar extends JPanel{
	
	private JLabel eactualizar;
	private JTextField factualizar;
	private JComboBox<String> cestadocivil;
	private JButton batras,bactualizar;
	
	public PanelActualizar() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		inicializarComponentes();
		
		setVisible(false);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		String[] est_civil= {"Soltero/a","Casado/a","Union libre","Separado/a","Divorciado/a","Viudo/a"};
		
		eactualizar=new JLabel();
		eactualizar.setForeground(Color.white);
		eactualizar.setFont(new Font("Calisto MT",ALLBITS, 25));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.gridheight=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		add(eactualizar,gbc);
		
		factualizar=new JTextField();
		cestadocivil=new JComboBox<String>(est_civil);
		factualizar.setFont(new Font("Calisto MT",ALLBITS, 25));
		cestadocivil.setFont(new Font("Calisto MT",ALLBITS, 25));
		factualizar.setVisible(false);
		cestadocivil.setVisible(false);
		gbc.gridy=1;
		gbc.ipadx=500;
		add(factualizar,gbc);
		gbc.ipadx=0;
		add(cestadocivil,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS ACTUALIZAR");
		batras.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		batras.setForeground(Color.white);
		batras.setBackground(Color.cyan);
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.ipadx=20;
		gbc.ipady=10;
		add(batras,gbc);
		
		bactualizar=new JButton("Actualizar");
		bactualizar.setActionCommand("ACTUALIZAR DATOS");
		bactualizar.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bactualizar.setForeground(Color.white);
		bactualizar.setBackground(Color.cyan);
		gbc.gridx=1;
		add(bactualizar,gbc);
		
	}

	public JLabel getEactualizar() {
		return eactualizar;
	}

	public void setEactualizar(JLabel eactualizar) {
		this.eactualizar = eactualizar;
	}

	public JTextField getFactualizar() {
		return factualizar;
	}

	public void setFactualizar(JTextField factualizar) {
		this.factualizar = factualizar;
	}

	public JComboBox<String> getCestadocivil() {
		return cestadocivil;
	}

	public void setCestadocivil(JComboBox<String> cestadocivil) {
		this.cestadocivil = cestadocivil;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}

	public JButton getBactualizar() {
		return bactualizar;
	}

	public void setBactualizar(JButton bactualizar) {
		this.bactualizar = bactualizar;
	}
	
	

}
