package ar.edu.unlam.pb2;

public interface Pagadora {

	Boolean pagar(Persona vendedor, Double importe);

	void setSaldo(Double d);

	Long getNumero();

	String getTitular();

	Double getSaldo();

}
