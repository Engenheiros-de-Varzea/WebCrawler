package webcrawler.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import webcrawler.model.bean.ServidorBean;
import webcrawler.model.connection.ConnectionFactory;

public class ServidorDAO {
    private Connection conn = null;

    public int getLastId() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT MAX(ID) AS 'ID' FROM SERVIDOR";
        int lastId = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                lastId = rs.getInt("ID");
            }
            
            return lastId;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return 0;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }

    public boolean insert(ServidorBean servidor) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO SERVIDOR(RGF, NOME, CARGO, REGIME, DT_INCLUSAO) VALUES(?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, servidor.getRgf());
            stmt.setString(2, servidor.getNome());
            stmt.setString(3, servidor.getCargo());
            stmt.setString(4, servidor.getRegime());
            stmt.setDate(5, new java.sql.Date(servidor.getDt_inclusao().getTime()));

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível inserir os dados no banco de dados.\n");
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public boolean update(ServidorBean servidor) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE SERVIDOR SET RGF=?, NOME=?, CARGO=?, REGIME=?, DT_INCLUSAO=? WHERE ID=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, servidor.getRgf());
            stmt.setString(2, servidor.getNome());
            stmt.setString(3, servidor.getCargo());
            stmt.setString(4, servidor.getRegime());
            stmt.setDate(5, new java.sql.Date(servidor.getDt_inclusao().getTime()));
            stmt.setInt(6, servidor.getId());

            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível alterar os dados no banco de dados.\n");
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public boolean delete(ServidorBean servidor) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM SERVIDOR WHERE ID=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, servidor.getId());

            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível deletar os dados no banco de dados.\n");
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public List<ServidorBean> selectAll() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM SERVIDOR ORDER BY ID DESC";
        List<ServidorBean> servidors = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ServidorBean found = new ServidorBean();
                found.setId(rs.getInt("ID"));
                found.setRgf(rs.getInt("RGF"));
                found.setNome(rs.getString("NOME"));
                found.setCargo(rs.getString("CARGO"));
                found.setRegime(rs.getString("REGIME"));
                found.setDt_inclusao(rs.getDate("DT_INCLUSAO"));

                servidors.add(found);
            }
            return servidors;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return null;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }
    
    public ServidorBean selectOneById(ServidorBean servidor) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM SERVIDOR WHERE ID=?";
        ServidorBean found = new ServidorBean();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, servidor.getId());
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                found.setId(rs.getInt("ID"));
                found.setRgf(rs.getInt("RGF"));
                found.setNome(rs.getString("NOME"));
                found.setCargo(rs.getString("CARGO"));
                found.setRegime(rs.getString("REGIME"));
                found.setDt_inclusao(rs.getDate("DT_INCLUSAO"));
            }
            
            return found;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return null;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }
    
    public int getId(ServidorBean servidor) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT ID FROM SERVIDOR WHERE RGF=? AND NOME=? AND CARGO=? AND REGIME=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, servidor.getRgf());
            stmt.setString(2, servidor.getNome());
            stmt.setString(3, servidor.getCargo());
            stmt.setString(4, servidor.getRegime());
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("ID");
            } else{
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return 0;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }
    
}