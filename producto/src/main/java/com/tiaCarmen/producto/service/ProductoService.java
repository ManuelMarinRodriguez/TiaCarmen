package com.tiaCarmen.producto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.tiaCarmen.producto.model.Producto;
import com.tiaCarmen.producto.repository.ProductoDao;
import com.tiaCarmen.producto.sto.ConsultaProductoDTO;
import com.tiaCarmen.producto.sto.ProductoDTO;
import com.tiaCarmen.producto.util.ProductosUtils;
import com.tiaCarmen.producto.util.Constantes;

/**
 * 
 * @author mmarinro
 *
 */
@Service
public class ProductoService {
	
	@Autowired
	
	ProductoDao produuctoDao;
	/**
	 * Metodo para consutlar el producto por 
	 * codigo de barra
	 * @param json
	 * @return
	 */
	public ProductoDTO validaProducto(String json) {
		ProductoDTO rsp = new ProductoDTO();
		ConsultaProductoDTO conlPro = new ConsultaProductoDTO();
		Gson gson = new Gson();
		try {
			json = json.replace("\\", "");
			json = json.replace("{\"json\":[\"", "");
			json = json.replace("]}", "");
			
			System.out.println("Verificar Json : " + json);
			conlPro = gson.fromJson(json, ConsultaProductoDTO.class);
			List<Producto> entityProducto = new ArrayList<Producto>();
		
			
			entityProducto = produuctoDao.findByProducto(conlPro.getCodigoBarra());
			
			
			
			
			if (entityProducto.size() > 0 ) {
				rsp.setNombre(entityProducto.get(0).getNombre());
				String PreioProducto = ProductosUtils.calcularPrecio(entityProducto.get(0).getPrecioVenta(), conlPro.getCantidadProducto() );
				rsp.setPrecio(PreioProducto);
				
			}else {
				
				rsp.setNombre(Constantes.no_existe_producto);
				rsp.setPrecio(Constantes.no_existe_producto);
			}
			
			
		} catch (Exception e) {
			
		}
		return rsp;
	}

}
