package ar.edu.unlam.pb2;

public class Cuenta extends MedioDePago {
	protected String entidad;

	protected Double saldo;
	
	public String getEntidad() {
		return this.entidad;
	}
	
	public Double getSaldo() {
		return saldo;
	}
}
