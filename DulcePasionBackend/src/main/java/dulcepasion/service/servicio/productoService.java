package dulcepasion.service.servicio;

import dulcepasion.service.Interfaces.ProductoRepository;
import dulcepasion.service.utlis.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static dulcepasion.service.utlis.Global.*;

@Service
@Transactional
public class productoService {
    private final ProductoRepository repository;

    public productoService(ProductoRepository repository) {
        this.repository = repository;
    }
    
    // ListarProductos
    public GenericResponse listarproductoRecomendados(){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA,
        		this.repository.listarproductoRecomendados());
    }
        
    public GenericResponse listarproducto(){
            return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA,
            		this.repository.listarproducto());
        
    //listar productosrecomendados
    }
    // Listar por categoria
    public GenericResponse listarproductoPorCategoria(int idC){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, 
        		this.repository.listarprodcutoPorCategoria(idC));
    }
}
