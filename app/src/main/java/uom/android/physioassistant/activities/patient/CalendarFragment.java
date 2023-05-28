package uom.android.physioassistant.activities.patient;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uom.android.physioassistant.R;
import uom.android.physioassistant.backend.api.PhysioActionApi;
import uom.android.physioassistant.backend.retrofit.RetrofitService;
import uom.android.physioassistant.models.PhysioAction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView appointmentRecyclerView;
    private AppointmentAdapter appointmentAdapter;
    private ArrayList<String> currentAppointments;
    private ArrayList<String> historyAppointments;
    private TextView historyButton,currentButton;
    private TextView underlineCurrent,underlineHistory;
    private RelativeLayout currentLayout,historyLayout;
    private FloatingActionButton createAppointmentButton;

    public CalendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calendar,container,false);

        initViews(view);

        currentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrentPressed(view);
            }
        });

        historyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHistoryPressed(view);

            }
        });

        createAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "Button pressed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void initLists(){

        historyAppointments = new ArrayList<>();
        historyAppointments.add("Αθλητική Μάλαξη 1");
        historyAppointments.add("Αθλητική Μάλαξη 2");
        historyAppointments.add("Αθλητική Μάλαξη 3");
        historyAppointments.add("Αθλητική Μάλαξη 4");
        historyAppointments.add("Αθλητική Μάλαξη 5");
        historyAppointments.add("Αθλητική Μάλαξη 6");

        currentAppointments = new ArrayList<>();
        currentAppointments.add("Αθλητική Μάλαξη 7");
        currentAppointments.add("Αθλητική Μάλαξη 8");
        currentAppointments.add("Αθλητική Μάλαξη 9");
        currentAppointments.add("Αθλητική Μάλαξη 10");

    }

    private  void initViews(View view){

        createAppointmentButton = view.findViewById(R.id.createAppointmentButton);

        currentButton = view.findViewById(R.id.currentButton);
        historyButton = view.findViewById(R.id.historyButton);

        underlineCurrent = view.findViewById(R.id.underlineCurrent);
        underlineHistory = view.findViewById(R.id.underlineHistory);

        currentLayout = view.findViewById(R.id.currentLayout);
        historyLayout = view.findViewById(R.id.historyLayout);

        initLists();
        appointmentAdapter = new AppointmentAdapter(view.getContext());
        appointmentAdapter.setAppointments(currentAppointments);

        appointmentRecyclerView = view.findViewById(R.id.appointmentRecyclerView);
        appointmentRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        appointmentRecyclerView.setAdapter(appointmentAdapter);

    }

    private void setHistoryPressed(View view){
        historyButton.setTextColor(Color.BLACK);
        underlineHistory.setBackgroundColor(Color.BLACK);

        currentButton.setTextColor(ContextCompat.getColor(view.getContext(),R.color.gray));
        underlineCurrent.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.gray));

        appointmentAdapter.setAppointments(historyAppointments);
        appointmentAdapter.notifyDataSetChanged();
    }

    private void setCurrentPressed(View view){
        currentButton.setTextColor(Color.BLACK);
        underlineCurrent.setBackgroundColor(Color.BLACK);

        historyButton.setTextColor(ContextCompat.getColor(view.getContext(),R.color.gray));
        underlineHistory.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.gray));

        appointmentAdapter.setAppointments(currentAppointments);
        appointmentAdapter.notifyDataSetChanged();
    }



}