package com.cowaine.dingcook.chapter06.domain;

import java.util.StringJoiner;
import lombok.Getter;

@Getter
public class HotelRoomNumber {

    private static final String DELIMITER = "-";

    private String buildingCode;
    private Long roomNumber;

    public HotelRoomNumber(String buildingCode, Long roomNumber) {
        this.buildingCode = buildingCode;
        this.roomNumber = roomNumber;
    }

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
