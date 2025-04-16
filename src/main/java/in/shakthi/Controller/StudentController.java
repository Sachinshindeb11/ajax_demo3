package in.shakthi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.shakthi.Entity.Student;
import in.shakthi.Repo.StudentRepo;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepo repo;

	@GetMapping("/reg")
	public String getReg() {
		return "Registration";
	}

	@GetMapping("/checkEmail")
	public ResponseEntity<Boolean> checkMail(@RequestParam String mail) {
		Boolean available = !repo.existsByEmail(mail);
		return ResponseEntity.ok(available);
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Student student, Model model) {
		Student st = repo.save(student);
		model.addAttribute("message", "Data " + st.getId() + " has been addded succesfully");
		return "Registration";
	}
}
