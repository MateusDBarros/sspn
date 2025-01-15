package mb.project.sspn.Clients.Repository;
import mb.project.sspn.Clients.Model.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    private final JdbcTemplate jdbc;

    public ClientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Add new client
    public void addNewClient(Client client) {
        String sql = "INSERT INTO Clients (name, email) VALUES (?, ?)";
        jdbc.update(sql, client.getName(), client.getEmail());
    }

    public List<Client> getClients() {
        String sql = "SELECT * FROM Clients";
        return jdbc.query(sql, (rs, rowNum) ->
                new Client(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("clientId")
                        )
        );
    }

    public void updateClient(Client client) {
        String sql = "UPDATE SET name = ?, email = ?, WHERE clientId = ?";
        client.setClientId();
        jdbc.update(sql, client.getName(), client.getEmail(), client.getClientId())
    }
}
