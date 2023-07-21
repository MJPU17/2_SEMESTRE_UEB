package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ShowPanel extends JPanel{
	
	private JLabel eplaque,ebrand,emodel,ecolor,cplaque,cbrand,cmodel,ccolor,image;
	private PanelImage pfondo;
	
	public ShowPanel(Properties properties) {
		setLayout(new GridBagLayout());
		setBackground(Color.black);
		
		startingComponents(properties);
		
		setVisible(false);
	}

	private void startingComponents(Properties properties) {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		eplaque=new JLabel(properties.getProperty("translator.panelshow.eplaque"));
		eplaque.setForeground(Color.white);
		eplaque.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(eplaque,gbc);
		
		ebrand=new JLabel(properties.getProperty("translator.panelshow.ebrand"));
		ebrand.setForeground(Color.white);
		ebrand.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=1;
		add(ebrand,gbc);
		
		emodel=new JLabel(properties.getProperty("translator.panelshow.emodel"));
		emodel.setForeground(Color.white);
		emodel.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=2;
		add(emodel,gbc);
		
		ecolor=new JLabel(properties.getProperty("translator.panelshow.ecolor"));
		ecolor.setForeground(Color.white);
		ecolor.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=3;
		add(ecolor,gbc);
		
		cplaque=new JLabel();
		cplaque.setForeground(Color.MAGENTA);
		cplaque.setFont(new Font("Arial",ALLBITS,20));
		gbc.gridy=0;
		gbc.gridx=2;
		add(cplaque,gbc);
		
		cbrand=new JLabel();
		cbrand.setForeground(Color.MAGENTA);
		cbrand.setFont(new Font("Arial",ALLBITS,20));
		gbc.gridy=1;
		add(cbrand,gbc);
		
		cmodel=new JLabel();
		cmodel.setForeground(Color.MAGENTA);
		cmodel.setFont(new Font("Arial",ALLBITS,20));
		gbc.gridy=2;
		add(cmodel,gbc);
		
		ccolor=new JLabel();
		ccolor.setForeground(Color.MAGENTA);
		ccolor.setFont(new Font("Arial",ALLBITS,20));
		gbc.gridy=3;
		add(ccolor,gbc);
		
		image=new JLabel();
		image.setBorder(new LineBorder(Color.magenta,2));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=4;
		add(image,gbc);
		
		pfondo=new PanelImage("src/resources/fondo.jpg");
		gbc.gridwidth=3;
		gbc.fill=GridBagConstraints.BOTH;
		add(pfondo,gbc);
	}
	
	public void generateImge() {
		ImageIcon sumbit=new  ImageIcon("src/resources/auto"+(int)(Math.random()*3+1)+".jpg");
		image.setIcon(new ImageIcon(sumbit.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT)));
	}
		

	public JLabel getEplaque() {
		return eplaque;
	}

	public void setEplaque(JLabel eplaque) {
		this.eplaque = eplaque;
	}

	public JLabel getEbrand() {
		return ebrand;
	}

	public void setEbrand(JLabel ebrand) {
		this.ebrand = ebrand;
	}

	public JLabel getEmodel() {
		return emodel;
	}

	public void setEmodel(JLabel emodel) {
		this.emodel = emodel;
	}

	public JLabel getEcolor() {
		return ecolor;
	}

	public void setEcolor(JLabel ecolor) {
		this.ecolor = ecolor;
	}

	public JLabel getCplaque() {
		return cplaque;
	}

	public void setCplaque(JLabel cplaque) {
		this.cplaque = cplaque;
	}

	public JLabel getCbrand() {
		return cbrand;
	}

	public void setCbrand(JLabel cbrand) {
		this.cbrand = cbrand;
	}

	public JLabel getCmodel() {
		return cmodel;
	}

	public void setCmodel(JLabel cmodel) {
		this.cmodel = cmodel;
	}

	public JLabel getCcolor() {
		return ccolor;
	}

	public void setCcolor(JLabel ccolor) {
		this.ccolor = ccolor;
	}

}
