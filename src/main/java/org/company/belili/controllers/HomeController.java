package org.company.belili.controllers;

import org.company.belili.models.Pelicula;
import org.company.belili.service.IBannersService;
import org.company.belili.service.IPeliculasService;
import org.company.belili.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Home controller.
 */
@Controller
public class HomeController {

    @Autowired
    private IBannersService serviceBanners; // Ejercicio : Solucion

    @Autowired
    private IPeliculasService iPeliculasService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Go home string.
     *
     * @return the string
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goHome() {
        return "home";
    }

    /**
     * Buscar string.
     *
     * @param fecha the fecha
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public String buscar(@RequestParam(value = "fecha", required = true) String fecha,
                         Model model) {

        List<String> listaFechas = Utileria.getNextDays(4);
        System.out.println(listaFechas);

        List<Pelicula> peliculas = iPeliculasService.buscarTodas();
        model.addAttribute("fechas", listaFechas);
        model.addAttribute("fechaBusqueda", fecha);
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("banners", serviceBanners.buscarTodos()); // Ejercicio : Solucion

        System.out.println("fecha --> " + fecha);
        return "home";
    }

    /**
     * Mostrar principal string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarPrincipal(Model model) {

        List<String> listaFechas = Utileria.getNextDays(4);
        System.out.println(listaFechas);

        List<Pelicula> peliculas = iPeliculasService.buscarTodas();
//		peliculas.add("Rapido y furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
        model.addAttribute("fechas", listaFechas);
        model.addAttribute("fechaBusqueda", simpleDateFormat.format(new Date()));
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("banners", serviceBanners.buscarTodos()); // Ejercicio : Solucion

        return "home";
    }

    /**
     * Mostrar detalle string.
     *
     * @param model      the model
     * @param idPelicula the id pelicula
     * @param fecha      the fecha
     * @return the string
     */
//    @RequestMapping(value = "/detail/{id}/{fecha}")
    @RequestMapping(value = "/detail")
//    public String mostrarDetalle(Model model, @PathVariable(value = "id") int idPelicula,
//                                 @PathVariable(value = "fecha") String fecha) {
    public String mostrarDetalle(Model model,
                                 @RequestParam(value = "idMovie", required = true) int idPelicula,
                                 @RequestParam(value = "fecha", required = true) String fecha) {
        System.out.println("id pelicula " + idPelicula);
        System.out.println("fecha pelicula " + fecha);

//        String tituloPelicula = "Rapidos y furiosos";
//        int duracion = 136;
//        double precioEntrada = 50;
//
//        model.addAttribute("titulo", tituloPelicula);
//        model.addAttribute("duracion", duracion);
//        model.addAttribute("precio", precioEntrada);

        model.addAttribute("pelicula", iPeliculasService.buscarPorId(idPelicula));

        return "detalle";
    }

}
