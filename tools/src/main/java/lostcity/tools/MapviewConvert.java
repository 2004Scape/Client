package lostcity.tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MapviewConvert {
	public static void main(String[] args) {
		// read in a file named "map-$width-$height-rgb.raw"
		// convert it to a file named "map-$width-$height.png"
		// we can extract the dimensions from the file name
		// the rgb indicates it's already in a 24-bit format so we don't have to do any conversion

		if (args.length != 1) {
			System.err.println("Usage: MapviewConvert <filename>");
			System.exit(1);
		}

		String filename = args[0];
		String[] parts = filename.split("-");
		if (parts.length != 4) {
			System.err.println("Filename must be of the form map-$width-$height-rgb.raw");
			System.exit(1);
		}

		int width = Integer.parseInt(parts[1]);
		int height = Integer.parseInt(parts[2]);

		System.out.println("Converting " + filename + " to map-" + width + "-" + height + ".png");

		try {
			byte[] src = Files.readAllBytes(Paths.get(filename));
			BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			int index = 0;
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					int r = src[index++] & 0xFF;
					int g = src[index++] & 0xFF;
					int b = src[index++] & 0xFF;
					int rgb = (r << 16) | (g << 8) | b;
					img.setRGB(x, y, rgb);
				}
			}

			ImageIO.write(img, "png", Paths.get("map-" + width + "-" + height + ".png").toFile());
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}