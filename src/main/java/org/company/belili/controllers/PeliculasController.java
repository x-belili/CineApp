package org.company.belili.controllers;

import org.company.belili.models.Pelicula;
import org.company.belili.service.IPeliculasService;
import org.company.belili.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = {"/peliculas"})
public class PeliculasController {

    @Autowired
    private IPeliculasService iPeliculasService;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Pelicula> list = iPeliculasService.buscarTodas();
        model.addAttribute("peliculas", list);
        return "peliculas/listPeliculas";
    }

    @GetMapping("/create")
    public String crear() {
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String guardar(Pelicula pelicula,
                          BindingResult result,
                          RedirectAttributes attributes,
                          @RequestParam(value = "archivoImagen", required = true)
                                  MultipartFile multipartFile,
                          HttpServletRequest httpServletRequest) {

        if (result.hasErrors()) {
            System.out.println("error of binding");
            return "peliculas/formPelicula";
        }

        if (!multipartFile.isEmpty()) {
            String nombreImagen = Utileria.guardarImagen(multipartFile, httpServletRequest);
            pelicula.setImagen(nombreImagen);
        }

//        for (ObjectError error : result.getAllErrors()) {
//            System.out.println(error.getDefaultMessage());
//        }

        iPeliculasService.insertar(pelicula);

        System.out.println("pelicula -->" + pelicula);
//        return "peliculas/formPelicula";

        attributes.addFlashAttribute("mensaje", "El registro fue guardado");

        return "redirect:/peliculas/index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
