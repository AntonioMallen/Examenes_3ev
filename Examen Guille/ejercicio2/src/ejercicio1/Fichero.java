package ejercicio1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Fichero {
	/**
	 * Clase para gestionar los archivos de datos
	 * Tendremos un archivo 
	 */
	ObjectOutputStream ficheroEscribir = null;
	ObjectInputStream ficheroLeer = null;
	
	
	Fichero(String fichero){
		try {
			ficheroEscribir= new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroLeer= new ObjectInputStream(new FileInputStream(fichero));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribirContactos(Agenda a) {
		try {
			ficheroEscribir.writeObject(a.getContactos());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void escribirTmp(Agenda a) {
		try {
			ObjectOutputStream tmpEscribir = null;
			tmpEscribir= new ObjectOutputStream(new FileOutputStream("tmp.dat"));
			tmpEscribir.writeObject(a.getContactos());
			tmpEscribir.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Contacto> leerTmp() {
		try {
			ObjectInputStream tmpLeer= new ObjectInputStream(new FileInputStream("tmp.dat"));
		
			ArrayList<Contacto> contactos = null;
			
			contactos=(ArrayList<Contacto>) tmpLeer.readObject();
			
			tmpLeer.close();
			return contactos;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Contacto> leerContactos (){
		try {
			ArrayList<Contacto> contactos= (ArrayList<Contacto>) ficheroLeer.readObject();
			return contactos;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void closeUp() {
			try {
				ficheroEscribir.close();
				ficheroLeer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

