package ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.Graphs2;

public class Ejercicio2 {
	
	public static Map<Integer, List<String>> apartadoA(Map<String, List<String>> map) {
		Map<Integer, List<String>> r = new HashMap<>();
		int i = 1;
		while(r.values().stream().flatMap(List::stream).collect(Collectors.toSet()).size()
				!= map.values().stream().flatMap(List::stream).collect(Collectors.toSet()).size()) {
			List<String> ls = new ArrayList<>();
			for(String profesor: map.keySet()) {
				for(String grupo: map.get(profesor)) {
					if(!ls.contains(grupo) && !r.values().stream().flatMap(List::stream).collect(Collectors.toList()).contains(grupo)) {
						ls.add(grupo);
						//System.out.println(profesor + " = " + grupo);
						break;
					}
				}
			}
			Collections.sort(ls);
			r.put(i, ls);
			//System.out.println();
			i++;
		}
		return r;
	}
	
	public static Graph<String, DefaultEdge> apartadoB(Map<String, List<String>> data, Map<Integer, List<String>> horarios) {
		Graph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		
		for(String grupo: horarios.values().stream().flatMap(x -> x.stream()).collect(Collectors.toCollection(() -> new TreeSet<>()))) {
			graph.addVertex(grupo);
		}
		
		for(String profesor: data.keySet()) {
			List<String> grupos = data.get(profesor);
			// 0 1 2
			for (int i = 0; i < grupos.size()-1; i++) {
				graph.addEdge(grupos.get(i), grupos.get(i+1));
			}
		}
		
		Graphs2.toDot(graph, "ficheros/Ej2.dot",
				v -> v.toString(),
				e -> "",
				v -> getColorIf(v.toString(), horarios),
				e -> GraphColors.getColor(Color.black));
		
		return graph;
	}
	
	private static Map<String,Attribute> getColorIf(String v, Map<Integer, List<String>> horarios) {		
		List<Color> ls = List.of(Color.black, Color.red, Color.yellow, Color.blue);
		Color c = null;
		for(Integer key: horarios.keySet()) {
			if(horarios.get(key).contains(v)) {
				c = ls.get(key);
				break;
			}
		}
		
		String cl = c.toString();
		Map<String,Attribute> m = Map.of("color", DefaultAttribute.createAttribute(cl));		
		return m;
	}
	
}
