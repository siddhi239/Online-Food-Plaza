package DAO;

public interface LoginDao {
	boolean custLogin(String email,String pwd);
	boolean adminLogin(String email,String pwd);
	boolean changePassword(String email,String pwd);
}
