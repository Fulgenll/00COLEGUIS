package com.example.fulge.a00coleguis;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by fulge on 05/03/2018.
 */

public class Class_Usuario implements Parcelable {

    //ATRIBUTOS DE LA LIST VIEW

    String descripcion;
    int edad;
    List<String> gustos;
    String lugar;
    String mail;
    String nick;
    String password;
    String avatar;

    ///////////////////////////////////////////////////////

    //CONSTRUCTOR VACÍO
    public Class_Usuario() {
    }

    ///////////////////////////////////////////////////////

    //CONSTRUCTOR (ALT + INS)

    public Class_Usuario(String descripcion, int edad, List<String> gustos, String lugar, String mail, String nick, String password, String avatar) {
        this.descripcion = descripcion;
        this.edad = edad;
        this.gustos = gustos;
        this.lugar = lugar;
        this.mail = mail;
        this.nick = nick;
        this.password = password;
        this.avatar = avatar;
    }
    //CONSTRUCTOR CON LAS VARIANTES QUE TENDRA UN LAYOUT (MA_A_02) (ALT + INS)
    public Class_Usuario(String descripcion, int edad, String mail, String nick, String password) {
        this.descripcion = descripcion;
        this.edad = edad;
        this.mail = mail;
        this.nick = nick;
        this.password = password;
    }

    //CONSTRUCTOR CON LAS VARIANTES QUE TENDRA UN LAYOUT (MA_A_00) (ALT + INS)
        public Class_Usuario(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }
    ///////////////////////////////////////////////////////

    //NOMBRE PARA EL PACELABLE (HECHO DESPUES) CONSTRUCTOR
    public Class_Usuario(Parcel u) {

        //PASAR EL PARCELABLRE
        readFromParcel(u);
    }

    ///////////////////////////////////////////////////////

    //CREATE DEL PARCELABLE (HECHO DESPUES)
    public static final Parcelable.Creator<Class_Evento> CREATOR = new Parcelable.Creator<Class_Evento>() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getGustos() {
        return gustos;
    }

    public void setGustos(List<String>  gustos1) {
        this.gustos = gustos1;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    ///////////////////////////////////////////////////////

    //PARCELABLE (HECHO DESPUES)
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.descripcion);
        dest.writeInt(this.edad);

        dest.writeList(this.gustos);
        dest.writeString(this.lugar);
        dest.writeString(this.mail);
        dest.writeString(this.nick);
        dest.writeString(this.password);
        dest.writeString(this.avatar);
    }

    ///////////////////////////////////////////////////////

    //METODO PARA EL PARCELABLE (HECHO DESPUES)

    private void readFromParcel(Parcel u) {
        this.descripcion = u.readString();
        this.edad = u.readInt();
        u.readList(this.gustos,null);
        this.lugar = u.readString();
        this.mail = u.readString();
        this.nick = u.readString();
        this.password = u.readString();
        this.avatar = u.readString();
    }

}
