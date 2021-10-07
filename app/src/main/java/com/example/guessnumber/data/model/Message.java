package com.example.guessnumber.data.model;

import java.io.Serializable;

public class Message implements Serializable {
    String nombre;
    int intento;

    public Message() {
    }

    public Message(String nombre, int intento) {
        this.nombre = nombre;
        this.intento = intento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    @Override
    public String toString() {
        return "Message{" +
                "nombre='" + nombre + '\'' +
                ", intento=" + intento +
                '}';
    }
}
