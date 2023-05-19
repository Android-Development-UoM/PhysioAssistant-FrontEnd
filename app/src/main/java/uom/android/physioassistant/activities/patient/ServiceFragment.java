package uom.android.physioassistant.activities.patient;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uom.android.physioassistant.R;
import uom.android.physioassistant.backend.api.PhysioActionApi;
import uom.android.physioassistant.backend.retrofit.RetrofitService;
import uom.android.physioassistant.models.PhysioAction;
import uom.android.physioassistant.ui.FragmentType;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView serviceImage;
    private ImageView backButton;
    private TextView serviceName,serviceDescription,servicePrice;
    private String code;
    public ServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiceFragment newInstance(String param1, String param2) {
        ServiceFragment fragment = new ServiceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

                PatientActivity patientActivity = (PatientActivity) requireActivity();
                patientActivity.replaceFragment(FragmentType.HOME_FRAGMENT.getFragment(), R.anim.fade_in,R.anim.fade_out );
                patientActivity.getNavBar().setVisibility(View.VISIBLE);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);

        Bundle bundle = getArguments();
        if(bundle!=null){
            String code = bundle.getString("physio_action_code");
            findPhysioActionById(view,code);
        }


        return view;
    }

    public void findPhysioActionById(View view,String code){

        RetrofitService retrofitService = new RetrofitService();
        PhysioActionApi physioActionApi = retrofitService.getRetrofit().create(PhysioActionApi.class);

        physioActionApi.getServiceByCode(code).enqueue(new Callback<PhysioAction>() {
            @Override
            public void onResponse(Call<PhysioAction> call, Response<PhysioAction> response) {
                Toast.makeText(ServiceFragment.this.getContext(), response.body().getName(), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()){
                    initViews(view,response.body());
                }
                else{
                    Log.e("Erorr", response.message());
                }
            }

            @Override
            public void onFailure(Call<PhysioAction> call, Throwable t) {
                Log.e("Error", "onFailure: failed to find action by id");
            }
        });

    }

    private void initViews(View view,PhysioAction physioAction) {

        serviceName = view.findViewById(R.id.serviceName);
        serviceName.setText(physioAction.getName());

        serviceDescription = view.findViewById(R.id.serviceDescription);
        serviceDescription.setText(physioAction.getDescription());

        servicePrice = view.findViewById(R.id.servicePrice);
        servicePrice.setText(String.valueOf(physioAction.getCost()));

        serviceImage = view.findViewById(R.id.serviceImage);
        String imageURL = "https://img.freepik.com/premium-photo/spa-arrangement-with-towel-soap-salt_23-2148268482.jpg?w=2000";
        Glide.with(view.getContext()).asBitmap().load(imageURL).into(serviceImage);

        backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });

    }


}