package com.cowaine.joisfe.part6.domain;

import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HotelRoomNumber {

    private static final String DELIMITER = "-";

    private String buildingCode;
    private Long roomNumber;

    public static final HotelRoomNumber parse(String roomNumberId) {

        String[] tokens = roomNumberId.split(DELIMITER);
        if (tokens.length != 2) {
            throw new IllegalArgumentException("invalid roomNumberId format");
        }

        return new HotelRoomNumber(tokens[0], Long.parseLong(tokens[1]));
    }

    @Override
    public String toString() {
        return new StringJoiner(DELIMITER)
            .add(buildingCode)
            .add(roomNumber.toString())
            .toString();
    }
}