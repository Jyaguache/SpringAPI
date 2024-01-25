package tec.utpl.safety.supply.serviciosweb.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tec.utpl.safety.supply.serviciosweb.entidad.Pedido;
import tec.utpl.safety.supply.serviciosweb.servicios.PedidoServicio;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    @GetMapping
    public ResponseEntity<List<Pedido>> listProducts(){
        List<Pedido> pedidos = new ArrayList<>();
        pedidos = pedidoServicio.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> obtenerPedido(@PathVariable("id") Long id){
        Pedido product = pedidoServicio.obtenerPedido(id);
        if (null == product){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido){
        Pedido pedidoCreado = pedidoServicio.crearPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCreado);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable("id") Long id){
        Pedido productDelete = pedidoServicio.eliminarPedido(id);

        if(productDelete!=null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Pedido eliminado");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pedido> updateProduct(@PathVariable("id") Long id,  @RequestBody Pedido pedido){
    	pedido.setId(id);
        Pedido pedidoDB = pedidoServicio.actualizarPedido(pedido);

        if (pedidoDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedidoDB);
    }

}
