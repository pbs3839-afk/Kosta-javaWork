package profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProfileService {
	public int insert(Profile profile) {
		File file = new File(profile.getName() + ".txt");

		try {
			if (file.createNewFile() == false) return -1;
			
			String data = profile.getWeight() + ":" + profile.getPassword();

			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data.getBytes());
			fos.close();

			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public Profile select(String name) {
		File file = new File(name + ".txt");

		try {
			if (file.exists() == false) return null;
			
			FileInputStream fis = new FileInputStream(file);

			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();

			String str = new String(data);
			String[] arr = str.split(":");

			int weight = Integer.parseInt(arr[0]);
			int password = Integer.parseInt(arr[1]);

			return new Profile(name, weight, password);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
