package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuPanel extends JPanel{
	
	private JMenuBar mbcrud;
	private JMenu mcreate,mupdate,mremove,mlist,mlanguage;
	private JMenuItem mienglish,mifrench,migerman,mirussian,mispanish;
	
	public MenuPanel(Properties properties) {
		setLayout(new GridLayout());
		setBackground(Color.black);
		
		startingComponents(properties);
		
		setVisible(true);
	}

	private void startingComponents(Properties properties) {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		mbcrud=new JMenuBar();
		mbcrud.setBackground(Color.magenta);
		mbcrud.setLayout(new GridBagLayout());
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.ipady=10;
		gbc.fill=GridBagConstraints.BOTH;
		
		mcreate=new JMenu(properties.getProperty("translator.panelmenu.mcreate"));
		mcreate.setBorder(new LineBorder(Color.black));
		gbc.gridx=1;
		mbcrud.add(mcreate,gbc);
		
		mupdate=new JMenu(properties.getProperty("translator.panelmenu.mupdate"));
		mupdate.setBorder(new LineBorder(Color.black));
		gbc.gridx=2;
		mbcrud.add(mupdate,gbc);
		
		mremove=new JMenu(properties.getProperty("translator.panelmenu.mremove"));
		mremove.setBorder(new LineBorder(Color.black));
		gbc.gridx=3;
		mbcrud.add(mremove,gbc);
		
		mlist=new JMenu(properties.getProperty("translator.panelmenu.mlist"));
		mlist.setBorder(new LineBorder(Color.black));
		gbc.gridx=4;
		mbcrud.add(mlist,gbc);
		
		mlanguage=new JMenu(properties.getProperty("translator.panelmenu.mlanguge"));
		mlanguage.setBorder(new LineBorder(Color.black));
		gbc.gridx=5;
		
		mienglish=new JMenuItem(properties.getProperty("translator.panelmenu.mienglish"));
		mienglish.setBackground(Color.magenta);
		mienglish.setBorder(new LineBorder(Color.black));
		mlanguage.add(mienglish);
		
		mifrench=new JMenuItem(properties.getProperty("translator.panelmenu.mifrench"));
		mifrench.setBackground(Color.magenta);
		mifrench.setBorder(new LineBorder(Color.black));
		mlanguage.add(mifrench);
		
		migerman=new JMenuItem(properties.getProperty("translator.panelmenu.migerman"));
		migerman.setBorder(new LineBorder(Color.black));
		migerman.setBackground(Color.magenta);
		mlanguage.add(migerman);
		
		mirussian=new JMenuItem(properties.getProperty("translator.panelmenu.mirussian"));
		mirussian.setBorder(new LineBorder(Color.black));
		mirussian.setBackground(Color.magenta);
		mlanguage.add(mirussian);
		
		mispanish=new JMenuItem(properties.getProperty("translator.panelmenu.mispanish"));
		mispanish.setBorder(new LineBorder(Color.black));
		mispanish.setBackground(Color.magenta);
		mlanguage.add(mispanish);
		mbcrud.add(mlanguage,gbc);
		add(mbcrud);
		
	}

	public JMenuBar getMbcrud() {
		return mbcrud;
	}

	public void setMbcrud(JMenuBar mbcrud) {
		this.mbcrud = mbcrud;
	}

	public JMenu getMcreate() {
		return mcreate;
	}

	public void setMcreate(JMenu mcreate) {
		this.mcreate = mcreate;
	}

	public JMenu getMupdate() {
		return mupdate;
	}

	public void setMupdate(JMenu mupdate) {
		this.mupdate = mupdate;
	}

	public JMenu getMremove() {
		return mremove;
	}

	public void setMremove(JMenu mremove) {
		this.mremove = mremove;
	}

	public JMenu getMlist() {
		return mlist;
	}

	public void setMlist(JMenu mlist) {
		this.mlist = mlist;
	}

	public JMenu getMlanguage() {
		return mlanguage;
	}

	public void setMlanguage(JMenu mlanguage) {
		this.mlanguage = mlanguage;
	}

	public JMenuItem getMienglish() {
		return mienglish;
	}

	public void setMienglish(JMenuItem mienglish) {
		this.mienglish = mienglish;
	}

	public JMenuItem getMifrench() {
		return mifrench;
	}

	public void setMifrench(JMenuItem mifrench) {
		this.mifrench = mifrench;
	}

	public JMenuItem getMigerman() {
		return migerman;
	}

	public void setMigerman(JMenuItem migerman) {
		this.migerman = migerman;
	}

	public JMenuItem getMirussian() {
		return mirussian;
	}

	public void setMirussian(JMenuItem mirussian) {
		this.mirussian = mirussian;
	}

	public JMenuItem getMispanish() {
		return mispanish;
	}

	public void setMispanish(JMenuItem mispanish) {
		this.mispanish = mispanish;
	}

}
