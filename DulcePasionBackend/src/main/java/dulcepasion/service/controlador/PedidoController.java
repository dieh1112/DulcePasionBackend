package dulcepasion.service.controlador;

import dulcepasion.service.entity.dto.GenerarPedidoDTO;
import dulcepasion.service.entity.dto.PedidoConDetallesDTO;
import dulcepasion.service.servicio.PedidoService;
import dulcepasion.service.utlis.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


import java.util.List;

import dulcepasion.service.modelo.*;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {


	@Autowired
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }
    //Pedidos del usuario con sesión abierta
    @GetMapping("/misPedidos/{idCli}")
    public GenericResponse<List<PedidoConDetallesDTO>> devolverMisComprasConDetalle(@PathVariable int idCli){
        return this.service.devolverMisCompras(idCli);
    }
   //Generar pedido 
    @PostMapping
    public GenericResponse guardarPedido(@RequestBody GenerarPedidoDTO dto){
        return this.service.guardarPedido(dto);
    }
    //anular pedido
    @DeleteMapping("/{id}")
    public GenericResponse anularPedido(@PathVariable int id){
        return this.service.anularPedido(id);
    }
    //generar reporte 
    @GetMapping("exportInvoice")
    public ResponseEntity<Resource> exportInvoice(@RequestParam int idCli, @RequestParam int idOrden){
        return this.service.exportInvoice(idCli, idOrden);
    }
    
    
    //LISTADO BÁSICO
    @GetMapping(path="/{id}")
	public Optional<Pedido> buscarid(@PathVariable("id") int id){
		return service.buscarid(id);
	}
}
