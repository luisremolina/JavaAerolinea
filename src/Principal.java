import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings({ "unused", "serial" })
public class Principal extends JFrame {

	private JPanel contentPane;
	static Integer identificacion=0,buscador=0, equipaje=0;       
    static String nombre="",apellido="",destino="",cadena;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/fondo/Aeropuerto (1).jpg")));
		Lista lista = new Lista();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblListasDeEstudiantes = new JLabel("RESERVACIONES");
		lblListasDeEstudiantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListasDeEstudiantes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListasDeEstudiantes.setBounds(218, 11, 255, 25);
		contentPane.add(lblListasDeEstudiantes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane.setBounds(356, 69, 365, 316);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("");
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opci\u00F3n");
		lblElijaUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaOpcin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblElijaUnaOpcin.setBounds(10, 80, 166, 25);
		contentPane.add(lblElijaUnaOpcin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción", "Primera clase", "Clase turista", "Clase ejecutiva", "Insertar antes de", "Insertar después de", "Eliminar", "Eliminar en Bloque", "Modificar", "Modificar en Bloque", "Buscar", "Desplegar"}));
		comboBox.setBounds(10, 110, 179, 24);
		contentPane.add(comboBox);
		
		JButton Abrir = new JButton("Abrir");
		Abrir.setBackground(Color.WHITE);
		Abrir.setFont(new Font("Tahoma", Font.BOLD, 14));
		Abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista.abrir();
				textArea.setText(lista.imprimirinifin());
			}
		});
		Abrir.setBounds(21, 362, 89, 23);
		contentPane.add(Abrir);
		
		JButton Guardar = new JButton("Guardar");
		Guardar.setBackground(Color.WHITE);
		Guardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista.guardar();
				textArea.setText(lista.imprimirinifin());
			}
		});
		Guardar.setBounds(192, 362, 101, 23);
		contentPane.add(Guardar);
		
		JButton Listar = new JButton("Dibujar lista");
		Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(lista.imprimirinifin());
			}
		});
		Listar.setBackground(Color.WHITE);
		Listar.setFont(new Font("Tahoma", Font.BOLD, 14));
		Listar.setBounds(595, 36, 126, 23);
		contentPane.add(Listar);
		
		JButton btnEjecutarAccin = new JButton("Ejecutar acci\u00F3n");
		btnEjecutarAccin.setBackground(Color.WHITE);
		btnEjecutarAccin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEjecutarAccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String operacombo = comboBox.getSelectedItem().toString();
				switch(operacombo) {
				case "Seleccione una opción":
					JOptionPane.showMessageDialog(null, "Por favor seleccione una opción");
					break;
				case "Primera clase":
					identificacion = leer_entero("Digite la identificacion ");
                    nombre= leer_letras("Digite el nombre de la persona");
                    apellido=leer_letras("Digite el apellido de "+nombre);
                    destino=leer_letras("Digite su destino");
                    equipaje =leer_entero("Digite el total de equipaje ");
                    lista.primeraclase(identificacion, nombre, apellido, destino, equipaje);
                    textArea.setText(lista.imprimirinifin());
					break;
				case "Clase turista":
					identificacion = leer_entero("Digite la identificacion ");
                    nombre= leer_letras("Digite el nombre de la persona");
                    apellido=leer_letras("Digite el apellido de "+nombre);
                    destino=leer_letras("Digite su destino");
                    equipaje =leer_entero("Digite el total de equipaje ");
                     lista.claseturista(identificacion, nombre, apellido, destino, equipaje);;
                     textArea.setText(lista.imprimirinifin());
					break;
				case "Clase ejecutiva":
					 buscador = Integer.parseInt(JOptionPane.showInputDialog("Digite La Posición del nodo en la que ingresará la información "));
					 identificacion = leer_entero("Digite la identificacion ");
	                 nombre= leer_letras("Digite el nombre de la persona");
	                 apellido=leer_letras("Digite el apellido de "+nombre);
	                 destino=leer_letras("Digite su destino");
	                 equipaje =leer_entero("Digite el total de equipaje ");
                     lista.claseejecutiva(buscador, identificacion, nombre, apellido, destino, equipaje);
                     textArea.setText(lista.imprimirinifin());;
					break;
				case "Insertar antes de":
					buscador = Integer.parseInt(JOptionPane.showInputDialog("Digite una identificación y se insertará la información en un nodo anterior a ella "));
					identificacion = leer_entero("Digite la identificacion ");
                    nombre= leer_letras("Digite el nombre de la persona");
                    apellido=leer_letras("Digite el apellido de "+nombre);
                    destino=leer_letras("Digite su destino");
                    equipaje =leer_entero("Digite el total de equipaje ");
                    lista.insertarantesde(buscador, identificacion, nombre, apellido, destino, equipaje);
                    textArea.setText(lista.imprimirinifin());
					break;
				case "Insertar después de":
					buscador = Integer.parseInt(JOptionPane.showInputDialog("Digite una identificación y se insertará la información en un nodo después a ella. "));
					identificacion = leer_entero("Digite la identificacion ");
                    nombre= leer_letras("Digite el nombre de la persona");
                    apellido=leer_letras("Digite el apellido de "+nombre);
                    destino=leer_letras("Digite su destino");
                    equipaje =leer_entero("Digite el total de equipaje ");
                    lista.insertardespuesde(buscador,identificacion, nombre, apellido, destino, equipaje);
                    textArea.setText(lista.imprimirinifin());
					break;
				case "Eliminar":
					identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite la identificacion a buscar"));
					lista.eliminar(identificacion);
					textArea.setText(lista.imprimirinifin());
					break;
				case "Eliminar en Bloque":
					cadena = JOptionPane.showInputDialog("Digite el o los números correspondientes a los parametros de menor a mayor \n"
                			+ "separados por un - ejemplo: 1-3-5 \n"
                			+ "1.Identificación\n"
                			+ "2.Nombre\n"
                			+ "3.Apellido\n"
                			+ "4.Destino\n"
                			+ "5.Equipaje\n");
                	String leer[]=cadena.split("-");
                	for(int i=0;i<leer.length;i++) {
                		switch(leer[i]) {
                		case "1":
                			identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite la identificacion "));
                			break;
                		case "2":
                			nombre= JOptionPane.showInputDialog("Digite el nombre ");
                			break;
                		case "3":
                			apellido=JOptionPane.showInputDialog("Digite el apellido");
                			break;
                		case "4":
                			destino=JOptionPane.showInputDialog("Digite el destino");
                			break;
                		case "5":
                			equipaje = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de equipaje"));
                			break;
                		}
                	}
                	lista.eliminarbloque(cadena, identificacion, nombre, apellido, destino, equipaje);
                	textArea.setText(lista.imprimirinifin());
					break;
				case "Modificar":
					buscador = Integer.parseInt(JOptionPane.showInputDialog("Digite una identificación del nodo a modificar "));
					identificacion = leer_entero("Digite la identificacion ");
                    nombre= leer_letras("Digite el nombre de la persona");
                    apellido=leer_letras("Digite el apellido de "+nombre);
                    destino=leer_letras("Digite su destino");
                    equipaje =leer_entero("Digite el total de equipaje ");
                    lista.modificar(buscador,identificacion, nombre, apellido, destino, equipaje);
                    textArea.setText(lista.imprimirinifin());
					break;
				case "Modificar en Bloque":
					cadena = JOptionPane.showInputDialog("Digite el o los números correspondientes a los parametros a buscar de menor a mayor \n"
                			+ "separados por un - ejemplo: 1-3-5 \n"
                			+ "1.Identificación\n"
                			+ "2.Nombre\n"
                			+ "3.Apellido\n"
                			+ "4.Destino\n"
                			+ "5.Equipaje\n");
                	String leer2[]=cadena.split("-");
                	for(int i=0;i<leer2.length;i++) {
                		switch(leer2[i]) {
                		case "1":
                			identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite la identificacion "));
                			break;
                		case "2":
                			nombre= JOptionPane.showInputDialog("Digite el nombre ");
                			break;
                		case "3":
                			apellido=JOptionPane.showInputDialog("Digite el apellido");
                			break;
                		case "4":
                			destino=JOptionPane.showInputDialog("Digite el destino");
                			break;
                		case "5":
                			equipaje = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de equipaje"));
                			break;
                		}
                	}
                	lista.modificaciónbloque(cadena, identificacion, nombre, apellido, destino, equipaje);
                	textArea.setText(lista.imprimirinifin());
					break;
					
				case "Buscar":
					identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite la identificacion del nodo a buscar"));
					lista.buscar(identificacion);
					break;
				case "Desplegar":
					lista.imprimirinifin2();
					break;
				}
			}
		});
		btnEjecutarAccin.setBounds(199, 110, 147, 25);
		contentPane.add(btnEjecutarAccin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/fondo/Aeropuerto (1).jpg")));
		lblNewLabel.setBounds(0, 0, 754, 437);
		contentPane.add(lblNewLabel);
	}
	public	static String leer_letras (String t) {
		String nombre="";
		while(nombre.equals("")) {
			nombre=JOptionPane.showInputDialog(t);
			if(!nombre.matches("^[A-Za-zñÑ ]*$")) {
				JOptionPane.showMessageDialog(null, "nombre no valido");
				nombre="";
			}}
		return (nombre);
		
		
	}
 
 static int leer_entero( String a ){
    	String cad;
    	int c;
    	while( true ){
    		cad = JOptionPane.showInputDialog( a );
    		if( cad.isEmpty() ){
    			JOptionPane.showMessageDialog( null, "Debe digitar entero..." );
    		}
    		else{
    			try{
    				c = Integer.parseInt(cad);
    				if(c>0) {
    				break; // si es correcto sale del ciclo 
    				}else {
    					JOptionPane.showMessageDialog( null, "El dato debe de ser mayor a cero" );
    				}
    				
    			}catch(NumberFormatException e){
    				JOptionPane.showMessageDialog( null, "El dato no es entero..." );			     
    			}
    		}
    	}
    	
    	return(c);

 }
}

