package principal;

import java.util.Scanner;

import model.Ciudad;
import service.TemperaturasService;

public class menu_Temperaturas {

	public static void main(String[] args) {
		TemperaturasService service=new TemperaturasService();
		Scanner sc;
		sc = new Scanner(System.in);
		boolean salir = false;
		int opcion; 

		while(!salir) {	
			menu();
			opcion = sc.nextInt();
			switch (opcion) {
				case 1:
					altaTemperatura(service);
					break;
				case 2:
					System.out.println("Temperatura media: "+service.media());
					break;
				case 3:
					System.out.println("ciudad con temperatura más alta: "+service.mayor().getNombre());
	                System.out.println("ciudad con temperatura más baja: "+service.menor().getNombre());
					break;
				case 4:
					mostrarTemperaturas(service);
					break;
				case 5:
					salir=true;
					System.out.println("Salimos de la aplicacion");
					break;
				default:
					System.out.println("La opcion elegida no es valida. Seleccionala de nuevo.");
					break;
			}
		}
		//sc.close();
	}
	
	static void menu() {
	
		System.out.println("1 - Alta temperatura");
		System.out.println("2 - Temperatura media");
		System.out.println("3 - Temperaturas extremas");
		System.out.println("4 - Mostrar todas");
		System.out.println("5 - Salir");
		System.out.println("Elige la opcion: ");
		
	}
	
	static void altaTemperatura(TemperaturasService service) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ciudad: ");
		String nombreCiudad=sc.nextLine();
		System.out.println("Introduce una temperatura: ");
		double temp=Double.parseDouble(sc.nextLine());
		Ciudad ciudad=new Ciudad(nombreCiudad,temp);
		if(service.agregarCiudad(ciudad)) {
			System.out.println("Ciudad añadida");
		}else {
			System.out.println("Ciudad repetida, prueba otra opción");
		}
	}
	
	static void mostrarTemperaturas(TemperaturasService service) {
		Ciudad[] ciudades=service.devolverCiudades();
		for(Ciudad ciudad:ciudades) {
			System.out.println(ciudad.getNombre()+"-"+ciudad.getTemperatura());
		}
	}

}
