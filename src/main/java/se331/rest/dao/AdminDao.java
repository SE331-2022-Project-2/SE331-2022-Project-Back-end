package se331.rest.dao;

import se331.rest.entity.Admin;
import se331.rest.entity.Doctor;

public interface AdminDao {
    Admin getAdmins(Long id);

    Admin save(Admin admin);
}
