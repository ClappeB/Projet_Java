package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Map;

class DAOMap {
	
	/** The connection. */
	private final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}
	
	/**
	 * Find
	 *
	 * @param id
	 *          the id
	 * @return the e
	 */
	public Map find() {
		String level;
		
		try {
			final String sql = "{call level(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, DBProperties.getGameLevel());
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			final int width = resultSet.getInt(1);
			final int height = resultSet.getInt(2);
			level = resultSet.getString(3);
			Map map = new Map(width, height, level);
			return map;
		} catch (final SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
