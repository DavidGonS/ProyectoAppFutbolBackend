package appfut.model;

import java.util.Objects;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private String estadio;
    private int puntuacion;
    private int idLiga;

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

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return idEquipo == equipo.idEquipo && puntuacion == equipo.puntuacion && idLiga == equipo.idLiga && Objects.equals(nombre, equipo.nombre) && Objects.equals(estadio, equipo.estadio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipo, nombre, estadio, puntuacion, idLiga);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo=" + idEquipo +
                ", nombre='" + nombre + '\'' +
                ", estadio='" + estadio + '\'' +
                ", puntuacion=" + puntuacion +
                ", idLiga=" + idLiga +
                '}';
    }
}
