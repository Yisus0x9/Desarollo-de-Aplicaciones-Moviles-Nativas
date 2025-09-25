package com.yisus.app.moviles.aves;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.listado);
        ArrayList<InputList> equiposLigaMX = new ArrayList<>();
        equiposLigaMX.add(new InputList(R.drawable.america,
                "CLUB AMÉRICA",
                "Las Águilas. Fundado el 12 de octubre de 1916. Estadio: Azteca (87,523). Ciudad: CDMX. Títulos: 15 campeonatos. El equipo más exitoso de México, conocido como 'El Más Grande'. Presidente: Santiago Baños. Rival clásico: Chivas."));

        equiposLigaMX.add(new InputList(R.drawable.chivas,
                "CHIVAS DE GUADALAJARA",
                "El Rebaño Sagrado. Fundado el 8 de mayo de 1906. Estadio: Akron (49,850). Ciudad: Guadalajara, Jalisco. Títulos: 12 campeonatos. El único equipo que solo utiliza jugadores mexicanos. Presidente: Amaury Vergara. Rival clásico: América."));

        equiposLigaMX.add(new InputList(R.drawable.cruz_azul,
                "CRUZ AZUL",
                "La Máquina. Fundado el 22 de marzo de 1927. Estadio: Ciudad de los Deportes (35,000). Ciudad: CDMX. Títulos: 9 campeonatos. Famoso por su historia de subcampeonatos y gran afición celeste. Presidente: Víctor Velázquez. Rival clásico: Pumas."));

        equiposLigaMX.add(new InputList(R.drawable.puma,
                "PUMAS UNAM",
                "Los Universitarios. Fundado el 2 de agosto de 1954. Estadio: Olímpico Universitario (72,000). Ciudad: CDMX. Títulos: 7 campeonatos. El equipo de la Universidad Nacional Autónoma de México. Presidente: Leopoldo Silva. Rival clásico: Cruz Azul."));

        equiposLigaMX.add(new InputList(R.drawable.monterrey,
                "CF MONTERREY",
                "Rayados. Fundado el 28 de junio de 1945. Estadio: BBVA (53,500). Ciudad: Monterrey, Nuevo León. Títulos: 5 campeonatos. El equipo más exitoso del norte de México. Presidente: José Antonio Noriega. Rival clásico: Tigres."));

        equiposLigaMX.add(new InputList(R.drawable.tigres,
                "TIGRES UANL",
                "Los Felinos. Fundado el 7 de marzo de 1960. Estadio: Universitario 'El Volcán' (41,615). Ciudad: San Nicolás, NL. Títulos: 8 campeonatos. El equipo de la Universidad Autónoma de Nuevo León. Presidente: Mauricio Culebro. Rival clásico: Monterrey."));

        equiposLigaMX.add(new InputList(R.drawable.santos,
                "SANTOS LAGUNA",
                "Los Guerreros. Fundado el 4 de septiembre de 1983. Estadio: Corona TSM (30,050). Ciudad: Torreón, Coahuila. Títulos: 6 campeonatos. Conocidos por su cantera y desarrollo de jóvenes talentos. Presidente: Alejandro Irarragorri."));

        equiposLigaMX.add(new InputList(R.drawable.leon,
                "CLUB LEÓN",
                "La Fiera. Fundado el 29 de julio de 1944. Estadio: León 'Nou Camp' (31,297). Ciudad: León, Guanajuato. Títulos: 8 campeonatos. El equipo del Bajío mexicano con gran tradición futbolística. Presidente: Jesús Martínez."));

        equiposLigaMX.add(new InputList(R.drawable.atlas,
                "ATLAS FC",
                "Los Rojinegros. Fundado el 15 de agosto de 1916. Estadio: Jalisco (56,713). Ciudad: Guadalajara, Jalisco. Títulos: 1 campeonato (2021). El equipo más romántico del fútbol mexicano. Presidente: Anderson Santamaría. Rival clásico: Chivas."));

        equiposLigaMX.add(new InputList(R.drawable.toluca,
                "DEPORTIVO TOLUCA",
                "Los Diablos Rojos. Fundado el 12 de febrero de 1917. Estadio: Nemesio Díez (30,000). Ciudad: Toluca, Estado de México. Títulos: 10 campeonatos. Uno de los equipos más exitosos del fútbol mexicano. Presidente: Valentín Díez Morodo."));

        equiposLigaMX.add(new InputList(R.drawable.pumas,
                "CF PACHUCA",
                "Los Tuzos. Fundado el 28 de octubre de 1901. Estadio: Hidalgo (30,000). Ciudad: Pachuca, Hidalgo. Títulos: 7 campeonatos. El equipo más antiguo de México. Presidente: Jesús Martínez. Campeón de CONCACAF."));

        equiposLigaMX.add(new InputList(R.drawable.necaxa,
                "CLUB NECAXA",
                "Los Rayos. Fundado el 21 de agosto de 1923. Estadio: Victoria (22,000). Ciudad: Aguascalientes. Títulos: 3 campeonatos. Equipo con gran historia en el fútbol mexicano. Presidente: Rodrigo Santos."));

        equiposLigaMX.add(new InputList(R.drawable.tijuana,
                "CLUB TIJUANA",
                "Xolos. Fundado el 21 de enero de 2007. Estadio: Caliente (33,333). Ciudad: Tijuana, Baja California. Títulos: 1 campeonato (2012). El equipo fronterizo más joven de la Liga MX. Presidente: Jorgealberto Hank."));

        equiposLigaMX.add(new InputList(R.drawable.queretaro,
                "QUERÉTARO FC",
                "Gallos Blancos. Fundado el 8 de julio de 1950. Estadio: Corregidora (35,575). Ciudad: Santiago de Querétaro. Títulos: 1 campeonato (2016). Equipo del centro de México. Presidente: Gabriel Solares."));

        equiposLigaMX.add(new InputList(R.drawable.puebla,
                "CLUB PUEBLA",
                "La Franja. Fundado el 7 de agosto de 1944. Estadio: Cuauhtémoc (51,726). Ciudad: Puebla de Zaragoza. Títulos: 2 campeonatos. Equipo con gran tradición poblana. Presidente: Jesús Martínez."));

        equiposLigaMX.add(new InputList(R.drawable.mazatlan,
                "MAZATLÁN FC",
                "Los Cañoneros. Fundado en 2020. Estadio: El Encanto (25,000). Ciudad: Mazatlán, Sinaloa. Títulos: 0 campeonatos. El equipo más nuevo de la Liga MX. Presidente: José Riestra."));

        equiposLigaMX.add(new InputList(R.drawable.juarez,
                "FC JUÁREZ",
                "Los Bravos. Fundado en 2015. Estadio: Olímpico Benito Juárez (19,703). Ciudad: Ciudad Juárez, Chihuahua. Títulos: 0 campeonatos. Equipo fronterizo del norte de México. Presidente: Alejandro Davila."));

        equiposLigaMX.add(new InputList(R.drawable.atletico,
                "SAN LUIS ATLÉTICO",
                "Los Tuneros. Re-fundado en 2013. Estadio: Alfonso Lastras (25,709). Ciudad: San Luis Potosí. Títulos: 2 campeonatos históricos. Equipo con gran tradición potosina. Presidente: Alberto Marrero."));
        ListView listView = findViewById(R.id.ListView_listado);

        listView.setAdapter(new ListAdapter(this, R.layout.activity_main, equiposLigaMX) {
            @Override
            public void onEntrada(Object o, View v) {
                if (o != null) {
                    TextView texto_superior_entrada = v.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((InputList) o).get_textUp());
                    TextView texto_inferior_entrada = v.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((InputList) o).getTextDown());
                    ImageView imagen_entrada = v.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((InputList) o).getImageId());
                }
            }
        });

        listView.setOnItemClickListener((av, view, i, l) -> {
            InputList le = (InputList) av.getItemAtPosition(i);
            CharSequence cs = "Seleccionado: " + le.getTextDown();
            Toast t = Toast.makeText(MainActivity.this, cs, Toast.LENGTH_SHORT);
            t.show();
        });

    }
}
 
 