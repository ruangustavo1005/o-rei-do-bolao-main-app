package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ImageIcon;

/**
 *
 * @author ruang
 */
public class ImageUtils {
    
    static public byte[] getBytes(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }
    
    static public ImageIcon getImageIcon(byte[] bytes) {
        return new ImageIcon(bytes);
    }
    
    static public ImageIcon getImageIcon(File file) throws IOException {
        return new ImageIcon(ImageUtils.getBytes(file));
    }
    
    static public BufferedImage resizeKeepProportion(BufferedImage image, int maxDimension) {
        int originalWidth        = image.getWidth();
        int originalHeight       = image.getHeight();
        int maxOriginalDimension = Math.max(originalWidth, originalHeight);
        
        if (maxOriginalDimension > maxDimension) {
            int mdc                 = NumberUtils.mdc(originalWidth, originalHeight);
            int fatorMultiplicacao  = ((int) maxDimension / (maxOriginalDimension / mdc));
            int targetWidth         = originalWidth  / mdc * fatorMultiplicacao;
            int targetHeight        = originalHeight / mdc * fatorMultiplicacao;

            BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, targetWidth, targetHeight, null);
            graphics2D.dispose();
            return resizedImage;
        }
        
        return image;
    }
    
}