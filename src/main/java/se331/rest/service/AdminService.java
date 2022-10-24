package se331.rest.service;

import se331.rest.entity.Admin;
import se331.rest.entity.Doctor;

public interface AdminService {

    Admin getAdmin(Long id);

    Admin save(Admin admin);
}
