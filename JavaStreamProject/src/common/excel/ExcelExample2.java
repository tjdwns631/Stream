package common.excel;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class ExcelExample2 {
	public static void main(String[] args) {
		EmployeeExcelWriter writer = new EmployeeExcelWriter();
		try {
			List<Employee> list = EmpDAO.getEmpList();
			List<Employee> col = list.stream()
					.filter(s -> s.getJobId().equals("IT_PROG"))
					.collect(Collectors.toList());
			writer.xlsWriter(col);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("엑셀 완료");
	}
}
