package profile.controller;

import profile.dto.Profile;
import profile.service.ProfileService;
import profile.service.ProfileServiceImpl;

public class ProfileController {
	private ProfileService service = new ProfileServiceImpl();

	public int insert(String name, int weight, int password) {
		return service.insert(new Profile(name, weight, password));
	}
	public Profile search(String name, int password) {
		Profile profile = service.select(name);
		if(profile == null) {
			return null;
			
		}
		if (profile.getPassword() != password) {
			return null;
		}
		return profile;
	}
	public void updateWeight(Profile profile, int newWeight) {
		profile.setWeight(newWeight);
		service.updateWeight(profile);
	}
	public void updatePassword(Profile profile, int newPassword) {
		profile.setPassword(newPassword);
		service.updatePassword(profile);
	}
}