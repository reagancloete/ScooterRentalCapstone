package za.ac.cput.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;

import java.util.List;

@Service
public abstract class AdminService implements IAdminService {
    private AdminRepository repository;

    @Autowired
    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public Admin create(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Admin update(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public void delete(Admin admin) {
        repository.delete(admin);
    }

    @Override
    public List<Admin> getall() {
        return repository.findAll();
    }


}

