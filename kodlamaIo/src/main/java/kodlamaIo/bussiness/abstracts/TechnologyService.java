package kodlamaIo.bussiness.abstracts;

import java.util.List;

import kodlamaIo.bussiness.request.technology.CreateTechnologyRequest;
import kodlamaIo.bussiness.request.technology.DeleteTechnologyRequest;
import kodlamaIo.bussiness.request.technology.UpdateTechnologyRequest;
import kodlamaIo.bussiness.response.GetAllTechnologyResponse;

public interface TechnologyService {
	List<GetAllTechnologyResponse> getAll();
	public void add(CreateTechnologyRequest createTechnologyRequest);
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest);
	
}
