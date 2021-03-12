package tests;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ejercicios.Ejercicio2;
import us.lsi.common.Files2;

public class Test2 {
	
	public static void execute() {
		System.out.println("==== EJERCICIO 2 ====");
		List<String> lines = Files2.linesFromFile("ficheros/PI5Ej2DatosEntrada.txt");
		Map<String, List<String>> data = new TreeMap<>();
		for(String line: lines) {
			String[] format = line.split(": ");
			String profesor = format[0].trim();
			String[] grupos = format[1].split(", ");
			List<String> ls = List.of(grupos);
			data.put(profesor, ls);
		}
		
		System.out.println("Apartado a)\n");
		Map<Integer, List<String>> resA = Ejercicio2.apartadoA(data);
		System.out.println("Nº de franjas horarias necesarias: " + resA.size());
		for(Integer key: resA.keySet()) {
			System.out.println("    Franja nº " + key + " : " + resA.get(key));
		}
		
		Ejercicio2.apartadoB(data, resA);
	}
	
	public static void main(String[] args) {
		execute();

	}

}
