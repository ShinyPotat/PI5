package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import datos.Profesor;

public class Ejercicio2 {
	
	public static Map<Integer, List<String>> apartadoA(List<Profesor> ls) {
		Map<Integer, List<String>> res = new HashMap<>();
		List<String> grupos = new ArrayList<>();
		
		// Contador de grupos
		for(Profesor p: ls) {
			for(String g: p.getGroups()) {
				if(!grupos.contains(g))
					grupos.add(g);
			}
		}
		
		Integer cont = 0;
		Integer gNum = grupos.size();
		
		res = apartadoA(ls, res, cont, gNum, 0);
		
		return res;
	}

	private static Map<Integer, List<String>> apartadoA(List<Profesor> ls, Map<Integer, List<String>> res, Integer cont,
			Integer gNum, Integer i) {
		if(cont < gNum) {
			i = i + 1;
			res.put(i, new ArrayList<String>());
			for(Profesor p: ls) {
				for(String g: p.getGroups()) {
					List<String> allValues = res.values().stream()
							.flatMap(List::stream)
							.collect(Collectors.toList());
					if(!allValues.contains(g)) {
						//System.out.format("Franja %d: %s con %s\n", i, g, p.getName());
						res.get(i).add(g);
						cont = cont + 1;
						break;
					}
				}
			}
			res = apartadoA(ls, res, cont, gNum, i);
		}
		return res;
	}
	
}
