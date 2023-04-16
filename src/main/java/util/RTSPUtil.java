package util;

import java.awt.image.BufferedImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

/**
 *
 * @author ruang
 */
public class RTSPUtil {
    
    static public BufferedImage getImageFromEndpointRTSP(String endpoint) throws FFmpegFrameGrabber.Exception {
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(endpoint);
        // timeout de 1s
        grabber.setOption("timeout", "1000000");
        grabber.start();
        Frame frame = grabber.grabImage();
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage image = converter.convert(frame);
        grabber.stop();
        return image;
    }
    
}
