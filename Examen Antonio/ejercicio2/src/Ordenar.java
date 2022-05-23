import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 * Clase para mostrar por pantalla los nombres añadidos por orden alfabeetico
 * 
 * @author Antonio Mallén
 *
 */
public class Ordenar {

	private String fichero;
	Scanner in = null;
	Set<String> vector = new TreeSet<String>();


	public Ordenar(String fichero) {
		this.fichero=fichero;
		try {
			in = new Scanner(new BufferedReader( new FileReader(fichero)));
		} catch (FileNotFoundException e) {
			System.out.println("El archivo aun no ha sido creado");
		}
	}

	public void mostrar(){
		for( String elem : vector) {
			System.out.println(elem);
		}
	}

	/**
	 * Te mete todos los nombres en un TreeSet el cual ordena
	 * automaticamente los nombres de forma alfabetica
	 */
	public void ordenAlfabetico() {
		while(in.hasNext()) {
			vector.add(in.next());
			in.nextLine();
		}
		mostrar();
	}


}
