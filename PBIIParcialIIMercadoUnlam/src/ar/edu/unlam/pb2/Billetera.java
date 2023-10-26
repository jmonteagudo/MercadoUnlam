package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Billetera {

	private String nombre;
	private Set<Comercio> comercios;
	private Set<Consumidor> consumidores;
	private Map<MedioDePago, Integer> mediosDePago;
	private List<Compra> compras;
	
	public Billetera(String nombre) {
		this.nombre = nombre;
		this.comercios = new HashSet<>();
		this.consumidores = new TreeSet<>();
		this.mediosDePago = new HashMap<>();
		this.compras = new ArrayList<>();
	}

	public void agregarComercio(Comercio nuevo) {
		comercios.add(nuevo);
	}

	public Integer getCantidadDeComercios() {
		return this.comercios.size();
	}

	public void agregarConsumidor(Consumidor nuevo) {
		this.consumidores.add(nuevo);
	}

	public Integer getCantidadDeConsumidores() {
		return consumidores.size();
	}

	public void agregarMedioDePago(Integer dniDelConsumidor, MedioDePago nuevo) throws NoCoincideTitularException, DniInvalidoException {
		Consumidor consumidor = buscarConsumidor(dniDelConsumidor);
		if(consumidor == null) {
			throw new DniInvalidoException();
		}
		
		if(!consumidor.getNombre().equalsIgnoreCase(nuevo.getTitular())) {
			throw new NoCoincideTitularException();
		}
		
		mediosDePago.put(nuevo, dniDelConsumidor);
	}
	
	private Consumidor buscarConsumidor(Integer dni) {
		for(Consumidor actual: consumidores) {
			if(actual.getDni().equals(dni)) {
				return actual;
			}
		}
		return null;
	}

	public Integer getCantidadDeMediosDePago(Integer dni) {

		Integer cantidadDeMediosDePago = 0;
		for (Map.Entry<MedioDePago, Integer> actual : mediosDePago.entrySet()) {
		    if(dni.equals(actual.getValue())){
		    	cantidadDeMediosDePago++;
		    }
		}
		return cantidadDeMediosDePago;
	}

	public Compra generarCodigoQR(Long cuitDelComercio, Double importeDeCompra) {
		
		Comercio buscado = buscarComercio(cuitDelComercio);
		Compra nueva = new Compra(buscado, importeDeCompra);
		compras.add(nueva);
		return nueva;
	}
	
	private Comercio buscarComercio(Long cuitDelComercio) {
		for(Comercio actual: comercios) {
			if(actual.getCuit().equals(cuitDelComercio)) {
				return actual;
			}
		}
		return null;
	}

	public Consumidor getConsumidor(Integer dni) {
		return buscarConsumidor(dni);
	}

	public Boolean pagar(Compra codigoQR, MedioDePago medioPagador) {
		for(Compra actual: compras) {
			if(actual==codigoQR) {
				// ToDo: resta validar el saldo y actualizar el saldo en el caso de las cuentas
				codigoQR.setPagada(true);
				return true;
			}
		}
		return false;
	}
}
