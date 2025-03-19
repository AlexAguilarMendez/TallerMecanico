package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Revision {
    private static final float PRECIO_HORA = 30F;
    private static final float PRECIO_DIA = 10F;
    private static final float PRECIO_MATERIAL = 1.5F;
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horas;
    private float precioMaterial;
    private Cliente cliente;


    public Revision(Cliente cliente, )
}
