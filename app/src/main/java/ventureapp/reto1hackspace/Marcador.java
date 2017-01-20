package ventureapp.reto1hackspace;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Marcador extends AppCompatActivity {


   private GoogleMap map;

   //TextView
   TextView nombre;
   TextView direccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador);

        map=((MapFragment)getFragmentManager().findFragmentById(R.id.fragmentMapa)).getMap();
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //DECLARANDO LOS TEXTVIEWS
        nombre = (TextView)findViewById(R.id.tvnombre);
        direccion =(TextView)findViewById(R.id.tvdireccion);

       /* map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setMyLocationEnabled(true);*/

        //Marcador numero 1
        LatLng marcador1 = new LatLng(-12.056026, -77.084423);
        String title1 = "Universidad Nacional Mayor de San Marcos";

        //Marcador numero 2
        LatLng marcador2 = new LatLng(-12.05961296634207, -77.09027051925659);
        String title2 = "Hospital Centro Médico Naval";

        //Marcador numero 3
        LatLng marcador3 = new LatLng(-12.06217301644664, -77.0891547203064);
        String title3 = "Liceo Naval Contralmirante Lizardo Montero";

        //Marcador numero 4
        LatLng marcador4 = new LatLng(-12.060515281872881, -77.0870304107666);
        String title4 = "Huaca de San Marcos - UNMSN";

        //Marcador sin icono
        Marker primero = map.addMarker(new MarkerOptions()
                        .position(new LatLng(-12.061270706493962,-77.0880925655365))
                        .title("I.E. Sta Teresa de Courdec"));

        insertarMarcador(marcador1,title1);
        insertarMarcador(marcador2,title2);
        insertarMarcador(marcador3,title3);
        insertarMarcador(marcador4,title4);

        limpiar();
       map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

                @Override
                public boolean onMarkerClick(Marker primero) {
                    nombre.setText(primero.getTitle());
                    direccion.setText("LUGAR DE ENVIO");
                    map.animateCamera(CameraUpdateFactory.newLatLng(primero.getPosition()));
                    return true;
                }

        }
       );
       limpiar();




      }

    void insertarMarcador(LatLng latLng, final String title){

               Marker primero = map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.icmoto))
                .position(latLng)
                .title(title)
        );
    }

    void limpiar (){
        nombre.setText("");
        direccion.setText("");

    }
}

