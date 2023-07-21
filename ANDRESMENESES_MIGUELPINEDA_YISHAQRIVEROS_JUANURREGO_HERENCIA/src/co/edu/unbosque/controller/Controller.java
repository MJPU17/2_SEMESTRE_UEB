package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.model.Facultad;
import co.edu.unbosque.model.Personal_servicio;
import co.edu.unbosque.model.Profesor;
import co.edu.unbosque.view.MensajesEmergentes;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener{
	
	private VentanaPrincipal vista;
	private Facultad gestion;
	private long act_dni;
	
	public Controller() {
		gestion=new Facultad();
		vista=new VentanaPrincipal();
		asignarOyentes();
	}
	
	public void asignarOyentes() {
		vista.getPmenu().getBadarlta().addActionListener(this);
		vista.getPmenu().getBdarbaja().addActionListener(this);
		vista.getPmenu().getBbuscar().addActionListener(this);
		vista.getPmenu().getBlista().addActionListener(this);
		vista.getPmenu().getBnominas().addActionListener(this);
		vista.getPmenu().getBactualizar().addActionListener(this);
		vista.getPseleccion().getBdaralta().addActionListener(this);
		vista.getPseleccion().getBlista().addActionListener(this);
		vista.getPseleccion().getBatras().addActionListener(this);
		vista.getPseleccion().getBactualizar().addActionListener(this);
		vista.getPlista().getBatras().addActionListener(this);
		vista.getPdni().getBeliminar().addActionListener(this);
		vista.getPdni().getBbuscar().addActionListener(this);
		vista.getPdni().getBatras().addActionListener(this);
		vista.getPdni().getBactualizar().addActionListener(this);
		vista.getPdaralta().getBagregar().addActionListener(this);
		vista.getPdaralta().getBatras().addActionListener(this);
		vista.getPdatos().getBatras().addActionListener(this);
		vista.getPactualizar().getBactualizar().addActionListener(this);
		vista.getPactualizar().getBatras().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
		String comando=e.getActionCommand();
		
		if(comando.equals("DAR ALTA")) {
			vista.getPmenu().setVisible(false);
			vista.getPseleccion().agregarItemsTipos();
			vista.getPseleccion().getBdaralta().setVisible(true);
			vista.getPseleccion().setVisible(true);
		}
		else if(comando.equals("DAR BAJA")) {
			vista.getPmenu().setVisible(false);
			vista.getPdni().getEdni().setText("Ingrese DNI de la persona que quiere eliminar:");
			vista.getPdni().getBeliminar().setVisible(true);
			vista.getPdni().setVisible(true);
			
		}
		else if(comando.equals("BUSCAR")) {
			vista.getPmenu().setVisible(false);
			vista.getPdni().getEdni().setText("Ingrese DNI de la persona que quiere buscar:");
			vista.getPdni().getBbuscar().setVisible(true);
			vista.getPdni().setVisible(true);
		}
		else if(comando.equals("LISTA")) {
			vista.getPmenu().setVisible(false);
			vista.getPseleccion().agregarItemsTipos();
			vista.getPseleccion().getCseleccion().addItem("Toda la facultad");
			vista.getPseleccion().getBlista().setVisible(true);
			vista.getPseleccion().setVisible(true);
		}
		else if(comando.equals("NOMINAS")) {
			if(gestion.getLempleados().size()>0) {
				vista.getPmenu().setVisible(false);
				vista.getPlista().getElista().setText("Nominas Empleados");
				vista.getPlista().iniciarLista(gestion.tablaEmpleados());
				vista.getPlista().setVisible(true);
			}else {
				MensajesEmergentes.mensajeError(vista, "No se ha ingresado ningun empleado.");
			}
		}
		else if(comando.equals("ACTUALIZAR")) {
			vista.getPmenu().setVisible(false);
			vista.getPseleccion().getBactualizar().setVisible(true);
			vista.getPseleccion().agregarItemsActualizar();
			vista.getPseleccion().setVisible(true);
		}
		else if(comando.equals("ACEPTAR ALTA")) {
			vista.getPseleccion().setVisible(false);
			vista.getPseleccion().getBdaralta().setVisible(false);
			if(vista.getPseleccion().getCseleccion().getSelectedIndex()==0) {
				vista.getPdaralta().getEextra().setText("Curso: ");
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==1) {
				vista.getPdaralta().getEano_incorp().setVisible(true);
				vista.getPdaralta().getFano_incorp().setVisible(true);
				vista.getPdaralta().getEnum_desp().setVisible(true);
				vista.getPdaralta().getFnum_desp().setVisible(true);
				vista.getPdaralta().getEextra().setText("Departamento: ");
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==2) {
				vista.getPdaralta().getEano_incorp().setVisible(true);
				vista.getPdaralta().getFano_incorp().setVisible(true);
				vista.getPdaralta().getEnum_desp().setVisible(true);
				vista.getPdaralta().getFnum_desp().setVisible(true);
				vista.getPdaralta().getEextra().setText("Seccion: ");
			}
			vista.getPdaralta().setVisible(true);
		}
		else if(comando.equals("ACEPTAR LISTA")) {
			if(vista.getPseleccion().getCseleccion().getSelectedIndex()==0) {
				if(gestion.getLestudiantes().size()>0) {
					vista.getPseleccion().setVisible(false);
					vista.getPlista().getElista().setText("Estudiantes de la facultad:");
					vista.getPlista().iniciarLista(gestion.tablaEstudiantes());
					vista.getPlista().setVisible(true);
				}
				else {
					MensajesEmergentes.mensajeError(vista, "No se ha ingresado ningun estudiante.");
				}
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==1) {
				if(gestion.getLprofesores().size()>0) {
					vista.getPseleccion().setVisible(false);
					vista.getPlista().getElista().setText("Profesores de la facultad:");
					vista.getPlista().iniciarLista(gestion.tablaProfesores());
					vista.getPlista().setVisible(true);
				}
				else {
					MensajesEmergentes.mensajeError(vista, "No se ha ingresado ningun profesor.");
				}
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==2) {
				if(gestion.getLpersonales_servicios().size()>0) {
					vista.getPseleccion().setVisible(false);
					vista.getPlista().getElista().setText("Personal servicio:");
					vista.getPlista().iniciarLista(gestion.tablaPersonalServicio());
					vista.getPlista().setVisible(true);
				}
				else {
					MensajesEmergentes.mensajeError(vista, "No se ha ingresado ningun personal de servicio.");
				}
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==3) {
				ArrayList<String[][]> listas=new ArrayList<>(3);
				ArrayList<String> titulos=new  ArrayList<>(3);
				if(gestion.getLestudiantes().size()>0||gestion.getLprofesores().size()>0||gestion.getLpersonales_servicios().size()>0) {
					if(gestion.getLestudiantes().size()>0) {
						titulos.add("Estudiantes");
						listas.add(gestion.tablaEstudiantes());
					}
					if(gestion.getLprofesores().size()>0) {
						titulos.add("Profesores");
						listas.add(gestion.tablaProfesores());
					}
					if(gestion.getLpersonales_servicios().size()>0) {
						titulos.add("Personales servicio");
						listas.add(gestion.tablaPersonalServicio());
					}
					vista.getPseleccion().setVisible(false);
					vista.getPlista().getElista().setText("Facultad:");
					vista.getPlista().iniciarListas(listas, titulos);
					vista.getPlista().setVisible(true);
				}
				else {
					MensajesEmergentes.mensajeError(vista, "No se ha ingresado ninguna persona.");
				}
			}
		}
		else if(comando.equals("ACEPTAR ACTUALIZAR")) {
			vista.getPseleccion().setVisible(false);
			vista.getPseleccion().getBactualizar().setVisible(false);
			if(vista.getPseleccion().getCseleccion().getSelectedIndex()==0) {
				vista.getPdni().getEdni().setText("Ingrese DNI estudiante: ");
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==1) {
				vista.getPdni().getEdni().setText("Ingrese DNI profesor: ");
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==2) {
				vista.getPdni().getEdni().setText("Ingrese DNI personal servicio: ");
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==3) {
				vista.getPdni().getEdni().setText("Ingrese DNI empleado: ");
			}
			else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==4) {
				vista.getPdni().getEdni().setText("Ingrese DNI persona: ");
			}
			vista.getPdni().getBactualizar().setVisible(true);
			vista.getPdni().setVisible(true);
		}
		else if(comando.equals("ACTUALIZAR DATOS")) {
			String dato=vista.getPactualizar().getFactualizar().getText();
			boolean seguir=true;
			if(formatoValido(dato)||vista.getPseleccion().getCseleccion().getSelectedIndex()==4) {
				if(vista.getPseleccion().getCseleccion().getSelectedIndex()==0) {
					gestion.getLestudiantes().get(act_dni).matriculacionCurso(dato);
					vista.getPactualizar().getFactualizar().setVisible(false);
				}
				else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==1) {
					gestion.getLprofesores().get(act_dni).setDepartamento(dato);
					vista.getPactualizar().getFactualizar().setVisible(false);
				}
				else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==2) {
					gestion.getLpersonales_servicios().get(act_dni).setSeccion(dato);
					vista.getPactualizar().getFactualizar().setVisible(false);
				}
				else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==3) {
					try {
						gestion.getLempleados().get(act_dni).setNum_desp(Integer.parseInt(dato));
						if(gestion.getLprofesores().containsKey(act_dni)) {
							gestion.getLprofesores().get(act_dni).setNum_desp(Integer.parseInt(dato));
						}
						else if(gestion.getLpersonales_servicios().containsKey(act_dni)) {
							gestion.getLpersonales_servicios().get(act_dni).setNum_desp(Integer.parseInt(dato));
						}
						vista.getPactualizar().getFactualizar().setVisible(false);
					} catch (NumberFormatException x) {
						MensajesEmergentes.mensajeError(vista, "El formato de entrada no es valido");
						seguir=false;
					}
				}
				else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==4) {
					gestion.obtenerPersona(act_dni).setEst_civil((String)vista.getPactualizar().getCestadocivil().getSelectedItem());
					if(gestion.getLempleados().containsKey(act_dni)) {
						gestion.getLempleados().get(act_dni).setEst_civil((String)vista.getPactualizar().getCestadocivil().getSelectedItem());
					}
					if(gestion.getLpersonales_servicios().containsKey(act_dni)){
						gestion.getLempleados().get(act_dni).calcularSueldo();
						gestion.getLpersonales_servicios().get(act_dni).calcularSueldo();
					}
					vista.getPactualizar().getCestadocivil().setVisible(false);
				}
				if(seguir) {
					vista.getPactualizar().setVisible(false);
					vista.getPseleccion().getBactualizar().setVisible(false);
					vista.getPseleccion().getCseleccion().removeAllItems();
					vista.getPactualizar().getFactualizar().setText("");
					vista.getPmenu().setVisible(true);
				}
			}
			else {
				MensajesEmergentes.mensajeError(vista, "El formato introducido no es valido");
			}
		}
		else if(comando.equals("AGREGAR")) {
			try {
				String nombres=vista.getPdaralta().getFnombre().getText();
				String apellidos=vista.getPdaralta().getFapellidos().getText();
				long dni=Long.parseLong(vista.getPdaralta().getFnum_ide().getText());
				String est_civil=(String)vista.getPdaralta().getCestadocivil().getSelectedItem();
				String extra=vista.getPdaralta().getFextra().getText();
				if(!gestion.comprobarDNI(dni)&&formatoValido(nombres, apellidos, extra)) {
					if(vista.getPseleccion().getCseleccion().getSelectedIndex()==0) {
						Estudiante aux=new Estudiante(nombres, apellidos, dni, est_civil, extra);
						gestion.darAlta(aux);
					}
					else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==1) {
						int incorporacion=Integer.parseInt(vista.getPdaralta().getFano_incorp().getText());
						int despacho=Integer.parseInt(vista.getPdaralta().getFnum_desp().getText());
						Profesor aux=new Profesor(nombres, apellidos, dni, est_civil, incorporacion, despacho, extra);
						aux.calcularSueldo();
						gestion.darAlta(aux);
						vista.getPdaralta().getEano_incorp().setVisible(false);
						vista.getPdaralta().getEnum_desp().setVisible(false);
						vista.getPdaralta().getFano_incorp().setVisible(false);
						vista.getPdaralta().getFnum_desp().setVisible(false);
					}
					else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==2) {
						int incorporacion=Integer.parseInt(vista.getPdaralta().getFano_incorp().getText());
						int despacho=Integer.parseInt(vista.getPdaralta().getFnum_desp().getText());
						Personal_servicio aux=new Personal_servicio(nombres, apellidos, dni, est_civil, incorporacion, despacho, extra);
						aux.calcularSueldo();
						gestion.darAlta(aux);
						vista.getPdaralta().getEano_incorp().setVisible(false);
						vista.getPdaralta().getEnum_desp().setVisible(false);
						vista.getPdaralta().getFano_incorp().setVisible(false);
						vista.getPdaralta().getFnum_desp().setVisible(false);
					}
					vista.getPdaralta().setVisible(false);
					vista.getPdaralta().getFnombre().setText("");
					vista.getPdaralta().getFapellidos().setText("");
					vista.getPdaralta().getFnum_ide().setText("");
					vista.getPdaralta().getFano_incorp().setText("");
					vista.getPdaralta().getFnum_desp().setText("");
					vista.getPdaralta().getFextra().setText("");
					vista.getPseleccion().getCseleccion().removeAllItems();
					vista.getPmenu().setVisible(true);
				}else if(!formatoValido(nombres, apellidos, extra)){
					MensajesEmergentes.mensajeError(vista, "El formato de entrada no es valido");
				}
				else {
					MensajesEmergentes.mensajeError(vista, "El DNI ingresado ya existe, ingrese otro.");
				}
			} catch (NumberFormatException x) {
				MensajesEmergentes.mensajeError(vista, "El formato de entrada no es valido");
			}
		}
		else if(comando.equals("ELIMINAR")) {
			try {
				long dni=Long.parseLong(vista.getPdni().getFdni().getText());
				if(gestion.comprobarDNI(dni)) {
					int opcion=MensajesEmergentes.mensajeVerificar(vista, "Seguro que quiere eliminarlo por completo.");
					if(opcion==0) {
						vista.getPdni().setVisible(false);
						vista.getPdni().getBeliminar().setVisible(false);
						gestion.darBaja(dni);
						vista.getPdni().getFdni().setText("");
						vista.getPmenu().setVisible(true);
					}else if(opcion==2) {
						vista.getPdni().setVisible(false);
						vista.getPdni().getBeliminar().setVisible(false);
						vista.getPdni().getFdni().setText("");
						vista.getPmenu().setVisible(true);
					}
					
				}
				else {
					MensajesEmergentes.mensajeError(vista, "El DNI introducido no existe.");
					vista.getPdni().getFdni().setText("");
				}
			} catch (NumberFormatException x) {
				MensajesEmergentes.mensajeError(vista, "El DNI introducido no es valido");
			}
			
		}
		else if(comando.equals("OBTENER")) {
			try {
				long dni=Long.parseLong(vista.getPdni().getFdni().getText());
				if(gestion.comprobarDNI(dni)) {
					vista.getPdni().setVisible(false);
					vista.getPdni().getFdni().setText("");
					vista.getPdni().getBbuscar().setVisible(false);
					vista.getPdatos().getAresult().setText(gestion.obtenerPersona(dni).toString());
					vista.getPdatos().setVisible(true);
				}
				else {
					MensajesEmergentes.mensajeError(vista, "El DNI introducido no existe.");
					vista.getPdni().getFdni().setText("");
				}
			} catch (NumberFormatException x) {
				MensajesEmergentes.mensajeError(vista, "El DNI introducido no es valido");
			}
		}
		else if(comando.equals("ACTUALIZADO")) {
			try {
				long dni=Long.parseLong(vista.getPdni().getFdni().getText());
				if(vista.getPseleccion().getCseleccion().getSelectedIndex()==0) {
					if(gestion.getLestudiantes().containsKey(dni)) {
						act_dni=dni;
						vista.getPdni().setVisible(false);
						vista.getPdni().getBactualizar().setVisible(false);
						vista.getPdni().getFdni().setText("");
						vista.getPactualizar().getEactualizar().setText("Ingrese el curso a matricular: ");
						vista.getPactualizar().getFactualizar().setVisible(true);
						vista.getPactualizar().setVisible(true);
					}
					else {
						MensajesEmergentes.mensajeError(vista, "El DNI ingresado no corresponde a ningun estudiante.");
					}
				}
				else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==1) {
					if(gestion.getLprofesores().containsKey(dni)) {
						act_dni=dni;
						vista.getPdni().setVisible(false);
						vista.getPdni().getBactualizar().setVisible(false);
						vista.getPdni().getFdni().setText("");
						vista.getPactualizar().getEactualizar().setText("Ingrese el departamento: ");
						vista.getPactualizar().getFactualizar().setVisible(true);
						vista.getPactualizar().setVisible(true);
					}
					else {
						MensajesEmergentes.mensajeError(vista, "El DNI ingresado no corresponde a ningun profesor.");
					}
				}
				else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==2) {
					if(gestion.getLpersonales_servicios().containsKey(dni)) {
						act_dni=dni;
						vista.getPdni().setVisible(false);
						vista.getPdni().getBactualizar().setVisible(false);
						vista.getPdni().getFdni().setText("");
						vista.getPactualizar().getEactualizar().setText("Ingrese la seccion: ");
						vista.getPactualizar().getFactualizar().setVisible(true);
						vista.getPactualizar().setVisible(true);
					}
					else {
						MensajesEmergentes.mensajeError(vista, "El DNI ingresado no corresponde a ningun personal de servicio.");
					}
				}
				if(vista.getPseleccion().getCseleccion().getSelectedIndex()==3) {
					if(gestion.getLempleados().containsKey(dni)) {
						act_dni=dni;
						vista.getPdni().setVisible(false);
						vista.getPdni().getBactualizar().setVisible(false);
						vista.getPdni().getFdni().setText("");
						vista.getPactualizar().getEactualizar().setText("Ingrese el numero de despacho: ");
						vista.getPactualizar().getFactualizar().setVisible(true);
						vista.getPactualizar().setVisible(true);
					}
					else {
						MensajesEmergentes.mensajeError(vista, "El DNI ingresado no corresponde a ningun empleado.");
					}
				}
				else if(vista.getPseleccion().getCseleccion().getSelectedIndex()==4) {
					if(gestion.comprobarDNI(dni)) {
						act_dni=dni;
						vista.getPdni().setVisible(false);
						vista.getPdni().getBactualizar().setVisible(false);
						vista.getPdni().getFdni().setText("");
						vista.getPactualizar().getEactualizar().setText("Seleccione el estado civil: ");
						vista.getPactualizar().getCestadocivil().setVisible(true);
						vista.getPactualizar().setVisible(true);
					}
					else {
						MensajesEmergentes.mensajeError(vista, "El DNI ingresado no existe.");
					}
				}
			} catch (NumberFormatException x) {
				MensajesEmergentes.mensajeError(vista, "El DNI introducido no es valido");
			}
		}
		else if(comando.equals("ATRAS SELECCION")) {
			vista.getPseleccion().setVisible(false);
			vista.getPseleccion().getBdaralta().setVisible(false);
			vista.getPseleccion().getBlista().setVisible(false);
			vista.getPseleccion().getBactualizar().setVisible(false);
			vista.getPseleccion().getCseleccion().removeAllItems();
			vista.getPmenu().setVisible(true);
		}
		else if(comando.equals("ATRAS DNI")) {
			vista.getPdni().setVisible(false);
			vista.getPdni().getFdni().setText("");
			vista.getPdni().getBbuscar().setVisible(false);
			vista.getPdni().getBeliminar().setVisible(false);
			vista.getPdni().getBactualizar().setVisible(false);
			vista.getPseleccion().getCseleccion().removeAllItems();
			vista.getPmenu().setVisible(true);
		}
		else if(comando.equals("ATRAS DAR ALTA")) {
			vista.getPdaralta().setVisible(false);
			vista.getPdaralta().getFnombre().setText("");
			vista.getPdaralta().getFapellidos().setText("");
			vista.getPdaralta().getFnum_ide().setText("");
			vista.getPdaralta().getFano_incorp().setText("");
			vista.getPdaralta().getFnum_desp().setText("");
			vista.getPdaralta().getFextra().setText("");
			vista.getPseleccion().getCseleccion().removeAllItems();
			vista.getPdaralta().getFnum_desp().setVisible(false);
			vista.getPdaralta().getEnum_desp().setVisible(false);
			vista.getPdaralta().getFano_incorp().setVisible(false);
			vista.getPdaralta().getEano_incorp().setVisible(false);
			vista.getPmenu().setVisible(true);
		}
		else if(comando.equals("ATRAS LISTA")) {
			vista.getPlista().setVisible(false);
			vista.getPseleccion().getBlista().setVisible(false);
			vista.getPlista().removerLista();
			vista.getPseleccion().getCseleccion().removeAllItems();
			vista.getPmenu().setVisible(true);
		}
		else if(comando.equals("ATRAS BUSQUEDA")) {
			vista.getPdatos().setVisible(false);
			vista.getPdatos().getAresult().setText("");
			vista.getPmenu().setVisible(true);
		}
		else if(comando.equals("ATRAS ACTUALIZAR")) {
			vista.getPactualizar().setVisible(false);
			vista.getPactualizar().getFactualizar().setText("");
			vista.getPseleccion().getCseleccion().removeAllItems();
			vista.getPactualizar().getFactualizar().setVisible(false);
			vista.getPactualizar().setVisible(false);
			vista.getPmenu().setVisible(true);
		}
		
		
	}
	
	public boolean formatoValido(String nombre,String apellido,String extra) {
		String[] entradas={nombre,apellido,extra};
		int cont=0;
		for(int i=0;i<entradas.length;i++) {
			for(int j=0;j<entradas[i].length();i++) {
				if(entradas[i].charAt(j)!=' ') {
					cont++;
					break;
				}
			}
		}
		if(cont==entradas.length) {
			return true;
		}
		return false;
	}
	
	public boolean formatoValido(String curso) {
		for(int i=0;i<curso.length();i++) {
			if(curso.charAt(i)!=' ') {
				return true;
			}
		}
		return false;
	}

}
