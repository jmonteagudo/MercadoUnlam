package ar.edu.unlam.pb2;

public class CuentaBancaria extends Cuenta implements Transferible {

	private String cbu;
	
	private final Integer LARGO_CBU = 20;
	
	public CuentaBancaria(String cbu, String entidad, String titular) throws CBUInvalidoException {
		this.setCbu(cbu);
		this.entidad = entidad;
		this.titular = titular;
	}

	private void setCbu(String cbu) throws CBUInvalidoException{
		if(cbu.length()!=LARGO_CBU) {
			throw new CBUInvalidoException();
		}
		this.cbu = cbu;
	}

	@Override
	public String getNumero() {
		return this.cbu;
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
		result = prime * result + ((cbu == null) ? 0 : cbu.hashCode());
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
		CuentaBancaria other = (CuentaBancaria) obj;
		if (cbu == null) {
			if (other.cbu != null)
				return false;
		} else if (!cbu.equals(other.cbu))
			return false;
		return true;
	}
	
	

}
