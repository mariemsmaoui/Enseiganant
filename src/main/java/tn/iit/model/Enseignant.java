package tn.iit.model;

import java.util.ArrayList;
import java.util.List;

public class Enseignant {
	private int idEnseignant;

	private String nom;
	private String email;
	private int cin;
	private int telephone;
    private List<Autorisation> authorisations;

	public Enseignant() {

	}

	public Enseignant(int idEnseignant, String nom, String email, int cin, int telephone) {
		this.idEnseignant = idEnseignant;
		this.nom = nom;
		this.email = email;
		this.cin = cin;
		this.telephone = telephone;
        this.authorisations = new ArrayList<>();


	}

	public int getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
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

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public List<Autorisation> getAuthorisations() {
        return authorisations;
    }

    public void setAuthorisations(List<Autorisation> authorisations) {
        this.authorisations = authorisations;
    }
	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", nom=" + nom + ", email=" + email + ", cin=" + cin
				+ ", telephone=" + telephone + ", getIdEnseignant()=" + getIdEnseignant() + ", getNom()=" + getNom()
				+ ", getEmail()=" + getEmail() + ", getCin()=" + getCin() + ", getTelephone()=" + getTelephone()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
