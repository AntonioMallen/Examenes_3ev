package ejercicio1;

import java.io.Serializable;
import java.util.*;

public class Agenda implements Serializable{
	
	private ArrayList<Contacto> contactos= new ArrayList<Contacto>();
	
	Agenda(ArrayList<Contacto> contactos){
		this.contactos= contactos;
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}
	
	
	/**
	 * metodo para buscar en la agenda si existe un contacto con un determinado nombre
	 * @param nombre: nombre que queremos buscar
	 * @return true si ya esta, false si no
	 */
	
	public Contacto devolverContacto(String nombre) {
		for(Contacto c: this.getContactos())
			if(c.getNombre().equals(nombre)) 
				return c;
			return null;
	}
	
	public boolean buscarPorNombreExiste (String nombre) {
		boolean existe= false;
		for(Contacto c: this.getContactos())
			if(c.getNombre().equals(nombre)) 
				existe= true;
			return existe; 
	}
	
	/**
	 * metodo que imprime los telefonos del contacto con el nombre pasado por param
	 * @param nombre
	 */
	public void devolverTelefonos (String nombre) {
		for(Contacto c: this.getContactos())
			if(c.getNombre().equals(nombre)) 
				for(Telefono telefono: c.getTelefonos())
					System.out.println(telefono);
		
	}
	
	public void annadirContacto(Contacto contacto) {
		this.getContactos().add(contacto);
	}

	/**
	 * 
	 * metodo que borra un contacto introduciendo el nombre del mismo
	 * da una confirmacion por consola si lo ha borrado o si no lo ha encontrado
	 * @param nombre: nombre por el que se busca el contacto a borrar
	 */
	public void borrarContacto(String nombre) {
		ListIterator<Contacto> iterador=this.getContactos().listIterator();
		while(iterador.hasNext()) {
			Contacto buscado= iterador.next();
			if(buscado.getNombre().equals(nombre)) {
				iterador.remove();
				System.out.println("se borro el contacto de "+nombre);
				}
			else {System.out.println("no se encontro ningun contacto con ese nombre");}
		}
	}
	
	
	/**
	 * metodo para buscar contactos por su numero de telefono
	 * recorre los contactos actuales de la agenda y añade los que coincidan el numero 
	 * a un arrayList de contactos
	 * @param telefono: objeto telefono del que buscamos el numero
	 * @return: nos devuelve un ArrayList de contactos con los que coincida
	 */
	public ArrayList<Contacto> buscarPorTelefono(Telefono telefonoABuscar) {
		ArrayList<Contacto> contactos= new ArrayList<Contacto>();
		for (Contacto contacto: this.getContactos()) {
			for(Telefono telefono: contacto.getTelefonos()) {
				if(telefono.equals(telefonoABuscar)) 
					contactos.add(contacto);
				}
		}
		return contactos;	
	}
	
}
