package tec.utpl.safety.supply.serviciosweb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tec.utpl.safety.supply.serviciosweb.entidad.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
