package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import datos.Profesor;
import ejercicios.Ejercicio2;
import us.lsi.common.Files2;

public class Test2 {
	
	public static void execute() {
		System.out.println("==== EJERCICIO 2 ====");
		List<String> lines = Files2.linesFromFile("ficheros/PI5Ej2DatosEntrada.txt");
		List<Profesor> profesores = new ArrayList<Profesor>();
		for(String line: lines) {
			String[] format = line.split(": ");
			Profesor p = Profesor.ofFormat(format);
			profesores.add(p);
		}
		
		System.out.println("Apartado a)\n");
		Map<Integer, List<String>> resA = Ejercicio2.apartadoA(profesores);
		System.out.format("Nº de franjas horarias necesarias: %d\n", resA.size());
		System.out.println("Grupos a impartirse en paralelo según franja horaria:");
		for(Integer key: resA.keySet()) {
			System.out.format("    Franja nº %d: %s\n", key, resA.get(key).toString());
		}
	}
	
	public static void main(String[] args) {
		execute();

	}

}
