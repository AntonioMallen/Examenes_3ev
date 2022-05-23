package ejercicio1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Contacto implements Serializable, Comparable<Contacto> {
	private boolean barba;
	private int hijos;
	private String nombre;
	boolean sexo; //true mujer false hombre
	private ArrayList<Telefono> telefonos= new ArrayList<Telefono>();
	
	/**
	 * Constructor que genera el contacto con un ArrayList de telefonos y nombre
	 * @param nombre: nombre del contacto
	 * @param telefonos: arrayList con los telefonos del contacto
	 */
	Contacto(String nombre, ArrayList<Telefono> telefonos){
		this.nombre= nombre;
		this.telefonos= telefonos;
	}
	public void setSexo(boolean sexo) {
		this.sexo=sexo;
	}
	
	public boolean getSexo() {
		return this.sexo;
	}
	/**
	 * Constructor que genera el contacto solo con el nombre, sin telefonos asociados
	 * @param nombre: nombre del contacto
	 */
	Contacto(String nombre){
		this.nombre= nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean getBarba() {
		return barba;
	}
	public void setBarba(boolean barba) {
		this.barba = barba;
	}
	public int getHijos() {
		return hijos;
	}
	public void setHijos(int hijos) {
		this.hijos = hijos;
	}
	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}
	public void annadirTelefono(Telefono telefono) {
		this.getTelefonos().add(telefono);
	}
	
	public void borrarTelefono(String numero) {
		ListIterator<Telefono> iterador= this.getTelefonos().listIterator();
		while(iterador.hasNext())
			if(iterador.next().getNumero().equals(numero))
				iterador.remove();
	}
	
	/*
	 * Implementamos metodo compareTo para poder comparar los contactos entre si
	 * como la comparacion ha de ser alfabetica,podemos usar el compareTo de las 
	 * Strings del atributo nombre de cada objeto para saber cual es mayor 
	 */
	@Override
	
	public int compareTo(Contacto o) {
		int comparacion=0;
		if(this.nombre.compareTo(o.nombre)==0)
			comparacion=0;
		if(this.nombre.compareTo(o.nombre)==1)
			comparacion=1;
		if(this.nombre.compareTo(o.nombre)==-1)
			comparacion=-1;
		return comparacion;
	}
	@Override 
	public String toString() {
		{
			String contacto= this.nombre+" ";
			if(this.getSexo())
				contacto+="M"+" "+this.getHijos()+" hijos ";
				
			else contacto+="H "+(this.getBarba()?"con barba":"imberbe");
			for(Telefono tf:this.getTelefonos()) {
				contacto+= "\n"+tf;
			}
			return contacto;
		}
	}
	
	
	
	
}
