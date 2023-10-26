package ar.edu.unlam.pb2;

public class Compra {
	
	private Comercio comercio;
	private Double importe;
	private Boolean pagada;

	public Compra(Comercio comercio, Double importeDeCompra) {
		this.comercio = comercio;
		this.importe = importeDeCompra;

	}

	public Comercio getComercio() {
		return comercio;
	}

	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Boolean getPagada() {
		return pagada;
	}

	public void setPagada(Boolean pagada) {
		this.pagada = pagada;
	}

}
