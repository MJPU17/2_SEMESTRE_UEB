package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ConsultPanel extends JPanel{
	
	private JLabel lconsult;
	private JTextField fconsult;
	private JButton bback,bconsult;
	
	public ConsultPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		startingComponents();
		
		setVisible(false);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		lconsult=new JLabel("Enter your DNI: ");
		lconsult.setForeground(Color.white);
		lconsult.setFont(new Font("Arial",ALLBITS,35));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridheight=1;
		gbc.gridwidth=2;
		gbc.weighty=2.0;
		gbc.weightx=2.0;
		add(lconsult,gbc);
		
		fconsult=new JTextField();
		fconsult.setBackground(Color.black);
		fconsult.setForeground(Color.white);
		fconsult.setBorder(new LineBorder(Color.white,3));
		fconsult.setFont(new Font("Arial",ALLBITS,35));
		fconsult.setBorder(new LineBorder(Color.white));
		gbc.gridy=1;
		gbc.ipadx=500;
		add(fconsult,gbc);
		
		bback=new JButton("Back");
		bback.setActionCommand("BACK");
		bback.setBackground(Color.red);
		bback.setBorder(new LineBorder(Color.white,3));
		bback.setForeground(Color.white);
		bback.setFont(new Font("Arial", ALLBITS, 35));
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.ipadx=30;
		gbc.ipady=10;
		add(bback,gbc);
		
		bconsult=new JButton("Consult");
		bconsult.setActionCommand("CONSULT PERSON");
		bconsult.setBackground(Color.green);
		bconsult.setForeground(Color.white);
		bconsult.setBorder(new LineBorder(Color.white,3));
		bconsult.setFont(new Font("Arial",ALLBITS,35));
		gbc.gridx=1;
		gbc.ipadx=10;
		add(bconsult,gbc);
		
	}

	public JLabel getLconsult() {
		return lconsult;
	}

	public void setLconsult(JLabel lconsult) {
		this.lconsult = lconsult;
	}

	public JTextField getFconsult() {
		return fconsult;
	}

	public void setFconsult(JTextField fconsult) {
		this.fconsult = fconsult;
	}

	public JButton getBback() {
		return bback;
	}

	public void setBback(JButton bback) {
		this.bback = bback;
	}

	public JButton getBconsult() {
		return bconsult;
	}

	public void setBconsult(JButton bconsult) {
		this.bconsult = bconsult;
	}

}
