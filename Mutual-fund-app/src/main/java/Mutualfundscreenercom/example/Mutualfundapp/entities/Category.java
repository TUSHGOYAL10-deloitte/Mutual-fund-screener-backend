package Mutualfundscreenercom.example.Mutualfundapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String companyImg;
    private  String name;
    private  String day;
    private  String dayGrowth;
    private  String year;
    private  String yearGrowth;
    private  String years;
    private  String yearsGrowth;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MutualFund> mutualFunds;

}
