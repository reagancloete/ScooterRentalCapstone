package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Profile;
import za.ac.cput.repository.ProfileRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProfileService implements IProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile read(String id) {
        return profileRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Profile not found for id: " + id));
    }

    @Override
    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void delete(Profile profile) {
        profileRepository.delete(profile);
    }

    @Override
    public List<Profile> getall() {
        return profileRepository.findAll();
    }
}
