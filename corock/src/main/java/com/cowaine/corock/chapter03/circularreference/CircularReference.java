package com.cowaine.corock.chapter03.circularreference;

import org.springframework.stereotype.Service;

// @Service
public class CircularReference {

    private CircularService circularService;

    public CircularReference(CircularService circularService) {
        this.circularService = circularService;
    }

}
