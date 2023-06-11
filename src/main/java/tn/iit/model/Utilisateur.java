package tn.iit.model;

public class Utilisateur {
	private int id;
	private String nom;
	private String email;
	private String pwd;

	public Utilisateur() {
		super();
		nom = "";
		email = "";
		pwd = "";
	}

	public Utilisateur(String nom, String email, String pwd) {
		super();
		this.nom = nom;
		this.email = email;
		this.pwd = pwd;
	}

	public Utilisateur(int id, String nom, String email, String pwd) {
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Utilisateur) {
			Utilisateur u = (Utilisateur) obj;
			return u.nom.equals(this.nom) & u.email.equals(this.email) & u.pwd.equals(this.pwd);
		} else {
			return false;
		}
	}

}
