package org.iesalandalus.programacion.tallermecanico.vista;

import java.util.HashMap;
import java.util.Map;

public enum Opcion {
    INSERTAR_CLIENTE(11,"Insertar cliente."),
    BUSCAR_CLIENTE(12,"Buscar cliente."),
    BORRAR_CLIENTE(13,"Borrar cliente."),
    LISTAR_CLIENTES(14,"Listar clientes."),
    MODIFICAR_CLIENTE(15,"Mofidicar cliente."),
    INSERTAR_VEHICULO(21,"Insertar vehiculo."),
    BUSCAR_VEHICULO(22,"Buscar vehiculo."),
    BORRAR_VEHICULO(23,"Borrar vehiculo."),
    LISTAR_VEHICULOS(24,"Listar vehiculos."),
    INSERTAR_REVISION(31,"Insertar revisión"),
    BUSCAR_REVISION(32,"Buscar revisión."),
    BORRAR_REVISION(33,"Borrar revisión"),
    LISTAR_REVISIONES(34,"Listar revisiones"),
    LISTAR_REVISIONES_CLIENTE(35,"Listar revisiones de un cliente"),
    LISTAR_REVISIONES_VEHICULO(36,"Listar revisiones de un vehículo."),
    AÑADIR_HORAS_REVISION(37,"Añadir horas a una revisión"),
    AÑADIR_PRECIO_MATERIAL_REVISION(38,"Añadir precio del material a una revision"),
    CERRAR_REVISION(39,"Cerrar revisión."),
    SALIR(0,"Salir.");



    private final int numeroOpcion;
    private final String texto;
    private static final Map<Integer, Opcion> opciones = new HashMap<>();

    static {
        for (Opcion opcion : values()) {
            opciones.put(opcion.numeroOpcion, opcion);
        }
    }

    private Opcion(int numeroOpcion, String texto){
        this.numeroOpcion = numeroOpcion;
        this.texto = texto;
    }
    public static boolean esValida(int numeroOpcion){return opciones.containsKey(numeroOpcion);}

    public static Opcion get(int numeroOpcion){
        if (!esValida(numeroOpcion)){
            throw new IllegalArgumentException("El número de la opción no es correcto.");
        }
        return opciones.get(numeroOpcion);
    }

    @Override
    public String toString() {
        return String.format("[numeroOpcion=%s, texto=%s]", numeroOpcion, texto);
    }
}
