package za.ac.cput.service;

import za.ac.cput.domain.Scooter;

import java.util.List;

public interface IScooterTypeService extends IService <Scooter,String> {
    public List<Scooter> getAll();
}
