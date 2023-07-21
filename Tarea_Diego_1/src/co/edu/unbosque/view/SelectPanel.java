package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SelectPanel extends JPanel{
	
	private JLabel lselect;
	private JComboBox<String> cproducts;
	private JButton bconsult,bedit,beliminated,bback;
	
	public SelectPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		startingComponents();
		
		setVisible(false);
	}

	public void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		lselect=new JLabel();
		lselect.setForeground(Color.white);
		lselect.setFont(new Font("Arial",Font.BOLD,30));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridheight=1;
		gbc.gridwidth=2;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(lselect,gbc);
		
		cproducts=new JComboBox<>();
		cproducts.setForeground(Color.white);
		cproducts.setBackground(Color.cyan);
		cproducts.setBorder(new LineBorder(Color.white));
		cproducts.setFont(new Font("Arial",Font.ITALIC,30));
		gbc.gridy=1;
		gbc.gridx=0;
		add(cproducts,gbc);
		
		bback=new JButton("Back");
		bback.setActionCommand("BACK");
		bback.setForeground(Color.white);
		bback.setBackground(Color.cyan);
		bback.setBorder(new LineBorder(Color.white,3));
		bback.setFont(new Font("Arial",Font.ITALIC,30));
		gbc.gridy=2;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.ipady=10;
		gbc.ipadx=50;
		add(bback,gbc);
		
		bconsult=new JButton("Search");
		bconsult.setActionCommand("SEARCH");
		bconsult.setForeground(Color.white);
		bconsult.setBackground(Color.cyan);
		bconsult.setBorder(new LineBorder(Color.white,3));
		bconsult.setFont(new Font("Arial",Font.ITALIC,30));
		bconsult.setVisible(false);
		gbc.ipadx=30;
		gbc.gridx=1;
		add(bconsult,gbc);
		
		bedit=new JButton("Edit");
		bedit.setActionCommand("EDIT PRODUCT");
		bedit.setForeground(Color.white);
		bedit.setBackground(Color.cyan);
		bedit.setBorder(new LineBorder(Color.white,3));
		bedit.setFont(new Font("Arial",Font.ITALIC,30));
		bedit.setVisible(false);
		gbc.ipadx=60;
		add(bedit,gbc);
		
		beliminated=new JButton("Eliminate");
		beliminated.setActionCommand("ELIMINATE");
		beliminated.setForeground(Color.white);
		beliminated.setBackground(Color.cyan);
		beliminated.setBorder(new LineBorder(Color.white,3));
		beliminated.setFont(new Font("Arial",Font.ITALIC,30));
		beliminated.setVisible(false);
		gbc.ipadx=15;
		add(beliminated,gbc);
	
	}

	public JLabel getLselect() {
		return lselect;
	}

	public void setLselect(JLabel lselect) {
		this.lselect = lselect;
	}

	public JComboBox<String> getCproducts() {
		return cproducts;
	}

	public void setCproducts(JComboBox<String> cproducts) {
		this.cproducts = cproducts;
	}

	public JButton getBconsult() {
		return bconsult;
	}

	public void setBconsult(JButton bconsult) {
		this.bconsult = bconsult;
	}

	public JButton getBedit() {
		return bedit;
	}

	public void setBedit(JButton bedit) {
		this.bedit = bedit;
	}

	public JButton getBeliminated() {
		return beliminated;
	}

	public void setBeliminated(JButton beliminated) {
		this.beliminated = beliminated;
	}

	public JButton getBback() {
		return bback;
	}

	public void setBback(JButton bback) {
		this.bback = bback;
	}

}
