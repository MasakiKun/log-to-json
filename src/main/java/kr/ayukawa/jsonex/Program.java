package kr.ayukawa.jsonex;

import kr.ayukawa.jsonex.dao.EmployeeDao;
import kr.ayukawa.jsonex.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 간단한 직원 관리 어플리케이션
 *
 * https://www.baeldung.com/java-log-json-output
 * 위 문서 중 Logback 부분만 해봄
 */
public class Program {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public void execute() {
		logger.info("프로그램 시작");

		// 직원을 4명 만든다
		Employee emp1 = new Employee(1, "홍길동", 27, 10000.0);
		Employee emp2 = new Employee(2, "강감찬", 25, 10500.0);
		Employee emp3 = new Employee(3, "임꺽정", 30, 12000);
		Employee emp4 = new Employee(4, "이칠오", 27, 27500);

		// 고의로 예외를 일으켜본다
		// 1. 나이를 음수로 넣을 수 없다
		Employee incorrectEmployee;
		try {
			incorrectEmployee = new Employee(5, "이태백", -5, 300);
		} catch(Exception e) {
			logger.error("", e);
		}

		// 2. 급여를 음수로 넣을 수 없다
		try {
			incorrectEmployee = new Employee(6, "김삿갓", 50, -200);
		} catch(Exception e) {
			logger.error("", e);
		}

		// DAO를 통해, 직원을 저장한다
		EmployeeDao dao = new EmployeeDao();

		dao.add(emp1);
		dao.add(emp2);
		dao.add(emp3);
		dao.add(emp4);

		// 고의로 예외를 일으켜본다
		// 1. 동일 직원을 다시 추가할 수 없다
		try {
			dao.add(emp2);
		} catch(Exception e) {
			logger.error("", e);
		}

		// 2. 없는 직원을 삭제할 수 없다
		try {
			dao.remove(7);
		} catch(Exception e) {
			logger.error("", e);
		}

		// 3. 없는 직원을 조회하면 예외가 발생한다
		try {
			Employee findEmp = dao.findEmployee(7);
		} catch(Exception e) {
			logger.error("", e);
		}

		// 4. DAO를 통해 저장되지 않은, 존재하지 않는 직원을 수정하려 시도하면 예외가 발생한다
		try {
			Employee modifiedEmployee = new Employee(7, "허준", 33, 17000);
			dao.modify(modifiedEmployee);
		} catch(Exception e) {
			logger.error("", e);
		}

		logger.info("프로그램 종료");
	}

	public static void main(String[] args) {
		Program program = new Program();
		program.execute();
	}
}
