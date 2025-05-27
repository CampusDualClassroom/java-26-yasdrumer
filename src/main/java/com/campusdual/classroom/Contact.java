package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {

    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode(name, surnames);
    }

    public String getCode() {
        return code;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    private String generateCode(String name, String surnames) {
        // Quitar tildes y convertir a minúscula
        String normalized = Normalizer.normalize(surnames.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\p{ASCII}]", "");

        String[] parts = normalized.trim().split("\\s+");

        if (parts.length == 1) {
            return (name.charAt(0) + parts[0]).toLowerCase();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(name.charAt(0)); // inicial del nombre
            sb.append(parts[0].charAt(0)); // inicial del primer apellido
            for (int i = 1; i < parts.length; i++) {
                sb.append(parts[i]); // resto de apellidos
            }
            return sb.toString().toLowerCase();
        }
    }

    @Override
    public void callMyNumber() {
        System.out.println(name + " " + surnames + " se está llamando a sí mismo al número " + phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println(name + " " + surnames + " está llamando al número " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + name);
        System.out.println("Apellidos: " + surnames);
        System.out.println("Teléfono: " + phone);
        System.out.println("Código: " + code);
    }

    // Sobreescritura deñ toString
    @Override
    public String toString() {
        return name + " " + surnames + " (" + code + ")";
    }
}