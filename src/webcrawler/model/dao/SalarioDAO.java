package webcrawler.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import webcrawler.model.bean.SalarioBean;
import webcrawler.model.connection.ConnectionFactory;

public class SalarioDAO {
    private Connection conn = null;

    public int getLastId() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT MAX(ID) AS 'ID' FROM SALARIO";
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

    public boolean insert(SalarioBean salario) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO SALARIO(ID_SERVIDOR, ID_LANCAMENTO, REFERENCIA, DESCRICAO, VALOR, DT_INCLUSAO) VALUES(?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, salario.getId_servidor());
            stmt.setInt(2, salario.getId_lancamento());
            stmt.setDate(3, new java.sql.Date(salario.getReferencia().getTime()));
            stmt.setString(4, salario.getDescricao());
            stmt.setDouble(5, salario.getValor());
            stmt.setDate(6, new java.sql.Date(salario.getDt_inclusao().getTime()));

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

    public boolean update(SalarioBean salario) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE SALARIO SET ID_SERVIDOR=?, ID_LANCAMENTO=?, REFERENCIA=?, DESCRICAO=?, VALOR=?, DT_INCLUSAO=? WHERE ID=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, salario.getId_servidor());
            stmt.setInt(2, salario.getId_lancamento());
            stmt.setDate(3, new java.sql.Date(salario.getReferencia().getTime()));
            stmt.setString(4, salario.getDescricao());
            stmt.setDouble(5, salario.getValor());
            stmt.setDate(6, new java.sql.Date(salario.getDt_inclusao().getTime()));
            stmt.setInt(7, salario.getId());

            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível alterar os dados no banco de dados.\n");
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public boolean delete(SalarioBean salario) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM SALARIO WHERE ID=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, salario.getId());

            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível deletar os dados no banco de dados.\n");
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public List<SalarioBean> selectAll() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM SALARIO ORDER BY ID DESC";
        List<SalarioBean> salarios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                SalarioBean found = new SalarioBean();
                found.setId(rs.getInt("ID"));
                found.setId_servidor(rs.getInt("ID_SERVIDOR"));
                found.setId_lancamento(rs.getInt("ID_LANCAMENTO"));
                found.setReferencia(rs.getDate("REFERENCIA"));
                found.setDescricao(rs.getString("DESCRICAO"));
                found.setValor(rs.getDouble("VALOR"));
                found.setDt_inclusao(rs.getDate("DT_INCLUSAO"));

                salarios.add(found);
            }
            return salarios;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return null;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }
    
    public List<SalarioBean> selectAllById_servidor(SalarioBean salario) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM SALARIO WHERE ID_SERVIDOR=? ORDER BY ID DESC";
        List<SalarioBean> salarios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, salario.getId_servidor());
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                SalarioBean found = new SalarioBean();
                found.setId(rs.getInt("ID"));
                found.setId_servidor(rs.getInt("ID_SERVIDOR"));
                found.setId_lancamento(rs.getInt("ID_LANCAMENTO"));
                found.setReferencia(rs.getDate("REFERENCIA"));
                found.setDescricao(rs.getString("DESCRICAO"));
                found.setValor(rs.getDouble("VALOR"));
                found.setDt_inclusao(rs.getDate("DT_INCLUSAO"));

                salarios.add(found);
            }
            return salarios;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return null;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }
    
    public SalarioBean selectOneById(SalarioBean salario) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM SALARIO WHERE ID=?";
        SalarioBean found = new SalarioBean();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, salario.getId());
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                found.setId(rs.getInt("ID"));
                found.setId_servidor(rs.getInt("ID_SERVIDOR"));
                found.setId_lancamento(rs.getInt("ID_LANCAMENTO"));
                found.setReferencia(rs.getDate("REFERENCIA"));
                found.setDescricao(rs.getString("DESCRICAO"));
                found.setValor(rs.getDouble("VALOR"));
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
    
    public int getId(SalarioBean salario) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT ID FROM SALARIO WHERE ID_SERVIDOR=? AND ID_LANCAMENTO=? AND REFERENCIA=? AND DESCRICAO=? AND VALOR=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, salario.getId_servidor());
            stmt.setInt(2, salario.getId_lancamento());
            stmt.setDate(3, new java.sql.Date(salario.getReferencia().getTime()));
            stmt.setString(4, salario.getDescricao());
            stmt.setDouble(5, salario.getValor());
            
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