package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class PanelDatos extends JPanel{
	
	private JLabel etitulo,enombre,efnacimiento,epais;
	private JTextField fnombre,fpais;
	private JButton bagregar,bactualizar,batras;
	private JDateChooser cnacimiento;
	private PanelImagen pimagen;
	
	public PanelDatos() {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridBagLayout());
		
		inicializarComponentes();
		
		setVisible(false);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		etitulo=new JLabel();
		etitulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		etitulo.setForeground(new Color(0,13,112));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=3;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(etitulo,gbc);
		
		enombre=new JLabel("<html>Nombre completo:");
		enombre.setFont(new Font("Times New Roman",Font.BOLD,20));
		enombre.setForeground(Color.white);
		gbc.gridy=1;
		gbc.gridwidth=1;
		add(enombre,gbc);
		
		efnacimiento=new JLabel("<html>Fecha nacimiento:");
		efnacimiento.setFont(new Font("Times New Roman",Font.BOLD,20));
		efnacimiento.setForeground(Color.white);
		gbc.gridy=2;
		add(efnacimiento,gbc);
		
		epais=new JLabel("<html>Lugar de nacimiento:");
		epais.setFont(new Font("Times New Roman",Font.BOLD,20));
		epais.setForeground(Color.white);
		gbc.gridy=3;
		add(epais,gbc);
		
		fnombre=new JTextField();
		fnombre.setFont((new Font("Arial",Font.BOLD,20)));
		fnombre.setPreferredSize(new Dimension(200, 30));
		fnombre.setBorder(new LineBorder(new Color(0,13,112),3));
		gbc.gridx=1;
		gbc.gridy=1;
		add(fnombre,gbc);
		
		cnacimiento=new JDateChooser();
		cnacimiento.setPreferredSize(new Dimension(200, 30));
		cnacimiento.setFont((new Font("Arial",ALLBITS,18)));
		cnacimiento.setBorder(new LineBorder(new Color(0,13,112),2));
		cnacimiento.getCalendarButton().setBackground(new Color(0,13,112));
		cnacimiento.getCalendarButton().setBorder(new LineBorder(new Color(0,13,112)));
		cnacimiento.getCalendarButton().setFocusPainted(false);
		gbc.gridy=2;
		add(cnacimiento,gbc);
		
		fpais=new JTextField();
		fpais.setFont((new Font("Arial",Font.BOLD,20)));
		fpais.setPreferredSize(new Dimension(200, 30));
		fpais.setBorder(new LineBorder(new Color(0,13,112),3));
		gbc.gridy=3;
		add(fpais,gbc);
		
		pimagen=new PanelImagen();
		gbc.gridy=1;
		gbc.gridx=2;
		gbc.gridheight=3;
		add(pimagen,gbc);
		
		bagregar=new JButton("Guardar");
		bactualizar=new JButton("Actualizar");
		bagregar.setActionCommand("GUARDAR");
		bactualizar.setActionCommand("CAMBIAR");
		bagregar.setFont(new Font("Arial",Font.BOLD,20));
		bactualizar.setFont(new Font("Arial",Font.BOLD,20));
		bagregar.setVisible(false);
		bactualizar.setVisible(false);
		bagregar.setForeground(Color.white);
		bactualizar.setForeground(Color.white);
		bagregar.setForeground(Color.white);
		bagregar.setBackground(new Color(0,13,112));
		bactualizar.setBackground(new Color(0,13,112));
		bagregar.setBorder(new LineBorder(Color.white,2));
		bactualizar.setBorder(new LineBorder(Color.white,2));
		bagregar.setFocusPainted(false);
		bactualizar.setFocusPainted(false);
		bagregar.setPreferredSize(new Dimension(150,50));
		bactualizar.setPreferredSize(new Dimension(150,50));
		gbc.gridheight=1;
		gbc.gridwidth=2;
		gbc.gridy=4;
		gbc.gridx=1;
		add(bagregar,gbc);
		add(bactualizar,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS DATOS");
		batras.setFont(new Font("Arial",Font.BOLD,20));
		batras.setForeground(Color.white);
		batras.setBackground(new Color(0,13,112));
		batras.setBorder(new LineBorder(Color.white,2));
		batras.setFocusPainted(false);
		batras.setPreferredSize(new Dimension(150,50));
		gbc.gridx=0;
		add(batras,gbc);
		
	}

	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
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

	public JTextField getFnombre() {
		return fnombre;
	}

	public void setFnombre(JTextField fnombre) {
		this.fnombre = fnombre;
	}

	public JTextField getFpais() {
		return fpais;
	}

	public void setFpais(JTextField fpais) {
		this.fpais = fpais;
	}

	public JButton getBagregar() {
		return bagregar;
	}

	public void setBagregar(JButton bagregar) {
		this.bagregar = bagregar;
	}

	public JButton getBatras() {
		return batras;
	}

	public void setBatras(JButton batras) {
		this.batras = batras;
	}

	public PanelImagen getPimagen() {
		return pimagen;
	}

	public void setPimagen(PanelImagen pimagen) {
		this.pimagen = pimagen;
	}

	public JDateChooser getCnacimiento() {
		return cnacimiento;
	}

	public void setCnacimiento(JDateChooser cnacimiento) {
		this.cnacimiento = cnacimiento;
	}

	public JButton getBactualizar() {
		return bactualizar;
	}

	public void setBactualizar(JButton bactualizar) {
		this.bactualizar = bactualizar;
	}

}
