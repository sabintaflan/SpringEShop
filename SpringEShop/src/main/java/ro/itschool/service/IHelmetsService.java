package ro.itschool.service;

import ro.itschool.entity.Helmets;
import ro.itschool.entity.User;

import java.util.List;

public interface IHelmetsService {
    List<Helmets> getHelmets();

    void createHelmets(Helmets helmets);

    void updateHelmets(Integer id, Helmets helmets);

    void deleteHelmets(Integer id);
}
