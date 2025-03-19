package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.util.Objects;

public class Cliente {
    private static final String ER_NOMBRE = "[A-Z][a-z]+(?: [A-Z][a-z]+)*";
    private static final String ER_DNI = "\\d{8}[A-Z]";
    private static final String ER_Telefono = "\\d{9}";
    private String nombre;
    private String dni;
    private String telefono;

    public Cliente(String nombre, String dni, String telefono){
        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
    }

    public Cliente(Cliente cliente){
        Objects.requireNonNull("No se puede copiar un cliente nulo");
        nombre = cliente.nombre;
        dni = cliente.dni;
        telefono = cliente.telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Objects.requireNonNull("El nombre no puede ser nulo");
        if (!nombre.matches(ER_NOMBRE)) {
            throw new IllegalArgumentException("El nombre no es válido");
        }
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    private void setDni(String dni) {
        Objects.requireNonNull("El dni no puede ser nulo");
        if (!dni.matches(ER_DNI)) {
            throw new IllegalArgumentException("El dni no es válido");
        }
        if (!comprobarLetrasDNI(dni)){
            throw new IllegalArgumentException("La letra no es correcta");
        }
        this.dni = dni;
    }

    private boolean comprobarLetrasDNI(String dni){
        String letrasDNi = "T, R, W, A, G, M, Y, F, P, D, X, B, N, J, Z, S, Q, V, H, L, C, K, E";
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = dni.charAt(8);
        return letra == letrasDNi.charAt(numero % 23);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Objects.requireNonNull("El telefono no puede ser nulo");
        if (!telefono.matches(ER_Telefono)) {
            throw new IllegalArgumentException("El telefono no es válido");
        }
        this.telefono = telefono;
    }

    public Cliente get(String dni){
        return new Cliente("Antonio Stiuca", dni, "123456789");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(dni, cliente.dni) && Objects.equals(telefono, cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni, telefono);
    }

    @Override
    public String toString() {
        return String.format("[nombre=%s, dni=%s, telefono=%s]", nombre, dni, telefono);
    }
}
