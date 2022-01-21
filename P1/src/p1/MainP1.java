package p1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.Scanner;

class Excepciones extends Exception {
    String errStr; 
    public Excepciones(String str) {
        errStr = str;
    }
    public String toString() {
        return errStr;
    }
}

class Corrector{
    private String palabra;

    public Corrector(String palabra) {
        this.palabra = palabra;
    }
    
    
    public static Boolean existe_caracteres_especiales(String c){
        return "+-/*^=%()`~!@#$%&*-_=1234567890;:[]{}'<,>./?|".indexOf (c) != -1;
    }
    
}

public class MainP1 {

    static int totalCoincidencias = 0;
    public static void main(String[] args) throws Excepciones{
        Scanner sc = new Scanner(System.in);
        
        String palabra = sc.nextLine();
        String [] palabra_vect = palabra.split("");
        
        for(int i = 0; i < palabra_vect.length; i++){
            if(Corrector.existe_caracteres_especiales(palabra_vect[i]))
                throw new Excepciones("palabar erronea");  
        }
        
        File archivo = new File("palabras.txt");
        buscarCoincidenciaPalabra(palabra, archivo);
        buscarCoincidenciaCaracter(palabra, archivo);
        buscarCoincidenciaPalabra_1(palabra, archivo);
    }
    
    public static void buscarCoincidenciaPalabra(String letraBuscar, File archivo) {
        totalCoincidencias = 0;

        try {
            if(archivo.exists()) {

                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                String lineaLeida;

                while((lineaLeida = archivoLeer.readLine()) != null) {

                    String[] partes = lineaLeida.split(" ");

                    for(int i = 0 ; i < partes.length ; i++) {
                        if(partes[i].equals(letraBuscar)) {
                            totalCoincidencias = totalCoincidencias + 1;
                        }
                    }
                }

                archivoLeer.close();
            }

            System.out.println("\n\nEl caracter: " + letraBuscar + 
                            " se encuentra: " + totalCoincidencias + 
                            " veces en el archivo buscando por PALABRA");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void buscarCoincidenciaPalabra_1(String letraBuscar, File archivo) {
        totalCoincidencias = 0;

        try {
            if(archivo.exists()) {
                
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                String lineaLeida;
                int coincidencia_aux = 0;
                String[] letraBuscar_array = letraBuscar.split("");
                
                while((lineaLeida = archivoLeer.readLine()) != null) {
                    
                    String[] partes = lineaLeida.split(" ");
                    System.out.println(partes);
//                    for(int i = 0 ; i < partes.length ; i++) {
//                        String aux = partes[i];
//                        String[] aux_array = aux.split("");
//                        if(partes[i].equals(letraBuscar_array[i])) {
//                            coincidencia_aux++;
//                        }
//                    }
//                    if(coincidencia_aux == letraBuscar_array.length)
//                        totalCoincidencias = totalCoincidencias + 1;
                }

                archivoLeer.close();
            }

            System.out.println("\n\nEl caracter: " + letraBuscar + 
                            " se encuentra: " + totalCoincidencias + 
                            " veces en el archivo buscando por PALABRA 1");
        } catch(Exception e) {
            System.out.println("error "+e.getMessage());
        }
    }
    
    public static void buscarCoincidenciaCaracter(String letraBuscar, File archivo) {
		totalCoincidencias = 0;
		
		char caracter = letraBuscar.charAt(0);
		
		try {
			if(archivo.exists()) {
				BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
				
				String lineaLeida;
				while((lineaLeida = archivoLeer.readLine()) != null) {
					
					char[] arregloCaracteres = lineaLeida.toCharArray();
					
					for(int i = 0 ; i < arregloCaracteres.length ; i++) {
						
						if(arregloCaracteres[i] == caracter) {
							totalCoincidencias = totalCoincidencias + 1;
						}
					}
				}
				archivoLeer.close();
			}
			
			System.out.println("\n\nEl caracter: " + letraBuscar + 
					" se encuentra: " + totalCoincidencias + 
					" veces en el archivo buscando por CARACTER");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}