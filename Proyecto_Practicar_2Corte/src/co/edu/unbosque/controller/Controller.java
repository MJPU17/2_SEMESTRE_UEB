package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import co.edu.unbosque.model.PasaporteDAO;
import co.edu.unbosque.model.PasaporteDTO;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VerificarEntrada;

public class Controller implements ActionListener,DocumentListener{
	
	private PasaporteDAO pasaportes;
	private VentanaPrincipal vista;
	private HashMap<Integer, Integer> indices;
	private String ruta,seleccion;
	private int pos;
	
	public Controller() {
		vista=new VentanaPrincipal();
		pasaportes=new PasaporteDAO();
		indices=new HashMap<>();
		ruta="";
		seleccion="";
		pos=0;
		asignarOyentes();
	}

	private void asignarOyentes() {
		vista.getPmenu().getBagregar().addActionListener(this);
		vista.getPmenu().getBactualizar().addActionListener(this);
		vista.getPmenu().getBeliminar().addActionListener(this);
		vista.getPmenu().getBgenerar_pas().addActionListener(this);
		vista.getPmenu().getBlistar_adm().addActionListener(this);
		vista.getPmenu().getBlistar_rec().addActionListener(this);
		vista.getPdatos().getBagregar().addActionListener(this);
		vista.getPdatos().getBactualizar().addActionListener(this);
		vista.getPdatos().getBatras().addActionListener(this);
		vista.getPdatos().getPimagen().getBimagen().addActionListener(this);
		vista.getPlista().getFlista().getDocument().addDocumentListener(this);
		vista.getPlista().getBactualizar().addActionListener(this);
		vista.getPlista().getBeliminar().addActionListener(this);
		vista.getPlista().getBmostrar().addActionListener(this);
		vista.getPlista().getBatras().addActionListener(this);
		vista.getPmostrar().getBatras().addActionListener(this);
		vista.getPmostrar().getBaceptar().addActionListener(this);
		vista.getPpasaporte().getBatras().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		
		switch (comando) {
		
		case "AGREGAR": {
			vista.getPmenu().setVisible(false);
			vista.getPdatos().getEtitulo().setText("AGREGAR PASAPORTE");
			vista.getPdatos().getBagregar().setVisible(true);
			vista.getPdatos().getPimagen().agregarImagen("src/recursos/AgregarImagen.png");
			vista.getPdatos().setVisible(true);
			break;
		}
		case "CARGAR":{
			String aux=vista.getPdatos().getPimagen().guardarImagen(vista.getPdatos());
			if(VerificarEntrada.comprobarExtencion(aux, vista)) {
				ruta=aux;
			}
			break;
		}
		case "GUARDAR":{
			String nombre=vista.getPdatos().getFnombre().getText();
			LocalDate fnacimiento=null;
			if(vista.getPdatos().getCnacimiento().getDate()!=null) {
				fnacimiento=vista.getPdatos().getCnacimiento().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
			String pais=vista.getPdatos().getFpais().getText();
			boolean uno=VerificarEntrada.comprobarNombre(nombre, vista),dos=VerificarEntrada.comprobarFecha(fnacimiento, vista),tres=VerificarEntrada.comprobarPais(pais, vista),cuatro=VerificarEntrada.comprobarExtencion(ruta, vista);
			if(uno&&dos&&tres&&cuatro) {
				pasaportes.crear(new PasaporteDTO(nombre, fnacimiento, pais, ruta));
				vista.getPdatos().setVisible(false);
				vista.getPdatos().getFnombre().setText("");
				vista.getPdatos().getCnacimiento().setDate(null);
				vista.getPdatos().getFpais().setText("");
				vista.getPdatos().getBagregar().setVisible(false);
				vista.getPmenu().setVisible(true);
				ruta="";
			}
			break;
		}
		case "ATRAS DATOS":{
			vista.getPdatos().setVisible(false);
			vista.getPdatos().getFnombre().setText("");
			vista.getPdatos().getCnacimiento().setDate(null);
			vista.getPdatos().getFpais().setText("");
			vista.getPdatos().getBagregar().setVisible(false);
			vista.getPdatos().getBactualizar().setVisible(false);
			vista.getPmenu().setVisible(true);
			break;
		}
		case "ACTUALIZAR":{
			vista.getPmenu().setVisible(false);
			vista.getPlista().getBactualizar().setVisible(true);
			vista.getPlista().getElista().setText("Seleccione pasaporte a actualizar:");
			vista.getPlista().agregarValores(pasaportes.getLpasaportes());
			seleccion="Ninguno";
			vista.getPlista().setVisible(true);
			break;
		}
		case "ACTUALIZAR LISTA":{
			if(vista.getPlista().getLista().getSelectedValue()!=null) {
				pos=Integer.parseInt(""+vista.getPlista().getLista().getSelectedValue().charAt(0))-1;
				PasaporteDTO pas=pasaportes.getLpasaportes().get(pos);
				vista.getPlista().setVisible(false);
				vista.getPdatos().getEtitulo().setText("ACTUALIZAR PASAPORTE");
				vista.getPdatos().getFnombre().setText(pas.getNombre());
				vista.getPdatos().getCnacimiento().setDate(Date.from(pas.getFnacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
				vista.getPdatos().getFpais().setText(pas.getPais());
				vista.getPdatos().getPimagen().agregarImagen(pas.getFoto());
				vista.getPlista().getBactualizar().setVisible(false);
				vista.getPdatos().getBactualizar().setVisible(true);
				vista.getPdatos().setVisible(true);
			}
			else {
				VerificarEntrada.mensajeError("Porfavor seleccione un pasaporte.", vista);
			}
			break;
		}
		case "ATRAS LISTA":{
			vista.getPlista().setVisible(false);
			vista.getPlista().getBactualizar().setVisible(false);
			vista.getPlista().getBeliminar().setVisible(false);
			vista.getPlista().getBmostrar().setVisible(false);
			vista.getPmenu().setVisible(true);
			break;
		}
		case "CAMBIAR":{
			String nombre=vista.getPdatos().getFnombre().getText();
			LocalDate fnacimiento=null;
			if(vista.getPdatos().getCnacimiento().getDate()!=null) {
				fnacimiento=vista.getPdatos().getCnacimiento().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
			String pais=vista.getPdatos().getFpais().getText();
			if(ruta.equals("")) {
				ruta=pasaportes.getLpasaportes().get(pos).getFoto();
			}
			boolean uno=VerificarEntrada.comprobarNombre(nombre, vista),dos=VerificarEntrada.comprobarFecha(fnacimiento, vista),tres=VerificarEntrada.comprobarPais(pais, vista),cuatro=VerificarEntrada.comprobarExtencion(ruta, vista);
			if(uno&&dos&&tres&&cuatro) {
				pasaportes.actualizar(pos, new PasaporteDTO(nombre, fnacimiento, pais, ruta));
				vista.getPdatos().setVisible(false);
				vista.getPdatos().getFnombre().setText("");
				vista.getPdatos().getCnacimiento().setDate(null);
				vista.getPdatos().getFpais().setText("");
				vista.getPdatos().getBactualizar().setVisible(false);
				vista.getPmenu().setVisible(true);
				ruta="";
			}
			break;
		}
		case "ELIMINAR":{
			vista.getPmenu().setVisible(false);
			vista.getPlista().getBeliminar().setVisible(true);
			vista.getPlista().getElista().setText("Seleccione pasaporte a eliminar:");
			vista.getPlista().agregarValores(pasaportes.getLpasaportes());
			vista.getPlista().setVisible(true);
			break;
		}
		case "REMOVER":{
			if(vista.getPlista().getLista().getSelectedValue()!=null) {
				pos=Integer.parseInt(""+vista.getPlista().getLista().getSelectedValue().charAt(0))-1;
				int opcion=VerificarEntrada.mensajeVerificar("Esta seguro de quiere eliminar este pasaporte.", vista);
				if(opcion==0) {
					vista.getPlista().setVisible(false);
					pasaportes.eliminar(pos);
					vista.getPlista().getBeliminar().setVisible(false);
					vista.getPmenu().setVisible(true);
				}
				else if(opcion==2) {
					vista.getPlista().setVisible(false);
					vista.getPlista().getBeliminar().setVisible(false);
					vista.getPmenu().setVisible(true);
				}
			}
			else {
				VerificarEntrada.mensajeError("Porfavor seleccione un pasaporte.", vista);
			}
			break;
		}
		case "PASAPORTES":{
			vista.getPmenu().setVisible(false);
			vista.getPmostrar().setVisible(true);
			break;
		}
		case "MOSTRAR":{
			vista.getPmostrar().setVisible(false);
			vista.getPlista().getBmostrar().setVisible(true);
			vista.getPlista().getElista().setText("Seleccione pasaporte a mostrar: ");
			if(vista.getPmostrar().getCbmostrar().getSelectedIndex()==0) {
				seleccion="Colombia";
				indices=vista.getPlista().agregarValores(pasaportes.getLpasaportes(), true);
			}
			else if(vista.getPmostrar().getCbmostrar().getSelectedIndex()==1) {
				seleccion="Extranjero";
				indices=vista.getPlista().agregarValores(pasaportes.getLpasaportes(), false);
			}
			else if(vista.getPmostrar().getCbmostrar().getSelectedIndex()==2) {
				seleccion="Ninguno";
				vista.getPlista().agregarValores(pasaportes.getLpasaportes());
			}
			vista.getPlista().setVisible(true);
			break;
		}
		case "MOSTRAR LISTA":{
			if(vista.getPlista().getLista().getSelectedValue()!=null) {
				vista.getPlista().setVisible(false);
				pos=Integer.parseInt(""+vista.getPlista().getLista().getSelectedValue().charAt(0));
				if(seleccion.equals("Colombia")||seleccion.equals("Extranjero")) {
					pos=indices.get(pos);
				}
				else {
					pos-=1;
				}
				PasaporteDTO pas=pasaportes.getLpasaportes().get(pos);
				vista.getPpasaporte().agregarImagen(pas.getFoto());
				vista.getPpasaporte().getCnombre().setText(pas.getNombre());
				vista.getPpasaporte().getCfnacimiento().setText(pas.getFnacimiento().toString());
				vista.getPpasaporte().getCpais().setText(pas.getPais());
				vista.getPpasaporte().getCvanios().setText(""+pas.calcularEdadAnios());
				vista.getPpasaporte().getCvmeses().setText(""+pas.calcularEdadMeses());
				vista.getPpasaporte().getCvdias().setText(""+pas.calcularEdadDias());
				vista.getPpasaporte().generarAdmicion(pas.isAdmitido());
				vista.getPpasaporte().setVisible(true);
			}
			else{
				VerificarEntrada.mensajeError("Porfavor seleccione un pasaporte.", vista);
			}
			break;
		}
		case "ATRAS MOSTRAR":{
			vista.getPmostrar().setVisible(false);
			vista.getPmenu().setVisible(true);
			break;
		}
		case "ATRAS PASAPORTE":{
			vista.getPpasaporte().setVisible(false);
			vista.getPlista().getBmostrar().setVisible(false);
			vista.getPmenu().setVisible(true);
			break;
		}
		case "ADMITIDOS":{
			vista.abrirLista("admitidos");
			break;
		}
		case "RECHAZADOS":{
			vista.abrirLista("rechazados");
			break;
		}
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		String filtro=vista.getPlista().getFlista().getText();
		if(seleccion.equals("Ninguno")) {
			vista.getPlista().filtrarMostrar(filtro, pasaportes.getLpasaportes());
		}
		else {
			vista.getPlista().filtrarMostrar(filtro, pasaportes.getLpasaportes(),seleccion.equals("Colombia"));
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) { 
		String filtro=vista.getPlista().getFlista().getText();
		if(seleccion.equals("Ninguno")) {
			vista.getPlista().filtrarMostrar(filtro, pasaportes.getLpasaportes());
		}
		else {
			vista.getPlista().filtrarMostrar(filtro, pasaportes.getLpasaportes(),seleccion.equals("Colombia"));
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		
	}
}
