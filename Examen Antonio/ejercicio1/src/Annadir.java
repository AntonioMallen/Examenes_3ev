import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Annadir {

	private String fichero;
	/**
	 * ponemos como atributo al contacto a añadir el cual sera pasado en el constructor
	 */
	private Contacto nuevo;
	/**
	 * Creamos un Scanner para comprobar si el nombre ya esta puesto
	 */
	Scanner in=null;
	private boolean add;

	/**
	 * 
	 * Creamos un constructor pasandole el parametro del fichero y el contacto que queremos añadir
	 * 
	 * @param fichero
	 * @param nuevo
	 */
	Annadir( String fichero, Contacto nuevo ){
		this.fichero=fichero;
		this.nuevo=nuevo;
		try {
			in = new Scanner(new BufferedReader( new FileReader(fichero)));
		} catch (FileNotFoundException e) {
			// ponemos a add en false ya que no existe aun el archivo
			add=false;
		}
	}

	/**
	 * 
	 * Metodo para saber si un contacto ya ha sido añadido anteriormente
	 * 
	 * @return devolvera falso en caso de que no se encuentre el nombre de usuario en el
	 * archivo y true si se ha encontrado
	 */
	public boolean comprobarUsuario (String nom) {
		/**
		 * Comprobamos si el archivo es nulo, si lo es devolvemos false,
		 * ya que aun no ha sido añadido el usuario
		 */
		if ( in == null )
			return false;
		boolean encontrado = false;
		/**
		 * Se va comprobando uno por uno los tokens y si alguno coincide, se hace un return de true,
		 * si ha terminado el archivo sin encontrar ninguno con el mismo nombre, se devuelve false.
		 */
		while ( ! encontrado && in.hasNext() ) {
			String nombre = in.next();
			if ( nom.equals(nombre) )
				return true;
			in.nextLine();
		}
		add=true;
		return false;
	}

	/**
	 * Metodo para añadir un nuevo usuario al archivo
	 */
	public void annadirUsuario ( ) {
		/**
		 * Cerramos el Scanner del archivo que habiamos creado anteriormente
		 */
		if ( in != null )
			in.close();

		PrintStream ps = null;

		try {
			ps = new PrintStream(
					new FileOutputStream(fichero,add));
			ps.println(this.nuevo.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}

	/**
	 * Creamos un metodo de finalizar en caso de que se introduzca un usuario que ya esta en el archivo
	 * en este metodo se cerrara el Scanner
	 *
	 */
	public void finalizar ( ) {
		if ( in != null )
			in.close();
		in = null;
	}



}
