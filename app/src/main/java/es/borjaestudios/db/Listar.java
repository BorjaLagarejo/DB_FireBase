package es.borjaestudios.db;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Listar extends Fragment {


    private ArrayList<String> Array_Articulos = new ArrayList<String>();

    private ListView my_lista_articulos;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase,DataRefe;

    public Listar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_listar, container, false);



        my_lista_articulos = (ListView) rootView.findViewById(R.id.lista_articulos);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, Array_Articulos);
        my_lista_articulos.setAdapter(arrayAdapter);

        DataRefe = FirebaseDatabase.getInstance().getReference("cesta");

        DataRefe.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                add_articulo favor = dataSnapshot.getValue(add_articulo.class);
                //arrayList.add(dataSnapshot.getKey());
                Array_Articulos.add(""+favor.getNombre()+" \n "+favor.getCantidad());
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return (rootView);
    }
}
