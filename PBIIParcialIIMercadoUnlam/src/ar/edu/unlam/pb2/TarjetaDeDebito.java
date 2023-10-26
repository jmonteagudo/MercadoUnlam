package ar.edu.unlam.pb2;

public class TarjetaDeDebito extends Tarjeta implements Pagadora {
	


	public TarjetaDeDebito(Long numero, String titular, String fechaDeVencimiento,
			Integer codigoDeSeguridad) throws NumeroDeTarjetaInvalidoException {
		this.setNumero(numero);
		this.setTitular(titular);
		this.setFechaDeVencimiento(fechaDeVencimiento);
		this.setCodigoDeSeguridad(codigoDeSeguridad);
		this.setSaldo(0.0);
	}
	


	@Override
	public Boolean pagar(Persona vendedor, Double importe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getSaldo() {
		return this.saldo;
	}



}
