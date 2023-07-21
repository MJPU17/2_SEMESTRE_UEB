package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import co.edu.unbosque.model.Product;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PopUpMessages;

public class Controller implements ActionListener{
	
	private MainWindow view;
	private LinkedList<Product> products;
	private int excep,pos;
	
	public Controller() {
		products=new LinkedList<>();
		view=new MainWindow();
		excep=0;
		pos=0;
		asignarOyentes();
	}

	private void asignarOyentes() {
		
		view.getPmenu().getBsave().addActionListener(this);
		view.getPmenu().getBconsult().addActionListener(this);
		view.getPmenu().getBedit().addActionListener(this);
		view.getPmenu().getBerase().addActionListener(this);
		view.getPdata().getBsave().addActionListener(this);
		view.getPdata().getBedit().addActionListener(this);
		view.getPdata().getBback().addActionListener(this);
		view.getPselect().getBconsult().addActionListener(this);
		view.getPselect().getBedit().addActionListener(this);
		view.getPselect().getBback().addActionListener(this);
		view.getPselect().getBeliminated().addActionListener(this);
		view.getPlist().getBback().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comand=e.getActionCommand(),name="",brand="",distribution="";
		Product aux=new Product();
		String[] columns= {"Id","Name","Brand","Price","Distribution","Quantity"};
		double price=0.0;
		int id=0,quantity=0;
		long timebefore,timeafter;
		
		if(comand.equals("SAVE")) {
			view.getPmenu().setVisible(false);
			view.getPdata().getLid().setText("Insert id:");
			view.getPdata().getLname().setText("Insert name:");
			view.getPdata().getLbrand().setText("Insert brand:");
			view.getPdata().getLprice().setText("Insert price:");
			view.getPdata().getLdistribution().setText("Insert distribution");
			view.getPdata().getLquantity().setText("Insert quantity:");
			view.getPdata().getBsave().setVisible(true);
			view.getPdata().setVisible(true);
			
		}
		else if(comand.equals("CONSULT")) {
			view.getPmenu().setVisible(false);
			if(products.size()>0) {
				view.getPlist().getLadvice().setVisible(false);
				view.getPlist().createList(dataProducts(products), columns);
			}
			view.getPlist().setVisible(true);
			
		}
		else if(comand.equals("EDIT")) {
			view.getPmenu().setVisible(false);
			view.getPselect().getBedit().setVisible(true);
			view.getPselect().getLselect().setText("Select the name of the product you want edit.");
			startingOptionList();
			view.getPselect().setVisible(true);
			
		}
		else if(comand.equals("ERASE")) {
			view.getPmenu().setVisible(false);
			view.getPselect().getBeliminated().setVisible(true);
			view.getPselect().getLselect().setText("Select the name of the product you want to delete.");
			startingOptionList();
			view.getPselect().setVisible(true);
			
		}
		else if(comand.equals("SAVE PRODUCT")){
			try {
				id=Integer.parseInt(view.getPdata().getFid().getText());
				name=view.getPdata().getFname().getText();
				brand=view.getPdata().getFbrand().getText();
				distribution=view.getPdata().getFdistribution().getText();
				price=Double.parseDouble(view.getPdata().getFprice().getText());
				quantity=Integer.parseInt(view.getPdata().getFquantity().getText());
				if (noRepeat(products, id, name)&&validFormat(id, name, brand, pos, distribution, quantity)) {
					aux=new Product(id,name, brand, price, distribution, quantity);
					System.out.println(aux.hashCode());
					products.add(aux);
					view.getPdata().setVisible(false);
					view.getPdata().getBsave().setVisible(false);
					view.getPmenu().setVisible(true);
					view.getPdata().getFid().setText("");
					view.getPdata().getFname().setText("");
					view.getPdata().getFbrand().setText("");
					view.getPdata().getFprice().setText("");
					view.getPdata().getFdistribution().setText("");
					view.getPdata().getFquantity().setText("");
					products=updateProducts(products);
					
				}
				else if(!validFormat(id, name, brand, pos, distribution, quantity)) {
					PopUpMessages.errorMessage(view, "The input format is invalid.");
				}
				else {
					PopUpMessages.errorMessage(view, "The element you want to save already exist, change id or name.");
				}
			}
			catch (NumberFormatException e1) {
				PopUpMessages.errorMessage(view, "The input format is invalid.");
			}
		}
		else if(comand.equals("EDIT PRODUCT")) {
			pos=view.getPselect().getCproducts().getSelectedIndex()-1;
			if(pos>=0) {
				view.getPselect().setVisible(false);
				aux=products.get(pos);
				excep=pos;
				view.getPdata().getLid().setText("Edit id:");
				view.getPdata().getLname().setText("Edit name:");
				view.getPdata().getLbrand().setText("Edit brand:");
				view.getPdata().getLprice().setText("Edit price:");
				view.getPdata().getLdistribution().setText("Edit distribution");
				view.getPdata().getLquantity().setText("Edit quantity:");
				view.getPdata().getFid().setText(""+aux.getId());
				view.getPdata().getFname().setText(aux.getName());
				view.getPdata().getFbrand().setText(""+aux.getBrand());
				view.getPdata().getFprice().setText(""+aux.getPrice());
				view.getPdata().getFdistribution().setText(aux.getDistribution());
				view.getPdata().getFquantity().setText(""+aux.getQuantity());
				view.getPselect().getBedit().setVisible(false);
				view.getPdata().getBedit().setVisible(true);
				view.getPdata().setVisible(true);
			}
			else {
				PopUpMessages.errorMessage(view, "Select a option.");
			}
		}
		else if(comand.equals("CHANGE")) {
			try {
				id=Integer.parseInt(view.getPdata().getFid().getText());
				name=view.getPdata().getFname().getText();
				brand=view.getPdata().getFbrand().getText();
				price=Double.parseDouble(view.getPdata().getFprice().getText());
				distribution=view.getPdata().getFdistribution().getText();
				quantity=Integer.parseInt(view.getPdata().getFquantity().getText());
				if(noRepeat(products, id, name,excep)&&validFormat(id, name, brand, pos, distribution, quantity)) {
					products.get(pos).setId(id);
					products.get(pos).setName(name);
					products.get(pos).setBrand(brand);
					products.get(pos).setPrice(price);
					products.get(pos).setDistribution(distribution);
					products.get(pos).setQuantity(quantity);
					view.getPdata().setVisible(false);
					view.getPdata().getBedit().setVisible(false);
					view.getPmenu().setVisible(true);
					view.getPdata().getFid().setText("");
					view.getPdata().getFname().setText("");
					view.getPdata().getFbrand().setText("");
					view.getPdata().getFprice().setText("");
					view.getPdata().getFdistribution().setText("");
					view.getPdata().getFquantity().setText("");
					products=updateProducts(products);
				}
				else if(!validFormat(id, name, brand, pos, distribution, quantity)) {
					PopUpMessages.errorMessage(view, "The input format is invalid.");
				}
				else {
					PopUpMessages.errorMessage(view, "The name or id already exist, change id or name.");
				}
			}
			catch (NumberFormatException e1) {
				PopUpMessages.errorMessage(view, "The input format is invalid.");
			}
		}else if(comand.equals("ELIMINATE")) {
			pos=view.getPselect().getCproducts().getSelectedIndex();
			if(pos!=0) {
				pos=PopUpMessages.confirmMessage(view, "Are you sure to remove this product.");
				if(pos==0) {
					pos=view.getPselect().getCproducts().getSelectedIndex()-1;
					products.remove(pos);
					view.getPselect().setVisible(false);
					view.getPselect().getBeliminated().setVisible(false);
					view.getPmenu().setVisible(true);
				}else if(pos==2) {
					view.getPselect().setVisible(false);
					view.getPselect().getBeliminated().setVisible(false);
					view.getPmenu().setVisible(true);
				}
			}else {
				PopUpMessages.errorMessage(view, "Select a option.");
			}
		}else if(comand.equals("BACK")) {
			if(view.getPdata().isVisible()) {
				view.getPdata().setVisible(false);
				view.getPdata().getBsave().setVisible(false);
				view.getPdata().getBedit().setVisible(false);
				view.getPdata().getFid().setText("");
				view.getPdata().getFname().setText("");
				view.getPdata().getFbrand().setText("");
				view.getPdata().getFprice().setText("");
				view.getPdata().getFdistribution().setText("");
				view.getPdata().getFquantity().setText("");
				view.getPmenu().setVisible(true);
			}else if(view.getPselect().isVisible()) {
				view.getPselect().setVisible(false);
				view.getPselect().getCproducts().removeAllItems();
				view.getPselect().getBedit().setVisible(false);
				view.getPselect().getBeliminated().setVisible(false);
				view.getPmenu().setVisible(true);
			}else if(view.getPlist().isVisible()) {
				view.getPlist().setVisible(false);
				if(view.getPlist().getSproducts()!=null) {
					view.getPlist().remove(view.getPlist().getSproducts());
					view.getPlist().getLadvice().setVisible(true);
				}
			    view.getPlist().getLadvice().setVisible(true);
			    view.getPmenu().setVisible(true);
			}
			
		}
		
		
		
	}
	
	public void startingOptionList() {
		
		String product="";
		
		view.getPselect().getCproducts().removeAllItems();
		view.getPselect().getCproducts().addItem("Select product");
		for(int i=0;i<products.size();i++) {
			product=products.get(i).getName();
			view.getPselect().getCproducts().addItem(product);
		}
	}
	
	public String[][] dataProducts(LinkedList<Product> products) {
		String[][] list=new String[products.size()][6];
		Product aux1;
		for(int y=0;y<products.size();y++) {
			aux1=products.get(y);
			for(int x=0;x<6;x++) {
				if(x==0) {
					list[y][x]=""+aux1.getId();
				}else if(x==1) {
					list[y][x]=aux1.getName();
				}else if(x==2) {
					list[y][x]=aux1.getBrand();
				}else if (x==3) {
					list[y][x]=""+aux1.getPrice();
				}else if (x==4) {
					list[y][x]=aux1.getDistribution();
				}else if (x==5) {
					list[y][x]=""+aux1.getQuantity();
				}
			}
		}
		return list;
	}
	
	public boolean noRepeat(LinkedList<Product> products,int id,String name) {
		String aux1;
		Integer aux2;
		for(int i=0;i<products.size();i++) {
			aux1=products.get(i).getName();
			aux2=products.get(i).getId();
			if(id==aux2||name==aux1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean noRepeat(LinkedList<Product> products,int id,String name,int excep) {
		String aux1;
		int aux2;
		for(int i=0;i<products.size();i++) {
			aux1=products.get(i).getName();
			aux2=products.get(i).getId();
			if((id==aux2||name.equals(aux1))&&i!=excep) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validFormat(int id,String name,String brand,int price,String distribution,int quantity) {
		int cont=0;
		if(id<0||name.equals("")||brand.equals("")||price<0||distribution.equals("")||quantity<0) {
			return false;
		}else {
			for(int i=0;i<name.length();i++) {
				if(name.charAt(i)!=' ') {
					cont++;
					break;
				}
			}
			if(cont==0) {
				return false;
			}
			for(int i=0;i<brand.length();i++) {
				if(brand.charAt(i)!=' ') {
					cont++;
					break;
				}
			}
			if(cont==1) {
				return false;
			}
			for(int i=0;i<distribution.length();i++) {
				if(distribution.charAt(i)!=' ') {
					cont++;
					break;
				}
			}
			if(cont==2) {
				return false;
			}
		}
		return true;
	}
	
	public LinkedList<Product> updateProducts(LinkedList<Product> products) {
		LinkedList<Product> orgproducts=new LinkedList<>();
		int pos=0,aux=0,size=products.size();
		long timebefore=System.currentTimeMillis();
		for(int y=0;y<size;y++) {
			aux=products.get(0).getId();
			pos=0;
			for(int x=0;x<products.size();x++) {
				if(aux>products.get(x).getId()) {
					aux=products.get(x).getId();
					pos=x;
				}
			}
			orgproducts.add(y, products.get(pos));
			products.remove(pos);
		}
		long timeafter=System.currentTimeMillis();
		System.out.println((timeafter-timebefore)+"ms");
		return orgproducts;
	}

}
