package tn.iit.model;

import java.util.Date;

public class Autorisation {
	private int idAutorisation;
    private Enseignant enseignant;
    private Date dateAutorisation;
    private int heuresAutorisees;
    private boolean autorisee=false;

	
	public Autorisation(int idAutorisation, Enseignant enseignant, Date dateAutorisation,int heuresAutorisees) {
        this.idAutorisation = idAutorisation;
        this.enseignant = enseignant;
        this.dateAutorisation = dateAutorisation;
        this.heuresAutorisees=heuresAutorisees;
    }
	public  Autorisation() {}
    
   

	public int getIdAutorisation() {
        return idAutorisation;
    }

    public void setIdAutorisation(int idAutorisation) {
        this.idAutorisation = idAutorisation;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Date getDateAutorisation() {
        return dateAutorisation;
    }

    public void setDateAutorisation(Date dateAutorisation) {
        this.dateAutorisation = dateAutorisation;
    }
    public int getHeuresAutorisees() {
  		return heuresAutorisees;
  	}
  	public void setHeuresAutorisees(int heuresAutorisees) {
  		this.heuresAutorisees = heuresAutorisees;
  	}

  	@Override
	public String toString() {
		return "Autorisation [idAutorisation=" + idAutorisation + ", enseignant=" + enseignant + ", dateAutorisation="
				+ dateAutorisation + ", heuresAutorisees=" + heuresAutorisees + ", getIdAutorisation()="
				+ getIdAutorisation() + ", getEnseignant()=" + getEnseignant() + ", getDateAutorisation()="
				+ getDateAutorisation() + ", getHeuresAutorisees()=" + getHeuresAutorisees() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
