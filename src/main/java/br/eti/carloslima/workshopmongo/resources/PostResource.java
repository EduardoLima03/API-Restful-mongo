package br.eti.carloslima.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.eti.carloslima.workshopmongo.domain.Post;
import br.eti.carloslima.workshopmongo.resources.util.URL;
import br.eti.carloslima.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	/*
	 * @RequestMapping(method = RequestMethod.GET) public
	 * ResponseEntity<List<PostDTO>> findAll() {
	 * 
	 * List<Post> list = service.findAll();
	 * 
	 * // convertendo a lista de user para uma dto List<PostDTO> listDTO =
	 * list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	 * 
	 * return ResponseEntity.ok().body(listDTO); }
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {

		Post obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	// recuperando um post pelo titulo

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);

		return ResponseEntity.ok().body(list);
	}
}
