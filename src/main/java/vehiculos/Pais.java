package vehiculos;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nombre;
    private static List<Pais> paises = new ArrayList<>();

    // Constructor
    public Pais(String nombre) {
        this.nombre = nombre;
        paises.add(this);
    }

    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Pais paisMasVendedor() {
        List<Vehiculo> vehiculos = Vehiculo.getVehiculos();
        int maxVentas = -1;
        Pais topPais = null;
        for (Pais pais : paises) {
            int ventas = 0;
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getFabricante().getPais().equals(pais)) {
                    ventas++;
                }
            }
            if (ventas > maxVentas) {
                maxVentas = ventas;
                topPais = pais;
            }
        }
        if (topPais == null) {
            throw new IllegalStateException("No sales registered");
        }
        return topPais;
    }

}