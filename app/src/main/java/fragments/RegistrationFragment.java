package fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fourthassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment implements View.OnClickListener {

    EditText etFname,etLname,etRUsername,etRPassword;
    Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        etFname = view.findViewById(R.id.etFname);
        etLname = view.findViewById(R.id.etLname);
        etRUsername = view.findViewById(R.id.etRUsername);
        etRPassword = view.findViewById(R.id.etRPassword);
        btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        signUp();
    }


    private void signUp(){

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("etFname",etFname.getText().toString());
        editor.putString("etLname",etLname.getText().toString());
        editor.putString("etRUsername",etRUsername.getText().toString());
        editor.putString("etRPassword",etRPassword.getText().toString());
        editor.commit();

        Toast.makeText(getActivity(),"Successfully registered",Toast.LENGTH_LONG).show();

    }

}
