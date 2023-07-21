package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	private MenuPanel pmenu;
	private SelectPanel pselect;
	private DataPanel pdata;
	private ListPanel plist;
	
	
	public MainWindow() {
		setTitle("Product Controller");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.white);
		
		startingComponents();
		
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.fill=GridBagConstraints.BOTH;
		
		pmenu=new MenuPanel();
		getContentPane().add(pmenu,gbc);
		
		pselect=new SelectPanel();
		getContentPane().add(pselect,gbc);
		
		pdata=new DataPanel();
		getContentPane().add(pdata,gbc);
		
		plist=new ListPanel();
		getContentPane().add(plist,gbc);
		
		
	}

	public MenuPanel getPmenu() {
		return pmenu;
	}

	public void setPmenu(MenuPanel pmenu) {
		this.pmenu = pmenu;
	}

	public SelectPanel getPselect() {
		return pselect;
	}

	public void setPselect(SelectPanel pselect) {
		this.pselect = pselect;
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

}
