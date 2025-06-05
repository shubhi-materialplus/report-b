package com.budgetpulse.report_generation.Controller;

import com.budgetpulse.report_generation.service.PdfReportService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportDownloadController {

    private final PdfReportService pdfReportService;

    public ReportDownloadController(PdfReportService pdfReportService) {
        this.pdfReportService = pdfReportService;
    }

    @GetMapping("/download/sample.pdf")
    public ResponseEntity<byte[]> downloadDynamicPdf() {
        byte[] pdfBytes = pdfReportService.generatePdf();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("sample.pdf").build());

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
