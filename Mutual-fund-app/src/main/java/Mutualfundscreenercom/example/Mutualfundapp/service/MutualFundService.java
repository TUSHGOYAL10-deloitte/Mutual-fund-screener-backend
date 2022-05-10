package Mutualfundscreenercom.example.Mutualfundapp.service;

import Mutualfundscreenercom.example.Mutualfundapp.entities.Category;
import Mutualfundscreenercom.example.Mutualfundapp.entities.MutualFund;
import Mutualfundscreenercom.example.Mutualfundapp.repository.CategoryRepository;
import Mutualfundscreenercom.example.Mutualfundapp.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MutualFundService {
    @Autowired
    MutualFundRepository mutualFundRepository;

    public List<MutualFund> getAllMutualFundsService() {
        List<MutualFund> mutualFunds = new ArrayList<>();
        mutualFundRepository.findAll().iterator().forEachRemaining(mutualFunds::add);
        return mutualFunds;
    }

    public ResponseEntity<?> getMutualFundService(Integer mutualFundId) {
        if (mutualFundId != null) {
            MutualFund mutualFund = mutualFundRepository.getById(mutualFundId);
            if (mutualFund != null) {
                return ResponseEntity.ok().body(mutualFund);
            }
            else {
                return ResponseEntity.status(404).body("This Mutual Fund does not exist");
            }
        }
        return ResponseEntity.status(404).body("provide correct name");
    }

    public ResponseEntity<?> addMutualFundService(MutualFund mutualFund) {
        if (mutualFund != null) {
            mutualFundRepository.save(mutualFund);
            return ResponseEntity.ok().body("Mutual Fund Added Successfully!");
        }
        return ResponseEntity.status(404).body("provide correct name");
    }

    public ResponseEntity<?> updateMutualFundService(MutualFund mutualFund) {
        if (mutualFund != null) {
            MutualFund fetchMutualFund = mutualFundRepository.getByName(mutualFund.getName());
            if (fetchMutualFund == null) {
                return ResponseEntity.status(404).body("request admin to add this Mutual Fund!");
            }
            mutualFund.setId(fetchMutualFund.getId());
            mutualFundRepository.save(mutualFund);
            return ResponseEntity.ok().body("Mutual Fund Updated Successfully!");
        } else {
            return ResponseEntity.status(404).body("some thing wrong with mutual fund data provided");
        }
    }


}
