package fr.epsi.individu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@Named
@ApplicationScoped
public class IndividuRepository {

	@Resource(name = "baseTest")
	private DataSource dataSource;
	
	public String create(Individu individu) throws SQLException {
		
		Connection connection = dataSource.getConnection();
		try {
			
			String request = "insert into individus (prenom,nom,age,id_individu) values (?, ?, ?,(select max(id_individu) + 1 from individus))";
			
			PreparedStatement pstmt = connection.prepareStatement(request);
			try {

				pstmt.setString(1, individu.getPrenom());
				pstmt.setString(2, individu.getNom());
				pstmt.setInt(3, individu.getAge());

				pstmt.executeUpdate();
			}
			finally{
				if (pstmt != null) {
					pstmt.close();
				}
			}
		}
		finally{
			if (connection != null) {
				connection.close();
			}
		}
		return "individu?faces-redirect=true";
	}

	public List<Individu> getAll() throws SQLException {
		List<Individu> result = new ArrayList<>();
		Connection connection = dataSource.getConnection();
		try {
			
			String request = "select * from individus";
			
			PreparedStatement pstmt = connection.prepareStatement(request);
			try {
				ResultSet individus = pstmt.executeQuery();
				while (individus.next()) {     
					result.add(new Individu(individus.getString(1),individus.getString(2),individus.getInt(3),individus.getLong(4)));
				}
				if(individus != null){
					individus.close();
				}
			}
			finally{
				if (pstmt != null) {
					pstmt.close();
				}
				
			}
		}
		finally{
			if (connection != null) {
				connection.close();
			}
		}
		return result;
	}

	public void delete(long id) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			
			String request = "delete from individus where id_individu = ?";
			
			PreparedStatement pstmt = connection.prepareStatement(request);
			try {

				pstmt.setLong(1,id);
				pstmt.executeUpdate();
			}
			finally{
				if (pstmt != null) {
					pstmt.close();
				}
			}
		}
		finally{
			if (connection != null) {
				connection.close();
			}
		}
	}

}
