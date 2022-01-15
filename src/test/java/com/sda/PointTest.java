package com.sda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void addingPositiveValuesShouldReturnPositiveResult(){
        //given
        Point point = new Point(10, 10);
        Point vector = new Point(2, 3);

        //when
        Point result = point.add(vector);

        //then
        Point expectedPoint = new Point(12, 13);
        Assertions.assertEquals(expectedPoint, result);
    }

}