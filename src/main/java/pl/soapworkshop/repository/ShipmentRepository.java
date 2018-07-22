package pl.soapworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.soapworkshop.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}
