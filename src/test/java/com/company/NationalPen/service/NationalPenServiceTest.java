package com.company.NationalPen.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NationalPenServiceTest {


    NationalPenService service = new NationalPenService();

    @Test
    void getMaterialsSize() {
        service.add();
        Assertions.assertEquals(3, service.getMaterials().size());
    }

    @Test
    void getMaterialsElement() {
        service.add();
        Assertions.assertEquals(service.getMaterials().get(0).toString(), service.getMaterials().get(0).toString());
    }
}