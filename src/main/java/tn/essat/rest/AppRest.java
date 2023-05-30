package tn.essat.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.IMessage;
import tn.essat.dao.IUtilisateur;
import tn.essat.model.Message;
import tn.essat.model.Utilisateur;

@RestController
@CrossOrigin("*")
public class AppRest {

	@Autowired
	private IUtilisateur dao_u;

	@Autowired
	private IMessage dao_m;

	public void setDao_m(IMessage dao_m) {
		this.dao_m = dao_m;
	}

	public void setDao_u(IUtilisateur dao_u) {
		this.dao_u = dao_u;
	}

	@GetMapping("/users")
	public List<Utilisateur> f1() {
		return dao_u.findAll();
	}

	@GetMapping("/messagesrecus/{id}")
	public List<Message> f2(@PathVariable("id") int id) {
		return dao_m.getAllMessagesRecusByIdUser(id);

	}

	@GetMapping("/messagessend/{id}")
	public List<Message> f3(@PathVariable("id") int id) {
		return dao_m.getAllMessagesSendByIdUser(id);

	}

	@PostMapping("/sendMessage")
	public Message f4(@RequestBody Message m) {
		return dao_m.save(m);
	}

	@GetMapping("/verif/{email}/{pass}")
	public List<Utilisateur> f5(@PathVariable("email") String email, @PathVariable("pass") String pass) {
		return dao_u.findByEmailAndPassword(email, pass);
	}
	
	@GetMapping("/user/{id}")
	public Optional<Utilisateur> f6(@PathVariable("id") int id){
		return dao_u.findById(id);
	}
}
