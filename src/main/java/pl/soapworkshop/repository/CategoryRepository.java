package pl.soapworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.soapworkshop.entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //Find all Categories, excluding Shipment Category (id = 1)
    List<Category> findAllByIdGreaterThan(Integer id);

    List<Category> findAllByIdEquals(Integer id);

}
