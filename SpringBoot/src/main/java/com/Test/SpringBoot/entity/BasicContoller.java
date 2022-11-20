package com.Test.SpringBoot.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicContoller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private PersonDao personDao;
		
	@RequestMapping("/start")
	public String start() {
		
		try {
		Person person = new Person();
		person.setSerialNo(1L);
		person.setFirstName("���w");
		person.setLastName("�i");
		personDao.save(person);
		
		Person person1 = new Person();
		person1.setSerialNo(2L);
		person1.setFirstName("�X�s");
		person1.setLastName("�s");
		personDao.save(person1);
		
		Car car= new Car();
		car.setSerialNo(1L);
		car.setCarType("���h");
		car.setCountry("�w��");
		car.setPerson(person);
		carDao.save(car);
		
		car= new Car();
		car.setSerialNo(2L);
		car.setCarType("Toyota");
		car.setCountry("�饻");
		car.setPerson(person1);
		carDao.save(car);
		}catch(Exception e) {
			return String.format("Person(%d), Car(%d)<hr> %s", 
					                        personDao.count(),
					                        carDao.count(),
					                        e.getMessage());
		}
		return String.format("Person(%d), Car(%d)", 
				                personDao.count(), carDao.count());
	}
	
	@RequestMapping("/show")
	public String show() {
		List<Car> carlist = carDao.queryBycarType("���h");
		Car c = carlist.get(0);
		String msg = String.format("[%s %s]�����D�O[%s %s](%d)(%s).", 
				                           c.getCarType(),
				                           c.getCountry(),
				                           c.getPerson().getLastName(),
				                           c.getPerson().getFirstName(),
				                           c.getPerson().getCarlist().size(),
				                           c.getPerson().getCarlist().get(0).getCarType());
		return msg;		
	}
}
