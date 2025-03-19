package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoException;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehiculos {

    private ArrayList<Vehiculo> coleccionVehiculos;

    public Vehiculos() {
        coleccionVehiculos = new ArrayList<>();
    }

    public List<Vehiculo> get() {
        return new ArrayList<>(coleccionVehiculos);
    }

    public void insertar(Vehiculo vehiculo) throws TallerMecanicoException {
        Objects.requireNonNull(vehiculo, "No se puede insertar un vehículo nulo.");
        if (coleccionVehiculos.contains(vehiculo)) {
            throw new TallerMecanicoException("Ya existe un vehículo con esa matrícula.");
        }
        coleccionVehiculos.add(vehiculo);
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "No se puede buscar un vehículo nulo.");
        int indice = coleccionVehiculos.indexOf(vehiculo);
        return (indice == -1) ? null : coleccionVehiculos.get(indice);
    }

    public void borrar(Vehiculo vehiculo) throws TallerMecanicoException {
        Objects.requireNonNull(vehiculo, "No se puede borrar un vehículo nulo.");
        if (!coleccionVehiculos.contains(vehiculo)) {
            throw new TallerMecanicoException("No existe ningún vehículo con esa matrícula.");
        }
        coleccionVehiculos.remove(vehiculo);
    }

}
