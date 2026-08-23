package profile.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import profile.dto.Profile;

public class ProfileServiceImpl implements ProfileService {
	@Override
	public int insert(Profile profile) {
		File file = new File(profile.getName() + ".txt");

		if (file.exists())
			return -1;
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(profile);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public Profile select(String name) {
		File file = new File(name + ".txt");
		if(!file.exists()) return null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			return (Profile) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

	@Override
	public void updateWeight(Profile profile) {
		save(profile);
	}
	@Override
	public void updatePassword(Profile profile) {
		save(profile);
	}
	private void save(Profile profile) {
		File file = new File(profile.getName() + ".txt");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			oos.writeObject(profile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
