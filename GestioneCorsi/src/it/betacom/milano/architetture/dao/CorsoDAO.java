package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.milano.businesscomponent.model.Corso;


public class CorsoDAO implements GenericDAO<Corso>, DAOConstants{
		private CachedRowSet rowSet;
		
		private CorsoDAO() throws DAOException {
			try {
				rowSet = RowSetProvider.newFactory().createCachedRowSet();
			}catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		public static CorsoDAO getFactory() throws DAOException {
			return new CorsoDAO();
		}

		@Override
		public void create(Connection conn, Corso entity) throws DAOException{
			try {
				rowSet.setCommand(SELECT_CORSI);
				rowSet.execute(conn);//ora ho il mio RowSet in cache
				rowSet.moveToInsertRow();// mi metto sulla riga vuota per l'insert
				rowSet.updateLong(1,entity.getCod_corso());
				rowSet.updateString(2, entity.getNome_corso());
				rowSet.updateDate(3,new java.sql.Date(entity.getData_iniziocorso().getTime()));
				rowSet.updateDate(4,new java.sql.Date(entity.getData_finecorso().getTime()));
				rowSet.updateDouble(5,entity.getCosto_corso());
				rowSet.updateString(6, entity.getCommenti_corso());
				rowSet.updateString(7, entity.getAula_corso());
				rowSet.updateLong(8, entity.getCod_docente());
				rowSet.insertRow();
				rowSet.moveToCurrentRow();
				rowSet.acceptChanges();
			}catch(SQLException sql) {
				throw new DAOException(sql);
			}		
		}

		@Override
		public void update(Connection conn, Corso entity) throws DAOException {
		}

		@Override
		public void delete(Connection conn, long id) throws DAOException {
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(DELETE_CORSO);
				pstmt.setLong(1, id);
				pstmt.execute();
				conn.commit();
			}catch (SQLException e) {
				throw new DAOException(e);
			}
			
		}

		@Override
		public Corso getById(Connection conn, long id) throws DAOException {
			Corso c = null;
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(SELECT_CORSO_BY_COD);
				ps.setLong(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					c = new Corso();
					c.setCod_corso(rs.getLong(1));
					c.setNome_corso(rs.getString(2));
					c.setData_iniziocorso(new java.util.Date(rs.getDate(3).getTime()));
					c.setData_finecorso(new java.util.Date(rs.getDate(4).getTime()));
					c.setCosto_corso(rs.getInt(5));
					c.setCommenti_corso(rs.getString(6));
					c.setAula_corso(rs.getString(7));
					c.setCod_docente(rs.getLong(8));
				}
			}catch (SQLException e) {
				throw new DAOException(e);
			}
			return c;
		}

		@Override
		public Corso[] getAll(Connection conn) throws DAOException {
			return null;
			
		}
		
		public Corso[] getAllCorsiAttivi(Connection conn) throws DAOException {
			Corso[] corsi = null;
			try {
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CORSI_ATTIVI, 
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
				pstmt.setDate(1, new Date(new java.util.Date().getTime()));
				ResultSet rs = pstmt.executeQuery();
				rs.last();
				corsi = new Corso[rs.getRow()];
				
				rs.beforeFirst();
				for(int i = 0; rs.next(); i++) {
					Corso c = new Corso();
					c.setCod_corso(rs.getLong(1));
					c.setNome_corso(rs.getString(2));
					c.setData_iniziocorso(new java.util.Date(rs.getDate(3).getTime()));
					c.setData_finecorso(new java.util.Date(rs.getDate(4).getTime()));
					c.setCosto_corso(rs.getInt(5));
					c.setCommenti_corso(rs.getString(6));
					c.setAula_corso(rs.getString(7));
					c.setCod_docente(rs.getLong(8));
					corsi[i] = c;
				}
				rs.close();
			}catch (SQLException e) {
				throw new DAOException(e);
			}
			return corsi;
		}
		
		public Corso[] getAllCorsiNonAttivi(Connection conn) throws DAOException {
			Corso[] corsi = null;
			try {
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CORSI_NON_ATTIVI, 
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
				pstmt.setDate(1, new Date(new java.util.Date().getTime()));
				ResultSet rs = pstmt.executeQuery();
				rs.last();
				corsi = new Corso[rs.getRow()];
				
				rs.beforeFirst();
				for(int i = 0; rs.next(); i++) {
					Corso c = new Corso();
					c.setCod_corso(rs.getLong(1));
					c.setNome_corso(rs.getString(2));
					c.setData_iniziocorso(new java.util.Date(rs.getDate(3).getTime()));
					c.setData_finecorso(new java.util.Date(rs.getDate(4).getTime()));
					c.setCosto_corso(rs.getInt(5));
					c.setCommenti_corso(rs.getString(6));
					c.setAula_corso(rs.getString(7));
					c.setCod_docente(rs.getLong(8));
					corsi[i] = c;
				}
				rs.close();
			}catch (SQLException e) {
				throw new DAOException(e);
			}
			return corsi;
		}
		
		public Corso[] getAllCorsiAttiviAttualmente(Connection conn) throws DAOException {
			Corso[] corsi = null;
			try {
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CORSI_ATTIVI_ATTUALMENTE, 
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
				pstmt.setDate(1, new Date(new java.util.Date().getTime()));
				ResultSet rs = pstmt.executeQuery();
				rs.last();
				corsi = new Corso[rs.getRow()];
				
				rs.beforeFirst();
				for(int i = 0; rs.next(); i++) {
					Corso c = new Corso();
					c.setCod_corso(rs.getLong(1));
					c.setNome_corso(rs.getString(2));
					c.setData_iniziocorso(new java.util.Date(rs.getDate(3).getTime()));
					c.setData_finecorso(new java.util.Date(rs.getDate(4).getTime()));
					c.setCosto_corso(rs.getInt(5));
					c.setCommenti_corso(rs.getString(6));
					c.setAula_corso(rs.getString(7));
					c.setCod_docente(rs.getLong(8));
					corsi[i] = c;
				}
				rs.close();
			}catch (SQLException e) {
				throw new DAOException(e);
			}
			return corsi;
		}
}