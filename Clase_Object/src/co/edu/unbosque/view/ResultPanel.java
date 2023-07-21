package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class ResultPanel extends JPanel{
	
	private JLabel lresult;
	private JTextArea aresult;
	private JButton bback;

	public ResultPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		startComponents();
		
		setVisible(false);
	}

	private void startComponents() {
		
		GridBagConstraints gbc =new GridBagConstraints();
		
		lresult=new JLabel("Result");
		lresult.setFont(new Font("Arial", ALLBITS, 35));
		lresult.setForeground(Color.white);
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weighty=2.0;
		gbc.weightx=2.0;
		add(lresult,gbc);
		
		aresult=new JTextArea();
		aresult.setFont(new Font("Arial",ALLBITS,35));
		aresult.setForeground(Color.white);
		aresult.setBackground(Color.black);
		aresult.setBorder(new LineBorder(Color.white,3));
		aresult.setEditable(false);
		gbc.gridy=1;
		gbc.gridx=0;
		gbc.gridheight=3;
		gbc.gridwidth=3;
		gbc.weighty=2.0;
		gbc.weightx=2.0;
		gbc.fill=GridBagConstraints.BOTH;
		add(aresult,gbc);
		
		bback=new JButton("Back");
		bback.setActionCommand("BACK");
		bback.setBackground(Color.red);
		bback.setForeground(Color.white);
		bback.setFont(new Font("Arial",ALLBITS,25));
		gbc.gridy=4;
		gbc.gridx=1;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.ipady=10;
		gbc.ipadx=30;
		gbc.fill=ABORT;
		add(bback,gbc);
	}

	public JLabel getLresult() {
		return lresult;
	}

	public void setLresult(JLabel lresult) {
		this.lresult = lresult;
	}

	public JTextArea getAresult() {
		return aresult;
	}

	public void setAresult(JTextArea aresult) {
		this.aresult = aresult;
	}

	public JButton getBback() {
		return bback;
	}

	public void setBback(JButton bback) {
		this.bback = bback;
	}
	
}
