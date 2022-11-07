package kodlamaIo.bussiness.abstracts;
import kodlamaIo.bussiness.request.language.CreateLanguageRequest;
import kodlamaIo.bussiness.request.language.DeleteLanguageRequest;
import kodlamaIo.bussiness.request.language.UpdateLanguageRequest;
import kodlamaIo.bussiness.response.GetAllLanguageResponse;
import java.util.List;
public interface LanguageService {
	List<GetAllLanguageResponse> getAll();
	void add(CreateLanguageRequest createLanguageRequest);
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(int id, UpdateLanguageRequest updateLanguageRequest);
	

}
