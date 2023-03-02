package ro.itschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Helmets;
import ro.itschool.entity.User;
import ro.itschool.repository.HelmetsRepository;

import java.util.List;

@Service
public class HelmetsService implements IHelmetsService{

    @Autowired
    private HelmetsRepository helmetsRepository;

    @Override
    public List<Helmets> getHelmets() {
        return helmetsRepository.findAll();
    }

    @Override
    public void createHelmets(Helmets helmets) {
        helmetsRepository.save(helmets);
    }

    @Override
    public void updateHelmets(Integer id, Helmets helmets) {
        Helmets helmetsUpdate = helmetsRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("User with id %d doesn't exist", id)));
        helmetsUpdate.setHelmetColour(helmets.getHelmetColour());
        helmetsUpdate.setHelmetName(helmets.getHelmetName());
        helmetsUpdate.setHelmetPrice(helmets.getHelmetPrice());
        helmetsUpdate.setHelmetType(helmetsUpdate.getHelmetType());
        helmetsRepository.save(helmetsUpdate);
    }

    @Override
    public void deleteHelmets(Integer id) {
        boolean helmetsExists = helmetsRepository.existsById(id);
        if(!helmetsExists){
            throw new IllegalStateException(String.format("User with id %d doesn't exist", id));
        }
        helmetsRepository.deleteById(id);

    }


}
