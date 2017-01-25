package com.ipartek.formacion.ejercicioLogin.pojo;

public class User {

	private long id;
	private String user;
	private String pass;
	private String email;
	private String imagen;
	private String gitUserName;
	
	public User(long id, String user, String pass, String email, String imagen, String gitUserName) {
		super();
		this.setId(id);
		this.setUser(user);
		this.setPass(pass);
		this.setEmail(email);
		this.setImagen("http://vignette2.wikia.nocookie.net/thebeatles/images/2/2e/Beatles2_256.png/revision/latest?cb=20090908223029&path-prefix=es");
		this.setGitUserName(gitUserName);
	}

	public User(String user, String pass) {
		super();
		this.setUser(user);
		this.setPass(pass);
		this.setImagen("http://vignette2.wikia.nocookie.net/thebeatles/images/2/2e/Beatles2_256.png/revision/latest?cb=20090908223029&path-prefix=es");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getGitUserName() {
		return gitUserName;
	}

	public void setGitUserName(String gitUserName) {
		this.gitUserName = gitUserName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", pass=" + pass + ", email=" + email + ", imagen=" + imagen
				+ ", gitUserName=" + gitUserName + "]";
	}
	
	
	
	
	
}
