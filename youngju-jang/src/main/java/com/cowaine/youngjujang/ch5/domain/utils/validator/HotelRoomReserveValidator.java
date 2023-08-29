package com.cowaine.youngjujang.ch5.domain.utils.validator;

import com.cowaine.youngjujang.ch5.domain.dto.HotelRoomReserveRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

public class HotelRoomReserveValidator implements Validator {
     @Override
     public boolean supports(Class<?> clazz) {
          return HotelRoomReserveRequest.class.equals(clazz);
     }
     
     @Override
     public void validate(Object target, Errors errors) {
          HotelRoomReserveRequest request = HotelRoomReserveRequest.class.cast(target);
          
          if (Objects.isNull(request.getCheckInDate())) {
               errors.rejectValue("checkInDate", "NotNull", "checkInDate is null");
               return;
          }
          if (Objects.isNull(request.getCheckOutDate())) {
               errors.rejectValue("checkOutDate", "NotNull", "checkOutDate is null");
               return;
          }
          if (!request.getCheckInDate().isBefore(request.getCheckOutDate())) {
               errors.rejectValue("checkOutDate", "Constraint Error", "checkOutDate is earlier than checkInDate");
               return;
          }
     }
}
