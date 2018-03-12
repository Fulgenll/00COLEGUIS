package com.example.fulge.a00coleguis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fulge on 05/03/2018.
 */

//CREACION DEL ADAPTADOR

//HACEMOS REFERENCIA A LA CLASE

public class Adaptador_Evento extends ArrayAdapter<Class_Evento> {
    ArrayList<Class_Evento> eventos;
    Context c;
    public Adaptador_Evento(Context c, ArrayList<Class_Evento> eventos) {
        super(c, R.layout.list_custom_eventos, eventos);
        this.eventos = eventos;
        this.c = c;

        ///////////////////////////////////////////////////////

    }
    public View getView(int position, View view, ViewGroup
            viewGroup) {

        //HACER EL INFLADOR (LUEGO SERA LO QUE HARA QUE SE VEA EN EL MAIN ACTIVITY)

        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_custom_eventos, null);

        ///////////////////////////////////////////////////////

        //DECLARAR VARIANTES DE LA CLASE QUE SE MOSTRARAN EN EL LA LISTVIEW

        //TEXTVIEW NOMBRE
        TextView tv_nombreeventolistcustomevento = (TextView)
                item.findViewById(R.id.tvnombreeventolistcustomevento);
        tv_nombreeventolistcustomevento.setText(eventos.get(position).getNombre());

        //TEXTVIEW CIUDAD
        TextView tv_ciudadlistcustomevento = (TextView)
                item.findViewById(R.id.tvciudadlistcustomevento);
        tv_ciudadlistcustomevento.setText(eventos.get(position).getCiudad() );

        //TEXTVIEW FECHA
        TextView tv_fechalistcustomevento = (TextView)
                item.findViewById(R.id.tvfechalistcustomevento);
        tv_fechalistcustomevento.setText(eventos.get(position).getFecha());

        //IMAGE VIEW
        String cartel = eventos.get(position).getFoto();

        int idImagen = c.getResources().getIdentifier(cartel,"drawable",c.getPackageName());
        ImageView img_eventolistcustomevento = (ImageView)item.findViewById(R.id.imgeventolistcustomevento);
        img_eventolistcustomevento.setImageResource(idImagen);

        //FIN
        return item;
    }
}
