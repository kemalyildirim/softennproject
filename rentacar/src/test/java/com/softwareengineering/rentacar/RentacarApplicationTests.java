package com.softwareengineering.rentacar;

import com.softwareengineering.rentacar.DAO.*;
import com.softwareengineering.rentacar.controller.CarController;
import com.softwareengineering.rentacar.controller.CityController;
import com.softwareengineering.rentacar.model.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentacarApplicationTests {

	@InjectMocks
	CityController cityCont;

	@InjectMocks
	CarController carCont;

	@Mock
	CityDAO cityDAO;

	@Mock
	CarDAO carDAO;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllCities(){
		when(cityCont.getAll()).thenReturn(Stream
		.of(new CityClass("Mersin")).collect(Collectors.toList()));
		assertEquals(1,cityDAO.getAllCities().size());
	}
	@Test
	public void searchCarByBranchTest(){
		BranchClass branch = new BranchClass(1);
		CarClass car = new CarClass(4,branch);
		List<CarClass> list = new ArrayList<CarClass>();
		list.add(car);
		when(carDAO.CarsByBranchId(branch.getId())).thenReturn(list);
		assertEquals(car.getBranch().getId(),carDAO.CarsByBranchId(branch.getId()).get(0).getBranch().getId());
	}
	@Test
	public void ListCarsTest(){
		BranchClass branch = new BranchClass(1);
		when(carCont.getCarsByBranch(branch.getId())).thenReturn(Stream
		.of(new CarClass(4,new BranchClass(1)), new CarClass(5,new BranchClass(1)), new CarClass(6,new BranchClass(1))).collect(Collectors.toList()));
		assertEquals(3,carDAO.CarsByBranchId(1).size());
	}
	@Test
	public void GetCarTest(){
		List<CarClass> list = new ArrayList<CarClass>();
		CarClass car1 = new CarClass(4,"bmw","5.20");
		CarClass car2 = new CarClass(5,"Tesla","S");

		list.add(car1); list.add(car2);
		when(carDAO.getAllCars()).thenReturn(list);
		//test
		List<CarClass> carlist = carCont.getAll();
		assertEquals(2,carlist.size());
		verify(carDAO,times(1)).getAllCars();
	}

}
