package ar.edu.unlam.pb2;

public class Comercio {

	private Long cuit;
	private String nombre;
	
	private final Integer CANTIDAD_DE_DIGITOS_DEL_CUIT = 11;
	private final String COMIENZO_CUIT = "30";
	
	public Comercio(Long cuit, String nombre) throws CuitInvalidoException {
		this.setCuit(cuit);
		this.setNombre(nombre);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuit == null) ? 0 : cuit.hashCode());
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
		Comercio other = (Comercio) obj;
		if (cuit == null) {
			if (other.cuit != null)
				return false;
		} else if (!cuit.equals(other.cuit))
			return false;
		return true;
	}

	protected void setCuit(Long cuit) throws CuitInvalidoException {
		 
		String cuitEnString = cuit.toString();
		if(cuitEnString.length()!=CANTIDAD_DE_DIGITOS_DEL_CUIT || cuitEnString.substring(0, 2) == COMIENZO_CUIT) {
			throw new CuitInvalidoException();
		}
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCuit() {
		return cuit;
	}
	
	
}
