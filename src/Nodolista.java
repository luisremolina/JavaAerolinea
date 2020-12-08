
public class Nodolista {
	Integer id,equipaje;
	String destino,nom,ape;
	public Nodolista sig,ant;
	
	public Nodolista(int ide, String nombre, String apellido, String carreraa, int seme,  Nodolista a, Nodolista s) {
		id = ide;
		nom = nombre;
		ape = apellido;
		destino = carreraa;
		equipaje = seme;
		ant = a;
		sig = s;
	}
	public Nodolista(int ide, String nombre, String apellido, String carreraa, int seme) {
		this(ide, nombre, apellido, carreraa, seme, null, null);
	}
}