package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.PasaporteDTO;

public class PanelLista extends JPanel{
	
	private JLabel elista;
	private JTextField flista;
	private JList<String> lista;
	private JButton batras,bactualizar,bmostrar,beliminar;
	
	public PanelLista() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		inicalizarComponentes();
		
		setVisible(false);
	}

	private void inicalizarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		elista=new JLabel();
		elista.setFont(new Font("Times New Roman",Font.BOLD,20));
		elista.setForeground(Color.white);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(elista,gbc);
		
		flista=new JTextField();
		flista.setFont((new Font("Arial",Font.BOLD,20)));
		flista.setPreferredSize(new Dimension(200, 30));
		flista.setBorder(new LineBorder(new Color(0,13,112),3));
		gbc.gridy=1;
		add(flista,gbc);
		
		lista=new JList<>();
		lista.setFont(new Font("Arial",ALLBITS,15));
		lista.setPreferredSize(new Dimension(450,320));
		lista.setBorder(new LineBorder(new Color(0,13,112),3));
		gbc.gridy=2;
		add(lista,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS LISTA");
		batras.setFont(new Font("Arial",Font.BOLD,20));
		batras.setForeground(Color.white);
		batras.setBackground(new Color(0,13,112));
		batras.setBorder(new LineBorder(Color.white,2));
		batras.setFocusPainted(false);
		batras.setPreferredSize(new Dimension(150,50));
		gbc.gridy=3;
		gbc.gridwidth=1;
		add(batras,gbc);
		
		bactualizar=new JButton("Actualizar");
		beliminar=new JButton("Eliminar");
		bmostrar=new JButton("Mostrar");
		bactualizar.setActionCommand("ACTUALIZAR LISTA");
		bmostrar.setActionCommand("MOSTRAR LISTA");
		beliminar.setActionCommand("REMOVER");
		bactualizar.setFont(new Font("Arial",Font.BOLD,20));
		beliminar.setFont(new Font("Arial", Font.BOLD, 20));
		bmostrar.setFont(new Font("Arial", Font.BOLD, 20));
		bactualizar.setForeground(Color.white);
		beliminar.setForeground(Color.white);
		bmostrar.setForeground(Color.white);
		bactualizar.setBackground(new Color(0,13,112));
		beliminar.setBackground(new Color(0,13,112));
		bmostrar.setBackground(new Color(0,13,112));
		bactualizar.setBorder(new LineBorder(Color.white,2));
		beliminar.setBorder(new LineBorder(Color.white,2));
		bmostrar.setBorder(new LineBorder(Color.white,2));
		bactualizar.setFocusPainted(false);
		beliminar.setFocusPainted(false);
		bmostrar.setFocusPainted(false);
		bactualizar.setPreferredSize(new Dimension(150,50));
		beliminar.setPreferredSize(new Dimension(150,50));
		bmostrar.setPreferredSize(new Dimension(150,50));
		bactualizar.setVisible(false);
		beliminar.setVisible(false);
		bmostrar.setVisible(false);
		gbc.gridx=1;
		add(bactualizar,gbc);
		add(beliminar,gbc);
		add(bmostrar,gbc);
		
	
	}
	
	public void agregarValores(LinkedList<PasaporteDTO>valores) {
		DefaultListModel<String>model=new DefaultListModel<>();
		for (int i = 0; i < valores.size(); i++) {
			model.addElement(((i+1)+") "+valores.get(i).getNombre()+"                   "+valores.get(i).getPais()));
		}
		lista.setModel(model);
	}
	
	public void filtrarMostrar(String filtro, LinkedList<PasaporteDTO>valores) {
		DefaultListModel<String>model=new DefaultListModel<>();
		for (int i = 0; i < valores.size(); i++) {
			String valor=((i+1)+") "+valores.get(i).getNombre()+"                   "+valores.get(i).getPais());
			if(valor.toLowerCase().contains(filtro.toLowerCase())) {
				model.addElement(valor);
			}
			else if(!filtro.matches(".*[^ ].*")) {
				model.addElement(valor);
			}
		}
		if(model.size()==0) {
			flista.setForeground(Color.red);
		}
		else {
			flista.setForeground(Color.black);
		}
		lista.setModel(model);
	}
	
	public HashMap<Integer, Integer> agregarValores(LinkedList<PasaporteDTO>valores,boolean colombianos) {
		DefaultListModel<String>model=new DefaultListModel<>();
		HashMap<Integer, Integer>indices=new HashMap<>();
		int i=1,j=0;
		for(PasaporteDTO pas: valores) {
			if(colombianos&&pas.getPais().equals("Colombia")) {
				model.addElement((i+") "+pas.getNombre()+"                   "+pas.getPais()));
				indices.put(i, j);
				i++;
			}
			else if(!colombianos&&!pas.getPais().equals("Colombia")){
				model.addElement((i+") "+pas.getNombre()+"                   "+pas.getPais()));
				indices.put(i, j);
				i++;
			}
			j++;
		}
		lista.setModel(model);
		return indices;
	}
	
	public void filtrarMostrar(String filtro, LinkedList<PasaporteDTO>valores,boolean colombianos) {
		DefaultListModel<String>model=new DefaultListModel<>();
		int i=1;
		for(PasaporteDTO pas : valores) {
			String valor=(i+") "+pas.getNombre()+"                   "+pas.getPais());
			if(valor.toLowerCase().contains(filtro.toLowerCase())&&colombianos&&pas.getPais().equals("Colombia")) {
				model.addElement(valor);
			}
			else if(!filtro.matches(".*[^ ].*")&&colombianos&&pas.getPais().equals("Colombia")) {
				model.addElement(valor);
			}
			else if(valor.toLowerCase().contains(filtro.toLowerCase())&&!colombianos&&!pas.getPais().equals("Colombia")) {
				model.addElement(valor);
			}
			else if(!filtro.matches(".*[^ ].*")&&!colombianos&&!pas.getPais().equals("Colombia")) {
				model.addElement(valor);
			}
			if((colombianos&&pas.getPais().equals("Colombia"))||!colombianos&&!pas.getPais().equals("Colombia")) {
				i++;
			}
			if(model.size()==0) {
				flista.setForeground(Color.red);
			}
			else {
				flista.setForeground(Color.black);
			}
		}
		lista.setModel(model);
	}

	public JLabel getElista() {
		return elista;
	}

	public void setElista(JLabel elista) {
		this.elista = elista;
	}

	public JTextField getFlista() {
		return flista;
	}

	public void setFlista(JTextField flista) {
		this.flista = flista;
	}

	public JList<String> getLista() {
		return lista;
	}

	public void setLista(JList<String> lista) {
		this.lista = lista;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}

	public JButton getBactualizar() {
		return bactualizar;
	}

	public void setBactualizar(JButton bactualizar) {
		this.bactualizar = bactualizar;
	}

	public JButton getBeliminar() {
		return beliminar;
	}

	public void setBeliminar(JButton beliminar) {
		this.beliminar = beliminar;
	}

	public JButton getBmostrar() {
		return bmostrar;
	}

	public void setBmostrar(JButton bmostrar) {
		this.bmostrar = bmostrar;
	}

}
