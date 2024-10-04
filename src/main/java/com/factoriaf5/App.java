package com.factoriaf5;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Iniciar el servidor H2
        DatabaseConnection.startServer();

        // Crear la tabla de personas
        CreateTable.createPersonTable();

        // Insertar una persona
        PersonCRUD.insertPerson("Ali", 25);
        PersonCRUD.insertPerson("Mick", 22);

        // Leer todas las personas
        List<Person> persons = PersonCRUD.getAllPersons();

        // Verificar si hay personas en la lista antes de continuar
        if (!persons.isEmpty()) {
            // Obtener el ID de la primera persona
            int idToUpdate = persons.get(0).getId();  // Obtener el ID de ali y mick

            // Actualizar persona con el ID obtenido
            PersonCRUD.updatePerson(idToUpdate, "Pepe", 30);

            // Leer todas las personas nuevamente para verificar la actualización
            persons = PersonCRUD.getAllPersons();
            System.out.println("Lista de personas después de la actualización:");
            for (Person person : persons) {
                System.out.println("ID: " + person.getId() + ", Name: " + person.getName() + ", Age: " + person.getAge());
            }

            // Eliminar persona con el ID obtenido
            PersonCRUD.deletePerson(idToUpdate);
        } else {
            System.out.println("No hay personas en la base de datos.");
        }
    }
}

