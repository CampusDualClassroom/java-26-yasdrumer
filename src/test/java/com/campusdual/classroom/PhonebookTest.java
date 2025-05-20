package com.campusdual.classroom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {
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
    void testAddContactToPhonebook() {
        Contact c = new Contact("Name","Sur Name", "111222333");
        Phonebook p = new Phonebook();
        int prevContactNumber = p.getData().size();
        p.addContact(c);
        int actContactNumber = p.getData().size();
        assertEquals(prevContactNumber+1, actContactNumber);
        assertEquals(c, p.getData().get(c.getCode()));

    }

    @Test
    void testRemoveContactFormPhonebook() {
        Contact c = new Contact("Name","Sur Name", "111222333");
        Phonebook p = new Phonebook();
        p.addContact(c);
        int prevContactNumber = p.getData().size();
        p.deleteContact(c.getCode());
        int actContactNumber = p.getData().size();
        assertEquals(prevContactNumber-1, actContactNumber);
        assertNull(p.getData().get(c.getCode()));
    }

    @Test
    void testShowPhonebook() {
        Contact c1 = new Contact("Name","Sur Name", "111222333");
        Contact c2 = new Contact("Eman","Rus Eman", "333444555");
        Phonebook p = new Phonebook();
        p.addContact(c1);
        p.addContact(c2);
        p.showPhonebook();
        this.outContent.toString().contains(c1.getName());
        this.outContent.toString().contains(c1.getSurnames());
        this.outContent.toString().contains(c1.getPhone());
        this.outContent.toString().contains(c1.getCode());
        this.outContent.toString().contains(c2.getName());
        this.outContent.toString().contains(c2.getSurnames());
        this.outContent.toString().contains(c2.getPhone());
        this.outContent.toString().contains(c2.getCode());

    }
}