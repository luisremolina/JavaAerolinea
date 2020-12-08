import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Lista {
	public Nodolista inicio,fin,aux,nuevo,aux2;
	private int tamaño;
	public Lista() {
		inicio=fin=aux=aux2=nuevo=null;
		tamaño=0;
	}
	public int tamaño(){
		return tamaño;
	}
	//Saber sí está vacía
	public boolean vacia() {
		return inicio==null;
	}
	public void imprimirinifin2() {
		if(!vacia()) {
			String cad = "";
			aux = inicio;
			while(aux!=null) {
				cad+= "Identificacion: "+aux.id+
						   "\n|Nombre: "+ aux.nom + "     | Apellido: "+aux.ape +
						   "\n|Destino: "+ aux.destino+ "     | Equipaje: "+aux.equipaje +
							"\n =======================================\n";
				aux = aux.sig;
			}
			JOptionPane.showMessageDialog(null, cad);
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		}
	}
	public String imprimirinifin() {
		String cad = "";
		if(!vacia()) {
			aux = inicio;
			while(aux!=null) {
				cad = cad +"Identificacion: "+aux.id+
						   "\n|Nombre: "+ aux.nom + "     | Apellido: "+aux.ape +
						   "\n|Destino: "+ aux.destino+ "      | Equipaje: "+aux.equipaje +
							"\n =======================================\n";
			       aux = aux.sig;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		}
		return cad;
	}
	public String imprimirfinini() {
		String cad = "";
		if(!vacia()) {
			aux = fin;
			while(aux!=null) {
				cad = cad +"Identificacion: "+aux.id+
						   "\n|Nombre: "+ aux.nom + "     | Apellido: "+aux.ape +
						   "\n|Carrera: "+ aux.destino+ "     | Semestre: "+aux.equipaje +
							"\n =======================================\n";
				aux = aux.ant;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		}
		return cad;
	}
	public void primeraclase(int ide, String nombre, String apellido, String carreraa, int seme) {
		if(!vacia()) {
			inicio = new Nodolista(ide, nombre, apellido, carreraa, seme, null, inicio);
			inicio.sig.ant = inicio;
			tamaño++;
		}
		else {
			inicio=fin=new Nodolista(ide, nombre, apellido, carreraa, seme);
			tamaño++;
		}
	}
	public void claseturista(int ide, String nombre, String apellido, String carreraa, int seme) {
		if(!vacia()) {
			fin = new Nodolista(ide, nombre, apellido, carreraa, seme, fin, null);
			fin.ant.sig = fin;
			tamaño++;
		}
		else {
			inicio=fin=new Nodolista(ide, nombre, apellido, carreraa, seme);
			tamaño++;
		}
	}
	public void claseejecutiva(int buscador, int ide, String nombre, String apellido, String carreraa, int seme) {
		aux = inicio;
		 if(!vacia()){
			if (buscador == 1) {
				primeraclase(ide, nombre, apellido, carreraa, seme);
			} else if (buscador == tamaño + 1) {
				claseturista(ide, nombre, apellido, carreraa, seme); 
			} else if (buscador > 1 && buscador < tamaño + 1) {
				for (int i = 1; i < (buscador); i++) {
					aux = aux.sig;
				}
				nuevo = new Nodolista(ide, nombre, apellido, carreraa, seme);
				aux.ant.sig = nuevo;
				nuevo.sig = aux;
				nuevo.ant = aux.ant;
				aux.ant = nuevo;
				tamaño++;
			} else {
				JOptionPane.showMessageDialog(null, "Ingresó una posición invalida");
			}
		}
		 else {
			 JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		 }
	}
	public void insertarantesde(int buscador,  int ide, String nombre, String apellido, String carreraa, int seme) {
		aux = inicio;
		 if(!vacia()){
			if (buscador == 1) {
				primeraclase(ide, nombre, apellido, carreraa, seme);
			} else {
				while(aux!=null) {
					if(aux.id==buscador) {
						nuevo = new Nodolista(ide, nombre, apellido, carreraa, seme);
						aux.ant.sig = nuevo;
						nuevo.sig = aux;
						nuevo.ant = aux.ant;
						aux.ant = nuevo;
						tamaño++;
					}
					aux = aux.sig;
				}
			} 
		}
		 else {
			 JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		 }
	}
	public void insertardespuesde(int buscador,  int ide, String nombre, String apellido, String carreraa, int seme) {
		aux = inicio;
		 if(!vacia()){	 
				while(aux!=null) {
					if (buscador == fin.id) {
						claseturista(ide, nombre, apellido, carreraa, seme);
						break;
					}
					if(aux.id==buscador) {
						nuevo = new Nodolista(ide, nombre, apellido, carreraa, seme);
						aux.sig.ant = nuevo;
						nuevo.sig = aux.sig;
						nuevo.ant = aux;
						aux.sig = nuevo;
						tamaño++;
						break;
					}
					aux = aux.sig;
				}
		}
		 else {
			 JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		 }
	}
	public void modificar(int buscador, int ide, String nombre, String apellido, String carreraa, int seme) {
		aux = inicio;
		if(!vacia()) {
			while(aux!=null) {
				if(aux == null) {
					JOptionPane.showMessageDialog(null, "No se encontró la identifación a modificar");
				}
				else if(aux.id == buscador) {
					aux.id = ide;
					aux.nom = nombre;
					aux.ape = apellido;
					aux.destino = carreraa;
					aux.equipaje = seme;
					break;
				}
				aux = aux.sig;
			}
		}else {
			JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		}
	}
	public void eliminar(int ide) {
		aux = inicio;
		if(!vacia()) {
			while(aux!=null) {
			  if(aux.id == ide) {
				if(aux==inicio) {
					inicio = inicio.sig;
					aux = null;
					tamaño--;
					break;
				}else if(aux==fin) {
					fin = fin.ant;
					fin.sig = null;
					tamaño--;
					break;
				}else {
					aux.ant.sig = aux.sig;
					aux.sig.ant = aux.ant;
					aux = null;
					tamaño--;
					break;
				}
			  }
				aux = aux.sig;	
			}
			
		}else
			JOptionPane.showMessageDialog(null, "No hay datos en la lista");
	}
	public void buscar(int ide) {
		aux = inicio;
		if(!vacia()) {
			while(aux != null) {
				if(aux == null)
					JOptionPane.showMessageDialog(null, "Identificación no encontrada");
				else if(aux.id == ide) {
					JOptionPane.showMessageDialog(null, "Identificacion: "+aux.id+
						   "\n|Nombre: "+ aux.nom + "     | Apellido: "+aux.ape +
						   "\n|Carrera: "+ aux.destino+ "     | Semestre: "+aux.equipaje);
				}
				aux = aux.sig;
			}
		}else
			JOptionPane.showMessageDialog(null, "No hay datos en la lista");
	}
	public void guardar() {
		try {
			FileWriter fw = new FileWriter("Listaestudiantes.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Character lim = ';';
			aux = inicio;
			while (aux != null) {
				pw.println(String.valueOf(aux.id) + lim + aux.nom + lim + aux.ape + lim + aux.destino + lim
						+ String.valueOf(aux.equipaje));
				aux = aux.sig;
			}
			pw.close();
			JOptionPane.showMessageDialog(null, "Archivo Guardado");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "¡Error intentelo de nuevo!");
		}
	}

	public void abrir() {
		try {
			String[] leer = null;
			FileReader fr = new FileReader("Listaestudiantes.txt");
			BufferedReader br = new BufferedReader(fr);
			Character lim = ';';
			String linea = "";
			File archivo = new File("Listaestudiantes.txt");
			boolean empty = archivo.exists() && archivo.length() == 0;
			if (empty) {
				JOptionPane.showMessageDialog(null, "No hay información guardada");
			} else {
				while ((linea = br.readLine()) != null) {
					leer = linea.split(String.valueOf(lim));
					Integer Id = Integer.parseInt(leer[0]);
					String nombre = leer[1];
					String apellido = leer[2];
					String carreraa = leer[3];
					Integer seme = Integer.parseInt(leer[4]);
					claseturista(Id, nombre, apellido, carreraa, seme);
				}
				br.close();
				
				JOptionPane.showMessageDialog(null, "Archivo cargado");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no se encontro");
		}
	}
	public void eliminarbloque(String Opciones,int ide, String nombre, String apellido, String carreraa, int seme) {
		switch(Opciones) {
		case "1":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null) {
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					}
					else if(aux.id == ide) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(aux.id == ide) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		break;
		case "2":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(nombre.equalsIgnoreCase(aux.nom)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(nombre.equalsIgnoreCase(aux.nom)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "3":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(apellido.equalsIgnoreCase(aux.ape)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(apellido.equalsIgnoreCase(aux.ape)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(carreraa.equalsIgnoreCase(aux.destino)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(carreraa.equalsIgnoreCase(aux.destino)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "5":
			if(!vacia()) {
				aux = inicio;
				while(aux != null) {
					if(seme == aux.equipaje) {
						if(aux == inicio) {
							inicio = inicio.sig;
							aux = null;
							aux = inicio;
							tamaño--;
						}
						else if(aux==fin) {
							fin = fin.ant;
							fin.sig = null;
							tamaño--;
						}
						else {
							aux.ant.sig = aux.sig;
							aux.sig.ant = aux.ant;
							aux = null;
							aux = inicio;
							tamaño--;
						}
					}try {
						aux = aux.sig;	
					  }catch(Exception eg) {}
				}
				aux = inicio;
					while(aux!=null) {
						if(aux==null)
							JOptionPane.showMessageDialog(null, "Nodo no encontrado");
						else if(seme == aux.equipaje) {
						if(aux==inicio) {
							inicio = inicio.sig;
							aux = null;
							aux = inicio;
							tamaño--;
						}else if(aux==fin) {
							fin = fin.ant;
							fin.sig = null;
							tamaño--;
						}else {
							aux.ant.sig = aux.sig;
							aux.sig.ant = aux.ant;
							aux = null;
							aux = inicio;
							tamaño--;
						}
					  }try {
							aux = aux.sig;	
					  }catch(Exception eg) {}		
					}
					}
			else {
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
				}
			break;
		case "1-2":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-3":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(carreraa.equalsIgnoreCase(aux.destino))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(carreraa.equalsIgnoreCase(aux.destino))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(seme == aux.equipaje)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(seme == aux.equipaje)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-3":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom))&&(apellido.equalsIgnoreCase(aux.ape))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom))&&(apellido.equalsIgnoreCase(aux.ape))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom))&&(carreraa.equalsIgnoreCase(aux.destino))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom))&&(carreraa.equalsIgnoreCase(aux.destino))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom))&&(seme == aux.equipaje)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom))&&(seme == aux.equipaje)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "3-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape))&&(carreraa.equalsIgnoreCase(aux.destino))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape))&&(carreraa.equalsIgnoreCase(aux.destino))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");			
			break;
		case "3-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape))&&(seme == aux.equipaje)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape))&&(seme == aux.equipaje)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((carreraa.equalsIgnoreCase(aux.destino))&&(seme == aux.equipaje)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((carreraa.equalsIgnoreCase(aux.destino))&&(seme == aux.equipaje)) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-3":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(seme == aux.equipaje))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(seme == aux.equipaje))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-3-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-3-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje))) {
					if(aux == inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme ==aux.equipaje))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme ==aux.equipaje))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-3-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-3-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "3-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-3-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-3-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-3-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(aux.id == ide) {
					if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-3-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape))&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape))&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-3-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))&&(seme == aux.equipaje)))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						aux = inicio;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						aux = inicio;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Ingresó un parametro o conjunto de parametros no válido");
			break;
		}
	}
	public void modificaciónbloque(String Opciones,int ide, String nombre, String apellido, String carreraa, int seme) {
		int	identificacion=0, semestre=0;
		String nombree="", apellidoo="", carrer="";
		String cadena = JOptionPane.showInputDialog("Digite el o los números de menor a mayor correspondientes de los datos que sé modificarán \n"
	    			+ "separados por un - ejemplo: 1-3-5 \n"
	    			+ "1.Identificación\n"
	    			+ "2.Nombre\n"
	    			+ "3.Apellido\n"
	    			+ "4.Carrera\n"
	    			+ "5.Semestre\n");
		String leer2[]=cadena.split("-");
		boolean validacion=false,validacion2=false,validacion3=false,validacion4=false,validacion5=false;
		for(int i=0;i<leer2.length;i++) {
			switch(leer2[i]) {
			case "1":
				identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite la identificacion nueva"));
				validacion=true;
				break;
			case "2":
				nombree= JOptionPane.showInputDialog("Digite el nombre nuevo ");
				validacion2=true;
				break;
			case "3":
				apellidoo=JOptionPane.showInputDialog("Digite el apellido nuevo");
				validacion3=true;
				break;
			case "4":
				carrer=JOptionPane.showInputDialog("Digite la carrera nueva");
				validacion4=true;
				break;
			case "5":
				semestre = Integer.parseInt(JOptionPane.showInputDialog("Digite el semestre nuevo"));
				validacion5=true;
				break;
			
				}
			}
		switch(Opciones) {
		case "1":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if(aux.id == ide) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
		break;
		case "2":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if(nombre.equalsIgnoreCase(aux.nom)) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "3":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if(apellido.equalsIgnoreCase(aux.ape)) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
			break;
		case "4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if(carreraa.equalsIgnoreCase(aux.destino)) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			break;
		case "5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if(seme == aux.equipaje) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom))) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-3":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape))) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((ide == aux.id)&&(carreraa.equalsIgnoreCase(aux.destino))) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((ide == aux.id)&&(seme == aux.equipaje)) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-3":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((nombre.equalsIgnoreCase(aux.nom))&&(apellido.equalsIgnoreCase(aux.ape))) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((nombre.equalsIgnoreCase(aux.nom))&&(carreraa.equalsIgnoreCase(aux.destino))) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((nombre.equalsIgnoreCase(aux.nom))&&(seme == aux.equipaje)) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "3-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((apellido.equalsIgnoreCase(aux.ape))&&(carreraa.equalsIgnoreCase(aux.destino))) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "3-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((apellido.equalsIgnoreCase(aux.ape))&&(seme == aux.equipaje)) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((carreraa.equalsIgnoreCase(aux.destino))&&(seme == aux.equipaje)) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-3":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
				  if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)))) {
					  if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}	
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(seme == aux.equipaje))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-3-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-3-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme ==aux.equipaje))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-3-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))))) {
					if(aux==inicio) {
						inicio = inicio.sig;
						aux = null;
						tamaño--;
					}else if(aux==fin) {
						fin = fin.ant;
						fin.sig = null;
						tamaño--;
					}else {
						aux.ant.sig = aux.sig;
						aux.sig.ant = aux.ant;
						aux = null;
						tamaño--;
					}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-3-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "2-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "3-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-3-4":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-3-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(seme == aux.equipaje)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			break;
		case "1-2-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-3-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			
			break;
		case "2-3-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((apellido.equalsIgnoreCase(aux.ape))&&(nombre.equalsIgnoreCase(aux.nom)&&(carreraa.equalsIgnoreCase(aux.destino)&&(seme == aux.equipaje)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		case "1-2-3-4-5":
			aux = inicio;
			if(!vacia()) {
				while(aux!=null) {
					if(aux==null)
						JOptionPane.showMessageDialog(null, "Nodo no encontrado");
					else if((ide == aux.id)&&(nombre.equalsIgnoreCase(aux.nom)&&(apellido.equalsIgnoreCase(aux.ape)&&(carreraa.equalsIgnoreCase(aux.destino))&&(seme == aux.equipaje)))) {
						if(validacion) {
							aux.id = identificacion;
						}
						if(validacion2) {
							aux.nom = nombree;
						}
						if(validacion3) {
							aux.ape = apellidoo;
						}
						if(validacion4) {
							aux.destino = carrer;
						}
						if(validacion5) {
							aux.equipaje = semestre;
						}
				  }try {
					aux = aux.sig;	
				  }catch(Exception eg) {}
				}
				
			}else
				JOptionPane.showMessageDialog(null, "No hay datos en la lista");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Ingresó un parametro o conjunto de parametros no válido");
			break;
			}
		}
}

