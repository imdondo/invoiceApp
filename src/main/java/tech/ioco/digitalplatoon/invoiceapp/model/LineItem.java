package tech.ioco.digitalplatoon.invoiceapp.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Entity
@Getter
@Setter
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long invoiceId;
    private long quantity;
    private String description;
//    private BigDecimal unitPrice=new  BigDecimal(String.valueOf(getUnitPrice())).setScale(2, RoundingMode.HALF_UP);

    public BigDecimal getLineItemTotal() {

        return null;
    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
