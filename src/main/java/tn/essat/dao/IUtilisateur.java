package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Utilisateur;

@Repository
public interface IUtilisateur extends JpaRepository<Utilisateur, Integer>{
	public List<Utilisateur> findByEmailAndPassword(String email , String pass);
}
