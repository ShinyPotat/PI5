package datos;

public class Amistad {
	
	public static Amistad ofFormat(Miembro m1, Miembro m2, String[] format) {
		return new Amistad(m1, m2, format);
	}
	
	private Miembro m1;
	private Miembro m2;
	
	private Amistad(Miembro m1, Miembro m2, String[] format) {
		super();
		this.m1 = m1;
		this.m2 = m2;
	}

	public Miembro getM1() {
		return m1;
	}

	public Miembro getM2() {
		return m2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m1 == null) ? 0 : m1.hashCode());
		result = prime * result + ((m2 == null) ? 0 : m2.hashCode());
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
		Amistad other = (Amistad) obj;
		if (m1 == null) {
			if (other.m1 != null)
				return false;
		} else if (!m1.equals(other.m1))
			return false;
		if (m2 == null) {
			if (other.m2 != null)
				return false;
		} else if (!m2.equals(other.m2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Amistad [m1=" + m1 + ", m2=" + m2 + "]";
	}
	
}
