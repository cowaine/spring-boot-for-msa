package com.cowaine.youngjujang.ch5.domain.controller;

import com.cowaine.youngjujang.ch5.domain.utils.exception.FileDownloadException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

@RestController
public class ReservationController {
     
     //localhost:8080/hotels/12/rooms/abc/reservations?page=1&size=50&sort=reservationId,desc&sort=reservationDate,desc
     @GetMapping("/hotels/{hotelId}/rooms/{roomNumber}/reservations")
     public List<Long> getReservationsByPaging(
          @PathVariable Long hotelId,
          @PathVariable String roomNumber,
          Pageable pageable){
          System.out.println("Page param : " + pageable.getPageNumber());
          System.out.println("Size param : " + pageable.getPageSize());
          pageable.getSort().stream()
               .forEach(order -> {
                    System.out.println("Sort param: " + order.getProperty() + " : " + order.getDirection());
               });
          return Collections.emptyList();
     }
     
     // 이미지 파일 내려받기 1. HttpMessageConverter 사용하는 방법
//     @GetMapping("/hotels/{hotelId}/rooms/{roomNumber}/reservations/{reservationId}")
     public ResponseEntity<byte[]> getInvoice(@PathVariable Long hotelId,
                                              @PathVariable String roomNumber,
                                              @PathVariable Long reservationId){
          String filePath = "pdf/test.pdf";
          
          try(InputStream inputStream = new ClassPathResource(filePath).getInputStream()) {
               byte[] bytes = StreamUtils.copyToByteArray(inputStream);
               return new ResponseEntity<>(bytes, HttpStatus.OK);
          }catch (Throwable th){
               th.printStackTrace();
               throw new FileDownloadException("file download Error");
          }
     }
     
     // 이미지 파일 내려받기 2. HttpServletResponse 사용하는 방법
     @GetMapping(value = "/hotels/{hotelId}/rooms/{roomNumber}/reservations/{reservationId}",
     produces = "application/pdf")
     public void downloadInvoice(@PathVariable Long hotelId, // 별도의 HttpServletResponse 응답객체를 사용하므로 return void
                                 @PathVariable String roomNumber,
                                 @PathVariable Long reservationId,
                                 HttpServletResponse response){
          String filePath = "pdf/test.pdf";
          try(InputStream is = new ClassPathResource(filePath).getInputStream();
              OutputStream os = response.getOutputStream()){
               response.setStatus(HttpStatus.OK.value());
               response.setContentType(MediaType.APPLICATION_PDF_VALUE);
               response.setHeader("Content-Disposition", "filename=test.png");
               
               StreamUtils.copy(is, os); // is 에서 읽어오고, os 에 데이터를 쓴다
               // 내부 버퍼만큼 데이터르르 읽고 쓰는 과정을 반복함
               // 내부버퍼 : 크기가 고정되어, 큰 파일을 서비스해도 JVM메모리를 효율적으로 사용 가능
          } catch (Throwable th){
               th.printStackTrace();
               throw new FileDownloadException("file download Error");
          };
     }
}
