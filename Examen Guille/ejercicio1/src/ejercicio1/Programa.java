package ejercicio1;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class Programa {
	

	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * Primero el programa comprueba si el archivo temporal tiene algo dentro
		 * si no lo tiene, la agenda empezara vacia y si lo tiene, empezara con lo que haya en tmp.dat
		 * La primera vez que se ejecute lanzara una exception FileNotFound ya que aun no existira el archivo tmp.dat ya que
		 * se escribe en el al finalziar el programa para guardar los datos que hayan sido introducidos
		 */
		
		ArrayList<Contacto> temporal=null;
		try {
			temporal=Fichero.leerTmp();
			}
			catch (Exception exception) {
			// TODO Auto-generated catch block
			System.out.println("no se ha leido nada, aun no existe");
			}

		//creamos una agenda temporal para leer los datos que ya hubiese de anteriores ejecuciones
		Agenda agendatmp;
		Scanner teclado= new Scanner(System.in);
		Fichero fichero= new Fichero("agenda.dat");
		if(temporal==null) {
			ArrayList<Contacto> contactos= new ArrayList<Contacto>();
			agendatmp= new Agenda(contactos);
		}
		else {
			agendatmp= new Agenda(temporal);
		}

		//pasamos los datos de tmp a agenda.dat
		fichero.escribirContactos(agendatmp);
		
		//asignamos el valor que hubiese en agenda.dat a la agenda que usamos
		Agenda agenda= new Agenda(fichero.leerContactos());
		
		//bucle con centinela para acabar el programa con el 0
		boolean trabajando=true;
		while(trabajando) {
			
			System.out.println("Introduzca una opcion: ");
			System.out.println("1-Añadir un contacto a la agenda");
			System.out.println("2-Borrar un contacto de la agenda");
			System.out.println("3-Imprimir contactos en orden alfabetico");
			System.out.println("4-Buscar contacto por un nombre");
			System.out.println("5-Añadir un telefono a un contacto");
			System.out.println("6-Borrar un telefono de un contacto");
			System.out.println("7-Buscar contactos por un telefono");
			System.out.println("0-salir del programa");
		int opcion= teclado.nextInt();
		
		switch(opcion) {
			case 0:
				trabajando=false;
				break;
			case 1:
				System.out.println("introduzca nombre contacto a introducir");
				teclado.nextLine();
				String nombreContactoAnnadir=teclado.nextLine();
				Contacto contacto= new Contacto(nombreContactoAnnadir);
				if(agenda.buscarPorNombreExiste(nombreContactoAnnadir)==true)
					System.out.println("Ya existe un contacto con ese nombre");
				else {
					agenda.annadirContacto(contacto);
					fichero.escribirContactos(agenda);
				}
				break;
				
			case 2:
				System.out.println("introduzca nombre contacto a borrar");
				teclado.nextLine();
				String nombreContactoBorrar=teclado.nextLine();
				agenda.borrarContacto(nombreContactoBorrar);
				break;
				
			case 3:
				if(agenda.getContactos().size()>0) {
				agenda.getContactos().sort(null);
				for(Contacto c: agenda.getContactos()) 
					System.out.println(c);
				}
				else System.out.println("no hay contactos");
				break;
			case 4:
				System.out.println("introduzca nombre contacto a buscar");
				teclado.nextLine();
				String nombreContactoBuscar=teclado.nextLine();
				if(agenda.buscarPorNombreExiste(nombreContactoBuscar)==true)
					{agenda.devolverTelefonos(nombreContactoBuscar);}
				else {System.out.println("no hay ningun contacto con ese nombre");}
				break;
	
			case 5: 
				System.out.println("introduzca nombre contacto a añadir telefono");
				teclado.nextLine();
				String nombreContactoTelefono=teclado.nextLine();
				if(agenda.buscarPorNombreExiste(nombreContactoTelefono)==true)
				{	
					ListIterator<Contacto>iterador= agenda.getContactos().listIterator();
					while(iterador.hasNext()) {
						Contacto contactoNuevo= iterador.next();
						if(contactoNuevo.getNombre().equals(nombreContactoTelefono)) {
							System.out.println("introduce tipo de numero nuevo");
							String tipoNuevo=teclado.nextLine();
							System.out.println("introduce numero valido nuevo");
							String numeroNuevo=teclado.nextLine();
							System.out.println("¿quieres introducir sufijo?");
							System.out.println("1-si");
							System.out.println("2-no");
							int sufijoOpcion=teclado.nextInt();
							System.out.println(sufijoOpcion);
							if(sufijoOpcion==1) {
								System.out.println("Introduce sufijo");			
								String sufijoNuevo=teclado.nextLine();
								Telefono telefonoSufijo=new Telefono(tipoNuevo,sufijoNuevo,numeroNuevo);
								contactoNuevo.annadirTelefono(telefonoSufijo);
							}
							else {
								Telefono telefono= new Telefono(tipoNuevo,numeroNuevo);
								contactoNuevo.annadirTelefono(telefono);
							}
							iterador.set(contactoNuevo);
							}
						
						
					}
				}
				else {System.out.println("no hay un contacto con ese nombre");}
				break;
			case 6: 
				System.out.println("Introduce nombre del contacto del que borrar el telefono");
				teclado.nextLine();
				String nombreBorrarTelefono= teclado.nextLine();
				if(agenda.buscarPorNombreExiste(nombreBorrarTelefono)==false)
					System.out.println("no hay contactos con ese nombre");
				else { System.out.println("introduce el numero a borrar");
				teclado.nextLine();
				String numeroBorrar=teclado.nextLine();
				ListIterator<Contacto> iterador=agenda.getContactos().listIterator();
				while(iterador.hasNext()) {
					Contacto contactoBorrarTelefono= iterador.next();
					if(contactoBorrarTelefono.getNombre().equals(nombreBorrarTelefono))
						contactoBorrarTelefono.borrarTelefono(numeroBorrar);
					}
				}
				break;
			case 7:
				System.out.println("introduce el numero de los contactos a buscar");
				teclado.nextLine();
				String numeroBorrar=teclado.nextLine();
				Telefono telefonoParaBuscar= new Telefono("cualquiera", numeroBorrar);
				ArrayList<Contacto> encontrados=agenda.buscarPorTelefono(telefonoParaBuscar);
				for(Contacto c:encontrados)
					System.out.println(c.getNombre());
				break;
			
		}//fin switch
		}
		System.out.println("Programa finalizado");
		
	Fichero.escribirTmp(agenda);
	
	
	fichero.closeUp();
	
	}
}
