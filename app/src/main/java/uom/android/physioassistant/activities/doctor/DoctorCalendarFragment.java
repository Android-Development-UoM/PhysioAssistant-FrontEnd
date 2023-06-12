package uom.android.physioassistant.activities.doctor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CalendarView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.threeten.bp.LocalDate;

import uom.android.physioassistant.R;
import uom.android.physioassistant.activities.adapters.DoctorAppointmentAdapter;
import uom.android.physioassistant.activities.adapters.TimeAdapter;
import uom.android.physioassistant.models.Doctor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DoctorCalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorCalendarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CalendarView calendarView;
    private TextView addButton;
    private  TextView appointmentText;
    private TextView noAppointmentsText;
    private RecyclerView recyclerView;
    private RecyclerView timeRecyclerView;
    private TimeAdapter timeAdapter;
    private DoctorAppointmentAdapter doctorAppointmentAdapter;
    private RelativeLayout appointmentLayout;
    private boolean addButtonIsPressed;
    private LocalDate selectedDate;
    private Doctor doctor;

    public DoctorCalendarFragment() {
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
    public static DoctorCalendarFragment newInstance(String param1, String param2) {
        DoctorCalendarFragment fragment = new DoctorCalendarFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar_doctor, container, false);

        initViews(view);

        return view;
    }

    private void initViews(View view) {

        DoctorActivity doctorActivity = (DoctorActivity) getActivity();
        doctor = doctorActivity.getDoctor();

        appointmentText = view.findViewById(R.id.appointmentText);

        noAppointmentsText = view.findViewById(R.id.noAppointmentsText);



        appointmentLayout = view.findViewById(R.id.appointmentLayout);

        doctorAppointmentAdapter = new DoctorAppointmentAdapter();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        timeAdapter = new TimeAdapter(view.getContext());
        timeRecyclerView = view.findViewById(R.id.timeRecyclerView);
        timeRecyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 3));

        selectedDate = LocalDate.now();

        updateAppointmentAdapter(selectedDate);
        animateLayout();

        calendarView = view.findViewById(R.id.calendarView2);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = LocalDate.of(year,month+1,dayOfMonth);
                checkDate(selectedDate);
                updateAppointmentAdapter(selectedDate);
                animateLayout();

            }
        });

        addButton = view.findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButtonIsPressed = !addButtonIsPressed;
            }
        });


    }

    private void updateAppointmentAdapter(LocalDate date){


        if(doctor.getAppointmentsByDate(date).size()==0){
            noAppointmentsText.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }
        else{
            recyclerView.setVisibility(View.VISIBLE);
            noAppointmentsText.setVisibility(View.INVISIBLE);
            doctorAppointmentAdapter.setAppointments(doctor.getAppointmentsByDate(date));
            recyclerView.setAdapter(doctorAppointmentAdapter);
        }
    }

    private void updateTimeAdapter(LocalDate date){

        if(doctor.getAvailableTimeSlots(date).size()==0){
            noAppointmentsText.setVisibility(View.VISIBLE);
            timeRecyclerView.setVisibility(View.INVISIBLE);
        }
        else{
            timeRecyclerView.setVisibility(View.VISIBLE);
            noAppointmentsText.setVisibility(View.INVISIBLE);
            timeAdapter.setTimes(doctor.getAvailableTimeSlots(date));
            recyclerView.setAdapter(timeAdapter);
        }

    }

    private void animateLayout() {

        appointmentLayout.setVisibility(View.VISIBLE);

        Animation slideAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1,
                Animation.RELATIVE_TO_SELF, 0);

        slideAnimation.setDuration(500);

        appointmentLayout.startAnimation(slideAnimation);

    }

    private void checkDate(LocalDate date){
        if(date.isBefore(LocalDate.now())){
            addButton.setVisibility(View.INVISIBLE);
        }
        else{
            addButton.setVisibility(View.VISIBLE);
        }
    }



}