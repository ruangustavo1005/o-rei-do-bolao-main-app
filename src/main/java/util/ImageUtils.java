package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author ruang
 */
public class ImageUtils {
    
    static public byte[] getBytesFromBufferedImage(BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, format, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    
    static public BufferedImage getBufferedImageFromBytes(byte[] bytes) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        return ImageIO.read(inputStream);
    }

    static public BufferedImage resizeKeepProportion(BufferedImage image, int maxDimension) {
        int originalWidth        = image.getWidth();
        int originalHeight       = image.getHeight();
        int maxOriginalDimension = Math.max(originalWidth, originalHeight);
        
        if (maxOriginalDimension > maxDimension) {
            int mdc                = NumberUtils.mdc(originalWidth, originalHeight);
            int fatorMultiplicacao = ((int) maxDimension / (maxOriginalDimension / mdc));
            int targetWidth        = originalWidth  / mdc * fatorMultiplicacao;
            int targetHeight       = originalHeight / mdc * fatorMultiplicacao;

            BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, targetWidth, targetHeight, null);
            graphics2D.dispose();
            return resizedImage;
        }
        
        return image;
    }
    
}