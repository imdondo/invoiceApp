package tech.ioco.digitalplatoon.invoiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ioco.digitalplatoon.invoiceapp.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
