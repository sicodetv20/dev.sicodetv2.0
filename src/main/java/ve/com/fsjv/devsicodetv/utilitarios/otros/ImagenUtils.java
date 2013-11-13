/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utilitarios.otros;

import java.awt.image.BufferedImage;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.resizers.Resizers;

/**
 *
 * @author Juan Clase para el manejo de las imagenes
 */
public class ImagenUtils {

    public static BufferedImage imagenZoomRecortada(BufferedImage imagenEscalar, int zoom) {
        BufferedImage imagen;
        try {
            imagen = Thumbnails.of(imagenEscalar)
                    .sourceRegion(Positions.CENTER, (imagenEscalar.getWidth() / zoom), (imagenEscalar.getHeight() / zoom))
                    .scale(zoom)
                    .resizer(Resizers.BICUBIC)
                    .asBufferedImage();
        } catch (Exception e) {
            e.printStackTrace();;
            imagen = null;
        }
        return imagen;
    }

    public static BufferedImage redimensionarImagen(BufferedImage imagenRecortar, int width, int height) {
        BufferedImage imagen;
        try {
            imagen = Thumbnails.of(imagenRecortar)
                    .size(width, height)
                    .asBufferedImage();
        } catch (Exception e) {
            e.printStackTrace();
            imagen = null;
        }
        return imagen;
    }

    public static int guardaImagen(BufferedImage imagen, String ruta) {
        int resultado = 1;
        try {
            Thumbnails.of(imagen)
                .size(imagen.getWidth(), imagen.getHeight())
                .toFile(ruta);
        } catch (Exception e) {
               e.printStackTrace();
               resultado=0;
        }
        return resultado;
    }
}
