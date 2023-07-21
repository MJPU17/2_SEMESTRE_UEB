package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class DataPanel extends JPanel{
	
	private JLabel lname,lage,lgender,lweigth,lheigth;
	private JTextField fname,fage,fweigth,fheight;
	private JRadioButton rmale,rfemale;
	private ButtonGroup ggender;
	private JButton bback,bregister;
	
	public DataPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		startingComponents();
		
		setVisible(false);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc =new GridBagConstraints();
		
		lname=new JLabel("Insert name: ");
		lname.setForeground(Color.white);
		lname.setFont(new Font("Arial",ABORT,35));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=2;
		gbc.gridwidth=1;
		gbc.weighty=2.0;
		gbc.weightx=2.0;
		add(lname,gbc);
		
		lage=new JLabel("Insert age: ");
		lage.setForeground(Color.white);
		lage.setFont(new Font("Arial",ABORT,35));
		gbc.gridy=1;
		add(lage,gbc);
		
		lgender=new JLabel("Enter gender: ");
		lgender.setFont(new Font("Arial",ALLBITS,35));
		lgender.setForeground(Color.white);
		gbc.gridy=2;
		add(lgender,gbc);
		
		
		lweigth=new JLabel("Enter weigth: ");
		lweigth.setFont(new Font("Arial",ALLBITS,35));
		lweigth.setForeground(Color.white);
		gbc.gridy=3;
		add(lweigth,gbc);
		
		lheigth=new JLabel("Enter heigth: ");
		lheigth.setFont(new Font("Arial",ALLBITS,35));
		lheigth.setForeground(Color.white);
		gbc.gridy=4;
		add(lheigth,gbc);
		
		ggender=new ButtonGroup();
		rmale=new JRadioButton("Male");
		rmale.setFont(new Font("Arial",ABORT,25));
		rmale.setForeground(Color.white);
		rmale.setBackground(Color.darkGray);
		rmale.setFocusPainted(false);
		ggender.add(rmale);
		gbc.gridy=2;
		gbc.gridx=2;
		gbc.gridwidth=1;
		add(rmale,gbc);
		
		rfemale=new JRadioButton("Female");
		rfemale.setFont(new Font("Arial",ALLBITS,25));
		rfemale.setForeground(Color.white);
		rfemale.setBackground(Color.darkGray);
		rfemale.setFocusPainted(false);
		ggender.add(rfemale);
		gbc.gridx=3;
		add(rfemale,gbc);
		
		fname=new JTextField();
		fname.setFont(new Font("Arial",ALLBITS,35));
		gbc.gridy=0;
		gbc.gridx=2;
		gbc.gridwidth=2;
		gbc.ipadx=200;
		add(fname,gbc);
		
		fage=new JTextField();
		fage.setFont(new Font("Arial",ALLBITS,35));
		gbc.gridy=1;
		add(fage,gbc);
		
		fweigth=new JTextField();
		fweigth.setFont(new Font("Arial",ALLBITS,35));
		gbc.gridy=3;
		add(fweigth,gbc);
		
		fheight=new JTextField();
		fheight.setFont(new Font("Arial", ALLBITS, 35));
		gbc.gridy=4;
		add(fheight,gbc);
		
		bback=new JButton("Back");
		bback.setActionCommand("BACK");
		bback.setBackground(Color.red);
		bback.setForeground(Color.white);
		bback.setFont(new Font("Arial",ALLBITS,35));
		bback.setBorder(new LineBorder(Color.white,3));
		gbc.gridy=5;
		gbc.gridx=0;
		gbc.ipadx=30;
		gbc.ipady=10;
		add(bback,gbc);
		
		bregister=new JButton("Register");
		bregister.setActionCommand("REGISTER PERSON");
		bregister.setBackground(Color.green);
		bregister.setForeground(Color.white);
		bregister.setFont(new Font("Arial",ALLBITS,35));
		bregister.setBorder(new LineBorder(Color.white,3));
		gbc.gridx=2;
		gbc.ipadx=10;
		add(bregister,gbc);
		
	}

	public JLabel getLname() {
		return lname;
	}

	public void setLname(JLabel lname) {
		this.lname = lname;
	}

	public JLabel getLage() {
		return lage;
	}

	public void setLage(JLabel lage) {
		this.lage = lage;
	}

	public JLabel getLgender() {
		return lgender;
	}

	public void setLgender(JLabel lgender) {
		this.lgender = lgender;
	}

	public JLabel getLweigth() {
		return lweigth;
	}

	public void setLweigth(JLabel lweigth) {
		this.lweigth = lweigth;
	}

	public JLabel getLheigth() {
		return lheigth;
	}

	public void setLheigth(JLabel lheigth) {
		this.lheigth = lheigth;
	}

	public JTextField getFname() {
		return fname;
	}

	public void setFname(JTextField fname) {
		this.fname = fname;
	}

	public JTextField getFage() {
		return fage;
	}

	public void setFage(JTextField fage) {
		this.fage = fage;
	}

	public JTextField getFweigth() {
		return fweigth;
	}

	public void setFweigth(JTextField fweigth) {
		this.fweigth = fweigth;
	}

	public JTextField getFheight() {
		return fheight;
	}

	public void setFheight(JTextField fheight) {
		this.fheight = fheight;
	}

	public JRadioButton getRmale() {
		return rmale;
	}

	public void setRmale(JRadioButton rmale) {
		this.rmale = rmale;
	}

	public JRadioButton getRfemale() {
		return rfemale;
	}

	public void setRfemale(JRadioButton rfemale) {
		this.rfemale = rfemale;
	}

	public ButtonGroup getGgender() {
		return ggender;
	}

	public void setGgender(ButtonGroup ggender) {
		this.ggender = ggender;
	}

	public JButton getBback() {
		return bback;
	}

	public void setBback(JButton bback) {
		this.bback = bback;
	}

	public JButton getBregister() {
		return bregister;
	}

	public void setBregister(JButton bregister) {
		this.bregister = bregister;
	}

}
