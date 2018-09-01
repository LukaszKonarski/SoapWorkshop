package pl.soapworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.soapworkshop.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //This one works
    List<Product> findByCategories_Id(Integer id);

    //Works as well!!!
    @Query("select p from Product p join p.categories category where category.id = ?1")
    List<Product> findProductsByCategoryId(Integer id);


}
