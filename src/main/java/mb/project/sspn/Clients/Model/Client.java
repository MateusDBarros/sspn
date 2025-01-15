package mb.project.sspn.Clients.Model;

public class Client {
    private int clientId;
    private String name;
    private String email;

    public Client() {
    }

    public Client(String name, String email, int clientId) {
        this.name = name;
        this.email = email;
        this.clientId = clientId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getClientId() {
        return clientId;
    }

    // Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
