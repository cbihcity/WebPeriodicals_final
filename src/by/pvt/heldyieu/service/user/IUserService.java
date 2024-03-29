package by.pvt.heldyieu.service.user;

import java.sql.SQLException;
import java.util.List;
import by.pvt.heldyieu.entity.User;

public interface IUserService {
	 User addUser(User user) throws SQLException;
	
	 User getUser(Integer id) throws SQLException;
	
	 void updateUser(User user) throws SQLException;
	
	 boolean deleteUser(Integer id) throws SQLException;
	
	 List<User> getAllUsers() throws SQLException;
	
	 User findUserByEmail(String email, String pass) throws SQLException;
}
