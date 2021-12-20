package berek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tasks {
	
	List<Entity> salaries = new ArrayList<Entity>();
	FileManager fmObj = new FileManager();
	
	public void fileRead(String fileName) {
		salaries = fmObj.fileReader(fileName);
	}
	
	public void dataWriteOut() {
		for (Entity entity : salaries) {
			System.out.print(entity.getName());
			System.out.print(";");
			System.out.print(entity.getGender());
			System.out.print(";");
			System.out.print(entity.getDepartment());
			System.out.print(";");
			System.out.print(entity.getEntry());
			System.out.print(";");
			System.out.print(entity.getSalary());
			System.out.println();
		}
	}
	
	public Integer howManyData() {
		int workersNumber = 0;
		for (Entity entity : salaries) {
			workersNumber++;
		}
		return workersNumber;
	}
	
	public Double avarageSalaries() {
		Integer piece = 0;
		Integer total = 0;
		for (Entity entity : salaries) {
			piece++;
			total += entity.getSalary();
		}
		return (double) Math.round((total/piece*10)/1000)/10;
	}
	
	public void askDepartment() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("K�rem egy r�szleg nev�t: ");
			String department = br.readLine();
			Integer maxSalary = -1;
			for (Entity entity : salaries) {
				if (entity.getDepartment().equalsIgnoreCase(department) && entity.getSalary()>maxSalary) {
					maxSalary = entity.getSalary();
				}
			}
			for (Entity entity : salaries) {
				if (entity.getSalary().equals(maxSalary) && entity.getDepartment().equalsIgnoreCase(department)) {
					System.out.println("6. feladat: A legt�bbet keres� dolgoz� a megadott r�szlegen");
					System.out.println("N�v: "+entity.getName());
					System.out.println("Neme: "+entity.getGender());
					System.out.println("Bel�p�s: "+entity.getEntry());
					System.out.println("B�r: "+entity.getSalary());
				}

			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void statistic() {
		int beszerzes = 0;
		int penzugy = 0;
		int asztalosmuhely = 0;
		int ertekesites = 0;
		int lakatosmuhely = 0;
		int karbantartas = 0;
		int szerelomuhely = 0;
		int szemelyzeti = 0;
		
		for (Entity entity : salaries) {
			if (entity.getDepartment().equalsIgnoreCase("beszerz�s")) {
				beszerzes++;
			}
		}
		System.out.println("beszerz�s - "+beszerzes+" f�");
		
		for (Entity entity : salaries) {
			if (entity.getDepartment().equalsIgnoreCase("p�nz�gy")) {
				penzugy++;
			}
		}
		System.out.println("penz�gy - "+penzugy+" f�");
		
		for (Entity entity : salaries) {
			if (entity.getDepartment().equalsIgnoreCase("asztalosm�hely")) {
				asztalosmuhely++;
			}
		}
		System.out.println("asztalosm�hely - "+asztalosmuhely+" f�");
		
		for (Entity entity : salaries) {
			if (entity.getDepartment().equalsIgnoreCase("�rt�kes�t�s")) {
				ertekesites++;
			}
		}
		System.out.println("�rt�kes�t�s - "+ertekesites+" f�");
		
		for (Entity entity : salaries) {
			if (entity.getDepartment().equalsIgnoreCase("lakatosm�hely")) {
				lakatosmuhely++;
			}
		}
		System.out.println("lakatosm�hely - "+lakatosmuhely+" f�");
		
		for (Entity entity : salaries) {
			if (entity.getDepartment().equalsIgnoreCase("karbantart�s")) {
				karbantartas++;
			}
		}
		System.out.println("karbantart�s - "+karbantartas+" f�");
		
		for (Entity entity : salaries) {
			if (entity.getDepartment().equalsIgnoreCase("szerel�m�hely")) {
				szerelomuhely++;
			}
		}
		System.out.println("szerel�m�hely - "+szerelomuhely+" f�");
		
		for (Entity entity : salaries) {
			if (entity.getDepartment().equalsIgnoreCase("szem�lyzeti")) {
				szemelyzeti++;
			}
		}
		System.out.println("szem�lyzeti - "+szemelyzeti+" f�");
	}
	
	
}
