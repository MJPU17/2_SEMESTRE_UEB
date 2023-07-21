package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	private PanelMenu pmenu;
	private PanelSeleccion pseleccion;
	private PanelDarAlta pdaralta;
	private PanelDNI pdni;
	private PanelLista plista;
	private PanelDatos pdatos;
	private PanelActualizar pactualizar;
	
	public VentanaPrincipal() {
		setTitle("Gestion de facultad");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.darkGray);
		getContentPane().setLayout(new GridBagLayout());
		
		inicializarComponentes();
		
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		gbc.fill=GridBagConstraints.BOTH;
		
		pmenu=new PanelMenu();
		getContentPane().add(pmenu,gbc);
		
		pseleccion=new PanelSeleccion();
		getContentPane().add(pseleccion,gbc);
		
		pdaralta=new PanelDarAlta();
		getContentPane().add(pdaralta,gbc);
		
		pdni=new PanelDNI();
		getContentPane().add(pdni,gbc);
		
		plista=new PanelLista();
		getContentPane().add(plista,gbc);
		
		pdatos=new PanelDatos();
		getContentPane().add(pdatos,gbc);
		
		pactualizar=new PanelActualizar();
		getContentPane().add(pactualizar,gbc);
	}

	public PanelMenu getPmenu() {
		return pmenu;
	}

	public void setPmenu(PanelMenu pmenu) {
		this.pmenu = pmenu;
	}

	public PanelSeleccion getPseleccion() {
		return pseleccion;
	}

	public void setPseleccion(PanelSeleccion pseleccion) {
		this.pseleccion = pseleccion;
	}

	public PanelDarAlta getPdaralta() {
		return pdaralta;
	}

	public void setPdaralta(PanelDarAlta pdaralta) {
		this.pdaralta = pdaralta;
	}

	public PanelDNI getPdni() {
		return pdni;
	}

	public void setPdni(PanelDNI pdni) {
		this.pdni = pdni;
	}

	public PanelLista getPlista() {
		return plista;
	}

	public void setPlista(PanelLista plista) {
		this.plista = plista;
	}

	public PanelDatos getPdatos() {
		return pdatos;
	}

	public void setPdatos(PanelDatos pdatos) {
		this.pdatos = pdatos;
	}

	public PanelActualizar getPactualizar() {
		return pactualizar;
	}

	public void setPactualizar(PanelActualizar pactualizar) {
		this.pactualizar = pactualizar;
	}

}
