package com.campusdual.classroom;


import com.campusdual.util.Utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        contacts.put(contact.getCode(), contact);
        System.out.println("Contacto añadido: " + contact);
    }

    public void showPhonebook() {
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos.");
        } else {
            for (Contact contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact(String code) {
        if (contacts.remove(code) != null) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("No se encontro el contacto con codigo: " + code);
        }
    }

    public void showContactMenu(String code) {
        Contact contact = contacts.get(code);
        if (contact == null) {
            System.out.println("Contacto no encontrado.");
            return;
        }

        int option;
        do {
            System.out.println("\nMenú de " + contact);
            System.out.println("1. Llamar a mi numero");
            System.out.println("2. Llamar a otro número");
            System.out.println("3. Ver detalles del contacto");
            System.out.println("0. Volver");
            option = Utils.integer("Selecciona una opcion: ");

            switch (option) {
                case 1: contact.callMyNumber();
                case 2: {
                    String number = Utils.string("Introduce numero a llamar: ");
                    contact.callOtherNumber(number);
                }
                case 3: contact.showContactDetails();
                case 0: System.out.println("Volviendo al menu principal...");
                default: System.out.println("Opción no válida.");
            }

        } while (option != 0);
    }

    public void mainMenu() {
        int option;

        do {
            System.out.println("\nAgenda Telefonica");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Seleccionar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("0. Salir");
            option = Utils.integer("Selecciona una opcion: ");

            switch (option) {
                case 1: {
                    String name = Utils.string("Nombre: ");
                    String surnames = Utils.string("Apellidos: ");
                    String phone = Utils.string("Telefono: ");
                    addContact(new Contact(name, surnames, phone));
                }
                case 2: showPhonebook();
                case 3: {
                    String code = Utils.string("Codigo del contacto: ");
                    showContactMenu(code);
                }
                case 4: {
                    String code = Utils.string("Codigo del contacto a eliminar: ");
                    deleteContact(code);
                }
                case 0: System.out.println("Saliendo de la agenda...");
                default: System.out.println("Opcion no valida.");
            }
        } while (option != 0);
    }

    public Map<String, Contact> getData() {
        return Collections.unmodifiableMap(contacts);
    }
}
