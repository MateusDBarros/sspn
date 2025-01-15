package mb.project.sspn.Clients.Service;

import mb.project.sspn.Clients.Model.Client;
import mb.project.sspn.Clients.Repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;


    public ClientService(ClientService services) {
        this.repository = services;
    }

    public void addNewClient(Client client) {
        if (client.getName() == null || client.getName().isEmpty())
            throw new IllegalStateException("Enter a valid name");
        if (client.getEmail() == null || client.getEmail().isEmpty())
            throw new IllegalStateException("Enter a valid email");

        repository.addNewClient(client);
    }

    public List<Client> getClients() {
        return repository.getClients();
    }

    @Transactional
    public void updateClient(Client client) {
        if (!repository.exist(client.getClientId()))
            throw new IllegalStateException("Client ID: " +client.getClientId()+" does not exist");
        if (client.getName() == null || client.getName().isEmpty())
            throw new IllegalStateException("Enter a valid name");
        if (client.getEmail() == null || client.getEmail().isEmpty())
            throw new IllegalStateException("Enter a valid email");

        repository.updateClient(client);
    }

    public void deleteClient(int id) {
        if (!repository.exist(id))
            throw new IllegalStateException("Client ID: " +id+" does not exist");
        repository.deleteClient(id);
    }

}
