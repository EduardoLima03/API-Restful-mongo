package br.eti.carloslima.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.eti.carloslima.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
