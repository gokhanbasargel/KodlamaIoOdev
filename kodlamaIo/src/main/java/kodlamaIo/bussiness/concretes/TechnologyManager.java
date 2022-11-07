package kodlamaIo.bussiness.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.bussiness.abstracts.TechnologyService;
import kodlamaIo.bussiness.request.technology.CreateTechnologyRequest;
import kodlamaIo.bussiness.request.technology.DeleteTechnologyRequest;
import kodlamaIo.bussiness.request.technology.UpdateTechnologyRequest;
import kodlamaIo.bussiness.response.GetAllTechnologyResponse;
import kodlamaIo.dataAccess.abstracts.TechnologyRepository;
import kodlamaIo.entities.Technology;
@Service
public class TechnologyManager implements TechnologyService {
		TechnologyRepository technologyRepository;
		
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository) {
			super();
			this.technologyRepository = technologyRepository;
		}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponse = new ArrayList<GetAllTechnologyResponse>();
		
		for(Technology technology : technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			technologyResponse.add(responseItem);
		}
		
		return technologyResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		if(!TechnologyNameExist(technology)) {
			technologyRepository.save(technology);
			
		}
		else {
			System.out.println("Name Exist");
		}
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(deleteTechnologyRequest.getName());
		
		if(TechnologyNameExist(technology)) {
			technologyRepository.delete(technology);
		}
		else {
			System.out.println("Name doesn't exist");
		}
		
	}

	@Override
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		
		for(Technology technologies : technologyRepository.findAll()) {
			
			if(TechnologyNameExist(technologies)) {
				Technology technology1 = technologyRepository.findById(id).get();
				technologyRepository.save(technology1);
			}
		}
		
	}
	
	public boolean TechnologyNameExist(Technology technology) {
		List<Technology> technologies = technologyRepository.findAll();
		for(Technology technology1 : technologies) {
			if(technology.getName().toLowerCase().matches(technology1.getName().toLowerCase())) {
				return true;
			}
			
		}
		return false;
		
	}

}
