package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.rest.dao.AdminDao;
import se331.rest.entity.Admin;
import se331.rest.entity.Doctor;

import javax.transaction.Transactional;

@Service

public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminDao adminDao;

    @Override
    public Admin getAdmin(Long id) {
        return adminDao.getAdmins(id);
    }

    @Override
    @Transactional
    public Admin save(Admin admin) {
        return adminDao.save(admin);
    }

}
