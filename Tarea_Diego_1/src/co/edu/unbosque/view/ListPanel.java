package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ListPanel extends JPanel{
	
	private JLabel llist,ladvice;
	private JPanel pproducts;
	private JScrollPane sproducts;
	private JButton bback;
	
	public ListPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		startingComponents();
		
		setVisible(false);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		llist=new JLabel("Products List");
		llist.setForeground(Color.white);
		llist.setFont(new Font("Arial",Font.BOLD,30));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=3;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(llist,gbc);
		
		ladvice=new JLabel("No products");
		ladvice.setForeground(Color.white);
		ladvice.setFont(new Font("Arial",Font.BOLD,20));
		gbc.gridy=1;
		gbc.gridx=1;
		gbc.gridwidth=1;
		add(ladvice,gbc);
		
		bback=new JButton("Back");
		bback.setActionCommand("BACK");
		bback.setForeground(Color.white);
		bback.setBackground(Color.cyan);
		bback.setBorder(new LineBorder(Color.white,3));
		bback.setFont(new Font("Arial", Font.BOLD, 20));
		gbc.gridy=2;
		gbc.ipadx=50;
		gbc.ipady=10;
		add(bback,gbc);
		
	}
	
	public void createList(String[][] data,String[] columns) {
		
		GridBagConstraints gbc=new GridBagConstraints();
		JTextArea com;
		
		pproducts=new JPanel(new GridLayout(0,6));
		for(int i=0;i<columns.length;i++) {
			com=new JTextArea();
			com.setLineWrap(true);
			com.setText(columns[i]);
			com.setBackground(Color.LIGHT_GRAY);
			com.setForeground(Color.BLACK);
			com.setBorder(new LineBorder(Color.BLACK));
			com.setFont(new Font("Arial",ALLBITS,12));
			com.setEditable(false);
			pproducts.add(com);
		}
		for(int y=0;y<data.length;y++) {
			for(int x=0;x<data[y].length;x++) {
				com=new JTextArea();
				com.setLineWrap(true);
				com.setText(data[y][x]);
				com.setBackground(Color.WHITE);
				com.setForeground(Color.BLACK);
				com.setBorder(new LineBorder(Color.BLACK));
				com.setFont(new Font("Arial",ALLBITS,12));
				com.setEditable(false);
				pproducts.add(com);
			}
		}
		sproducts=new JScrollPane(pproducts);
		gbc.gridy=1;
		gbc.gridx=0;
		gbc.gridwidth=3;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.fill=GridBagConstraints.BOTH;
		add(sproducts,gbc);
		
	}

	public JLabel getLlist() {
		return llist;
	}

	public void setLlist(JLabel llist) {
		this.llist = llist;
	}

	public JLabel getLadvice() {
		return ladvice;
	}

	public void setLadvice(JLabel ladvice) {
		this.ladvice = ladvice;
	}

	public JPanel getPproducts() {
		return pproducts;
	}

	public void setPproducts(JPanel pproducts) {
		this.pproducts = pproducts;
	}

	public JScrollPane getSproducts() {
		return sproducts;
	}

	public void setSproducts(JScrollPane sproducts) {
		this.sproducts = sproducts;
	}

	public JButton getBback() {
		return bback;
	}

	public void setBback(JButton bback) {
		this.bback = bback;
	}

}
