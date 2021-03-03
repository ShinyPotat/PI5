package datos;

public class Miembro {

	public static Miembro ofFormat(String[] format) {
		return new Miembro(format);
	}
	
	public static Miembro ofName(String name) {
		return new Miembro(name);
	}
	
	private String name;

	private Miembro(String name) {
		super();
		this.name = name;
	}
	
	private Miembro(String[] format) {
		super();
		this.name = format[0];
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Miembro other = (Miembro) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
