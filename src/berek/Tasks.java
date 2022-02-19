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
			System.out.print("Kérem egy részleg nevét: ");
			String department = br.readLine();
			Integer maxSalary = -1;
			for (Entity entity : salaries) {
				if (entity.getDepartment().equalsIgnoreCase(department) && entity.getSalary()>maxSalary) {
					maxSalary = entity.getSalary();
				}
			}
			for (Entity entity : salaries) {
				if (entity.getSalary().equals(maxSalary) && entity.getDepartment().equalsIgnoreCase(department)) {
					System.out.println("6. feladat: A legtöbbet keresõ dolgozó a megadott részlegen");
					System.out.println("Név: "+entity.getName());
					System.out.println("Neme: "+entity.getGender());
					System.out.println("Belépés: "+entity.getEntry());
					System.out.println("Bér: "+entity.getSalary());
				}

			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void statistic() {
		List<String> departs = new ArrayList<String>();
		for (int i = 0; i < salaries.size(); i++) {
			boolean isIn = false;
			for (int j = 0; j < departs.size(); j++) {
				if (salaries.get(i).getDepartment().equals(departs.get(j))) {
					isIn = true;
				}
			}
			if (isIn == false) {
				departs.add(salaries.get(i).getDepartment());
			}
		}
		
		int[] listHelp = new int[salaries.size()];
		for (int i = 0; i < salaries.size(); i++) {
			for (int j = 0; j < departs.size(); j++) {
				if (salaries.get(i).getDepartment().equals(departs.get(j))) {
					listHelp[j] ++;
				}
			}
		}
		for (int i = 0; i < listHelp.length; i++) {
			System.out.println(departs.get(i) + " - "+ listHelp[i]);
		}
	}
	
	
}
