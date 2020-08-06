package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(8000);) {
			System.out.println("Esperando llamadas ....");
			Socket sc =server.accept();
			System.out.println("Conexion establecida");
			//envio de datos
			PrintStream enviardatos = new PrintStream(sc.getOutputStream());
			
			//recepcion de datos:
            BufferedReader recibirdatos = new BufferedReader(new InputStreamReader(sc.getInputStream()));

            String linearecibida = recibirdatos.readLine();
            System.out.println("Recibido: " + linearecibida);
            String lineaenviada = linearecibida.toUpperCase();
            System.out.println("Enviado desde el servidor: " + lineaenviada);
            enviardatos.println(lineaenviada);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
