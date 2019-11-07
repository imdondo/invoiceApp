package tech.ioco.digitalplatoon.invoiceapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class LineItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long quantity;
    private String description;
    private BigDecimal unitPrice;

    public BigDecimal getLineItemTotal(){

        return null;
    }
}
