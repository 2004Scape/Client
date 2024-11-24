import jagex2.client.GameShell;
import jagex2.client.InputTracking;
import jagex2.config.Component;
import jagex2.config.*;
import jagex2.dash3d.CollisionMap;
import jagex2.dash3d.World;
import jagex2.dash3d.World3D;
import jagex2.dash3d.entity.*;
import jagex2.dash3d.type.Ground;
import jagex2.datastruct.JString;
import jagex2.datastruct.LinkList;
import jagex2.graphics.*;
import jagex2.io.*;
import jagex2.sound.Wave;
import jagex2.wordenc.WordFilter;
import jagex2.wordenc.WordPack;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.zip.CRC32;

public class Playground extends GameShell {
    public static void main(String[] args) {
        try {
            signlink.startpriv(InetAddress.getByName("w1.225.2004scape.org"));

            Playground app = new Playground();
            app.initApplication(789, 532);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static int portOffset;

	@Override
	public URL getCodeBase() {
		if (signlink.mainapp != null) {
			return signlink.mainapp.getCodeBase();
		}

		try {
			if (super.frame != null) {
				return new URL("http://w1.225.2004scape.org:" + (portOffset + 80));
			}
		} catch (@Pc(21) Exception ex) {
		}

		return super.getCodeBase();
	}

	private final CRC32 crc32 = new CRC32();
	private final int[] archiveChecksum = new int[9];

	private PixFont fontPlain11;
	private PixFont fontPlain12;
	private PixFont fontBold12;
	private PixFont fontQuill8;

    int eyeX = 0;
    int eyeY = 0;
    int eyeZ = 0;
    int eyePitch = 0;
    int eyeYaw = 0;

    int modifier = 2;

    Model model = null;
    int modelId = 0;
    int modelX = 0;
    int modelY = 0;
    int modelZ = 420;
    int modelYaw = 0;

    @Override
    protected void load() {
        try {
			int retry = 5;
			this.archiveChecksum[8] = 0;
			while (this.archiveChecksum[8] == 0) {
				this.drawProgress("Connecting to fileserver", 10);

				try {
					DataInputStream stream = this.openUrl("crc" + (int) (Math.random() * 9.9999999E7D));
					Packet checksums = new Packet(new byte[36]);
					stream.readFully(checksums.data, 0, 36);
					for (int i = 0; i < 9; i++) {
						this.archiveChecksum[i] = checksums.g4();
					}
					stream.close();
				} catch (IOException ex) {
					for (int i = retry; i > 0; i--) {
						this.drawProgress("Error loading - Will retry in " + i + " secs.", 10);

						try {
							Thread.sleep(1000L);
						} catch (Exception ignored) {
						}
					}

					retry *= 2;
					if (retry > 60) {
						retry = 60;
					}
				}
			}

            Jagfile title = this.loadArchive("title", this.archiveChecksum[1], "title screen", 10);
            this.fontPlain11 = new PixFont(title, "p11");
            this.fontPlain12 = new PixFont(title, "p12");
            this.fontBold12 = new PixFont(title, "b12");
            this.fontQuill8 = new PixFont(title, "q8");

            Jagfile config = this.loadArchive("config", this.archiveChecksum[2], "config", 15);
            Jagfile inter = this.loadArchive("interface", this.archiveChecksum[3], "interface", 20);
            Jagfile media = this.loadArchive("media", this.archiveChecksum[4], "2d graphics", 30);
            Jagfile models = this.loadArchive("models", this.archiveChecksum[5], "3d graphics", 40);
            Jagfile textures = this.loadArchive("textures", this.archiveChecksum[6], "textures", 60);
            Jagfile wordenc = this.loadArchive("wordenc", this.archiveChecksum[7], "chat system", 65);
            Jagfile sounds = this.loadArchive("sounds", this.archiveChecksum[8], "sound effects", 70);

            Pix3D.unpackTextures(textures);
            Pix3D.setBrightness(0.8);
            Pix3D.initPool(20);

            Model.unpack(models);
            AnimBase.unpack(models);
            AnimFrame.unpack(models);

            SeqType.unpack(config);
            LocType.unpack(config);
            FloType.unpack(config);
            ObjType.unpack(config);
            NpcType.unpack(config);
            IdkType.unpack(config);
            SpotAnimType.unpack(config);
            VarpType.unpack(config);

            byte[] data = sounds.read("sounds.dat", null);
            Packet soundDat = new Packet(data);
            Wave.unpack(soundDat);

			PixFont[] fonts = new PixFont[] { this.fontPlain11, this.fontPlain12, this.fontBold12, this.fontQuill8 };
			Component.unpack(inter, media, fonts);

            WordFilter.unpack(wordenc);

            this.drawArea.bind();
            Pix3D.init2D();

            this.model = new Model(this.modelId);
            this.model.calculateNormals(64, 850, -30, -50, -30, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void update() {
    }

    @Override
    protected void draw() {
        Pix2D.clear();
        Pix2D.fillRect(0, 0, 0x555555, this.screenWidth, this.screenHeight);

        this.model.draw(this.modelYaw, Pix3D.sinTable[this.eyePitch], Pix3D.cosTable[this.eyePitch], Pix3D.sinTable[this.eyeYaw], Pix3D.cosTable[this.eyeYaw], this.modelX - this.eyeX, this.modelY - this.eyeY, this.modelZ - this.eyeZ, 0);

        this.fontBold12.drawStringRight(this.screenWidth, this.fontBold12.height, "FPS: " + super.fps, 0xFFFF00, true);

        this.drawArea.draw(super.graphics, 0, 0);
    }

	private Jagfile loadArchive(String name, int crc, String displayName, int displayProgress) {
		int retry = 5;
		byte[] data = signlink.cacheload(name);
		if (data != null) {
			this.crc32.reset();
			this.crc32.update(data);
			int crcValue = (int) this.crc32.getValue();
			if (crcValue != crc) {
				data = null;
			}
		}

		if (data != null) {
			return new Jagfile(data);
		}

		while (data == null) {
			this.drawProgress("Requesting " + displayName, displayProgress);

			try {
				int lastProgress = 0;
				DataInputStream stream = this.openUrl(name + crc);
				byte[] header = new byte[6];
				stream.readFully(header, 0, 6);
				Packet head = new Packet(header);
				head.pos = 3;
				int length = head.g3() + 6;
				int offset = 6;
				data = new byte[length];
				System.arraycopy(header, 0, data, 0, 6);
				while (offset < length) {
					int remaining = length - offset;
					if (remaining > 1000) {
						remaining = 1000;
					}

					offset += stream.read(data, offset, remaining);
					int progress = offset * 100 / length;
					if (progress != lastProgress) {
						this.drawProgress("Loading " + displayName + " - " + progress + "%", displayProgress);
					}
					lastProgress = progress;
				}
				stream.close();
			} catch (IOException ex) {
				data = null;
				for (int i = retry; i > 0; i--) {
					this.drawProgress("Error loading - Will retry in " + i + " secs.", displayProgress);
					try {
						Thread.sleep(1000L);
					} catch (Exception ignored) {
					}
				}

				retry *= 2;
				if (retry > 60) {
					retry = 60;
				}
			}
		}

		signlink.cachesave(name, data);
		return new Jagfile(data);
	}

	private DataInputStream openUrl(String url) throws IOException {
		if (signlink.mainapp != null) {
			return signlink.openurl(url);
		}

		return new DataInputStream((new URL(this.getCodeBase(), url)).openStream());
	}
}
