package tec.utpl.safety.supply.serviciosweb.servicios;


import java.util.List;

import tec.utpl.safety.supply.serviciosweb.entidad.Pedido;

public interface PedidoServicio {

    public List<Pedido> listarPedidos();
    public Pedido crearPedido(Pedido pedido);
    public Pedido obtenerPedido(Long id);
    public Pedido actualizarPedido(Pedido pedido);
    public Pedido eliminarPedido(Long id);
    
}
