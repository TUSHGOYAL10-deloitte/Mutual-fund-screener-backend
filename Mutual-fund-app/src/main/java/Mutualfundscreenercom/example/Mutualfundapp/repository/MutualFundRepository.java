package Mutualfundscreenercom.example.Mutualfundapp.repository;

import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//
//@Repository
public interface MutualFundRepository extends CrudRepository<MutualFund,Integer> {
    MutualFund getByName(String name);
    MutualFund getById(Integer id);
}
