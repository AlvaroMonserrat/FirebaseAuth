package com.example.firebaseauth;

// Buenas Prácticas: La primera letra de cada palabra de la clase debe ser con Mayuscula: e.i DatosPaciente
// Los nombres de los atributos se recomiendan que sean en minuscula. e.i rut. Si son dos palabras, la primera en miniscula y la segunda puede ser mayuscula. e.i: tiempoEv
// Esté tipo de clases tienen la particularidad de que no requieren librerías externas, son aisladas (no depende de otros objetos) y no tienen funciones lógicas.
// Estás caracteristicas hacen que se puedan llevar a un paquete llamado "model" y dentro de una subcarpeta llamada "data", 
// Esto le dará un orden y servirá para escalabilidad y portabilidad de código. 


public class datospaciente {
    String RUT;
    String name;
    String diag;
    String sexo;
    String edad;
    String fecha;
    String tiempoev;
    String medicamentos;
    String amorbidos;
    String herida1;


    public datospaciente(String RUT, String name, String diag, String sexo, String edad, String fecha, String tiempoev, String medicamentos, String amorbidos,String herida1) {
        this.RUT = RUT;
        this.name = name;
        this.diag = diag;
        this.sexo = sexo;
        this.edad = edad;
        this.fecha = fecha;
        this.tiempoev = tiempoev;
        this.medicamentos = medicamentos;
        this.amorbidos = amorbidos;
        this.herida1 = herida1;
    }


    public String getHerida1(){return  herida1;}

    public void setHerida1(String herida1){this.herida1 = herida1;}

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiag() {
        return diag;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTiempoev() {
        return tiempoev;
    }

    public void setTiempoev(String tiempoev) {
        this.tiempoev = tiempoev;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getAmorbidos() {
        return amorbidos;
    }

    public void setAmorbidos(String amorbidos) {
        this.amorbidos = amorbidos;
    }
}
