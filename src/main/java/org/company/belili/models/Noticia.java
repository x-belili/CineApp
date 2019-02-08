package org.company.belili.models;

import java.util.Date;

/**
 * The type Noticia.
 */
public class Noticia {

    private Integer id;
    private String titulo;
    private Date date;
    private String detalle;
    private String estatus;

    /**
     * Instantiates a new Noticia.
     */
    public Noticia() {
        this.date = new Date();
        this.estatus = "Activa";
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
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
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets detalle.
     *
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Sets detalle.
     *
     * @param detalle the detalle
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
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
        return "Noticia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", date=" + date +
                ", detalle='" + detalle + '\'' +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}
