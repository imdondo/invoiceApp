package tech.ioco.digitalplatoon.invoiceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ioco.digitalplatoon.invoiceapp.model.Invoice;
import tech.ioco.digitalplatoon.invoiceapp.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> list = new ArrayList<>();
        invoiceRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Invoice getInvoiceById(long id) {
        Invoice obj = invoiceRepository.findById(id).get();
        return obj;
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
        long id =invoice.getId();
        return  invoiceRepository.findById(id).get();
    }
}
