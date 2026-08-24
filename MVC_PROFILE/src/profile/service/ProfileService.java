package profile.service;

import profile.dto.Profile;

public interface ProfileService {

	Profile select(String name);

	int insert(Profile profile);

	void updateWeight(Profile profile);

	void updatePassword(Profile profile);

}
