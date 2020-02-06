package com.hsi.graphql.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.repository.UserRepository;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Value("classpath:graphql/user.graphqls")
	Resource schemaResource; 
	
	private GraphQL graphQL;
	
	@PostConstruct
	public void loadSchema() throws IOException {
		File schemaFile = schemaResource.getFile();
		TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildWiring() {
		DataFetcher<List<User>> fetcherAllPerson = data -> {
			return (List<User>) userRepository.findAll();
		};

		DataFetcher<User> fetcherFindPerson = data -> {
			return userRepository.findByEmail(data.getArgument("email"));
		};

		return RuntimeWiring.newRuntimeWiring().type("Query",
				typeWriting -> typeWriting.dataFetcher("getAllPerson", fetcherAllPerson).dataFetcher("findPerson", fetcherFindPerson))
				.build();
	
	}

	@PostMapping("/addPerson")
	public String addPerson(@RequestBody List<User> persons) {
		userRepository.saveAll(persons);
		return "record inserted " + persons.size();
	}

	@GetMapping("/findAllPerson")
	public List<User> getPersons() {
		return (List<User>) userRepository.findAll();
	}

	@PostMapping("/getAll")
	public ResponseEntity<Object> getAll(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	@PostMapping("/getPersonByEmail")
	public ResponseEntity<Object> getPersonByEmail(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
	

}