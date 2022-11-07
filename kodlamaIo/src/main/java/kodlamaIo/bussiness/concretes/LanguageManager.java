package kodlamaIo.bussiness.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.bussiness.abstracts.LanguageService;
import kodlamaIo.bussiness.request.language.CreateLanguageRequest;
import kodlamaIo.bussiness.request.language.DeleteLanguageRequest;
import kodlamaIo.bussiness.request.language.UpdateLanguageRequest;
import kodlamaIo.bussiness.response.GetAllLanguageResponse;
import kodlamaIo.dataAccess.abstracts.LangugageRepository;
import kodlamaIo.entities.Language;

@Service
public class LanguageManager implements LanguageService{
	
	LangugageRepository langugageRepository;
	
	
	@Autowired
	public LanguageManager (LangugageRepository langugageRepository) {
		this.langugageRepository = langugageRepository;
	}
	
	public boolean languageNameExist(Language languageName) {
		List<Language> lanugageList = langugageRepository.findAll();
		for(Language language2 : lanugageList) {
			if(language2.getName().toLowerCase().matches(languageName.getName().toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = langugageRepository.findAll();
		List<GetAllLanguageResponse> languageResponse = new ArrayList<GetAllLanguageResponse>();
		
		for(Language language : languages) {
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}
		
		return languageResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language= new Language();
		language.setName(createLanguageRequest.getName());
		if(!languageNameExist(language)) {
			langugageRepository.save(language);
		}
		else {
			
			System.out.println("Name  Exist");
		}
		
		
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language language = new Language();
		language.setName(deleteLanguageRequest.getName());
		if(languageNameExist(language)) {
			langugageRepository.delete(language);
			
		}
		else {
			System.out.println("There is no language registered to this name");
		}
		}
		
	



	@Override
	public void update(int id, UpdateLanguageRequest updateLanguageRequest) {
		for(Language languages : langugageRepository.findAll()) {
			if(languages.getName().equals(updateLanguageRequest.getName())) {
				
				Language language = langugageRepository.findById(id).get();
				language.setName(updateLanguageRequest.getName());
				langugageRepository.save(language);
			}
			}
			
		
		
		
		
		
	}

}
