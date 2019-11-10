package tech.ioco.digitalplatoon.invoiceapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceError {
    private Date timestamp;
    private String message;
}
