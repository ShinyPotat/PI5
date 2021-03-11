package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ejercicios.Ejercicio3;
import us.lsi.common.Files2;

public class Test3 {
	
	public static void execute() {
		System.out.println("==== EJERCICIO 3 ====");
		List<String> lines = Files2.linesFromFile("ficheros/PI5Ej3DatosEntrada.txt");
		Map<String, List<String>> map = new TreeMap<>();
		for(String line: lines) {
			String[] format = line.split(": ");
			String asignatura = format[0];
			String s = format[1];
			int beginIndex = s.indexOf("{");
			int endIndex = s.indexOf("}");
			String[] array = format[1].substring(beginIndex+1, endIndex).split(",");
			List<String> ls = new ArrayList<>();
			if(!array[0].isBlank()) {
				ls = List.of(array);
			}
			map.put(asignatura, ls);
		}
		System.out.println("Apartado a)\n");
		List<String> resA = Ejercicio3.apartadoA(map);
		for(String s: resA) {
			System.out.println(s);
		}
		System.out.println("\nApartado b)\n");
		List<String> resB = Ejercicio3.apartadoB(map);
		System.out.println("Las asignaturas que no requieren aprobar otra antes son:");
		for(String s: resB) {
			System.out.println("    " + s);
		}
	}
	
	public static void main(String[] args) {
		execute();

	}

}
