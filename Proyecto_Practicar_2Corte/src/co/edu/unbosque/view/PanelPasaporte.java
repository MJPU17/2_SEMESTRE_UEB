package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelPasaporte extends JPanel{
	
	private JLabel epasaporte,pasaporte,etitulo,foto,enombre,efnacimiento,epais,evanios,evmeses,evdias;
	private JLabel cnombre,cfnacimiento,cpais,cvanios,cvmeses,cvdias,admicion;
	private JButton batras;
	
	public PanelPasaporte() {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridBagLayout());
		
		inicializarComponentes();
		
		setVisible(false);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		ImageIcon subir=new ImageIcon("src/recursos/Pasport.png");
		
		epasaporte=new JLabel("PASAPORTE");
		epasaporte.setFont(new Font("Times New Roman", Font.BOLD, 30));
		epasaporte.setForeground(new Color(0,13,112));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(epasaporte,gbc);
		
		pasaporte=new JLabel();
		pasaporte.setIcon(new ImageIcon(subir.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
		pasaporte.setLayout(null);
		gbc.gridy=1;
		
		etitulo=new JLabel("REPUBLICA DE COLOMBIA");
		etitulo.setFont(new Font("Arial", Font.BOLD, 17));
		etitulo.setForeground(new Color(219,216,65));
		etitulo.setBounds(35, 31, 250, 17);
		pasaporte.add(etitulo);
		
		foto=new JLabel();
		foto.setBounds(49, 66, 106, 137);
		pasaporte.add(foto);
		
		enombre=new JLabel("Nombre:");
		enombre.setFont(new Font("Arial", Font.BOLD, 15));
		enombre.setForeground(new Color(219,216,65));
		enombre.setBounds(35, 225, 80, 15);
		pasaporte.add(enombre);
		
		cnombre=new JLabel();
		cnombre.setFont(new Font("Arial", Font.BOLD, 15));
		cnombre.setForeground(Color.white);
		cnombre.setBounds(105, 225, 300, 15);
		pasaporte.add(cnombre);
		
		efnacimiento=new JLabel("Fecha nacimiento:");
		efnacimiento.setFont(new Font("Arial", Font.BOLD, 15));
		efnacimiento.setForeground(new Color(219,216,65));
		efnacimiento.setBounds(35, 250, 150, 15);
		pasaporte.add(efnacimiento);
		
		cfnacimiento=new JLabel();
		cfnacimiento.setFont(new Font("Arial", Font.BOLD, 15));
		cfnacimiento.setForeground(Color.white);
		cfnacimiento.setBounds(175, 250, 150, 15);
		pasaporte.add(cfnacimiento);
		
		epais=new JLabel("Pais:");
		epais.setFont(new Font("Arial", Font.BOLD, 15));
		epais.setForeground(new Color(219,216,65));
		epais.setBounds(35, 275, 80, 15);
		pasaporte.add(epais);
		
		cpais=new JLabel();
		cpais.setFont(new Font("Arial", Font.BOLD, 15));
		cpais.setForeground(Color.white);
		cpais.setBounds(75, 275, 300, 15);
		pasaporte.add(cpais);
		
		evanios=new JLabel("Años de vida:");
		evanios.setFont(new Font("Arial", Font.BOLD, 15));
		evanios.setForeground(new Color(219,216,65));
		evanios.setBounds(35, 300, 300, 15);
		pasaporte.add(evanios);
		
		cvanios=new JLabel();
		cvanios.setFont(new Font("Arial", Font.BOLD, 15));
		cvanios.setForeground(Color.white);
		cvanios.setBounds(140, 300, 300, 15);
		pasaporte.add(cvanios);
		
		evmeses=new JLabel("Meses de vida:");
		evmeses.setFont(new Font("Arial", Font.BOLD, 15));
		evmeses.setForeground(new Color(219,216,65));
		evmeses.setBounds(35, 325, 150, 15);
		pasaporte.add(evmeses);
		
		cvmeses=new JLabel();
		cvmeses.setFont(new Font("Arial", Font.BOLD, 15));
		cvmeses.setForeground(Color.white);
		cvmeses.setBounds(150, 325, 150, 15);
		pasaporte.add(cvmeses);
		
		evdias=new JLabel("Dias de vida:");
		evdias.setFont(new Font("Arial", Font.BOLD, 15));
		evdias.setForeground(new Color(219,216,65));
		evdias.setBounds(35, 350, 150, 15);
		pasaporte.add(evdias);
		
		cvdias=new JLabel();
		cvdias.setFont(new Font("Arial", Font.BOLD, 15));
		cvdias.setForeground(Color.white);
		cvdias.setBounds(135, 350, 150, 15);
		pasaporte.add(cvdias);
		
		admicion=new JLabel();
		admicion.setBounds(266, 265, 100, 100);
		pasaporte.add(admicion);
		add(pasaporte,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS PASAPORTE");
		batras.setFont(new Font("Arial",Font.BOLD,20));
		batras.setForeground(Color.white);
		batras.setBackground(new Color(0,13,112));
		batras.setBorder(new LineBorder(Color.white,2));
		batras.setFocusPainted(false);
		batras.setPreferredSize(new Dimension(150,50));
		gbc.gridy=2;
		add(batras,gbc);
			
	}
	
	public void agregarImagen(String filename) {
		ImageIcon subir=new ImageIcon(filename);
		ImageIcon imagen=new ImageIcon(subir.getImage().getScaledInstance(106,137 , Image.SCALE_SMOOTH));
		foto.setIcon(imagen);
	}
	
	public void generarAdmicion(boolean isadmicion) {
		ImageIcon subir=new ImageIcon();
		if(isadmicion)subir=new ImageIcon("src/recursos/Approved.png");
		else subir=new ImageIcon("src/recursos/Rejected.png");
		ImageIcon imagen=new ImageIcon(subir.getImage().getScaledInstance(100,100 , Image.SCALE_SMOOTH));
		admicion.setIcon(imagen);
	}

	public JLabel getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(JLabel pasaporte) {
		this.pasaporte = pasaporte;
	}

	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JLabel getFoto() {
		return foto;
	}

	public void setFoto(JLabel foto) {
		this.foto = foto;
	}

	public JLabel getEnombre() {
		return enombre;
	}

	public void setEnombre(JLabel enombre) {
		this.enombre = enombre;
	}

	public JLabel getEfnacimiento() {
		return efnacimiento;
	}

	public void setEfnacimiento(JLabel efnacimiento) {
		this.efnacimiento = efnacimiento;
	}

	public JLabel getEpais() {
		return epais;
	}

	public void setEpais(JLabel epais) {
		this.epais = epais;
	}

	public JLabel getEvanios() {
		return evanios;
	}

	public void setEvanios(JLabel evanios) {
		this.evanios = evanios;
	}

	public JLabel getEvmeses() {
		return evmeses;
	}

	public void setEvmeses(JLabel evmeses) {
		this.evmeses = evmeses;
	}

	public JLabel getEvdias() {
		return evdias;
	}

	public void setEvdias(JLabel evdias) {
		this.evdias = evdias;
	}

	public JLabel getCnombre() {
		return cnombre;
	}

	public void setCnombre(JLabel cnombre) {
		this.cnombre = cnombre;
	}

	public JLabel getCfnacimiento() {
		return cfnacimiento;
	}

	public void setCfnacimiento(JLabel cfnacimiento) {
		this.cfnacimiento = cfnacimiento;
	}

	public JLabel getCpais() {
		return cpais;
	}

	public void setCpais(JLabel cpais) {
		this.cpais = cpais;
	}

	public JLabel getCvanios() {
		return cvanios;
	}

	public void setCvanios(JLabel cvanios) {
		this.cvanios = cvanios;
	}

	public JLabel getCvmeses() {
		return cvmeses;
	}

	public void setCvmeses(JLabel cvmeses) {
		this.cvmeses = cvmeses;
	}

	public JLabel getCvdias() {
		return cvdias;
	}

	public void setCvdias(JLabel cvdias) {
		this.cvdias = cvdias;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}

}
