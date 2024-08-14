package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
@RequestMapping("/kafka")
class Controler {
	private Producer service;

	public Controler(Producer service) {
		this.service = service;
	}
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		service.sendMessage("teste", name);
		return "Mensagem enviada";
	}
	
	@PostMapping
	public String post(@RequestBody Produto produto) {
		service.sendMessageObj("teste", produto);
		return "Mensagem enviada";
	}
}