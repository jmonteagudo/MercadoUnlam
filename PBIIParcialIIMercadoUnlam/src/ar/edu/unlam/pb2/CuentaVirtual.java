package ar.edu.unlam.pb2;

public class CuentaVirtual extends Cuenta implements Transferible {
	
	private String cvu;
	
	private final Integer LARGO_CVU = 23;

	public CuentaVirtual(String cvu, String entidad, String titular) throws CVUInvalidoException{
		this.setCvu(cvu);
		this.entidad = entidad;
		this.titular = titular;
	}
	
	private void setCvu(String cvu) throws CVUInvalidoException{
		if(cvu.length()!=LARGO_CVU) {
			throw new CVUInvalidoException();
		}
		this.cvu = cvu;
	}

	@Override
	public String getNumero() {
		return this.cvu;
	}

	@Override
	public void depositar(Double importe) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean extraer(Double importe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cvu == null) ? 0 : cvu.hashCode());
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
		CuentaVirtual other = (CuentaVirtual) obj;
		if (cvu == null) {
			if (other.cvu != null)
				return false;
		} else if (!cvu.equals(other.cvu))
			return false;
		return true;
	}
	
	

}
