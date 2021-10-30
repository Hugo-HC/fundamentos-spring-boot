package com.fundamentos.springboot.Fundamentos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.fundamentos.springboot.Fundamentos.bean.MyBean;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.Fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.Fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.Fundamentos.entity.User;
import com.fundamentos.springboot.Fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.Fundamentos.repository.UserRepository;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	
	private ComponentDependency componentDependency;
	
	private MyBean myBean;
	
	private MyBeanWithDependency myBeanWithDependency;
	
	private MyBeanWithProperties myBeanWithProperties;
	
	private UserPojo userPojo;
	
	private UserRepository userRepository;

	// Inyeccion de dependencia puede ir o no el autowired
	// @Qualifier Toma el nombre de la clase pero con minuscula cuando tiene mas de una implementacion
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ejemplosAnteriores();
		saveUserInDataBase();
		getInformationJpqlFromUser();
	}
	
	private void getInformationJpqlFromUser() {
		/*
		LOGGER.info("El usuario con el metodo " + 
				userRepository.findByUserEmail("hugo@gmail.com").
				orElseThrow(()-> new RuntimeException("No se encontro el usuario")));
		
		userRepository.findAndSort("Hugo", Sort.by("id").descending())
			.stream()
			.forEach(user -> LOGGER.info("Usuario con metodo getInformationJpqlFromUser" + user));
		
		userRepository.findByName("HHC")
			.stream().forEach(user -> LOGGER.info("USUARIO CON QUERY METHODS"+ user));
		
		LOGGER.info("USUARIO CON QUERY METHODS: " + userRepository.findByEmailAndName("hugo3@gmail.com", "DMC")
			.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
		
		userRepository.findByNameLike("%Hugo1%")
			.stream()
			.forEach(user -> LOGGER.info("Usuario finByNamelike" + user));
		
		userRepository.findByNameOrEmail(null,"hugo7@gmail.com")
			.stream()
			.forEach(user -> LOGGER.info("Usuario findByNameOrEmail" + user));
		
		userRepository.findByNameOrEmail(null,"hugo7@gmail.com")
			.stream()
			.forEach(user -> LOGGER.info("Usuario findByNameOrEmail" + user));
		*/
		
		userRepository.findByBirthDateBetween(LocalDate.of(2021, 5, 1), LocalDate.of(2021, 10, 15))
			.stream()
			.forEach(user -> LOGGER.info("USUARIO CON INTERVALO DE FECHAS: " + user));;
		/*
		userRepository.findByNameLikeOrderByIdDesc("%Hugo1%")
			.stream()
			.forEach(user -> LOGGER.info("TODOS LOS USUARIOS ENCONTRADOS CON LIKE Y ORDENADOS :" + user));
		*/
		userRepository.findByNameContainingOrderByIdDesc("Hugo1")
		.stream()
		.forEach(user -> LOGGER.info("TODOS LOS USUARIOS ENCONTRADOS CON LIKE Y ORDENADOS :" + user));
		
	}
	
	private void saveUserInDataBase(){
		User user1 = new User("Hugo","hugo@gmail.com", LocalDate.of(2021, 10, 30));
		User user2 = new User("HHC","hugo2@gmail.com", LocalDate.of(2021, 5, 29));
		User user3 = new User("DMC","hugo3@gmail.com", LocalDate.of(2021, 1, 30));
		User user4 = new User("Hugo4","hugo4@gmail.com", LocalDate.of(2021, 7, 30));
		User user5 = new User("HHC","hugo5@gmail.com", LocalDate.of(2021, 8, 30));
		User user6 = new User("Hugo6","hugo6@gmail.com", LocalDate.of(2021, 9, 30));
		User user7 = new User("Hugo7","hugo7@gmail.com", LocalDate.of(2021, 11, 30));
		User user8 = new User("Hugo8","hugo8@gmail.com", LocalDate.of(2021, 12, 30));
		User user9 = new User("Hugo9","hugo9@gmail.com", LocalDate.of(2021, 3, 30));
		User user10 = new User("Hugo10","hugo10@gmail.com", LocalDate.of(2021, 2, 10));
		User user11 = new User("Hugo11","hugo11@gmail.com", LocalDate.of(2021, 10, 15));
		User user12 = new User("Hugo12","hugo12@gmail.com", LocalDate.of(2021, 10, 3));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
		
		list.stream().forEach(userRepository::save);
	}
	
	private void ejemplosAnteriores() {
		// TODO Auto-generated method stub
				componentDependency.saludar();
				myBean.print();
				myBeanWithDependency.printWithDependency();
				System.out.println(myBeanWithProperties.funtion());
				System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
				
				try {
					// error
					int value = 10/0;
					LOGGER.info("MI VALOR :" + value);
				} catch (Exception e) {
					LOGGER.error("ERROR AL DIVIDIR POR 0" + e.getMessage());
				}
	}
}
