package br.com.paulohss.todolistapi;

import br.com.paulohss.todolistapi.entity.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApiApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateToDoSuccess() {
		var todo = new ToDo(
				"Lista de compras",
				"1Kg cenoura, 2Kg Feijão, 1Kg açúcar",
				false,
				1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(todo.getName())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].accomplished").isEqualTo(todo.getAccomplished())
				.jsonPath("$[0].priority").isEqualTo(todo.getPriority());
	}

	@Test
	void testCreateToDoFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new ToDo("", "", false, 1)
				).exchange()
				.expectStatus().isBadRequest();
	}

}
