package com.example.RestTemp;

import com.example.RestTemp.User.User;
import com.example.RestTemp.UserRepo.User_repo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTempApplicationTests {

	@Autowired
	private User_repo userRepo;

	@Test
	public void saveusertest() {
		User u=new User("Akash","belli","987654321","245Card","jan-fed-2014");
		User u1=new User("balvir","mohgavir","569874123","2365Card","jan-may-2240");
		User u2=new User("cancee","mancee","589632147","2458Card","jun-july-2088");
		User u3=new User("Dimon","devil","321456987","895Card","jan-April-2028");
		userRepo.save(u);
		log.info("u is sucessfull");
		userRepo.save(u1);
		log.info("u1 is sucessfull");
		userRepo.save(u2);
		log.info("u2 is sucessfull");
		userRepo.save(u3);
		log.info("u3 is sucessfull");
	}

	@Test
	public void getusertest()
	{
		assertNotNull(userRepo.findAll());
	}

	@Test
	public void putusertest()
	{
		User u=userRepo.findById(2L).get();
		u.setFname("amiba");
		u.setLname("verydeger");
		u.setCvv("123456789");
		u.setCard_number("card1234567890");
		u.setExpire_data("dec-1020");
		userRepo.save(u);
	}
	@Test
	public void delettest()
	{
		userRepo.deleteById(202L);
	}


}
