package uom.android.physioassistant.activities.patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uom.android.physioassistant.R;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {


    private ArrayList<String> appointments = new ArrayList<>();
    private Context context;
    public AppointmentAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_item,parent,false);
        return new AppointmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String imageURL = "https://img.freepik.com/premium-photo/spa-arrangement-with-towel-soap-salt_23-2148268482.jpg?w=2000";
        Glide.with(context).asBitmap().load(imageURL).into(holder.serviceImage);

        holder.serviceName.setText(appointments.get(position));

    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public void setAppointments(ArrayList<String> appointments) {
        this.appointments = appointments;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView serviceImage;
        TextView serviceName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceImage = itemView.findViewById(R.id.serviceImage);
            serviceName = itemView.findViewById(R.id.serviceName);
        }
    }

}
