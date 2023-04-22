package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
//		Pessoa p1 = new Pessoa(null, "Vinicius Castro", "vcgs@gmail.com");
//		Pessoa p2 = new Pessoa(null, "Maria do Bairro", "maria@bairro.com");
//		Pessoa p3 = new Pessoa(null, "Joao Jogos", "jogos@jogos.com");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Pessoa pessoa1 = entityManager.find(Pessoa.class, 2);
		Pessoa pessoa = entityManager.find(Pessoa.class, 1);
		
		entityManager.getTransaction().begin();
		entityManager.remove(pessoa1);
		entityManager.getTransaction().commit();
		
		
//		entityManager.getTransaction().begin();
//		entityManager.persist(p1);
//		entityManager.persist(p2);
//		entityManager.persist(p3);
//		entityManager.getTransaction().commit();

		System.out.println(pessoa);
		System.out.println(pessoa1);

		entityManagerFactory.close();
		entityManager.close();

	}

}
