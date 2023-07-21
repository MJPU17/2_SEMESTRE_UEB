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
	private JButton bregister;
	private JButton bconsult;
	
	public MenuPanel() {
		setBackground(Color.darkGray);
		setLayout(new GridBagLayout());
		
		startingComponents();
		
		setVisible(true);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		ltitle=new JLabel("Person Register");
		ltitle.setFont(new Font("Arial",ABORT,45));
		ltitle.setForeground(Color.white);
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridheight=1;
		gbc.gridwidth=2;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		add(ltitle,gbc);
		
		bregister=new JButton("Register");
		bregister.setActionCommand("REGISTER");
		bregister.setFont(new Font("Arial",ABORT,35));
		bregister.setForeground(Color.white);
		bregister.setBackground(Color.BLUE);
		bregister.setBorder(new LineBorder(Color.white,3));
		gbc.gridy=1;
		gbc.ipady=10;
		gbc.gridwidth=1;
		gbc.ipadx=10;
		add(bregister,gbc);
		
		bconsult=new JButton("Consult");
		bconsult.setActionCommand("CONSULT");
		bconsult.setFont(new Font("Arial",ABORT,35));
		bconsult.setForeground(Color.white);
		bconsult.setBackground(Color.BLUE);
		bconsult.setBorder(new LineBorder(Color.white,3));
		gbc.gridx=1;
		gbc.ipadx=15;
		add(bconsult,gbc);
		
	}

	public JLabel getLtitle() {
		return ltitle;
	}

	public void setLtitle(JLabel ltitle) {
		this.ltitle = ltitle;
	}

	public JButton getBregister() {
		return bregister;
	}

	public void setBregister(JButton bregister) {
		this.bregister = bregister;
	}

	public JButton getBconsult() {
		return bconsult;
	}

	public void setBconsult(JButton bconsult) {
		this.bconsult = bconsult;
	}
	
}
