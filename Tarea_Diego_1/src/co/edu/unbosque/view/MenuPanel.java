package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuPanel extends JPanel{
	
	private JLabel ltitle;
	private JButton bsave, bconsult, bedit, berase;
	
	public MenuPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		startingComponents();
		
		setVisible(true);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		ltitle=new JLabel("Product controller");
		ltitle.setFont(new Font("Arial",Font.BOLD,45));
		ltitle.setForeground(Color.white);
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.gridheight=1;
		gbc.gridwidth=3;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(ltitle,gbc);
		
		bsave=new JButton("Save");
		bsave.setActionCommand("SAVE");
		bsave.setBackground(Color.cyan);
		bsave.setBorder(new LineBorder(Color.white,3));
		bsave.setForeground(Color.white);
		bsave.setFont(new Font("Arial",Font.BOLD,25));
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.ipadx=50;
		gbc.ipady=10;
		add(bsave,gbc);
		
		bconsult=new JButton("Consult");
		bconsult.setActionCommand("CONSULT");
		bconsult.setBackground(Color.cyan);
		bconsult.setBorder(new LineBorder(Color.white,3));
		bconsult.setForeground(Color.white);
		bconsult.setFont(new Font("Arial",Font.BOLD,25));
		gbc.gridy=2;
		gbc.ipadx=20;
		add(bconsult,gbc);
		
		bedit=new JButton("Edit");
		bedit.setActionCommand("EDIT");
		bedit.setBackground(Color.cyan);
		bedit.setBorder(new LineBorder(Color.white,3));
		bedit.setForeground(Color.white);
		bedit.setFont(new Font("Arial",Font.BOLD,25));
		gbc.gridy=3;
		gbc.ipadx=60;
		add(bedit,gbc);
		
		berase=new JButton("Erase");
		berase.setActionCommand("ERASE");
		berase.setBackground(Color.cyan);
		berase.setBorder(new LineBorder(Color.white,3));
		berase.setForeground(Color.white);
		berase.setFont(new Font("Arial",Font.BOLD,25));
		gbc.gridy=4;
		gbc.ipadx=40;
		add(berase,gbc);
		
	}

	public JLabel getLtitle() {
		return ltitle;
	}

	public void setLtitle(JLabel ltitle) {
		this.ltitle = ltitle;
	}

	public JButton getBsave() {
		return bsave;
	}

	public void setBsave(JButton bsave) {
		this.bsave = bsave;
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

	public JButton getBerase() {
		return berase;
	}

	public void setBerase(JButton berase) {
		this.berase = berase;
	}

}
