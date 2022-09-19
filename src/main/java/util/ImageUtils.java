package util;

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
    
}