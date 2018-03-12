package com.example.fulge.a00coleguis;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulge on 05/03/2018.
 */

public class Class_Evento implements Parcelable {

    //ATRIBUTOS DE LA LIST VIEW

    String categoria;
    String ciudad;
    String fecha;
    String foto;
    String nombre;
    String provincia;

    ///////////////////////////////////////////////////////

    //CONSTRUCTOR VACÍO
    public Class_Evento() {
    }

    ///////////////////////////////////////////////////////

    //CONSTRUCTOR (ALT + INS)

    public Class_Evento(String categoria, String ciudad, String fecha, String foto, String nombre, String provincia) {
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.foto = foto;
        this.nombre = nombre;
        this.provincia = provincia;
    }

    //CONSTRUCTOR CON LAS VARIANTES QUE TENDRA UN LAYOUT (MA_A_00) (ALT + INS)

    public Class_Evento(String ciudad, String fecha, String nombre, String provincia) {
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.nombre = nombre;
        this.provincia = provincia;
    }

    ///////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////

    //NOMBRE PARA EL PACELABLE (HECHO DESPUES) CONSTRUCTOR
    public Class_Evento(Parcel e) {

        //PASAR EL PARCELABLRE
        readFromParcel(e);
    }

    ///////////////////////////////////////////////////////

    //CREATE DEL PARCELABLE (HECHO DESPUES)
    public static final Creator<Class_Evento> CREATOR = new Creator<Class_Evento>() {
        @Override
        public Class_Evento createFromParcel(Parcel in) {
            return new Class_Evento(in);
        }

        @Override
        public Class_Evento[] newArray(int size) {
            return new Class_Evento[size];
        }
    };

    //GET & SETTER (ALT + INS)

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String ciudad) {
        this.categoria = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    ///////////////////////////////////////////////////////

    //PARCELABLE (HECHO DESPUES)
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.categoria);
        dest.writeString(this.ciudad);
        dest.writeString(this.fecha);
        dest.writeString(this.foto);
        dest.writeString(this.nombre);
        dest.writeString(this.provincia);
    }

    ///////////////////////////////////////////////////////

    //METODO PARA EL PARCELABLE (HECHO DESPUES)

    private void readFromParcel(Parcel e) {
        this.categoria = e.readString();
        this.ciudad = e.readString();
        this.fecha = e.readString();
        this.foto = e.readString();
        this.nombre = e.readString();
        this.provincia = e.readString();
    }
}

