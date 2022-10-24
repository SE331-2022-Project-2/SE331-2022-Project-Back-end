package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Admin;
import se331.rest.entity.Doctor;
import se331.rest.repository.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin getAdmins(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }
}
