package com.cowaine.dingcook.chapter05.domain.hotelroom.validator;

import com.cowaine.dingcook.chapter05.domain.hotelroom.request.HotelRoomReserveRequest;
import java.util.Objects;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
        }

        if (Objects.isNull(request.getCheckOutDate())) {
            errors.rejectValue("checkOutDate", "NotNull", "checkOutDate is null");
        }

        if (request.getCheckInDate().compareTo(request.getCheckOutDate()) >= 0) {
            errors.rejectValue("checkOutDate", "Constraint Error",
                "checkOutDate is earlier than checkInDate");
            return;
        }
    }
}
