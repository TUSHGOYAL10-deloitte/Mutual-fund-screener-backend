package Mutualfundscreenercom.example.Mutualfundapp.repository;

import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
    Category getByName(String name);
    Category getByCategoryId(Integer id);
    Boolean existsByName(String name);

}
