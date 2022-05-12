package Mutualfundscreenercom.example.Mutualfundapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.engine.spi.CascadeStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "mutual_funds")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class MutualFund{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String total_invested;
    private String current_valuation;
    private String net_profit;
    private String absolute_profit;
    private String total_installments;
    private String internal_roi;
    private String sip_start_date;
    private String sip_end_date;

    private Boolean is_active=true;
}
