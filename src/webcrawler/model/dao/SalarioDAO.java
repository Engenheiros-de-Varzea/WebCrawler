package webcrawler.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import webcrawler.model.bean.SalarioBean;
import webcrawler.model.connection.ConnectionFactory;

public class SalarioDAO {
    private Connection conn = null;

    public int getLastId() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT MAX(id) FROM salario";
        int lastId = -1;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                lastId = rs.getInt("C1");
            }
            
            return lastId;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return -1;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }

    public boolean insert(int id_servidor, Date referencia, SalarioBean salario) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO SALARIO(ID_SERVIDOR, ID_LANCAMENTO, REFERENCIA, DESCRICAO, VALOR, DT_INCLUSAO) VALUES(?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_servidor);
            stmt.setInt(2, salario.getId_lancamento());
            stmt.setDate(3, (java.sql.Date) referencia);
            stmt.setString(4, salario.getDescricao());
            stmt.setDouble(5, salario.getValor());
            stmt.setDate(6, (java.sql.Date) new Date());

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
        String sql = "UPDATE salario SET nome=?, ende=?, cida=?, esta=?, cep=?, cnpj=?, tele=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, salario.getNome());
            stmt.setString(2, salario.getEnde());
            stmt.setString(3, salario.getCida());
            stmt.setString(4, salario.getEsta());
            stmt.setString(5, salario.getCep());
            stmt.setString(6, salario.getCnpj());
            stmt.setString(7, salario.getTele());
            stmt.setInt(8, salario.getId());

            if(stmt.executeUpdate() == 1){
                return true;
            } else{
                return false;
            }
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
        String sql = "DELETE FROM salario WHERE id =?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, salario.getId());

            if(stmt.executeUpdate() == 1){
                return true;
            } else{
                return false;
            }
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
        List<SalarioBean> clientes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                SalarioBean cliente = new SalarioBean();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEnde(rs.getString("ende"));
                cliente.setCida(rs.getString("cida"));
                cliente.setEsta(rs.getString("esta"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setTele(rs.getString("tele"));

                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return null;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }
    
    public SalarioBean selectOne(SalarioBean salario) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM salario WHERE id=?";
        SalarioBean found = new SalarioBean();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, salario.getId());
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                found.setId(rs.getInt("id"));
                found.setNome(rs.getString("nome"));
                found.setEnde(rs.getString("ende"));
                found.setCida(rs.getString("cida"));
                found.setEsta(rs.getString("esta"));
                found.setCep(rs.getString("cep"));
                found.setCnpj(rs.getString("cnpj"));
                found.setTele(rs.getString("tele"));
            } else {
                found.setId(-1);
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
    
    public boolean verifyExist(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) FROM salario WHERE id=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                if(rs.getInt("C1") == 0) {
                    return false;
                } else {
                    return true;
                }
            } else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível selecionar os dados no banco de dados.\n");
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
    }
    
}