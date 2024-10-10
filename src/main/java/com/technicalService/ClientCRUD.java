package com.technicalService;

import java.util.ArrayList;
import java.util.List;


public class ClientCRUD {

    private static List<Client> clientes = new ArrayList<>(); // In-memory storage
  
   // Insertar un cliente
    public static void insertClient(int ID_solicitud, String nombre, String apellidos) {
        int ID_cliente= clientes.size() + 1;
        Client newClient = new Client(ID_cliente,ID_solicitud, nombre, apellidos);
        clientes.add(newClient);
        System.out.println("Cliente creado correctamente: " + newClient);
    }
     

        // Obtener todos los clientes
        public static List<Client> getAllClientes() {
        return new ArrayList<>(clientes); // Return a copy of the list
        }

     

        
    
}

