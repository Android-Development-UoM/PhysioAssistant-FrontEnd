package uom.android.physioassistant.activities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uom.android.physioassistant.R;
import uom.android.physioassistant.models.Appointment;

public class DoctorAppointmentAdapter extends RecyclerView.Adapter<DoctorAppointmentAdapter.ViewHolder> {


    private ArrayList<Appointment> appointments;

    @NonNull
    @Override
    public DoctorAppointmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_appointment_item,parent,false);
        return new DoctorAppointmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAppointmentAdapter.ViewHolder holder, int position) {

        holder.patientName.setText(appointments.get(position).getPatient().getName());
        holder.serviceName.setText(appointments.get(position).getPhysioAction().getName());
        holder.time.setText(appointments.get(position).getTimeRange());

    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView patientName;
        TextView serviceName;
        TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientName = itemView.findViewById(R.id.patientName);
            serviceName = itemView.findViewById(R.id.serviceName);
            time = itemView.findViewById(R.id.timeText);


        }
    }

}
