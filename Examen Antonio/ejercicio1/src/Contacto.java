/**
 * 
 * Creamos una clase Contacto con los atributos y los getters de cada contacto
 * 
 * @author Antonio Mallén
 *
 */
public class Contacto {

	/**
	 * nombre del contacto
	 */
	private String nombre;
	/**
	 * Su numero de trabajo en formato de String para luego validarlo
	 */
	private String num_trabajo;
	/**
	 * Su numero de movil en formato de String para luego validarlo
	 */
	private String num_movil;
	/**
	 * Su numero opcional en formato de String para luego validarlo
	 */
	private String otro;
	/**
	 * Su fax en formato de String para luego validarlo
	 */
	private String fax;


	public Contacto( String nombre) {
		this.nombre=nombre;
	}

	public void añadirDatos(String num_trabajo,String num_movil ,String otro ,String fax ) {
		this.num_trabajo=num_trabajo;
		this.num_movil=num_movil;
		this.otro=otro;
		this.fax=fax;
	}

	public String getNombre() {
		return nombre;
	}


	public String toString() {
		return nombre + " ; " + "trabajo " + num_trabajo + " ; "+ "móvil " + num_movil + " ; " + "otro " + num_movil + " ; " +"fax " + num_movil ;
	}



}
