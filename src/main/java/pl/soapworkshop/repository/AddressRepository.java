package pl.soapworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.soapworkshop.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address getAddressByOrderId();
}
