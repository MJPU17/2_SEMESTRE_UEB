package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	private PanelMenu pmenu;
	private PanelDatos pdatos;
	private PanelLista plista;
	private PanelMostrar pmostrar;
	private PanelPasaporte ppasaporte;
	
	public VentanaPrincipal() {
		setTitle("Ministerio Exteriores");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		setIconImage(new ImageIcon("src/recursos/colombia.png").getImage());;
		
		inicializarComponentes();
		
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
	}

	private void inicializarComponentes() {
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.fill=GridBagConstraints.BOTH;
		
		pmenu=new PanelMenu();
		add(pmenu,gbc);
		
		pdatos=new PanelDatos();
		add(pdatos,gbc);
		
		plista=new PanelLista();
		add(plista,gbc);
		
		pmostrar=new PanelMostrar();
		add(pmostrar,gbc);
		
		ppasaporte=new PanelPasaporte();
		add(ppasaporte,gbc);
		
	}
	
	public void abrirLista (String filename) {
		try {
			Runtime.getRuntime().exec(
					"C:\\Windows\\System32\\cmd.exe /K start src\\co\\edu\\unbosque\\model\\persistence\\"+filename+".csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PanelMenu getPmenu() {
		return pmenu;
	}

	public void setPmenu(PanelMenu pmenu) {
		this.pmenu = pmenu;
	}

	public PanelDatos getPdatos() {
		return pdatos;
	}

	public void setPdatos(PanelDatos pdatos) {
		this.pdatos = pdatos;
	}

	public PanelLista getPlista() {
		return plista;
	}

	public void setPlista(PanelLista plista) {
		this.plista = plista;
	}

	public PanelMostrar getPmostrar() {
		return pmostrar;
	}

	public void setPmostrar(PanelMostrar pmostrar) {
		this.pmostrar = pmostrar;
	}

	public PanelPasaporte getPpasaporte() {
		return ppasaporte;
	}

	public void setPpasaporte(PanelPasaporte ppasaporte) {
		this.ppasaporte = ppasaporte;
	}
	
}

