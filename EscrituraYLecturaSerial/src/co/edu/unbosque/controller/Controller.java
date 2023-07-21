package co.edu.unbosque.controller;

import co.edu.unbosque.model.VideoJuegoDAO;
import co.edu.unbosque.model.VideoJuegoDTO;
import co.edu.unbosque.view.Consola;

public class Controller {

	private VideoJuegoDAO vj;
	private Consola con;

	public Controller() {

		vj = new VideoJuegoDAO();
		con = new Consola();

		ejecutar();
	}

	public void ejecutar() {

		while (true) {

			con.imprimirConSalto(
					"\n**Cordial saludo, por favor indique que desea hacer, gracias te amo, eres muy importante para mi:3** \n\n 1. Agregar \n 2. Eliminar \n 3. Actualizar \n 4. Mostrar");
			int caso = con.leerEntero();
			con.quemarLinea();

			switch (caso) {
			case 1: {

				con.imprimirConSalto("Ingrese el nombre del videojuego");
				String nombre = con.leerLineaEntera();
				con.imprimirConSalto("Ingrese la consola en la que juega el videojuego");
				String consola = con.leerLineaEntera();
				con.imprimirConSalto("Ingrese el rating del videojuego");
				String rating = con.leerLineaEntera();
				con.imprimirConSalto("El videojuego tiene multijugador?");
				String multi = con.leerLineaEntera();

				boolean multi2;

				if (multi.equalsIgnoreCase("si")) {
					multi2 = true;
				} else {

					multi2 = false;

				}

				vj.crear(new VideoJuegoDTO(nombre, consola, rating, multi2));

				break;
			}
			case 2: {

				con.imprimirConSalto("Por favor, ingrese la posición que desea eliminar");

				int index = con.leerEntero();

				vj.eliminar(index);

				break;

			}
			case 3: {

				break;
			}
			case 4: {

				con.imprimirConSalto(vj.mostrar());

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + caso);
			}
		}

	}

}
