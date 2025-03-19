package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.util.Objects;

public record Vehiculo(String marca, String modelo, String matricula) {
    private static final String ER_MARCA = "[A-Z][a-z]+";
    private static final String ER_MATRICULA = "\\d{4}[^\\W_AEIOUa-z]{3}";



    public Vehiculo{
        validarMarca(marca);
        validarModelo(modelo);
        validarMatricula(matricula);
    }

    private void validarMarca(String marca){
        Objects.requireNonNull("La marca no puede ser nula");
        if (!marca.matches(ER_MARCA)) {
            throw new IllegalArgumentException("La marca no es correcta");
        }
    }

    private void validarModelo(String modelo){
        Objects.requireNonNull("El modelo no puede ser nulo");
        if (!modelo.isBlank()) {
            throw new IllegalArgumentException("El modelo no es correcto");
        }
    }

    private void validarMatricula(String matricula){
        Objects.requireNonNull("La matricula no puede ser nula");
        if (!matricula.matches(ER_MATRICULA)) {
            throw new IllegalArgumentException("La matricula no es correcta");
        }
    }

    public static Vehiculo get(String matricula){
        return new Vehiculo("Seat", "Ibiza", "KDZ 1010");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo) && Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, matricula);
    }

    @Override
    public String toString() {
        return String.format("[marca=%s, modelo=%s, matricula=%s]", marca, modelo, matricula);
    }
}
