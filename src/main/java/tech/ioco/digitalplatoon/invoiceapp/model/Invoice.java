package tech.ioco.digitalplatoon.invoiceapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String client;
    private long vatRate;
    private Date invoiceDate;

    public BigDecimal getSubTotal() {

        return null;
    }

    public BigDecimal getVat() {

        return null;
    }

    public BigDecimal getTotal() {

        return null;
    }
}
