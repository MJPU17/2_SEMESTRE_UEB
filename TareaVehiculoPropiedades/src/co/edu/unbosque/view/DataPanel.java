package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Properties;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.VehicleDTO;

public class DataPanel extends JPanel{
	
	private JLabel echoose,eplaque,ebrand,emodel,ecolor;
	private JTextField tfplaque,tfbrand,tfmodel,tfcolor;
	private JComboBox<String> cbchoose;
	private JButton bsave,bupdate,bclear;
	private PanelImage pfondo;
	
	public DataPanel(Properties properties) {
		setLayout(new GridBagLayout());
		setBackground(Color.black);
		
		startingComponents(properties);
		
		setVisible(true);
	}

	private void startingComponents(Properties properties) {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		echoose=new JLabel(properties.getProperty("translator.paneldata.echoose"));
		echoose.setVisible(false);
		echoose.setForeground(Color.white);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(echoose,gbc);
		
		eplaque=new JLabel(properties.getProperty("translator.paneldata.eplaque"));
		eplaque.setForeground(Color.white);
		gbc.gridy=1;
		add(eplaque,gbc);
		
		ebrand=new JLabel(properties.getProperty("translator.paneldata.ebrand"));
		ebrand.setForeground(Color.white);
		gbc.gridy=2;
		add(ebrand,gbc);
		
		emodel=new JLabel(properties.getProperty("translator.paneldata.emodel"));
		emodel.setForeground(Color.white);
		gbc.gridy=3;
		add(emodel,gbc);
		
		ecolor=new JLabel(properties.getProperty("translator.paneldata.ecolor"));
		ecolor.setForeground(Color.white);
		gbc.gridy=4;
		add(ecolor,gbc);
		
		cbchoose=new JComboBox<>();
		cbchoose.setPreferredSize(new Dimension(200,30));
		cbchoose.setVisible(false);
		cbchoose.setBorder(new LineBorder(Color.black,2));
		cbchoose.setBackground(Color.magenta);
		gbc.gridx=1;
		gbc.gridy=0;
		add(cbchoose,gbc);
		
		tfplaque=new JTextField();
		tfplaque.setPreferredSize(new Dimension(200,30));
		tfplaque.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=1;
		add(tfplaque,gbc);
		
		tfbrand=new JTextField();
		tfbrand.setPreferredSize(new Dimension(200,30));
		tfbrand.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=2;
		add(tfbrand,gbc);
		
		tfmodel=new JTextField();
		tfmodel.setPreferredSize(new Dimension(200,30));
		tfmodel.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=3;
		add(tfmodel,gbc);
		
		tfcolor=new JTextField();
		tfcolor.setPreferredSize(new Dimension(200,30));
		tfcolor.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=4;
		add(tfcolor,gbc);
		
		bsave=new JButton(properties.getProperty("translator.paneldata.bsave"));
		bsave.setActionCommand("SAVE");
		bsave.setPreferredSize(new Dimension(150,30));
		bsave.setBackground(Color.magenta);
		bsave.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=5;
		add(bsave,gbc);
		
		bupdate=new JButton(properties.getProperty("translator.paneldata.bupdate"));
		bupdate.setActionCommand("UPDATE");
		bupdate.setPreferredSize(new Dimension(150,30));
		bupdate.setBackground(Color.magenta);
		bupdate.setBorder(new LineBorder(Color.black,2));
		bupdate.setVisible(false);
		add(bupdate,gbc);
		
		bclear=new JButton(properties.getProperty("translator.paneldata.bclear"));
		bclear.setActionCommand("CLEAR");
		bclear.setPreferredSize(new Dimension(150,30));
		bclear.setBackground(Color.magenta);
		bclear.setBorder(new LineBorder(Color.black,2));
		gbc.gridx=0;
		add(bclear,gbc);
		
		pfondo=new PanelImage("src/resources/fondo2.jpg");
		gbc.gridy=0;
		gbc.gridheight=6;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.BOTH;
		add(pfondo,gbc);
		
	}
	
    public void addItems(TreeMap<String, VehicleDTO> list,Properties properties) {
    	cbchoose.addItem(properties.getProperty("translator.paneldata.cbchoose"));
		for(String key : list.keySet()) {
			cbchoose.addItem(key);
		}
	}
	

	public JLabel getEchoose() {
		return echoose;
	}

	public void setEchoose(JLabel echoose) {
		this.echoose = echoose;
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

	public JTextField getTfplaque() {
		return tfplaque;
	}

	public void setTfplaque(JTextField tfplaque) {
		this.tfplaque = tfplaque;
	}

	public JTextField getTfbrand() {
		return tfbrand;
	}

	public void setTfbrand(JTextField tfbrand) {
		this.tfbrand = tfbrand;
	}

	public JTextField getTfmodel() {
		return tfmodel;
	}

	public void setTfmodel(JTextField tfmodel) {
		this.tfmodel = tfmodel;
	}

	public JTextField getTfcolor() {
		return tfcolor;
	}

	public void setTfcolor(JTextField tfcolor) {
		this.tfcolor = tfcolor;
	}

	public JComboBox<String> getCbchoose() {
		return cbchoose;
	}

	public void setCbchoose(JComboBox<String> cbchoose) {
		this.cbchoose = cbchoose;
	}

	public JButton getBsave() {
		return bsave;
	}

	public void setBsave(JButton bsave) {
		this.bsave = bsave;
	}

	public JButton getBupdate() {
		return bupdate;
	}

	public void setBupdate(JButton bupdate) {
		this.bupdate = bupdate;
	}

	public JButton getBclear() {
		return bclear;
	}

	public void setBclear(JButton bclear) {
		this.bclear = bclear;
	}
	
}
