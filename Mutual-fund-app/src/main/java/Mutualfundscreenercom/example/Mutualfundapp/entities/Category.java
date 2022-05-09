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
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int category_id;
    private String name;
    private String details;
    private boolean active;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MutualFund> mutualFunds=new ArrayList<>();
}
