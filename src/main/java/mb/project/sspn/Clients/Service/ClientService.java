package mb.project.sspn.Clients.Service;

import mb.project.sspn.Clients.Model.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientService services;


    public ClientService(ClientService services) {
        this.services = services;
    }

    public void addNewClient(Client client) {
        if (client.getName() == null || client.getName().isEmpty())
            throw new IllegalStateException("Enter a valid name");
        if (client.getEmail() == null || client.getEmail().isEmpty())
            throw new IllegalStateException("Enter a valid email");

        services.addNewClient(client);
    }
}
