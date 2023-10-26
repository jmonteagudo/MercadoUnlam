package ar.edu.unlam.pb2;

public abstract class Tarjeta extends MedioDePago {
	protected Long numero;
	protected String fechaDeVencimiento;
	protected Integer codigoDeSeguridad;
	protected Double saldo;
	
	final Integer CANTIDAD_DE_DIGITOS_DE_LA_TARJETA = 16;

	protected void setCodigoDeSeguridad(Integer codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;	
	}


	protected void setFechaDeVencimiento(String fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
		
	}


	protected void setTitular(String titular) {
		this.titular = titular;	
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;		
	}

	public Long getNumero() {
		return this.numero;
	}

	public Integer getCodigoDeSeguridad() {
		return this.codigoDeSeguridad;
	}

	public String getFechaDeVencimiento() {
		return this.fechaDeVencimiento;
	}

	public abstract Double getSaldo();


	protected void setNumero(Long numero) throws NumeroDeTarjetaInvalidoException {
 
		String numeroDeTarjetaEnString = numero.toString();
		if(numeroDeTarjetaEnString.length()!=CANTIDAD_DE_DIGITOS_DE_LA_TARJETA) {
			throw new NumeroDeTarjetaInvalidoException();
		}
		this.numero = numero;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Tarjeta other = (Tarjeta) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
}
