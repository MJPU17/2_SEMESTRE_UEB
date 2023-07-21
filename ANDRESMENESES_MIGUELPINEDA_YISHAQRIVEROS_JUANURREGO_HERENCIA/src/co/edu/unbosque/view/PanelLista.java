package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class PanelLista extends JPanel{
	
	private JLabel elista;
	private JScrollPane slista;
	private JButton batras;
	
	public PanelLista() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		inicalizarComponentes();
		
		setVisible(false);
	}

	private void inicalizarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		elista=new JLabel();
		elista.setForeground(Color.white);
		elista.setFont(new Font("Bauhaus 93", ALLBITS, 30));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		add(elista,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS LISTA");
		batras.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		batras.setForeground(Color.white);
		batras.setBackground(Color.cyan);
		gbc.gridy=2;
		gbc.ipady=10;
		gbc.ipadx=20;
		add(batras,gbc);
		
	}
	
	public void iniciarLista(String [][] lista) {
		
		GridBagConstraints gbc=new GridBagConstraints();
		JPanel pdata=new JPanel(new GridLayout(lista.length,lista[0].length));
		JTextArea aux;
		
		for(int y=0;y<lista.length;y++) {
			for(int x=0;x<lista[y].length;x++) {
				aux=new JTextArea();
				aux.setLineWrap(true);
				aux.setText(lista[y][x]);
				aux.setEditable(false);
				aux.setBorder(new LineBorder(Color.black));
				if(y==0) {
					aux.setBackground(Color.lightGray);
				}else {
					aux.setBackground(Color.white);
				}
				pdata.add(aux);
			}
		}
		slista=new JScrollPane(pdata);
		slista.setPreferredSize(new Dimension(784,184));
		gbc.gridy=1;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		add(slista,gbc);
		
	}
	
	public void iniciarListas(ArrayList<String[][]> listas,ArrayList<String> titulos) {
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		JPanel pdata=new JPanel(new GridBagLayout());
		JLabel tlista;
		JTextArea aux;
		
		int i=0;
		for(int j=0;j<listas.size();j++) {
			tlista=new JLabel(titulos.get(j));
			tlista.setFont(new Font("Bahnschrift", Font.BOLD, 18));
			gbc.gridy=i;
			gbc.gridx=0;
			gbc.gridwidth=7;
			gbc.fill=GridBagConstraints.BOTH;
			pdata.add(tlista,gbc);
			i++;
			gbc.gridwidth=1;
			for(int y=0;y<listas.get(j).length;y++) {
				gbc.gridy=i;
				for(int x=0;x<listas.get(j)[y].length;x++) {
					aux=new JTextArea();
					aux.setLineWrap(true);
					aux.setText(listas.get(j)[y][x]);
					aux.setEditable(false);
					aux.setBorder(new LineBorder(Color.black));
					if(y==0) {
						aux.setBackground(Color.lightGray);
					}else {
						aux.setBackground(Color.white);
					}
					gbc.gridx=x;
					pdata.add(aux,gbc);
				}
				i++;
			}
		}
		slista=new JScrollPane(pdata);
		slista.setPreferredSize(new Dimension(784,400));
		gbc.gridy=1;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		gbc.fill=ABORT;
		add(slista,gbc);
	}
	
	public void removerLista() {
		remove(slista);
	}

	public JLabel getElista() {
		return elista;
	}

	public void setElista(JLabel elista) {
		this.elista = elista;
	}

	public JScrollPane getSlista() {
		return slista;
	}

	public void setSlista(JScrollPane slista) {
		this.slista = slista;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}

}
