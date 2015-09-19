package example.jesus.getfragmentdata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by JesusManuel on 19/09/15.
 */
public class MyFragment extends Fragment {

    //private TextView textViewFragmentArgument;
    private EditText editTextFragmentData;

    /**
     * Constructor estatico
     * De esta manera se pasan argumentos al momento de crear el fragment
     * se usa asi: MyFragment myFragment = MyFragment.newInstace(1);
     */
    public static MyFragment newInstance(int fragmentNumber) {
        Bundle arguments = new Bundle();
        arguments.putInt("FRAGMENT_NUMBER", fragmentNumber);
        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(arguments);
        return myFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_fragment, container, false);
        //textViewFragmentArgument = (TextView) rootView.findViewById(R.id.textView_fragment_argument);
        editTextFragmentData = (EditText) rootView.findViewById(R.id.editText_fragment_data);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //De esta manera se resiven los argumentos
        //int fragmentNumber = getArguments().getInt("FRAGMENT_NUMBER");
        //textViewFragmentArgument.setText("Argumento del fragment: " + fragmentNumber);
    }

    /**
     * De esta forma obtenemos informacion del fragment, recuerda los fragments se agregan en un
     * segundo hilo de ejecucion y no puedes llamar a estos metodos justo despues de instanciar un fragment
     * ya que este no se a creado
     */
    public String getFragmentData() {
        String data = editTextFragmentData.getText().toString().trim();
        if (!data.isEmpty()) {
            return data;
        } else {
            return "No escribiste nada";
        }
    }

}
