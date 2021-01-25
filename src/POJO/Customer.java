package POJO;

public class Customer {
private int id;
private String password;
private String name,email;
private long contact;
private String address;
public int getId() {
	return id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", contact="
			+ contact + ", address=" + address + "]";
}


}
