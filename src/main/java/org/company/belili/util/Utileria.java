package org.company.belili.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Utileria.
 */
public class Utileria {

    /**
     * Gets next days.
     *
     * @param count the count
     * @return the next days
     */
    public static List<String> getNextDays(int count) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Today is Date
        Date start = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, count); //Next N days from now
        Date endDate = calendar.getTime();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(start);
        List<String> nextDays = new ArrayList<String>();
        while (!gregorianCalendar.getTime().after(endDate)) {
            Date date = gregorianCalendar.getTime();
            gregorianCalendar.add(Calendar.DATE, 1);
            nextDays.add(simpleDateFormat.format(date));
        }
        return nextDays;
    }

    public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
        // Obtenemos el nombre original del archivo
        String nombreOriginal = multiPart.getOriginalFilename();
        nombreOriginal = nombreOriginal.replace(" ", "-");
        String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
        // Obtenemos la ruta ABSOLUTA del directorio images
        // apache-tomcat/webapps/cineapp/resources/images/
        String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
        try {
            // Formamos el nombre del archivo para guardarlo en el disco duro
            File imageFile = new File(rutaFinal + nombreFinal);
            System.out.println("path of image --> " + imageFile);
            // Aqui se guarda fisicamente el archivo en el disco duro
            multiPart.transferTo(imageFile);
            return nombreFinal;
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }

    //Metodo para generar una cadena de longitud de N caracteres aleatorios
    public static String randomAlphaNumeric(int count) {
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * CARACTERES.length());
            builder.append(CARACTERES.charAt(character));
        }
        return builder.toString();
    }

}
