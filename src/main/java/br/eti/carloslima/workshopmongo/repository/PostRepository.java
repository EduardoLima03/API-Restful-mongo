package br.eti.carloslima.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.eti.carloslima.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContainingIgnoreCase(String text);

	/*
	 * metodo personalizado de realiza a cunsulta por titulo
	 */
	@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);

}
