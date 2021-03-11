package tests;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ejercicios.Ejercicio3;
import us.lsi.common.Files2;

public class Test3 {
	
	public static void execute() {
		System.out.println("==== EJERCICIO 3 ====");
		List<String> lines = Files2.linesFromFile("ficheros/PI5Ej3DatosEntrada.txt");
		Map<String, Set<String>> map = new TreeMap<>();
		for(String line: lines) {
			String[] format = line.split(": ");
			String asignatura = format[0];
			String s = format[1];
			int beginIndex = s.indexOf("{");
			int endIndex = s.indexOf("}");
			String[] array = format[1].substring(beginIndex+1, endIndex).split(",");
			Set<String> set = new HashSet<>();
			if(!array[0].isBlank()) {
				set = Set.of(array);
			}
			map.put(asignatura, set);
		}
		System.out.println("Apartado a)\n");
		Set<String> resA = Ejercicio3.apartadoA(map);
		for(String s: resA) {
			System.out.println(s);
		}
		System.out.println("\nApartado b)\n");
		Set<String> resB = Ejercicio3.apartadoB(map);
		System.out.println("Las asignaturas que no requieren aprobar otra antes son:");
		for(String s: resB) {
			System.out.println("    " + s);
		}
		System.out.println("\nApartado c)\n");
		
		// Uno de los dos test deben estar comentados
		
		// TEST 1
		
//		Set<String> set1 = Set.of("Asignatura_01", "Asignatura_02", "Asignatura_03",
//		                           "Asignatura_04", "Asignatura_05");
//		Set<String> resC1 = Ejercicio3.apartadoC(map, set1);
//		System.out.println("· Test 1 – El alumno puede cursar las siguientes asignaturas:");
//		System.out.println(resC1);
		
		// TEST 2
		
		Set<String> set2 = Set.of("Asignatura_01", "Asignatura_02", "Asignatura_03",
                "Asignatura_04", "Asignatura_05", "Asignatura_06", "Asignatura_07",
                "Asignatura_08", "Asignatura_11");
		Set<String> resC2 = Ejercicio3.apartadoC(map, set2);
		System.out.println("\n· Test 2 – El alumno puede cursar las siguientes asignaturas:");
		System.out.println(resC2);
	}
	
	public static void main(String[] args) {
		execute();

	}

}
