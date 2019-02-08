package org.company.belili.models;

import java.util.Date;

/**
 * The type Pelicula.
 */
public class Pelicula {

    private int id;
    private String titulo;
    private int duracion;
    private String clasificacion;
    private String genero;
    private String imagen = "cinema.png"; // imagen por default
    private Date fechaEstreno;
    private String estatus = "Activa";

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets titulo.
     *
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets titulo.
     *
     * @param titulo the titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Gets duracion.
     *
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Sets duracion.
     *
     * @param duracion the duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Gets clasificacion.
     *
     * @return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Sets clasificacion.
     *
     * @param clasificacion the clasificacion
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * Gets genero.
     *
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Sets genero.
     *
     * @param genero the genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Gets imagen.
     *
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Sets imagen.
     *
     * @param imagen the imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Gets fecha estreno.
     *
     * @return the fecha estreno
     */
    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Sets fecha estreno.
     *
     * @param fechaEstreno the fecha estreno
     */
    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Gets estatus.
     *
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Sets estatus.
     *
     * @param estatus the estatus
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", genero='" + genero + '\'' +
                ", imagen='" + imagen + '\'' +
                ", fechaEstreno=" + fechaEstreno +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}
