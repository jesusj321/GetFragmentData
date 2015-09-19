package example.jesus.getfragmentdata;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicia el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creamos una lista para tener un facil acceso a los fragments

        final List<MyFragment> myFragmentList = new ArrayList<>();
        myFragmentList.add(new MyFragment());
        myFragmentList.add(new MyFragment());
        myFragmentList.add(new MyFragment());
        myFragmentList.add(new MyFragment());
        myFragmentList.add(new MyFragment());
        myFragmentList.add(new MyFragment());
        myFragmentList.add(new MyFragment());
        myFragmentList.add(new MyFragment());


        //Crear el fragment pager adapter
        final FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            private static final int FRAGMENT_COUNT = 8;

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return myFragmentList.get(position);
                    case 1:
                        return myFragmentList.get(position);
                    case 2:
                        return myFragmentList.get(position);
                    case 3:
                        return myFragmentList.get(position);
                    case 4:
                        return myFragmentList.get(position);
                    case 5:
                        return myFragmentList.get(position);
                    case 6:
                        return myFragmentList.get(position);
                    case 7:
                        return myFragmentList.get(position);
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return FRAGMENT_COUNT;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Fragment " + position;
                    case 1:
                        return "Fragment " + position;
                    case 2:
                        return "Fragment " + position;
                    case 3:
                        return "Fragment " + position;
                    case 4:
                        return "Fragment " + position;
                    case 5:
                        return "Fragment " + position;
                    case 6:
                        return "Fragment " + position;
                    case 7:
                        return "Fragment " + position;
                    default:
                        return super.getPageTitle(position);
                }
            }
        };

        //Iniciamos el viewpager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);


        /**
         * Ahora aqui esta el secreto para mantener los datos de cada fragment,
         * el metodo setOffscreenPageLimit define el numero de paginas que deben ser retenidos
         * a ambos lados de la pagina actual en la jerarquia de vistas en un estado activo.
         * Esto quiere decir que si tenemos 3 paginas y deseamos retener la informacion de todos ponemos
         * viewPager.setOffscreenPageLimit(3) ya que al momento de estar en la pagina inicial tenemos un limite
         * de 2 a un lado pero para asegurarse usamos el mismo numero de fragmentes en el adaptador
         * El numero que esta por defecto es 3 ya que es el numero de tabs que te recomiendan que uses
         */

        /**
         * En este caso tenemos 8 paginas asi que usaremos 8
         */

        viewPager.setOffscreenPageLimit(8);

        //Asignamos el adaptador
        viewPager.setAdapter(fragmentPagerAdapter);

        //Iniciamos las tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //En este caso son mas de 3 tabs asi que vamos ponerle un scroll al tabLayout
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        //Boton para obtener datos de los fragments
        Button button = (Button) findViewById(R.id.button_get_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**Para poder obtener los datos de los fragments en este caso vamos a usar el
                 * viewpager y la lista para que nos devuelvan los fragments
                 */
                Log.i("CURRENT_ITEM", "Currrent item: " + viewPager.getCurrentItem());

                MyFragment myFragment = myFragmentList.get(viewPager.getCurrentItem());
                Toast.makeText(MainActivity.this, myFragment.getFragmentData(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
