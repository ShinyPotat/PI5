package tests;

import java.util.ArrayList;
import java.util.List;

import datos.Profesor;
import us.lsi.common.Files2;

public class Test2 {
	
	public static void execute() {
		List<String> lines = Files2.linesFromFile("ficheros/PI5Ej2DatosEntrada.txt");
		List<Profesor> profesores = new ArrayList<Profesor>();
		for(String line: lines) {
			String[] format = line.split(": ");
			Profesor p = Profesor.ofFormat(format);
			profesores.add(p);
		}
		System.out.println(profesores);
	}
	
	public static void main(String[] args) {
		execute();

	}

}
