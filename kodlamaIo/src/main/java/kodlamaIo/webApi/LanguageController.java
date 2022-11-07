package kodlamaIo.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.bussiness.abstracts.LanguageService;
import kodlamaIo.bussiness.request.language.CreateLanguageRequest;
import kodlamaIo.bussiness.request.language.DeleteLanguageRequest;
import kodlamaIo.bussiness.request.language.UpdateLanguageRequest;
import kodlamaIo.bussiness.response.GetAllLanguageResponse;

@RestController
@RequestMapping("api/languages")
public class LanguageController {
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
		
	}
	
	
	@GetMapping("/getAll")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	
	
	
	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
		languageService.add(createLanguageRequest);
		
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
	}
	@PutMapping("/update/{id}")
	public void update (@PathVariable int id, @RequestBody UpdateLanguageRequest updateLanguageRequest) {
		languageService.update(id, updateLanguageRequest);
	}

}
