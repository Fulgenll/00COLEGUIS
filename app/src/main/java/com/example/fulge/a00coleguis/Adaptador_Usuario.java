package com.example.fulge.a00coleguis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulge on 05/03/2018.
 */

public class Adaptador_Usuario extends ArrayAdapter<Class_Usuario> {
    ArrayList<Class_Usuario> usuarios;
    Context c;
    public Adaptador_Usuario(Context c, ArrayList<Class_Usuario> usuarios) {
        super(c, R.layout.list_custom_usuarios, usuarios);
        this.usuarios = usuarios;
        this.c = c;

        ///////////////////////////////////////////////////////

    }
    public View getView(int position, View view, ViewGroup
            viewGroup) {

        //HACER EL INFLADOR (LUEGO SERA LO QUE HARA QUE SE VEA EN EL MAIN ACTIVITY)

        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_custom_usuarios, null);

        ///////////////////////////////////////////////////////

        //DECLARAR VARIANTES DE LA CLASE QUE SE MOSTRARAN EN EL LA LISTVIEW

        //TEXTVIEW NOMBRE
        TextView tv_nombrelistcustomusuarios = (TextView)
                item.findViewById(R.id.tvnombrelistcustomusuarios);
        tv_nombrelistcustomusuarios.setText(usuarios.get(position).getNick());

        //TEXTVIEW EDAD
        TextView tv_edadlistcustomusuarios = (TextView)
                item.findViewById(R.id.tvedadlistcustomusuarios);
        tv_edadlistcustomusuarios.setText(usuarios.get(position).getEdad() );

        //TEXTVIEW GUSTOS
        TextView tv_gustoslistcustomusuarios1 = (TextView)
                item.findViewById(R.id.tvgustoslistcustomusuarios1);
        for (int i=0; i<usuarios.get(position).getGustos().size(); i++){
            //obtenemosla listsa de gustos del objeto usuario
            List<String> listaGustos =usuarios.get(position).getGustos();
            //añadimos cada uno de los gustos de la lista
            tv_gustoslistcustomusuarios1.setText(listaGustos.get(i)+"\n");
        }

        //TEXTVIEW AVATAR
        TextView tv_perfillistcustomusuarios = (TextView)
                item.findViewById(R.id.tvperfillistcustomusuarios);
        tv_perfillistcustomusuarios.setText(usuarios.get(position).getAvatar());


        //FIN
        return item;
    }
}