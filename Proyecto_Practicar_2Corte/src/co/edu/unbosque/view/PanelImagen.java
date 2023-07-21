package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelImagen extends JPanel{
	
	private JLabel eimagen;
	private JButton bimagen;
	
	public PanelImagen() {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridBagLayout());
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		eimagen=new JLabel();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(eimagen,gbc);
		
		bimagen=new JButton("Cargar");
		bimagen.setActionCommand("CARGAR");
		bimagen.setFont(new Font("Arial",Font.BOLD,20));
		bimagen.setForeground(Color.white);
		bimagen.setBackground(new Color(0,13,112));
		bimagen.setBorder(new LineBorder(Color.white,2));
		bimagen.setFocusPainted(false);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridy=1;
		add(bimagen,gbc);
	
	}

	public void agregarImagen(String filename) {
		ImageIcon subir=new ImageIcon(filename);
		ImageIcon imagen=new ImageIcon(subir.getImage().getScaledInstance(200,200 , Image.SCALE_SMOOTH));
		eimagen.setIcon(imagen);
	}
	
	public String guardarImagen(JPanel panel) {
		JFileChooser selector=new JFileChooser();
		FileNameExtensionFilter filextend = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
		selector.setFileFilter(filextend);
		String ruta="";
		int eleccion= selector.showOpenDialog(panel);
		
		if(eleccion==selector.APPROVE_OPTION) {
			ruta=selector.getSelectedFile().getPath();
			String extencion=ruta.substring(ruta.lastIndexOf(".")+1);
			if(extencion.equalsIgnoreCase("jpg")||extencion.equalsIgnoreCase("jpeg")||extencion.equalsIgnoreCase("gif")||extencion.equalsIgnoreCase("png")) {
				ImageIcon subir=new ImageIcon(ruta);
				ImageIcon imagen=new ImageIcon(subir.getImage().getScaledInstance(200,200 , Image.SCALE_SMOOTH));
				eimagen.setIcon(imagen);
			}
		}
		return ruta;
	}

	public JLabel getEimagen() {
		return eimagen;
	}

	public void setEimagen(JLabel eimagen) {
		this.eimagen = eimagen;
	}

	public JButton getBimagen() {
		return bimagen;
	}

	public void setBimagen(JButton bimagen) {
		this.bimagen = bimagen;
	}

}
