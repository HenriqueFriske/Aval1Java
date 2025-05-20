package app.clients.dao;

import app.clients.model.Client;
import app.utils.db.ConnectionFactory;
import app.utils.db.DBException;
import app.clients.dto.ClientSummaryDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public void create(Client c) {
        String sql = "INSERT INTO tb_clientes(name,cpf,email,homePhone,cellPhone,zipCode,address,number,neighborhood,city,uf) " +
                     "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, c.getName());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getHomePhone());
            stmt.setString(5, c.getCellPhone());
            stmt.setString(6, c.getZipCode());
            stmt.setString(7, c.getAddress());
            stmt.setString(8, c.getNumber());
            stmt.setString(9, c.getNeighborhood());
            stmt.setString(10, c.getCity());
            stmt.setString(11, c.getUf());

            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) c.setId(rs.getInt(1));
            }
            conn.commit();
        } catch (SQLException e) {
            throw new DBException("Erro ao cadastrar cliente", e);
        }
    }

    public List<ClientSummaryDTO> getAllSummarized() {
        String sql = "SELECT id,name,cpf,email,homePhone,cellPhone FROM tb_clientes";
        List<ClientSummaryDTO> list = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new ClientSummaryDTO(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("homePhone"),
                    rs.getString("cellPhone")
                ));
            }
            conn.commit();
            return list;
        } catch (SQLException e) {
            throw new DBException("Erro ao listar resumo de clientes", e);
        }
    }

    public List<ClientSummaryDTO> getSummarizedByName(String name) {
        String sql = "SELECT id,name,cpf,email,homePhone,cellPhone FROM tb_clientes " +
                     "WHERE LOWER(name) LIKE ?";
        List<ClientSummaryDTO> list = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name.toLowerCase() + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new ClientSummaryDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("homePhone"),
                        rs.getString("cellPhone")
                    ));
                }
            }
            conn.commit();
            return list;
        } catch (SQLException e) {
            throw new DBException("Erro ao filtrar resumo de clientes", e);
        }
    }

    public Client getById(int id) {
        String sql = "SELECT * FROM tb_clientes WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Client c = new Client(
                        rs.getInt("id"), rs.getString("name"), rs.getString("cpf"), rs.getString("email"),
                        rs.getString("homePhone"), rs.getString("cellPhone"), rs.getString("zipCode"),
                        rs.getString("address"), rs.getString("number"), rs.getString("neighborhood"),
                        rs.getString("city"), rs.getString("uf")
                    );
                    conn.commit();
                    return c;
                }
                conn.commit();
                return null;
            }
        } catch (SQLException e) {
            throw new DBException("Erro ao buscar cliente por ID", e);
        }
    }

    public void update(Client c) {
        String sql = "UPDATE tb_clientes SET name=?,cpf=?,email=?,homePhone=?,cellPhone=?," +
                     "zipCode=?,address=?,number=?,neighborhood=?,city=?,uf=? WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getName());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getHomePhone());
            stmt.setString(5, c.getCellPhone());
            stmt.setString(6, c.getZipCode());
            stmt.setString(7, c.getAddress());
            stmt.setString(8, c.getNumber());
            stmt.setString(9, c.getNeighborhood());
            stmt.setString(10, c.getCity());
            stmt.setString(11, c.getUf());
            stmt.setInt(12, c.getId());

            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new DBException("Erro ao atualizar cliente", e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM tb_clientes WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new DBException("Erro ao excluir cliente", e);
        }
    }
}