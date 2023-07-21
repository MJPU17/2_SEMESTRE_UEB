package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDarAlta extends JPanel{
	
	private JLabel edatos,eano_incorp,enum_desp,eextra;
	private JTextField fnombre,fapellidos,fnum_ide,fano_incorp,fnum_desp,fextra;
	private JComboBox<String> cestadocivil;
	private JButton bagregar,batras;
	
	public PanelDarAlta() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		inicializarComponentes();
		
		setVisible(false);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=2.0;
		gbc.weighty=2.0;
		
		String[] datos= {"Nombre: ","Apellidos: ","Num. Identificacion: ","Est. Civil: "};
		for(int i=0;i<4;i++) {
			edatos=new JLabel(datos[i]);
			edatos.setForeground(Color.white);
			edatos.setFont(new Font("Calisto MT",ALLBITS, 25));
			gbc.gridy=i;
			add(edatos,gbc);
		}
		
		eano_incorp=new JLabel("Año incorporacion: ");
		eano_incorp.setForeground(Color.white);
		eano_incorp.setFont(new Font("Calisto MT",ALLBITS, 25));
		eano_incorp.setVisible(false);
		gbc.gridy=4;
		add(eano_incorp,gbc);
		
		enum_desp=new JLabel("Num. despacho: ");
		enum_desp.setForeground(Color.white);
		enum_desp.setFont(new Font("Calisto MT",ALLBITS, 25));
		enum_desp.setVisible(false);
		gbc.gridy=5;
		add(enum_desp,gbc);
		
		eextra=new JLabel();
		eextra.setForeground(Color.white);
		eextra.setFont(new Font("Calisto MT",ALLBITS, 25));
		gbc.gridy=6;
		add(eextra,gbc);
		
		String[] est_civil= {"Soltero/a","Casado/a","Union libre","Separado/a","Divorciado/a","Viudo/a"};
		cestadocivil=new JComboBox<String>(est_civil);
		cestadocivil.setFont(new Font("Calisto MT",ALLBITS, 25));
		gbc.gridx=1;
		gbc.gridy=3;
		add(cestadocivil,gbc);
		
		fnombre=new JTextField();
		fnombre.setFont(new Font("Calisto MT",ALLBITS, 25));
		fnombre.setPreferredSize(new Dimension(250, 39));
		gbc.gridy=0;
		add(fnombre,gbc);
		
		fapellidos=new JTextField();
		fapellidos.setFont(new Font("Calisto MT",ALLBITS, 25));
		fapellidos.setPreferredSize(new Dimension(250, 39));
		gbc.gridy=1;
		add(fapellidos,gbc);
		
		fnum_ide=new JTextField();
		fnum_ide.setFont(new Font("Calisto MT",ALLBITS, 25));
		fnum_ide.setPreferredSize(new Dimension(250, 39));
		gbc.gridy=2;
		add(fnum_ide,gbc);
		
		fano_incorp=new JTextField();
		fano_incorp.setFont(new Font("Calisto MT",ALLBITS, 25));
		fano_incorp.setPreferredSize(new Dimension(250, 39));
		fano_incorp.setVisible(false);
		gbc.gridy=4;
		add(fano_incorp,gbc);
		
		fnum_desp=new JTextField();
		fnum_desp.setFont(new Font("Calisto MT",ALLBITS, 25));
		fnum_desp.setPreferredSize(new Dimension(250, 39));
		fnum_desp.setVisible(false);
		gbc.gridy=5;
		add(fnum_desp,gbc);
		
		fextra=new JTextField();
		fextra.setFont(new Font("Calisto MT",ALLBITS, 25));
		fextra.setPreferredSize(new Dimension(250, 39));
		gbc.gridy=6;
		add(fextra,gbc);
		
		bagregar=new JButton("Agregar");
		bagregar.setActionCommand("AGREGAR");
		bagregar.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		bagregar.setForeground(Color.white);
		bagregar.setBackground(Color.cyan);
		gbc.gridy=7;
		gbc.ipadx=20;
		gbc.ipady=10;
		add(bagregar,gbc);
		
		batras=new JButton("Atras");
		batras.setActionCommand("ATRAS DAR ALTA");
		batras.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		batras.setForeground(Color.white);
		batras.setBackground(Color.cyan);
		gbc.gridx=0;
		add(batras,gbc);
		
	}

	public JLabel getEdatos() {
		return edatos;
	}

	public void setEdatos(JLabel edatos) {
		this.edatos = edatos;
	}

	public JLabel getEano_incorp() {
		return eano_incorp;
	}

	public void setEano_incorp(JLabel eano_incorp) {
		this.eano_incorp = eano_incorp;
	}

	public JLabel getEnum_desp() {
		return enum_desp;
	}

	public void setEnum_desp(JLabel enum_desp) {
		this.enum_desp = enum_desp;
	}

	public JLabel getEextra() {
		return eextra;
	}

	public void setEextra(JLabel eextra) {
		this.eextra = eextra;
	}

	public JTextField getFnombre() {
		return fnombre;
	}

	public void setFnombre(JTextField fnombre) {
		this.fnombre = fnombre;
	}

	public JTextField getFapellidos() {
		return fapellidos;
	}

	public void setFapellidos(JTextField fapellidos) {
		this.fapellidos = fapellidos;
	}

	public JTextField getFnum_ide() {
		return fnum_ide;
	}

	public void setFnum_ide(JTextField fnum_ide) {
		this.fnum_ide = fnum_ide;
	}

	public JComboBox<String> getCestadocivil() {
		return cestadocivil;
	}

	public void setCestadocivil(JComboBox<String> cestadocivil) {
		this.cestadocivil = cestadocivil;
	}

	public JTextField getFano_incorp() {
		return fano_incorp;
	}

	public void setFano_incorp(JTextField fano_incorp) {
		this.fano_incorp = fano_incorp;
	}

	public JTextField getFnum_desp() {
		return fnum_desp;
	}

	public void setFnum_desp(JTextField fnum_desp) {
		this.fnum_desp = fnum_desp;
	}

	public JTextField getFextra() {
		return fextra;
	}

	public void setFextra(JTextField fextra) {
		this.fextra = fextra;
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

}
