package fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fourthassignment.Dashboard;
import com.fourthassignment.R;


import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {


    EditText etUsername,etPassword;
    Button btnLogin;



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        checkUser();




    }

    private void checkUser(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User",MODE_PRIVATE);
        String username = sharedPreferences.getString("etRUsername","");
        String password = sharedPreferences.getString("etRPassword","");

        if (username.equals(etUsername.getText().toString()) &&  password.equals(etPassword.getText().toString())) {

            Toast.makeText(getActivity(),"Success",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), Dashboard.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getActivity(),"Either username or password is incorrect", Toast.LENGTH_LONG).show();
        }
    }


}
