package app.admission.service;


import app.admission.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserDao userDao;

}