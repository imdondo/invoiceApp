package tech.ioco.digitalplatoon.invoiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ioco.digitalplatoon.invoiceapp.model.Invoice;
import tech.ioco.digitalplatoon.invoiceapp.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    //Fetches all invoices
    @GetMapping
    public List<Invoice> viewAllInvoices() {
        return invoiceService.getAllInvoices();
    }
    //Fetches invoice by id
    @GetMapping(value = "/{id}")
//    Take note for some reason this does not a parameter according to the spec
    public Invoice viewInvoice(@PathVariable final long id){
        return invoiceService.getInvoiceById(id);
    }
    //Creates a new invoice
    @PostMapping
    public Invoice addInvoice(@RequestBody final Invoice invoice) {
        invoiceService.addInvoice(invoice);
        return invoiceService.getInvoiceById(invoice.getId());
    }

}
