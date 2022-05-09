package Mutualfundscreenercom.example.Mutualfundapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.spi.CascadeStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MutualFunds")
public class MutualFund {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private String fund_details;
    private int price;
    private boolean active;

}
