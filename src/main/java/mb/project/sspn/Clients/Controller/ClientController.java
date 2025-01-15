package mb.project.sspn.Clients.Controller;

import mb.project.sspn.Clients.Model.Client;
import mb.project.sspn.Clients.Service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService services;


    public ClientController(ClientService services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<String> addNewClient(@RequestBody Client client) {
        services.addNewClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("New client added");
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = services.getClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @PostMapping("{clientId}")
    public ResponseEntity<String> updateClient(@RequestBody Client client, @RequestParam int id) {
        client.setClientId(id);
        services.updateClient(client);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente updated");
    }


    @DeleteMapping("{clientId}")
    public ResponseEntity<String> deleteClient(@RequestParam int id) {
        services.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Client with ID: " +id+ " was deleted");
    }

}
