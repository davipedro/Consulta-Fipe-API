package br.com.fipeconsulta.fipeconsulta;

import br.com.fipeconsulta.fipeconsulta.menu.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeconsultaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeconsultaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.listarSaidas();
	}
}
