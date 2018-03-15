package es.borjaestudios.db;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Agregar extends Fragment {

    private EditText my_edit_nombre,my_edit_cantidad;
    private Button my_b_enviar;
    private DatabaseReference mDatabase;

    public Agregar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_agregar, container, false);
        my_edit_nombre = (EditText) rootView.findViewById(R.id.edit_nombre);
        my_edit_cantidad = (EditText) rootView.findViewById(R.id.edit_cantidad);
        my_b_enviar = (Button) rootView.findViewById(R.id.b_enviar);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference();

        my_b_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = my_edit_nombre.getText().toString().trim();
                String cantidad = my_edit_cantidad.getText().toString().trim();

                add_articulo add = new add_articulo(nombre,cantidad);
                mDatabase.child("cesta").push().setValue(add);

                my_edit_nombre.setText("");
                my_edit_cantidad.setText("");

                Snackbar.make(my_b_enviar, "Articulo agregado", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });

        return (rootView);
    }
}
