package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;

import datos.Amistad;
import datos.Miembro;
import ejercicios.Ejercicio1;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.common.Tuple2;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;


public class Test1 {
	
	public static void execute() {
		System.out.println("==== EJERCICIO 1 ====");
		SimpleGraph<Miembro, Amistad> graph = GraphsReader.newGraph("ficheros/PI5Ej1DatosEntrada.txt",
											Miembro::ofFormat,
											Amistad::ofFormat,
											Graphs2::simpleGraph);
		
		System.out.println("Apartado a)\n");
		Set<Miembro> resA1 = Ejercicio1.apartadoANinguno(graph);
		System.out.println("Los miembros con 0 amigos son: " + resA1);
		Tuple2<Integer, Set<Miembro>> resA2 = Ejercicio1.apartadoAMayor(graph);
		System.out.println("Los miembros con más amigos ("+ resA2.v1 + ") son: " + resA2.v2);
		Graphs2.toDot(graph, "ficheros/Ej1ApA.dot",
				v -> String.format("%s(%d amigos)", v.getName(), graph.edgesOf(v).size()),
				e -> "",
				v -> getColorIf(v, resA1, resA2.v2),
				e -> GraphColors.getColor(Color.black));
		
		System.out.println("\nApartado b)\n");
		List<Miembro> resB = Ejercicio1.apartadoB(graph, Miembro.ofName("Juan"), Miembro.ofName("Ramiro"));
		System.out.println(resB);
		Graphs2.toDot(graph, "ficheros/Ej1ApB.dot",
				v -> String.format("%s(%d amigos)", v.getName(), graph.edgesOf(v).size()),
				e -> "",
				v -> GraphColors.getColorIf(Color.blue, Color.gray, resB.contains(v)),
				e -> GraphColors.getColor(Color.gray));
		
		System.out.println("\nApartado c)\n");
		List<Set<Miembro>> resC = Ejercicio1.apartadoC(graph);
		
		List<Color> colorList = new ArrayList<>();
		colorList.add(Color.black);
		colorList.add(Color.red);
		colorList.add(Color.blue);
		colorList.add(Color.yellow);
		colorList.add(Color.green);
		colorList.add(Color.cyan);
		colorList.add(Color.orange);
		int i = 0;
		for(Set<Miembro> set: resC) {
			System.out.format("Grupo %s (%d usuario):\n",colorList.get(i),set.size());
			System.out.println(set + "\n");
			i++;
		}
		Graphs2.toDot(graph, "ficheros/Ej1ApC.dot",
				v -> String.format("%s", v.getName()),
				e -> "",
				v -> getColorIf(v, resC, colorList),
				e -> getColorIf(e.getM1(), resC, colorList));
		
		System.out.println("\nApartado d)\n");
		Set<Miembro> resD = Ejercicio1.apartadoD(graph);
		System.out.println(resD);
		Graphs2.toDot(graph, "ficheros/Ej1ApD.dot",
				v -> String.format("%s", v.getName()),
				e -> "",
				v -> GraphColors.getColorIf(Color.blue, Color.gray, resD.contains(v)),
				e -> GraphColors.getColor(Color.gray));
	}
	
	private static Map<String,Attribute> getColorIf(Miembro v, Set<Miembro> ninguno, Set<Miembro> maximo) {		
		Color c = Color.black;
		if(ninguno.contains(v)) {
			c = Color.gray;
		}else if(maximo.contains(v)) {
			c = Color.red;
		}	
		
		String cl = c.toString();
		Map<String,Attribute> m = Map.of("color", DefaultAttribute.createAttribute(cl));		
		return m;
	}
	
	private static Map<String,Attribute> getColorIf(Miembro v, List<Set<Miembro>> ls, List<Color> colorList) {		
		Color c = null;
		for (int i = 0; i < ls.size(); i++) {
			if(ls.get(i).contains(v)) {
				c = colorList.get(i);
				break;
			}
		}
		
		String cl = c.toString();
		Map<String,Attribute> m = Map.of("color", DefaultAttribute.createAttribute(cl));		
		return m;
	}

	public static void main(String[] args) {
		execute();

	}

}
