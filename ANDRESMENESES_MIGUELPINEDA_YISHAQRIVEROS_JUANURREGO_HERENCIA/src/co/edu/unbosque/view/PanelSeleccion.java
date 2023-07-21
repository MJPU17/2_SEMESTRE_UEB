package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelSeleccion extends JPanel{

	private JLabel eseleccion;
	private JComboBox<String> cseleccion;
	private JButton bdaralta,blista,bactualizar,batras;
	
	public PanelSeleccion() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		inicializarComponetes();
		
		setVisible(false);
	}

	private void inicializarComponetes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		eseleccion=new JLabel("Seleccione: ");
		eseleccion.setForeground(Color.white);
		eseleccion.setFont(new Font("Calisto MT",ALLBITS, 25));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.gridheight=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		add(eseleccion,gbc);
		
		
		cseleccion=new JComboBox<String>();
		cseleccion.setForeground(Color.white);
		cseleccion.setBackground(Color.cyan);
		cseleccion.setBorder(new LineBorder(Color.white,2));
		cseleccion.setFont(new Font("Bahnschrift",Font.BOLD, 18));
		gbc.gridy=1;
		add(cseleccion,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS SELECCION");
		batras.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		batras.setBackground(Color.cyan);
		batras.setForeground(Color.white);
		gbc.gridwidth=1;
		gbc.ipadx=20;
		gbc.ipady=10;
		gbc.gridy=2;
		add(batras,gbc);
		
		bdaralta=new JButton("Aceptar");
		blista=new JButton("Aceptar");
		bactualizar=new JButton("Actualizar");
		bdaralta.setActionCommand("ACEPTAR ALTA");
		blista.setActionCommand("ACEPTAR LISTA");
		bactualizar.setActionCommand("ACEPTAR ACTUALIZAR");
		bdaralta.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		blista.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bactualizar.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bdaralta.setForeground(Color.white);
		blista.setForeground(Color.white);
		bactualizar.setForeground(Color.white);
		bdaralta.setBackground(Color.cyan);
		blista.setBackground(Color.cyan);
		bactualizar.setBackground(Color.cyan);
		bdaralta.setVisible(false);
		blista.setVisible(false);
		bactualizar.setVisible(false);
		gbc.gridx=1;
		add(bdaralta,gbc);
		add(blista,gbc);
		add(bactualizar,gbc);
		
	}
	
	public void agregarItemsTipos() {
		String[] items= {"Estudiante","Profesor","Personal de servicio"};
		for(String item:items) {
			cseleccion.addItem(item);
		}
	}
	
	public void agregarItemsActualizar() {
		String[] items= {"Agragar curso estudiante.","Cambiar departamento profesor.","Cambiar seccion personal servicio.","Cambiar num despacho empleado.","Cambiar estado civil"};
		for(String item:items) {
			cseleccion.addItem(item);
		}
	}

	public JLabel getEseleccion() {
		return eseleccion;
	}

	public void setEseleccion(JLabel eseleccion) {
		this.eseleccion = eseleccion;
	}

	public JComboBox<String> getCseleccion() {
		return cseleccion;
	}

	public void setCseleccion(JComboBox<String> cseleccion) {
		this.cseleccion = cseleccion;
	}

	public JButton getBdaralta() {
		return bdaralta;
	}

	public void setBdaralta(JButton bdaralta) {
		this.bdaralta = bdaralta;
	}

	public JButton getBlista() {
		return blista;
	}

	public void setBlista(JButton blista) {
		this.blista = blista;
	}

	public JButton getBactualizar() {
		return bactualizar;
	}

	public void setBactualizar(JButton bactualizar) {
		this.bactualizar = bactualizar;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}
	
}
