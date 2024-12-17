package vehiculos;

import java.util.ArrayList;
import java.util.List;

public class Fabricante {
    private String nombre;
    private Pais pais;
    private static List<Fabricante> fabricantes = new ArrayList<>();

    // Constructor
    public Fabricante(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
        fabricantes.add(this);
    }

    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public static Fabricante fabricaMayorVentas(){
        List<Vehiculo> vehiculos = Vehiculo.getVehiculos();
        int maxVentas = -1;
        Fabricante topFabricante = null;
        for (Fabricante fabricante : fabricantes) {
            int ventas = 0;
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getFabricante().equals(fabricante)) {
                    ventas++;
                }
            }
            if (ventas > maxVentas) {
                maxVentas = ventas;
                topFabricante = fabricante;
            }
        }
        if (topFabricante == null) {
            throw new IllegalStateException("No sales registered");
        }
        return topFabricante;
    }
}