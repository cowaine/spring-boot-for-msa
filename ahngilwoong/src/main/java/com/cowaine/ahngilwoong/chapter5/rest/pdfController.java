package com.cowaine.ahngilwoong.chapter5.rest;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download/pdf")
public class pdfController {

//    @GetMapping(value="/statementA", produces="application/pdf")
//    public ResponseEntity<byte[]> statementDownloadA(){
//        String filePath = "pdf/statement.pdf";
//        try (InputStream inputStream = new ClassPathResource(filePath).getInputStream();){
//            byte[] data = StreamUtils.copyToByteArray(inputStream);
//            HttpHeaders header = new HttpHeaders();
//            header.setContentType(MediaType.APPLICATION_PDF);
//            header.setContentDispositionFormData("Content-Disposition", "statement.pdf");
//
//            return ResponseEntity.status(HttpStatus.OK)
//                .header(header.toString())
//                .body(data);
//        } catch (IOException e) {
//            throw new FileDownloadException("file download error", e);
//        }
//    }
//
//    @GetMapping(value="/statementB", produces="application/pdf")
//    public void statementDownloadB(HttpServletResponse response){
//        String filePath = "pdf/statement.pdf";
//        try (InputStream inputStream = new ClassPathResource(filePath).getInputStream(); OutputStream os=response.getOutputStream();){
//            response.setStatus(HttpStatus.OK.value());
//            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
//            response.setHeader("Content-Disposition", "filename=statement.pdf");
//            StreamUtils.copy(inputStream, os);
//        } catch (IOException e) {
//            throw new FileDownloadException("file download error", e);
//        }
//    }
}
