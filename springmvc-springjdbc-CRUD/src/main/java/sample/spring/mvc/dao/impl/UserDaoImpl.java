
package sample.spring.mvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sample.spring.mvc.dao.UserDao;
import sample.spring.mvc.dao.entity.User;


@Repository
public class UserDaoImpl implements UserDao {

	@Resource
    private JdbcTemplate template; 
	
	@Override
	public List<User> list() {

		return this.template.query(
				"SELECT " + 
				"		\"ID\", " + 
				"		\"USER_NAME\", " + 
				"		\"PASSWORD\", " + 
				"		\"E_MAIL\"" + 
				"		FROM \"USERS\"", new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User u = new User();
						u.setId(rs.getLong(1));
						u.setUserName(rs.getString(2));
						u.setPassWord(rs.getString(3));
						u.setEmail(rs.getString(4));
						return u;
					}
					
				});
	}

	@Override
	public int insert(User u) {
		return this.template.update("INSERT INTO \"USERS\"(\"USER_NAME\", \"PASSWORD\", \"E_MAIL\") " + 
				"		VALUES(?,?,?)", u.getUserName(), u.getPassWord(), u.getEmail());
	}

	@Override
	public int update(User u) {
		return this.template.update("UPDATE \"USERS\" SET \"USER_NAME\" = ?, \"PASSWORD\" = ?, \"E_MAIL\" = ? WHERE \"ID\" = ?", u.getUserName(), u.getPassWord(), u.getEmail(), u.getId());
	}

	@Override
	public int delete(long id) {
		int result = this.template.update("DELETE FROM \"USERS\" WHERE \"ID\" = ?", id);
		return result;
	}

	@Override
	public User get(long id) {
		
		return this.template.query("SELECT " + 
				"		\"ID\", " + 
				"		\"USER_NAME\", " + 
				"		\"PASSWORD\", " + 
				"		\"E_MAIL\"" + 
				"		FROM \"USERS\" WHERE \"ID\" = ?", new Object[] {id}, new ResultSetExtractor<User>() {

					@Override
					public User extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (rs.next()) {
							User user = new User();
							user.setId(rs.getLong(1));
							user.setUserName(rs.getString(2));
							user.setPassWord(rs.getString(3));
							user.setEmail(rs.getString(4));
							return user;
						}
						return null;
					}
				});
	}
}
