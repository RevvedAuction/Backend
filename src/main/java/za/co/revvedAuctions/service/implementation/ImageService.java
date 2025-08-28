package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.repository.CarRepository;
import za.co.revvedAuctions.util.ImageUtil;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private CarRepository repository;

    public String uploadImage(String carVIN, MultipartFile file) {
        try {
            Optional<Car> optionalCar = repository.findById(carVIN);

            if (optionalCar.isEmpty()) {
                return "Car with VIN " + carVIN + " not found!";
            }

            Car existingCar = optionalCar.get();

            // Compress and update the image
            Car updatedCar = new Car.Builder()
                    .copy(existingCar)
                    .setMediaBase64(ImageUtil.compressImage(file.getBytes()))
                    .build();

            repository.save(updatedCar);

            return "Image uploaded successfully for VIN: " + carVIN;

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image", e);
        }
    }

    public byte[] getImage(String carVIN) {
        Optional<Car> optionalCar = repository.findById(carVIN);

        if (optionalCar.isEmpty()) {
            throw new RuntimeException("Car with VIN " + carVIN + " not found!");
        }

        Car car = optionalCar.get();

        if (car.getMedia() == null || car.getMedia().length == 0) {
            throw new RuntimeException("No image found for VIN: " + carVIN);
        }

        // Decompress and return the image
        return ImageUtil.decompressImage(car.getMedia());
    }
}
