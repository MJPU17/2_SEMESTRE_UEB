package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.VehicleDTO;

public class ListPanel extends JPanel{
	
	private JLabel elist;
	private JTextField tflist;
	private JTable tlist;
	private JScrollPane splist;
	private JButton bshow,bremove;
	private PanelImage pfondo;
	
	public ListPanel(Properties properties) {
		setLayout(new GridBagLayout());
		setBackground(Color.black);
		
		startingComponents(properties);
		
		setVisible(false);
	}

	private void startingComponents(Properties properties) {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		elist=new JLabel();
		elist.setForeground(Color.white);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(elist,gbc);
		
		tflist=new JTextField();
		tflist.setPreferredSize(new Dimension(200,30));
		tflist.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=1;
		add(tflist,gbc);
		
		tlist=new JTable();
		tlist.setBorder(new LineBorder(Color.black));
		splist=new JScrollPane(tlist);
		splist.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=2;
		add(splist,gbc);
		
		bshow=new JButton(properties.getProperty("translator.panellist.bshow"));
		bshow.setActionCommand("SHOW");
		bshow.setPreferredSize(new Dimension(150,30));
		bshow.setVisible(false);
		bshow.setBackground(Color.magenta);
		bshow.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=3;
		add(bshow,gbc);
		
		bremove=new JButton(properties.getProperty("translator.panellist.bremove"));
		bremove.setActionCommand("ELIMINATE");
		bremove.setPreferredSize(new Dimension(150,30));
		bremove.setVisible(false);
		bremove.setBackground(Color.magenta);
		bremove.setBorder(new LineBorder(Color.black,2));
		add(bremove,gbc);
		
		pfondo=new PanelImage("src/resources/fondo.jpg");
		gbc.gridy=0;
		gbc.gridheight=6;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.BOTH;
		add(pfondo,gbc);
		
	}
	
	public void addValues(TreeMap<String, VehicleDTO> list,Properties properties) {
		String[] columns= {properties.getProperty("translator.panelshow.eplaque").replace(":", "") ,properties.getProperty("translator.panelshow.ebrand").replace(":", ""),properties.getProperty("translator.panelshow.emodel").replace(":", ""),properties.getProperty("translator.panelshow.ecolor").replace(":", "")};
		String [][]data=new String[list.size()][4];
		int i=0;
		for(VehicleDTO vehicle : list.values()) {
			data[i][0]=vehicle.getPlaque();
			data[i][1]=vehicle.getBrand();
			data[i][2]=vehicle.getModel();
			data[i][3]=vehicle.getColor();
			i++;
		}
		tlist.setModel(new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}
	
	public void filterShow(TreeMap<String, VehicleDTO> list,String filter,Properties properties) {
		ArrayList<VehicleDTO> arr=new ArrayList<>(list.size());
		for(VehicleDTO vehicle : list.values()) {
			if(!filter.matches(".*[^ ].*")||filter.length()==0) {
				arr.add(vehicle);
			}
			else if(vehicle.getPlaque().toLowerCase().contains(filter.toLowerCase())||vehicle.getBrand().toLowerCase().contains(filter.toLowerCase())||vehicle.getModel().toLowerCase().contains(filter.toLowerCase())||vehicle.getColor().toLowerCase().contains(filter.toLowerCase())) {
				arr.add(vehicle);
			}
		}
		String[] columns= {properties.getProperty("translator.panelshow.eplaque").replace(":", "") ,properties.getProperty("translator.panelshow.ebrand").replace(":", ""),properties.getProperty("translator.panelshow.emodel").replace(":", ""),properties.getProperty("translator.panelshow.ecolor").replace(":", "")};
		String [][]data=new String[arr.size()][4];
		int i=0;
		for(VehicleDTO vehicle : arr) {
			data[i][0]=vehicle.getPlaque();
			data[i][1]=vehicle.getBrand();
			data[i][2]=vehicle.getModel();
			data[i][3]=vehicle.getColor();
			i++;
		}
		DefaultTableModel model=new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		if(model.getRowCount()<1) {
			tflist.setForeground(Color.red);
		}
		else {
			tflist.setForeground(Color.black);
		}
		tlist.setModel(model);
	}

	public JLabel getElist() {
		return elist;
	}

	public void setElist(JLabel elist) {
		this.elist = elist;
	}

	public JTextField getTflist() {
		return tflist;
	}

	public void setTflist(JTextField tflist) {
		this.tflist = tflist;
	}

	public JTable getTlist() {
		return tlist;
	}

	public void setTlist(JTable tlist) {
		this.tlist = tlist;
	}

	public JScrollPane getSplist() {
		return splist;
	}

	public void setSplist(JScrollPane splist) {
		this.splist = splist;
	}

	public JButton getBshow() {
		return bshow;
	}

	public void setBshow(JButton bshow) {
		this.bshow = bshow;
	}

	public JButton getBremove() {
		return bremove;
	}

	public void setBremove(JButton bremove) {
		this.bremove = bremove;
	}
	
}
