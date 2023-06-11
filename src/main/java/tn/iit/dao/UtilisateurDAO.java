package tn.iit.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tn.iit.model.Utilisateur;
import tn.iit.utils.JDBCUtils;
import tn.iit.utils.JDBCUtilss;

public class UtilisateurDAO {

	public static void save(Utilisateur u) {
		String query = "insert into utilisateur (nom, email, pwd) values ('" + u.getNom() + "','" + u.getEmail() + "','" + u.getPwd() + "')".toString();
		System.out.println(query);
		try {
			JDBCUtilss.getStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Utilisateur findByLoginPwd(String email, String pwd) {
		String query = "select * from utilisateur where email ='" + email + "' and pwd ='" + pwd + "'";
		System.out.println(query);
		Utilisateur res = null;
		try {
			ResultSet rs = JDBCUtilss.getStatement().executeQuery(query);
			if (rs.next()) {
				res = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	

}
