package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoException;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clientes {

    private ArrayList<Clientes> coleccionClientes;

    public Clientes(){
        coleccionClientes = new ArrayList<>();
    }

    public List<Clientes> get(){
        return new ArrayList<>(coleccionClientes);
    }

    public void insertar(Cliente cliente) throws TallerMecanicoException {
        Objects.requireNonNull("El cliente no puede ser nulo");
        if (coleccionClientes.contains(cliente)){
            throw new TallerMecanicoException("Ya existe un cliente con ese dni");
        }
        coleccionClientes.add(cliente);

    }

    public Cliente modificar(Cliente cliente, String nombre, String telefono){

    }

    public Cliente buscar(Cliente cliente){

    }

    public void borrar(Cliente cliente){

    }

}
