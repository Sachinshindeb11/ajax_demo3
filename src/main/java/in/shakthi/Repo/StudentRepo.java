package in.shakthi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shakthi.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

		Boolean existsByEmail(String mail);

}
