package com.mycompany.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.dao.CustomerDao;
import com.mycompany.dao.CustomerDaoImpl;
import com.mycompany.dto.Customer;

public class Demo {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("Choose an Option");
			System.out.println("1. Save Customers");
			System.out.println("2. Get All Custoemers");
			System.out.println("3. Get Customer By Customer Id");
			System.out.println("4. Update Customer by CustomerID");
			System.out.println("5. Delete Customer by CustomerID");
			System.out.println("6. Exit Program");

			choice = scanner.nextInt();
			CustomerDao customerDao =new CustomerDaoImpl();
			String data=null;
			Customer  customer =null;
			String[] elements=null;
			switch (choice) {
			case 1:
				System.out.println("Enter customer id , name ,phone,email,age, (enter in a single coma separated values)");
                data = scanner.next()+scanner.nextLine();
				elements = data.split(",");
				customer = new Customer(Integer.parseInt(elements[0]),elements[1],elements[2],elements[3],Integer.parseInt(elements[4])) ;
				System.out.println("is customer updated?" +customerDao.update(customer));
				System.out.println("is customer saved?" +customerDao.save(null));
				
				break;
			case 2:
				ArrayList<Customer> customers = customerDao.getAll();
				for(Customer customer2: customers) {
					System.out.println(customer2);
				}

				break;
			case 3:
				System.out.println("Enter custoerId");
				customer = customerDao.get(scanner.nextInt());
				System.out.println(customer);

				break;
			case 4:
				System.out.println("Enter customer id , name ,phone,email,age, (enter in a single coma separated values)");
               data = scanner.next()+scanner.nextLine();
				elements = data.split(",");
				customer = new Customer(Integer.parseInt(elements[0]),elements[1],elements[2],elements[3],Integer.parseInt(elements[4])) ;
                System.out.println("is customer updated?" +customerDao.update(customer));

				break;
			case 5:
				System.out.println("Enter custoerId");
				
				System.out.println("is customer Deleted?" +customerDao.delete(scanner.nextInt()));
				break;
			case 6:
				System.out.println("Exiting program");

				break;

			default:
				break;
			}

		} while (choice != 5);

		scanner.close();

	}

}
