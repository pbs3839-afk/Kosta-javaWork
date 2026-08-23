package profile.service;

import profile.dto.Profile;

public interface ProfileService {
	public int insert(Profile profile);
	public Profile select(String name);
	public void updateWeight(Profile profile);
	public void updatePassword(Profile prpfile);
}
