package com.campusdual.classroom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(this.originalOut);
        System.setErr(this.originalErr);
    }


    @Test
    void testCallMyNumber() {
        Contact c = new Contact("Name","Sur Name", "111222333");
        c.callMyNumber();
        assertTrue(this.outContent.toString().contains(c.getName()), "Not show contact name");
        assertTrue(this.outContent.toString().contains(c.getSurnames()), "Not show contact surname");
        assertTrue(this.outContent.toString().contains(c.getPhone()), "Not show phone number");
    }

    @Test
    void testCallOtherNumber() {
        Contact c = new Contact("Name","Sur Name", "111222333");
        String phone= "999888777";
        c.callOtherNumber(phone);
        assertTrue(this.outContent.toString().contains(c.getName()), "Not show contact name");
        assertTrue(this.outContent.toString().contains(c.getSurnames()), "Not show contact surname");
        assertTrue(this.outContent.toString().contains(phone), "Not show phone number to call");
    }

    @Test
    void testShowContactDetails() {
        Contact c = new Contact("Name","Sur Name", "111222333");
        c.showContactDetails();
        assertTrue(this.outContent.toString().contains(c.getName()), "Not show contact name");
        assertTrue(this.outContent.toString().contains(c.getSurnames()), "Not show contact surname");
        assertTrue(this.outContent.toString().contains(c.getPhone()), "Not show phone number");
        assertTrue(this.outContent.toString().contains(c.getCode()), "Not show contact code");
    }

    @Test
    void testContactCodeGenerator() {
        Contact c1 = new Contact("Javier", "López", "654321321");
        assertEquals("jlopez", c1.getCode(), "Contact code not match with expected value");
        Contact c2 = new Contact("Carlos", "Fernández-Simón", "654321321");
        assertEquals("cfernandez-simon", c2.getCode(), "Contact code not match with expected value");
        Contact c3 = new Contact("Jose Manuel", "Soria", "654321321");
        assertEquals("jsoria", c3.getCode(), "Contact code not match with expected value");
        Contact c4 = new Contact("Santiago","Fernández Rocha", "654321321");
        assertEquals("sfrocha", c4.getCode(), "Contact code not match with expected value");
        Contact c5 = new Contact("Esteban","Serrano del Río", "654321321");
        assertEquals("esdelrio", c5.getCode(), "Contact code not match with expected value");
        Contact c6 = new Contact("Fernando Miguel","Juan de los Santos Requejo León", "654321321");
        assertEquals("fjdelossantosrequejoleon", c6.getCode(), "Contact code not match with expected value");
    }
}