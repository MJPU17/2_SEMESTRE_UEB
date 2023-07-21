package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame{
	
	private MenuPanel pmenu;
	private DataPanel pdata;
	private ConsultPanel pconsult;
	private ResultPanel presult;
	
	public MainWindow() {
		setTitle("Person Register");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.black);
		getContentPane().setLayout(new GridBagLayout());
		
		startingComponents();
		
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridy=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weighty=1.0;
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.BOTH;
		
		pmenu=new MenuPanel();
		getContentPane().add(pmenu,gbc);
		
		pdata=new DataPanel();
		getContentPane().add(pdata,gbc);
		
		pconsult=new ConsultPanel();
		getContentPane().add(pconsult,gbc);
		
		presult=new ResultPanel();
		getContentPane().add(presult,gbc);
		
	}
	
	public JPanel visiblePanel() {
		if(pmenu.isVisible()) {
			return pmenu;
		}
		else if(pdata.isVisible()) {
			return pdata;
		}
		else if(pconsult.isVisible()) {
			return pconsult;
		}
		else if(presult.isVisible()) {
			return presult;
		}
		return null;
	}

	public MenuPanel getPmenu() {
		return pmenu;
	}

	public void setPmenu(MenuPanel pmenu) {
		this.pmenu = pmenu;
	}

	public DataPanel getPdata() {
		return pdata;
	}

	public void setPdata(DataPanel pdata) {
		this.pdata = pdata;
	}

	public ConsultPanel getPconsult() {
		return pconsult;
	}

	public void setPconsult(ConsultPanel pconsult) {
		this.pconsult = pconsult;
	}

	public ResultPanel getPresult() {
		return presult;
	}

	public void setPresult(ResultPanel presult) {
		this.presult = presult;
	}

}
