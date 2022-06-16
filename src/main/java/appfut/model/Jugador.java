package appfut.model;

import java.util.Objects;

public class Jugador {
    private int idJugador;
    private int idEquipo;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int dorsal;
    private String nacionalidad;
    private String posicion;
    private int valorMercado;

    public Jugador(int idJugador, int idEquipo, String nombre, String apellido, String fechaNacimiento, int dorsal, String nacionalidad, String posicion, int valorMercado) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
    }

    public Jugador() {
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(int valorMercado) {
        this.valorMercado = valorMercado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return idJugador == jugador.idJugador && idEquipo == jugador.idEquipo && dorsal == jugador.dorsal && valorMercado == jugador.valorMercado && Objects.equals(nombre, jugador.nombre) && Objects.equals(apellido, jugador.apellido) && Objects.equals(fechaNacimiento, jugador.fechaNacimiento) && Objects.equals(nacionalidad, jugador.nacionalidad) && Objects.equals(posicion, jugador.posicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugador, idEquipo, nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + idJugador +
                ", idEquipo=" + idEquipo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", dorsal=" + dorsal +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", posicion='" + posicion + '\'' +
                ", valorMercado=" + valorMercado +
                '}';
    }
}

