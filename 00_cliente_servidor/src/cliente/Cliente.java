package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		try (Socket sc=new Socket("localhost",8000);) {
			//envio de datos:
			PrintStream enviardatos = new PrintStream(sc.getOutputStream());
			
			//recepcion de datos:
            BufferedReader recibirdatos = new BufferedReader(new InputStreamReader(sc.getInputStream()));

            //solicitamos datos por el teclado:
            System.out.println("Hola soy el cliente y me llamo: ");
            InputStreamReader isr =new InputStreamReader(System.in);
            BufferedReader teclado=null;
            teclado=new BufferedReader(isr);
			String nombre=teclado.readLine();
			
			//enviamos los datos por el socket:
            enviardatos.println(nombre);
            //recibimos los datos por el socket:
            System.out.println("Recibido: " + recibirdatos.readLine());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
