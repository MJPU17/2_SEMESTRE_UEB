package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import co.edu.unbosque.model.VehicleDAO;
import co.edu.unbosque.model.VehicleDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PopUpMessages;

public class Controller implements ActionListener,MenuListener,DocumentListener{
	
	private MainWindow view;
	private VehicleDAO vehicles;
	
	public Controller() {
		view=new MainWindow();
		vehicles=new VehicleDAO(); 
		assignListeners();
	}
	
	public void assignListeners() {
		view.getPmenu().getMcreate().addMenuListener(this);
		view.getPmenu().getMupdate().addMenuListener(this);
		view.getPmenu().getMremove().addMenuListener(this);
		view.getPmenu().getMlist().addMenuListener(this);
		view.getPdata().getBsave().addActionListener(this);
		view.getPdata().getBupdate().addActionListener(this);
		view.getPdata().getBclear().addActionListener(this);
		view.getPlist().getTflist().getDocument().addDocumentListener(this);
		view.getPlist().getBremove().addActionListener(this);
		view.getPlist().getBshow().addActionListener(this);
		view.getPmenu().getMienglish().addActionListener(this);
		view.getPmenu().getMifrench().addActionListener(this);
		view.getPmenu().getMigerman().addActionListener(this);
		view.getPmenu().getMirussian().addActionListener(this);
		view.getPmenu().getMispanish().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		
		switch (comando) {
		case "SAVE":{
			String plaque=view.getPdata().getTfplaque().getText();
			String brand=view.getPdata().getTfbrand().getText();
			String model=view.getPdata().getTfmodel().getText();
			String color=view.getPdata().getTfcolor().getText();
			boolean one=PopUpMessages.errorPlaque(view, plaque, view.getProperties()),two=PopUpMessages.errorBrand(view, brand, view.getProperties()),three=PopUpMessages.errorModel(view, model, view.getProperties()),four=PopUpMessages.errorColor(view, color, view.getProperties());
			if(!one&&!two&&!three&&!four) {
				vehicles.create(new VehicleDTO(plaque, brand, model, color));
			}
			break;
		}
		case "UPDATE":{
			String aplaque=(String)view.getPdata().getCbchoose().getSelectedItem();
			if(!aplaque.equals(view.getProperties().getProperty("translator.paneldata.cbchoose"))) {
				String nplaque=view.getPdata().getTfplaque().getText();
				String brand=view.getPdata().getTfbrand().getText();
				String model=view.getPdata().getTfmodel().getText();
				String color=view.getPdata().getTfcolor().getText();
				boolean one=PopUpMessages.errorPlaque(view, nplaque, view.getProperties()),two=PopUpMessages.errorBrand(view, brand, view.getProperties()),three=PopUpMessages.errorModel(view, model, view.getProperties()),four=PopUpMessages.errorColor(view, color, view.getProperties());
				if(!one&&!two&&!three&&!four) {
					vehicles.update(aplaque, nplaque, new VehicleDTO(nplaque, brand, model, color));
					view.getPdata().getCbchoose().removeAllItems();
					view.getPdata().addItems(vehicles.getLvehicles(),view.getProperties());
				}
				
			}
			else {
				PopUpMessages.errorMessage(view, view.getProperties().getProperty("translator.updateerror"));
			}
			break;
		}
		case "CLEAR":{
			view.getPdata().getTfplaque().setText("");
			view.getPdata().getTfbrand().setText("");
			view.getPdata().getTfcolor().setText("");
			view.getPdata().getTfmodel().setText("");
			break;
		}
		case "ELIMINATE":{
			int i=view.getPlist().getTlist().getSelectedRow();
			if(i>=0) {
				int opcion=PopUpMessages.confirmMessage(view.getProperties().getProperty("translator.messageconfirm"), view);
				if(opcion==0) {
					vehicles.remove((String)view.getPlist().getTlist().getModel().getValueAt(i, 0));;
				}
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
			}
			else {
				PopUpMessages.errorMessage(view, view.getProperties().getProperty("translator.selecterror"));
			}
			break;
		}
		case "SHOW":{
			int i=view.getPlist().getTlist().getSelectedRow();
			if(i>=0) {
				VehicleDTO vehicle=vehicles.getLvehicles().get((String)view.getPlist().getTlist().getModel().getValueAt(i, 0));
				view.getPlist().setVisible(false);
				view.getPshow().generateImge();
				view.getPshow().getCplaque().setText(vehicle.getPlaque());
				view.getPshow().getCbrand().setText(vehicle.getBrand());
				view.getPshow().getCmodel().setText(vehicle.getModel());
				view.getPshow().getCcolor().setText(vehicle.getColor());
				view.getPshow().setVisible(true);
			}
			else {
				PopUpMessages.errorMessage(view, view.getProperties().getProperty("translator.selecterror"));
			}
			break;
		}
		}
		
		if(e.getSource()==view.getPmenu().getMienglish()) {
			view.changeLanguage(FileHandler.cargarPropiedades("english.properties"));
			FileHandler.escribirArchivo("language.init", "english");
			if(view.getPdata().getBupdate().isVisible()) {
				view.getPdata().getCbchoose().removeAllItems();
				view.getPdata().addItems(vehicles.getLvehicles(),view.getProperties());
			}
			else if(view.getPlist().getBshow().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.show"));
			}
			else if(view.getPlist().getBremove().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.remove"));
			}
		}
		else if(e.getSource()==view.getPmenu().getMifrench()) {
			view.changeLanguage(FileHandler.cargarPropiedades("french.properties"));
			FileHandler.escribirArchivo("language.init", "french");
			if(view.getPdata().getBupdate().isVisible()) {
				view.getPdata().getCbchoose().removeAllItems();
				view.getPdata().addItems(vehicles.getLvehicles(),view.getProperties());
			}
			else if(view.getPlist().getBshow().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.show"));
			}
			else if(view.getPlist().getBremove().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.remove"));
			}
		}
		else if(e.getSource()==view.getPmenu().getMigerman()) {
			view.changeLanguage(FileHandler.cargarPropiedades("german.properties"));
			FileHandler.escribirArchivo("language.init", "german");
			if(view.getPdata().getBupdate().isVisible()) {
				view.getPdata().getCbchoose().removeAllItems();
				view.getPdata().addItems(vehicles.getLvehicles(),view.getProperties());
			}
			else if(view.getPlist().getBshow().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.show"));
			}
			else if(view.getPlist().getBremove().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.remove"));
			}
		}
		else if(e.getSource()==view.getPmenu().getMirussian()) {
			view.changeLanguage(FileHandler.cargarPropiedades("russian.properties"));
			FileHandler.escribirArchivo("language.init", "russian");
			if(view.getPdata().getBupdate().isVisible()) {
				view.getPdata().getCbchoose().removeAllItems();
				view.getPdata().addItems(vehicles.getLvehicles(),view.getProperties());
			}
			else if(view.getPlist().getBshow().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.show"));
			}
			else if(view.getPlist().getBremove().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.remove"));
			}
		}
		else if(e.getSource()==view.getPmenu().getMispanish()) {
			view.changeLanguage(FileHandler.cargarPropiedades("spanish.properties"));
			FileHandler.escribirArchivo("language.init", "spanish");
			if(view.getPdata().getBupdate().isVisible()) {
				view.getPdata().getCbchoose().removeAllItems();
				view.getPdata().addItems(vehicles.getLvehicles(),view.getProperties());
			}
			else if(view.getPlist().getBshow().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.show"));
			}
			else if(view.getPlist().getBremove().isVisible()) {
				view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
				view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.remove"));
			}
		}
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		if(e.getSource()==view.getPmenu().getMcreate()) {
			view.visiblePanel().setVisible(false);
			view.getPdata().getBsave().setVisible(true);
			view.getPdata().setVisible(true);
		}
		else if(e.getSource()==view.getPmenu().getMupdate()) {
			view.visiblePanel().setVisible(false);
			view.getPdata().addItems(vehicles.getLvehicles(),view.getProperties());
			view.getPdata().getEchoose().setVisible(true);
			view.getPdata().getCbchoose().setVisible(true);
			view.getPdata().getBupdate().setVisible(true);
			view.getPdata().setVisible(true);
		}
		else if(e.getSource()==view.getPmenu().getMremove()) {
			view.visiblePanel().setVisible(false);
			view.getPlist().getTflist().setText("");
			view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
			view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.remove"));
			view.getPlist().getBremove().setVisible(true);
			view.getPlist().setVisible(true);
		}
		else if(e.getSource()==view.getPmenu().getMlist()) {
			view.visiblePanel().setVisible(false);
			view.getPlist().getTflist().setText("");
			view.getPlist().addValues(vehicles.getLvehicles(),view.getProperties());
			view.getPlist().getElist().setText(view.getProperties().getProperty("translator.panellist.elist.show"));
			view.getPlist().getBshow().setVisible(true);
			view.getPlist().setVisible(true);
		}
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {}

	@Override
	public void menuCanceled(MenuEvent e) {}

	@Override
	public void insertUpdate(DocumentEvent e) {
		String filter=view.getPlist().getTflist().getText();
		view.getPlist().filterShow(vehicles.getLvehicles(), filter,view.getProperties());
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		String filter=view.getPlist().getTflist().getText();
		view.getPlist().filterShow(vehicles.getLvehicles(), filter,view.getProperties());
	}

	@Override
	public void changedUpdate(DocumentEvent e) {}
	
}
