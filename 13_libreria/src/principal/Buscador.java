package principal;

import java.util.Scanner;

public class Buscador {

	public static void main(String[] args) {
		StringBuilder titulos= new StringBuilder("");
		Scanner sc;
		sc = new Scanner(System.in);
		boolean salir = false;
		int opcion;

		while(!salir) {	
			menu();
			opcion = sc.nextInt();
			switch (opcion) {
				case 1:
					insertarLibro(titulos);
					System.out.println(titulos);
					break;
				case 2:
					consultarLibro(titulos);
					System.out.println(titulos);
					break;
				case 3:
					//borrarLibro(titulos);
					System.out.println(titulos);
					break;
				case 4:
					salir=true;
					System.out.println("Salimos de la aplicacion");
					System.out.println(titulos);
					break;
			}
		}
		//sc.close();
	}
	
	static void menu() {
	
		System.out.println("1 - Añadir libro");
		System.out.println("2 - Consultar libro");
		System.out.println("3 - Borrar libro");
		System.out.println("4 - Salir");
		System.out.println("Elige la opcion: ");
		
	}
	
	static void insertarLibro(StringBuilder titulos) {
		Scanner sc2;
		sc2 = new Scanner(System.in);
		System.out.println("Introduce un nuevo libro ");
		titulos.append(sc2.nextLine());
		titulos.append(";");
		}
	
	static void consultarLibro(StringBuilder titulos) {
		Scanner sc2;
		sc2 = new Scanner(System.in);
		System.out.println("Buscar libro ");
        String textoBuscado = sc2.nextLine().toLowerCase();
        String nuevosTitulos = titulos.toString();
        String [] libros = nuevosTitulos.toLowerCase().split(";");
		for (int i=0;i<libros.length;i++) { 
			if (libros[i].contains(textoBuscado)) {
				System.out.println(libros[i]);
			}
		}
	}
	
	//eliminatr titulo
	String=titulo
	scanner
	titulo=sc.scanner+";"
	int posini;		
	posini=titulos.indexOf(titulo)//buscamos posicion inical del borrado
	if(posini != -1) {
	titulos.delete(posini,posini+titluo.length()+1); //borra por titulo completo
	else {
		no existe
		}
	}
	}
}
