package datos;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	
	public static Profesor ofFormat(String[] format) {
		return new Profesor(format);
	}
	
	private String name;
	private List<String> groups;
	
	private Profesor(String[] format) {
		super();
		this.name = format[0];
		this.groups = new ArrayList<>();
		for(String s: format[1].split(",")) {
			this.groups.add(s);
		}
	}

	public String getName() {
		return name;
	}

	public List<String> getGroups() {
		return groups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[name: " + name + ", groups:" + groups + "]";
	}
	
}
