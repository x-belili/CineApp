package org.company.belili.service;

import org.company.belili.models.Pelicula;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodas();

    Pelicula buscarPorId(int id);

    void insertar(Pelicula pelicula);
}
