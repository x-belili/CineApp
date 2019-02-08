package org.company.belili.controllers;

import org.company.belili.models.Noticia;
import org.company.belili.service.INoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Noticias controller.
 */
@Controller
@RequestMapping(value = {"/noticias"})
public class NoticiasController {

    @Autowired
    private INoticiaService iNoticiaService;

    /**
     * Crear string.
     *
     * @return the string
     */
    @GetMapping(value = {"/create"})
    public String crear() {
        return "noticias/formNoticia";
    }

    @PostMapping(value = {"/save"})
    public String guardar(Noticia noticia) {

        // Pendiente: Guardar el objeto noticia en la BD

        iNoticiaService.guardar(noticia);

        return "noticias/formNoticia";
    }

}
