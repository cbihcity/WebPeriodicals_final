package by.pvt.heldyieu.entity;

import java.io.Serializable;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.interfaces.Identified;

public class User implements Identified, Serializable{
	
	private static final long serialVersionUID = -7237973696500040785L;
	
		private Integer id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    private UserType userType;
	    
	
		/**
		 * @return the id
		 */
		@Override
		public Integer getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}
		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the userType
		 */
		public UserType getUserType() {
			return userType;
		}
		/**
		 * @param userType the userType to set
		 */
		public void setUserType(UserType userType) {
			this.userType = userType;
		}
}
