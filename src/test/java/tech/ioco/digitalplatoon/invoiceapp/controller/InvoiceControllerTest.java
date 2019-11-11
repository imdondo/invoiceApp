package tech.ioco.digitalplatoon.invoiceapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tech.ioco.digitalplatoon.invoiceapp.model.Invoice;
import tech.ioco.digitalplatoon.invoiceapp.service.InvoiceService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class InvoiceControllerTest {

    @InjectMocks
    private InvoiceController invoiceController;

    @MockBean
    private InvoiceService invoiceService;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void it_should_return_all_invoices() throws Exception {
        List<Invoice> invoiceList = new ArrayList<Invoice>();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Invoice first = new Invoice(1, "Lorem ipsum", 5, date);
        Invoice second = new Invoice(2, "Standard", 5, date);
        invoiceList.add(first);
        invoiceList.add(second);
        when(invoiceService.findAll()).thenReturn(invoiceList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/invoices")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize(2)));

    }

    @Test
    public void it_should_return_single_invoice() throws Exception {
        List<Invoice> invoiceList = new ArrayList<Invoice>();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Invoice first = new Invoice(1, "Lorem ipsum", 5, date);
        Invoice second = new Invoice(2, "Standard", 5, date);
        invoiceList.add(first);
        invoiceList.add(second);
        when(invoiceService.findById(1)).thenReturn(first);


        Invoice inv1 = invoiceService.findById(1L);

        verify(invoiceService).findById(1l);

        assertEquals(1l, inv1.getId());
    }

    @Test
    public void viewInvoiceShouldReturnInvoice() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Invoice first = new Invoice(1, "Lorem ipsum", 5, date);

        given(this.invoiceService.findById(1))
                .willReturn(first);

        mockMvc.perform(post("/api/invoices", 1L)
                .contentType("application/json")
                .param("invoiceId", String.valueOf(1))
                .content(mapper.writeValueAsString(first)))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidInput_viewInvoiceShould_thenReturns200() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Invoice first = new Invoice(1, "Lorem ipsum", 5, date);

        mockMvc.perform(post("/api/invoices", 1L)
                .contentType("application/json")
                .param("sendWelcomeMail", "true")
                .content(mapper.writeValueAsString(first)))
                .andExpect(status().isOk());

    }


}