package org.company.belili.service;

import org.company.belili.models.Banner;

import java.util.List;

public interface IBannersService {

    void insertar(Banner banner);

    List<Banner> buscarTodos();
}
