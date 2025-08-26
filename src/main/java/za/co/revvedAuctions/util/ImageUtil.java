package za.co.revvedAuctions.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtil {

    public static byte[] compressImage(byte[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(data.length)) {
            byte[] buffer = new byte[4 * 1024];
            int length;
            while (!deflater.finished()) {
                length = deflater.deflate(buffer);
                byteArrayOutputStream.write(buffer, 0, length);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error during compression", e);
        } finally {
            deflater.end();
        }
    }

    public static byte[] decompressImage(byte[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        Inflater inflater = new Inflater();
        inflater.setInput(data);

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(data.length)) {
            byte[] buffer = new byte[4 * 1024];
            int length;
            while (!inflater.finished()) {
                length = inflater.inflate(buffer);
                byteArrayOutputStream.write(buffer, 0, length);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException | DataFormatException e) {
            throw new RuntimeException("Error during decompression", e);
        } finally {
            inflater.end();
        }
    }
}
