/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.complex;

import org.example.dto.Car;
import org.example.dto.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface CarMapper {

    @Mapping(source = "numberOfSeats", target = "seatCount", qualifiedByName = "<caret>")
    @Mapping(source = "manufacturingDate", target = "manufacturingYear")
    CarDto carToCarDto(Car car);

    @Named("doubleSeatCount")
    default int multiplyByFactor(Double input, int factor) {
        return (int) (input * 2);
    }

    @Named("numberToZero")
    default Long setToZero(int ignore) {
        return 0L;
    }

    @Named("someNamedAfterMapping")
    @AfterMapping
    default void someNamedAfterMapping(CarDto target) {
        target.setMake("...");
    }

}
