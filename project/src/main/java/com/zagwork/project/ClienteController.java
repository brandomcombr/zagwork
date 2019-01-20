package com.zagwork.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Cliente> findAll() {
		return repository.findAll().collectList().block();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void salvar(@RequestBody Cliente cliente) {
		Flux.just(cliente).map(c -> repository.save(c));
	}

}