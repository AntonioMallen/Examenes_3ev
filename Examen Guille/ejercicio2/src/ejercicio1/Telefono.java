package ejercicio1;

import java.io.Serializable;

public class Telefono implements Serializable{
	
	private String tipo;
	//separo el sufijo y el telefono en dos variables para hacer  
	//mas facil la validacion
	private String sufijo="";
	private String numero;
	//hare dos constructores, uno con sufijo y otro sin ya que es opcional
	
	public Telefono(String tipo, String sufijo, String numero) {
		this.tipo = tipo;
		if(sufijo.length()<=3) {
			if((sufijo.charAt(0)=='+')&&
				(sufijo.charAt(1)<='9')&&(sufijo.charAt(1)>='0')&&
				(sufijo.charAt(2)<='9')&&(sufijo.charAt(2)>='0'))
					this.sufijo = sufijo;
			else System.out.println("sufijo no valido, caracteres no validos");
		}
		
		else System.out.println("sufijo no valido, longitud mayor que 3");
		if(numero.length()==9) {
			if(	(numero.charAt(0)<='9')&&(numero.charAt(0)>='0')&&
			   	(numero.charAt(1)<='9')&&(numero.charAt(1)>='0')&&
				(numero.charAt(2)<='9')&&(numero.charAt(2)>='0')&&
				(numero.charAt(3)<='9')&&(numero.charAt(3)>='0')&&
				(numero.charAt(4)<='9')&&(numero.charAt(4)>='0')&&
				(numero.charAt(5)<='9')&&(numero.charAt(5)>='0')&&
				(numero.charAt(6)<='9')&&(numero.charAt(6)>='0')&&
				(numero.charAt(7)<='9')&&(numero.charAt(7)>='0')&&
				(numero.charAt(8)<='9')&&(numero.charAt(8)>='0') )
					this.numero = numero;
			else System.out.println("numero no valido, caracteres no validos");
		}		
		else System.out.println("numero no valido, longitud no valida");
	}
	
	public Telefono(String tipo, String numero) {
		this.tipo = tipo;
		
		if(numero.length()==9) {
			if(	(numero.charAt(0)<='9')&&(numero.charAt(0)>='0')&&
			   	(numero.charAt(1)<='9')&&(numero.charAt(1)>='0')&&
				(numero.charAt(2)<='9')&&(numero.charAt(2)>='0')&&
				(numero.charAt(3)<='9')&&(numero.charAt(3)>='0')&&
				(numero.charAt(4)<='9')&&(numero.charAt(4)>='0')&&
				(numero.charAt(5)<='9')&&(numero.charAt(5)>='0')&&
				(numero.charAt(6)<='9')&&(numero.charAt(6)>='0')&&
				(numero.charAt(7)<='9')&&(numero.charAt(7)>='0')&&
				(numero.charAt(8)<='9')&&(numero.charAt(8)>='0') )
					this.numero = numero;
			else System.out.println("numero no valido, caracteres no validos");
		}		
		else System.out.println("numero no valido, longitud no valida");
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setDescripcion(String tipo) {
		this.tipo = tipo;
	}
	
	public String getSufijo() {
		return sufijo;
	}
	
	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * metodo para comprobar si dos telefonos son iguales, lo compara solamente con el numero
	 * no se comparan ni el tipo ni el sufijo
	 * @param telefono: objeto telefono con el que se compara para ver si es igual
	 * @return true si es igual, false si no
	 */
	public boolean equals(Telefono telefono) {
		boolean igual=false;
		if(this.getNumero().equals(telefono.getNumero())){
				igual=true;
		}
		return igual;
		}

	public String toString() {
		return this.getTipo()+" "+this.getSufijo()+" "+this.getNumero();
	}
	
}
