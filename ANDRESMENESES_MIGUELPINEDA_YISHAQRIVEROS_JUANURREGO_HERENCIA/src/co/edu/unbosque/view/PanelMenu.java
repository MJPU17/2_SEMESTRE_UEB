package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel{
	
	private JLabel etitulo;
	private JButton bdaralta,bdarbaja,bbuscar,blista,bnominas,bactualizar;
	
	public PanelMenu() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		inicializarComponentes();
		
		setVisible(true);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		etitulo=new JLabel("Gestion de facultad");
		etitulo.setForeground(Color.white);
		etitulo.setFont(new Font("Bauhaus 93", ALLBITS, 45));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=3;
		gbc.gridheight=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		add(etitulo,gbc);
		
		bdaralta=new JButton("Dar alta");
		bdaralta.setActionCommand("DAR ALTA");
		bdaralta.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bdaralta.setBackground(Color.cyan);
		bdaralta.setForeground(Color.white);
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.ipadx=30;
		gbc.ipady=10;
		add(bdaralta,gbc);
		
		bdarbaja=new JButton("Dar baja");
		bdarbaja.setActionCommand("DAR BAJA");
		bdarbaja.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bdarbaja.setBackground(Color.cyan);
		bdarbaja.setForeground(Color.white);
		gbc.gridy=2;
        add(bdarbaja,gbc);
        
        bbuscar=new JButton("Buscar persona");
        bbuscar.setActionCommand("BUSCAR");
        bbuscar.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        bbuscar.setBackground(Color.cyan);
        bbuscar.setForeground(Color.white);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.ipadx=10;
        add(bbuscar,gbc);
		
		blista=new JButton("Listar");
		blista.setActionCommand("LISTA");
		blista.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		blista.setBackground(Color.cyan);
		blista.setForeground(Color.white);
		gbc.gridy=2;
		gbc.ipadx=95;
		add(blista,gbc);
		
		bnominas=new JButton("Ver nominas");
		bnominas.setActionCommand("NOMINAS");
		bnominas.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bnominas.setBackground(Color.cyan);
		bnominas.setForeground(Color.white);
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.ipadx=20;
		add(bnominas,gbc);
		
		bactualizar=new JButton("Actualizar");
		bactualizar.setActionCommand("ACTUALIZAR");
		bactualizar.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bactualizar.setForeground(Color.white);
		bactualizar.setBackground(Color.cyan);
		gbc.gridy=2;
		gbc.ipadx=38;
		add(bactualizar,gbc);
		
	}

	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JButton getBadarlta() {
		return bdaralta;
	}

	public void setBdaralta(JButton bañadir) {
		this.bdaralta = bañadir;
	}

	public JButton getBdarbaja() {
		return bdarbaja;
	}

	public void setBdarbaja(JButton bdarbaja) {
		this.bdarbaja = bdarbaja;
	}

	public JButton getBbuscar() {
		return bbuscar;
	}

	public void setBbuscar(JButton bbuscar) {
		this.bbuscar = bbuscar;
	}

	public JButton getBlista() {
		return blista;
	}

	public void setBlista(JButton blista) {
		this.blista = blista;
	}

	public JButton getBnominas() {
		return bnominas;
	}

	public void setBnominas(JButton bnominas) {
		this.bnominas = bnominas;
	}

	public JButton getBdaralta() {
		return bdaralta;
	}

	public JButton getBactualizar() {
		return bactualizar;
	}

	public void setBactualizar(JButton bmatricular) {
		this.bactualizar = bmatricular;
	}

}
