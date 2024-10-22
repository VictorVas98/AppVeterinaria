package com.example.AppVeterinaria.Servicios;

import com.example.AppVeterinaria.Entidades.TelefonoSucursal;
import com.example.AppVeterinaria.Repositorios.TelefonoSucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TelefonoSucursalService {

    @Autowired
    private TelefonoSucursalRepository telefonoSucursalRepository;

    public List<TelefonoSucursal> obtenerTodosLosTelefonosSucursal() {
        return telefonoSucursalRepository.findAll();
    }

    public Optional<TelefonoSucursal> obtenerTelefonoSucursalPorId(int id) {
        return telefonoSucursalRepository.findById(id);
    }

    public TelefonoSucursal crearTelefonoSucursal(TelefonoSucursal telefonoSucursal) {
        return telefonoSucursalRepository.save(telefonoSucursal);
    }

    public TelefonoSucursal actualizarTelefonoSucursal(TelefonoSucursal telefonoSucursal) {
        return telefonoSucursalRepository.save(telefonoSucursal);
    }

    public boolean eliminarTelefonoSucursal(int id) {
        if (telefonoSucursalRepository.existsById(id)) {
            telefonoSucursalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
