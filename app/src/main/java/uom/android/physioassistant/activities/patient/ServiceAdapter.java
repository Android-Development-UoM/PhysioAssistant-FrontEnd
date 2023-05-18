package uom.android.physioassistant.activities.patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import uom.android.physioassistant.R;
import uom.android.physioassistant.ui.FragmentType;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    private Context context;

    public ServiceAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item,parent,false);
        return new ServiceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String imageURL = "https://img.freepik.com/premium-photo/spa-arrangement-with-towel-soap-salt_23-2148268482.jpg?w=2000";
        Glide.with(context).asBitmap().load(imageURL).into(holder.serviceImage);

        holder.serviceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ((PatientActivity)context).getNavBar().setVisibility(View.GONE);
                ((PatientActivity)context).replaceFragment(FragmentType.SERVICE_FRAGMENT.getFragment(), R.anim.fade_in,R.anim.fade_out);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{


        ImageView serviceImage;
        TextView serviceName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            serviceImage = itemView.findViewById(R.id.serviceImage);
            serviceName = itemView.findViewById(R.id.serviceName);

        }
    }

}
