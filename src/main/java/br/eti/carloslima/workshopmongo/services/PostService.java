package br.eti.carloslima.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.carloslima.workshopmongo.domain.Post;
import br.eti.carloslima.workshopmongo.dto.PostDTO;
import br.eti.carloslima.workshopmongo.repository.PostRepository;
import br.eti.carloslima.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Post insert(Post obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Post Update(Post obj) {
		Post newObj = findById(obj.getId());// objeto original vindo do banco de dados

		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Post newObj, Post obj) {
		// String id, Date date, String title, String boby, User author
		newObj.setDate(obj.getDate());
		newObj.setTitle(obj.getTitle());
		newObj.setBoby(obj.getBoby());
		newObj.setAuthor(obj.getAuthor());

	}

	public Post fromDTO(PostDTO objDto) {
		return new Post(objDto.getId(), objDto.getDate(), objDto.getTitle(), objDto.getBoby(), objDto.getAuthor());
	}
}
