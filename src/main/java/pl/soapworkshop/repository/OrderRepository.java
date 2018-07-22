package pl.soapworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.soapworkshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {


    Order findFirstByOrderByOrderIdDesc();
}
