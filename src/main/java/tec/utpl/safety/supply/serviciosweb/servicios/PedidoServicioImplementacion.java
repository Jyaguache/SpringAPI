package tec.utpl.safety.supply.serviciosweb.servicios;

import lombok.RequiredArgsConstructor;
import tec.utpl.safety.supply.serviciosweb.entidad.Pedido;
import tec.utpl.safety.supply.serviciosweb.repositorio.PedidoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServicioImplementacion implements PedidoServicio{

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.findAll();
    }

    @Override
    public Pedido obtenerPedido(Long id) {
        return pedidoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Pedido crearPedido(Pedido product) {
        return pedidoRepositorio.save(product);
    }
    
    @Override
    public Pedido actualizarPedido(Pedido pedido) {
    	Pedido pedidoBD = obtenerPedido(pedido.getId());

        if (null == pedidoBD){
            return null;
        }
        pedidoBD.setNombre(pedido.getNombre());
        pedidoBD.setCantidad(pedido.getCantidad());
        pedidoBD.setPrecio(pedido.getPrecio());
        pedidoBD.setTotalItem(pedido.getTotalItem());
        return pedidoRepositorio.save(pedidoBD);
    }
    

    @Override
    public Pedido eliminarPedido(Long id) {
        Pedido pedidoBD = obtenerPedido(id);

        if (null == pedidoBD){
            return null;
        }

        pedidoRepositorio.delete(pedidoBD);
        return pedidoBD;
    }
    
}
