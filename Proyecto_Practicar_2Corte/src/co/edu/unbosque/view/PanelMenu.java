package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelMenu extends JPanel{
	
	private JLabel etitulo;
	private JButton bagregar,bgenerar_pas,bactualizar,beliminar,blistar_adm,blistar_rec;
	private ImagePanel fondo;
	
	public PanelMenu() {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridBagLayout());
		
		inicializarComponentes();
		
		setVisible(true);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		etitulo=new JLabel("Ministerio Exteriores");
		etitulo.setFont(new Font("Times New Roman",Font.BOLD,30));
		etitulo.setForeground(Color.white);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=3;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(etitulo,gbc);
		
		
		bagregar=new JButton("Agregar");
		bagregar.setFont(new Font("Arial",Font.BOLD,20));
		bagregar.setActionCommand("AGREGAR");
		bagregar.setForeground(Color.white);
		bagregar.setBackground(new Color(0,13,112));
		bagregar.setBorder(new LineBorder(Color.white,2));
		bagregar.setFocusPainted(false);
		bagregar.setPreferredSize(new Dimension(150,50));
		gbc.gridy=1;
		gbc.gridwidth=1;
		add(bagregar,gbc);
		
		bactualizar=new JButton("Actualizar");
		bactualizar.setFont(new Font("Arial",Font.BOLD,20));
		bactualizar.setActionCommand("ACTUALIZAR");
		bactualizar.setForeground(Color.white);
		bactualizar.setBackground(new Color(0,13,112));
		bactualizar.setBorder(new LineBorder(Color.white,2));
		bactualizar.setFocusPainted(false);
		bactualizar.setPreferredSize(new Dimension(150,50));
		gbc.gridx=1;
		add(bactualizar,gbc);
		
		beliminar=new JButton("Eliminar");
		beliminar.setFont(new Font("Arial",Font.BOLD,20));
		beliminar.setActionCommand("ELIMINAR");
		beliminar.setForeground(Color.white);
		beliminar.setBackground(new Color(0,13,112));
		beliminar.setBorder(new LineBorder(Color.white,2));
		beliminar.setFocusPainted(false);
		beliminar.setPreferredSize(new Dimension(150,50));
		gbc.gridx=2;
		add(beliminar,gbc);
		
		bgenerar_pas=new JButton("Pasaportes");
		bgenerar_pas.setFont(new Font("Arial",Font.BOLD,20));
		bgenerar_pas.setActionCommand("PASAPORTES");
		bgenerar_pas.setForeground(Color.white);
		bgenerar_pas.setBackground(new Color(0,13,112));
		bgenerar_pas.setBorder(new LineBorder(Color.white,2));
		bgenerar_pas.setFocusPainted(false);
		bgenerar_pas.setPreferredSize(new Dimension(150,50));
		gbc.gridy=2;
		gbc.gridx=0;
		add(bgenerar_pas,gbc);
		
		blistar_adm=new JButton("Admitidos");
		blistar_adm.setFont(new Font("Arial",Font.BOLD,20));
		blistar_adm.setActionCommand("ADMITIDOS");
		blistar_adm.setForeground(Color.white);
		blistar_adm.setBackground(new Color(0,13,112));
		blistar_adm.setBorder(new LineBorder(Color.white,2));
		blistar_adm.setFocusPainted(false);
		blistar_adm.setPreferredSize(new Dimension(150,50));
		gbc.gridx=1;
		add(blistar_adm,gbc);
		
		blistar_rec=new JButton("Rechazados");
		blistar_rec.setFont(new Font("Arial",Font.BOLD,20));
		blistar_rec.setActionCommand("RECHAZADOS");
		blistar_rec.setForeground(Color.white);
		blistar_rec.setBackground(new Color(0,13,112));
		blistar_rec.setBorder(new LineBorder(Color.white,2));
		blistar_rec.setFocusPainted(false);
		blistar_rec.setPreferredSize(new Dimension(150,50));
		gbc.gridx=2;
		add(blistar_rec,gbc);
		
	}

	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JButton getBagregar() {
		return bagregar;
	}

	public void setBagregar(JButton bagregar) {
		this.bagregar = bagregar;
	}

	public JButton getBgenerar_pas() {
		return bgenerar_pas;
	}

	public void setBgenerar_pas(JButton bgenerar_pas) {
		this.bgenerar_pas = bgenerar_pas;
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

	public JButton getBlistar_adm() {
		return blistar_adm;
	}

	public void setBlistar_adm(JButton blistar_adm) {
		this.blistar_adm = blistar_adm;
	}

	public JButton getBlistar_rec() {
		return blistar_rec;
	}

	public void setBlistar_rec(JButton blistar_rec) {
		this.blistar_rec = blistar_rec;
	}
	
}
