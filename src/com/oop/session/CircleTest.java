package com.oop.session;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @org.junit.jupiter.api.Test
    void circumference() {
        Circle circulo = new Circle(5);
        assertEquals(0, Math.floor(circulo.circumference() - 31));
    }
}