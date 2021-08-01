package com.tiaCarmen.venta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.tiaCarmen.venta.Util.Constantes;
import com.tiaCarmen.venta.Util.Utils;
import com.tiaCarmen.venta.dto.PagoBoletaDTO;
import com.tiaCarmen.venta.dto.PagoFacturaDTO;
import com.tiaCarmen.venta.dto.ProductoDTO;
import com.tiaCarmen.venta.dto.VentaDTO;
import com.tiaCarmen.venta.model.Boleta;
import com.tiaCarmen.venta.model.Factura;
import com.tiaCarmen.venta.model.Producto;
import com.tiaCarmen.venta.model.Venta;
import com.tiaCarmen.venta.repository.BoletaDao;
import com.tiaCarmen.venta.repository.DetalleVoucherDao;
import com.tiaCarmen.venta.repository.FacturaDao;
import com.tiaCarmen.venta.repository.ProductoDao;
import com.tiaCarmen.venta.repository.VentaDao;
import com.tiaCarmen.venta.repository.VoucherDao;

/**
 * 
 * @author msagredo
 *
 */
@Service
public class VentaService {

    @Autowired
    VentaDao ventaDao;
    
    @Autowired
    BoletaDao boletaDao;

    @Autowired
    ProductoDao productoDao;
    
    @Autowired
    DetalleVoucherDao detalleVoucherDao;
    
    @Autowired
    VoucherDao voucherDao;
    
    @Autowired
    FacturaDao facturaDao;
    
    /**
     * Clase para poder rescatar la venta a 
     * traves del numero de Boleta
     * 
     * @param numero
     * @return
     */
    public VentaDTO getVenta(Long numero) {

        var venta = new VentaDTO();
    
        try {

            var entityVenta = ventaDao.findByNumero(numero);
         
            if (entityVenta != null) {
                venta = new VentaDTO(entityVenta);
                if (entityVenta.getTipo().equals("1")) {
                	venta.setTipoVenta("Boleta");
				}else {
					venta.setTipoVenta("Factura");
				}
                var entitiesProductos = productoDao.findByVoucherId(entityVenta.getVoucherId());

                for (Producto entityProducto : entitiesProductos) {
                	String nombre = entityProducto.getNombre();
                	double Cantidad = cantidadVentaProducto(numero, nombre);
                	
                    var producto = new ProductoDTO(entityProducto, Cantidad);
                	venta.setProducto(producto);
	
                    
                }
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return venta;
    }

    /**
     * Metodo que devuelve la cantidad del producto vendido
     * 
     * @param numero
     * @param nombre
     * @return
     */
    private double cantidadVentaProducto(Long numero, String nombre) {
    	
    	var detalleVou = detalleVoucherDao.findByDetalleVoucherId(numero, nombre);
    	double Paso = detalleVou.get(0).getCantidad();
    	
		return Paso;
	}

    /**
     * Agrega la venta en la BD
     * @param json
     * @return
     */
	public String agregarVenta(String json) {

        VentaDTO rsp = new VentaDTO();
        Gson gson = new Gson();
        String Guardado = Constantes.exito_guardar_venta;
        try {
            json = json.replace("\\", "");
            json = json.replace("{\"json\":[\"", "");
            json = json.replace("]}", "");

            System.out.println("Verificar Json Final : " + json);
            rsp = gson.fromJson(json, VentaDTO.class);

            var numero = ventaDao.getNumero();

            Venta nuevaVenta = new Venta(numero, rsp.monto, rsp.tipoVenta, rsp.voucherId);
            ventaDao.save(nuevaVenta);

        } catch (Exception e) {
            System.out.println(e);
            Guardado = Constantes.error_guardar_venta;
        }
        return Guardado;
    }

	
	/**
	 * Metodo para poder pagar la Boleta
	 * 
	 * @param json
	 * @return
	 */
	public String pagarBoleta(String json) {
		
		PagoBoletaDTO rsp = new PagoBoletaDTO();
		Gson gson = new Gson();
		String Pagado = Constantes.exito_pagar_boleta;
		
		 try {
	            json = json.replace("\\", "");
	            json = json.replace("{\"json\":[\"", "");
	            json = json.replace("]}", "");

	            System.out.println("Verificar Json Final : " + json);
	            rsp = gson.fromJson(json, PagoBoletaDTO.class);
	            Long NomeroBoleta = rsp.numeroVenta;
	            var PagarBoleta = ventaDao.findByVenta(NomeroBoleta);
	          
	            if (PagarBoleta.size() > 0) {
					System.out.println("Puede realizar Compra");
					var numero = boletaDao.getBoleta();
					Long numeroBoleta = Utils.ValidarVacio(numero);
					Boleta nuevaVentaBoleta = new Boleta(numeroBoleta, rsp.numeroVenta);
					ventaDao.pagarBoleta(NomeroBoleta);
					boletaDao.save(nuevaVentaBoleta);
					
				}else {
					System.out.println("NO realizar Compra");
					Pagado = Constantes.error_pagar_boleta;
				}
	            
	          

	        } catch (Exception e) {
	            System.out.println(e);
	            Pagado = Constantes.error_pagar_boleta;
	        }
		
		
		return Pagado;
	}

	/**
	 * Metodo para poder pagar la factura
	 * 
	 * @param json
	 * @return
	 */
	public String pagarFactura(String json) {
		
		PagoFacturaDTO rsp = new PagoFacturaDTO();
		Gson gson = new Gson();
		String Pagado = Constantes.exito_pagar_Factura;
		
		 try {
	            json = json.replace("\\", "");
	            json = json.replace("{\"json\":[\"", "");
	            json = json.replace("]}", "");

	            System.out.println("Verificar Json Final : " + json);
	            rsp = gson.fromJson(json, PagoFacturaDTO.class);
	            Long NomeroBoleta = rsp.numeroVenta;
	            String rutEmpresa = rsp.rutEmpresa;
	            var PagarFactura = ventaDao.findByVenta(NomeroBoleta);
	          
	            if (PagarFactura.size() > 0) {
					System.out.println("Puede realizar Compra");
					var numero = facturaDao.getFactura();
					Long numeroBoleta = Utils.ValidarVacio(numero);
					Factura nuevaVentaFactura = new Factura(numeroBoleta, NomeroBoleta, rutEmpresa);
					ventaDao.pagarBoleta(NomeroBoleta);
					facturaDao.save(nuevaVentaFactura);
					
				}else {
					System.out.println("NO realizar Compra");
					Pagado = Constantes.error_pagar_Factura;
				}
	            
	          

	        } catch (Exception e) {
	            System.out.println(e);
	            Pagado = Constantes.error_pagar_Factura;
	        }
		
		
		return Pagado;
	}

	
}
