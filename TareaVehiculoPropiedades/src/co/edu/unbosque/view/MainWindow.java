package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.unbosque.model.persistence.FileHandler;

public class MainWindow extends JFrame{
	
	private Properties properties;
	private MenuPanel pmenu;
	private JPanel pcontainer;
	private DataPanel pdata;
	private ListPanel plist;
	private ShowPanel pshow;
	
	public MainWindow() {
		properties=FileHandler.cargarPropiedades(chooseLanguage()+".properties");
		setTitle(properties.getProperty("translator.jframe.title"));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000,800));
		setIconImage(new ImageIcon("src/resources/acura.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		startingComponents();
		
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		pmenu=new MenuPanel(properties);
		getContentPane().add(pmenu,BorderLayout.NORTH);
		
		pcontainer=new JPanel(new GridBagLayout());
		pdata=new DataPanel(properties);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.fill=GridBagConstraints.BOTH;
		pcontainer.add(pdata,gbc);
		
		plist=new ListPanel(properties);
		pcontainer.add(plist,gbc);
		
		pshow=new ShowPanel(properties);
		pcontainer.add(pshow,gbc);
		
		getContentPane().add(pcontainer,BorderLayout.CENTER);
	}

	public String chooseLanguage() {
		String option=FileHandler.leerArchivo("language.init").substring(0,FileHandler.leerArchivo("language.init").indexOf("\n"));
		if(option.equals("ninguno")) {
			String[] options= {"Spanish","English","German","French","Russian"};
			option=PopUpMessages.readOptions("Select language:",options).toLowerCase();
			FileHandler.escribirArchivo("language.init", option);
		}
		return option;
		
	}
	
	public void changeLanguage(Properties properties) {
		this.properties=properties;
		setTitle(properties.getProperty("translator.jframe.title"));
		pmenu.getMcreate().setText(properties.getProperty("translator.panelmenu.mcreate"));
		pmenu.getMupdate().setText(properties.getProperty("translator.panelmenu.mupdate"));
		pmenu.getMremove().setText(properties.getProperty("translator.panelmenu.mremove"));
		pmenu.getMlist().setText(properties.getProperty("translator.panelmenu.mlist"));
		pmenu.getMlanguage().setText(properties.getProperty("translator.panelmenu.mlanguge"));
		pmenu.getMienglish().setText(properties.getProperty("translator.panelmenu.mienglish"));
		pmenu.getMifrench().setText(properties.getProperty("translator.panelmenu.mifrench"));
		pmenu.getMigerman().setText(properties.getProperty("translator.panelmenu.migerman"));
		pmenu.getMirussian().setText(properties.getProperty("translator.panelmenu.mirussian"));
		pmenu.getMispanish().setText(properties.getProperty("translator.panelmenu.mispanish"));
		pdata.getEchoose().setText(properties.getProperty("translator.paneldata.echoose"));
		pdata.getEplaque().setText(properties.getProperty("translator.paneldata.eplaque"));
		pdata.getEbrand().setText(properties.getProperty("translator.paneldata.ebrand"));
		pdata.getEmodel().setText(properties.getProperty("translator.paneldata.emodel"));
		pdata.getEcolor().setText(properties.getProperty("translator.paneldata.ecolor"));
		pdata.getBsave().setText(properties.getProperty("translator.paneldata.bsave"));
		pdata.getBupdate().setText(properties.getProperty("translator.paneldata.bupdate"));
		pdata.getBclear().setText(properties.getProperty("translator.paneldata.bclear"));
		plist.getBshow().setText(properties.getProperty("translator.panellist.bshow"));
		plist.getBremove().setText(properties.getProperty("translator.panellist.bremove"));
		pshow.getEplaque().setText(properties.getProperty("translator.panelshow.eplaque"));
		pshow.getEbrand().setText(properties.getProperty("translator.panelshow.ebrand"));
		pshow.getEmodel().setText(properties.getProperty("translator.panelshow.emodel"));
		pshow.getEcolor().setText(properties.getProperty("translator.panelshow.ecolor"));
	}
	
	public JPanel visiblePanel() {
		if(pdata.isVisible()) {
			pdata.getTfplaque().setText("");
			pdata.getTfbrand().setText("");
			pdata.getTfcolor().setText("");
			pdata.getTfmodel().setText("");
			pdata.getEchoose().setVisible(false);
			pdata.getCbchoose().setVisible(false);
			pdata.getBsave().setVisible(false);
			pdata.getBupdate().setVisible(false);
			pdata.getCbchoose().removeAllItems();
			return pdata;
		}
		else if(plist.isVisible()) {
			plist.getBshow().setVisible(false);
			plist.getBremove().setVisible(false);
			return plist;
		}
		return pshow;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public MenuPanel getPmenu() {
		return pmenu;
	}

	public void setPmenu(MenuPanel pmenu) {
		this.pmenu = pmenu;
	}

	public JPanel getPcontainer() {
		return pcontainer;
	}

	public void setPcontainer(JPanel pcontainer) {
		this.pcontainer = pcontainer;
	}

	public DataPanel getPdata() {
		return pdata;
	}

	public void setPdata(DataPanel pdata) {
		this.pdata = pdata;
	}

	public ListPanel getPlist() {
		return plist;
	}

	public void setPlist(ListPanel plist) {
		this.plist = plist;
	}

	public ShowPanel getPshow() {
		return pshow;
	}

	public void setPshow(ShowPanel pshow) {
		this.pshow = pshow;
	}

}
