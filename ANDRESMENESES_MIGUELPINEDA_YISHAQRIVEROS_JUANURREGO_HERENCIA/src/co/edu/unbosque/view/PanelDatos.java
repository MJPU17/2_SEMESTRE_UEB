package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelDatos extends JPanel{
	
	private JLabel eresult;
	private JTextArea aresult;
	private JButton batras;
	
	public PanelDatos() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		iniciarComponentes();
		
		setVisible(false);
	}

	private void iniciarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		eresult=new JLabel("Resultado:");
		eresult.setForeground(Color.white);
		eresult.setFont(new Font("Calisto MT",ALLBITS, 30));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		add(eresult,gbc);
		
		aresult=new JTextArea();
		aresult.setEditable(false);
		aresult.setFont(new Font("Calisto MT",ALLBITS, 25));
		gbc.fill=GridBagConstraints.BOTH;
		gbc.gridy=1;
		add(aresult,gbc);
	
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS BUSQUEDA");
		batras.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		batras.setBackground(Color.cyan);
		batras.setForeground(Color.white);
		gbc.gridy=2;
		gbc.fill=ALLBITS;
		gbc.ipadx=20;
		gbc.ipady=10;
		add(batras,gbc);
		
	}

	public JLabel getEresult() {
		return eresult;
	}

	public void setEresult(JLabel eresult) {
		this.eresult = eresult;
	}

	public JTextArea getAresult() {
		return aresult;
	}

	public void setAresult(JTextArea aresult) {
		this.aresult = aresult;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}

}
