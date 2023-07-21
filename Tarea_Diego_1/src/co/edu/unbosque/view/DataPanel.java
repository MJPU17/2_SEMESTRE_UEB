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

public class DataPanel extends JPanel{
	
	private JLabel lid,lname,lbrand,lprice,ldistribution,lquantity;
	private JTextField fid,fname,fbrand,fprice,fdistribution,fquantity;
	private JButton bsave,bedit,bback;
	
	public DataPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		startingComponents();
		
		setVisible(false);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		lid=new JLabel();
		lid.setForeground(Color.white);
		lid.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(lid,gbc);
		
		lname=new JLabel();
		lname.setForeground(Color.white);
		lname.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=1;
		add(lname,gbc);
		
		lbrand=new JLabel();
		lbrand.setForeground(Color.white);
		lbrand.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=2;
		add(lbrand,gbc);
		
		lprice=new JLabel();
		lprice.setForeground(Color.white);
		lprice.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=3;
		add(lprice,gbc);
		
		ldistribution=new JLabel();
		ldistribution.setForeground(Color.white);
		ldistribution.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=4;
		add(ldistribution,gbc);
		
		lquantity=new JLabel();
		lquantity.setForeground(Color.white);
		lquantity.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=5;
		add(lquantity,gbc);
		
		fid=new JTextField();
		fid.setForeground(Color.black);
		fid.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.ipadx=200;
		add(fid,gbc);
		
		fname=new JTextField();
		fname.setForeground(Color.black);
		fname.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=1;
		add(fname,gbc);
		
		fbrand=new JTextField();
		fbrand.setForeground(Color.black);
		fbrand.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=2;
		add(fbrand,gbc);
		
		fprice=new JTextField();
		fprice.setForeground(Color.black);
		fprice.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=3;
		add(fprice,gbc);
		
		fdistribution=new JTextField();
		fdistribution.setForeground(Color.black);
		fdistribution.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=4;
		add(fdistribution,gbc);
		
		fquantity=new JTextField();
		fquantity.setForeground(Color.black);
		fquantity.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=5;
		add(fquantity,gbc);
		
		bback=new JButton("Back");
		bback.setActionCommand("BACK");
		bback.setBackground(Color.cyan);
		bback.setBorder(new LineBorder(Color.white,3));
		bback.setForeground(Color.white);
		bback.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=6;
		gbc.gridx=0;
		gbc.ipady=10;
		gbc.ipadx=50;
		add(bback,gbc);
		
		bsave=new JButton("Save");
		bsave.setActionCommand("SAVE PRODUCT");
		bsave.setBackground(Color.cyan);
		bsave.setBorder(new LineBorder(Color.white,3));
		bsave.setForeground(Color.white);
		bsave.setFont(new Font("Arial",Font.BOLD,20));
		bsave.setVisible(false);
		gbc.gridx=1;
		add(bsave,gbc);
		
		bedit=new JButton("Edit");
		bedit.setActionCommand("CHANGE");
		bedit.setBackground(Color.cyan);
		bedit.setBorder(new LineBorder(Color.white,3));
		bedit.setForeground(Color.white);
		bedit.setFont(new Font("Arial",Font.BOLD,20));
		bedit.setVisible(false);
		gbc.ipadx=60;
		add(bedit,gbc);
		
		
		
	}

	public JLabel getLid() {
		return lid;
	}

	public void setLid(JLabel lid) {
		this.lid = lid;
	}

	public JTextField getFid() {
		return fid;
	}

	public void setFid(JTextField fid) {
		this.fid = fid;
	}

	public JLabel getLname() {
		return lname;
	}

	public void setLname(JLabel lname) {
		this.lname = lname;
	}

	public JLabel getLbrand() {
		return lbrand;
	}

	public void setLbrand(JLabel lbrand) {
		this.lbrand = lbrand;
	}

	public JLabel getLprice() {
		return lprice;
	}

	public void setLprice(JLabel lprice) {
		this.lprice = lprice;
	}

	public JLabel getLdistribution() {
		return ldistribution;
	}

	public void setLdistribution(JLabel ldistribution) {
		this.ldistribution = ldistribution;
	}

	public JLabel getLquantity() {
		return lquantity;
	}

	public void setLquantity(JLabel lquantity) {
		this.lquantity = lquantity;
	}

	public JTextField getFname() {
		return fname;
	}

	public void setFname(JTextField fname) {
		this.fname = fname;
	}

	public JTextField getFbrand() {
		return fbrand;
	}

	public void setFbrand(JTextField fbrand) {
		this.fbrand = fbrand;
	}

	public JTextField getFprice() {
		return fprice;
	}

	public void setFprice(JTextField fprice) {
		this.fprice = fprice;
	}

	public JTextField getFdistribution() {
		return fdistribution;
	}

	public void setFdistribution(JTextField fdistribution) {
		this.fdistribution = fdistribution;
	}

	public JTextField getFquantity() {
		return fquantity;
	}

	public void setFquantity(JTextField fquantity) {
		this.fquantity = fquantity;
	}

	public JButton getBsave() {
		return bsave;
	}

	public void setBsave(JButton bsave) {
		this.bsave = bsave;
	}

	public JButton getBedit() {
		return bedit;
	}

	public void setBedit(JButton bedit) {
		this.bedit = bedit;
	}

	public JButton getBback() {
		return bback;
	}

	public void setBback(JButton bback) {
		this.bback = bback;
	}

}
